WITH sales_summary AS (
  SELECT 
    p.category_id,
    c.category_name,
    DATE_TRUNC('month', s.sale_date) AS sale_month,
    SUM(s.quantity * p.price) AS total_sales
  FROM 
    sales s
    JOIN products p ON s.product_id = p.product_id
    JOIN categories c ON p.category_id = c.category_id
  WHERE 
    s.sale_date >= DATE_TRUNC('year', CURRENT_DATE) 
    AND s.sale_date < DATE_TRUNC('year', CURRENT_DATE) + INTERVAL '1 year'
  GROUP BY 
    p.category_id, c.category_name, DATE_TRUNC('month', s.sale_date)
)

SELECT 
  ss.category_name,
  ss.sale_month,
  ss.total_sales,
  SUM(ss.total_sales) OVER (PARTITION BY ss.category_id ORDER BY ss.sale_month) AS cumulative_sales,
  RANK() OVER (PARTITION BY ss.sale_month ORDER BY ss.total_sales DESC) AS category_rank
FROM 
  sales_summary ss
WHERE 
  ss.total_sales > (
    SELECT AVG(total_sales) 
    FROM sales_summary 
    WHERE category_id = ss.category_id
  )
ORDER BY 
  ss.sale_month, ss.total_sales DESC
LIMIT 100;