package com.aixcoder.java;

import java.util.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class MegaECommerceSystem {
   private name ; //名称
   private Map<String, User> users = new HashMap<>();
   private List<Product> products = new ArrayList<>();
   private List<Order> orders = new ArrayList<>();
   private Map<String, Category> categories = new HashMap<>();
   private List<Transaction> transactions = new ArrayList<>();
   private Map<String, Coupon> coupons = new HashMap<>();
   private List<Review> reviews = new ArrayList<>();
   private Map<String, Supplier> suppliers = new HashMap<>();
   private List<Shipment> shipments = new ArrayList<>();
   private Map<String, Warehouse> warehouses = new HashMap<>();
   private List<Refund> refunds = new ArrayList<>();
   private Map<String, Customer> customerSupport = new HashMap<>();
   private List<MarketingCampaign> marketingCampaigns = new ArrayList<>();
   private Map<String, AnalyticsData> analyticsData = new HashMap<>();

   // 用户管理
   public void registerUser(String username, String password, String email) {
       if (users.containsKey(username)) {
           throw new IllegalArgumentException("Username already exists");
       }
       User newUser = new User(username, password, email);
       users.put(username, newUser);
   }

   public User login(String username, String password) {
       User user = users.get(username);
       if (user != null && user.authenticate(password)) {
           return user;
       }
       return null;
   }

   public void updateUserProfile(String username, Map<String, String> profileUpdates) {
       User user = users.get(username);
       if (user != null) {
           user.updateProfile(profileUpdates);
       }
   }

   // 产品管理
   public void addProduct(Product product) {
       products.add(product);
       Category category = categories.get(product.getCategory());
       if (category == null) {
           category = new Category(product.getCategory());
           categories.put(product.getCategory(), category);
       }
       category.addProduct(product);
   }

   public void updateProductStock(String productId, int newStock) {
       for (Product product : products) {
           if (product.getId().equals(productId)) {
               product.setStock(newStock);
               break;
           }
       }
   }

   public List<Product> searchProducts(String keyword) {
       List<Product> results = new ArrayList<>();
       for (Product product : products) {
           if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                   product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
               results.add(product);
           }
       }
       return results;
   }

   // 订单处理
   public Order createOrder(String username, List<OrderItem> items) {
       User user = users.get(username);
       if (user == null) {
           throw new IllegalArgumentException("User not found");
       }
       Order order = new Order(user, items);
       orders.add(order);
       return order;
   }

   public void processPayment(String orderId, String paymentMethod, BigDecimal amount) {
       Order order = findOrderById(orderId);
       if (order != null) {
           Transaction transaction = new Transaction(order, paymentMethod, amount);
           transactions.add(transaction);
           order.setStatus(OrderStatus.PAID);
       }
   }

   public void shipOrder(String orderId) {
       Order order = findOrderById(orderId);
       if (order != null && order.getStatus() == OrderStatus.PAID) {
           Shipment shipment = new Shipment(order);
           shipments.add(shipment);
           order.setStatus(OrderStatus.SHIPPED);
       }
   }

   // 库存管理
   public void receiveStock(String productId, int quantity, String warehouseId) {
       Product product = findProductById(productId);
       Warehouse warehouse = warehouses.get(warehouseId);
       if (product != null && warehouse != null) {
           warehouse.addStock(product, quantity);
           product.setStock(product.getStock() + quantity);
       }
   }

   public void transferStock(String productId, int quantity, String fromWarehouseId, String toWarehouseId) {
       Warehouse fromWarehouse = warehouses.get(fromWarehouseId);
       Warehouse toWarehouse = warehouses.get(toWarehouseId);
       Product product = findProductById(productId);
       if (fromWarehouse != null && toWarehouse != null && product != null) {
           fromWarehouse.removeStock(product, quantity);
           toWarehouse.addStock(product, quantity);
       }
   }

   // 优惠券管理
   public void createCoupon(String code, BigDecimal discountAmount, LocalDateTime expiryDate) {
       Coupon coupon = new Coupon(code, discountAmount, expiryDate);
       coupons.put(code, coupon);
   }

   public void applyCoupon(String orderId, String couponCode) {
       Order order = findOrderById(orderId);
       Coupon coupon = coupons.get(couponCode);
       if (order != null && coupon != null && coupon.isValid()) {
           order.applyCoupon(coupon);
       }
   }

   // 评价系统
   public void addReview(String username, String productId, int rating, String comment) {
       User user = users.get(username);
       Product product = findProductById(productId);
       if (user != null && product != null) {
           Review review = new Review(user, product, rating, comment);
           reviews.add(review);
           product.addReview(review);
       }
   }

   public List<Review> getProductReviews(String productId) {
       List<Review> productReviews = new ArrayList<>();
       for (Review review : reviews) {
           if (review.getProduct().getId().equals(productId)) {
               productReviews.add(review);
           }
       }
       return productReviews;
   }

   // 供应商管理
   public void addSupplier(Supplier supplier) {
       suppliers.put(supplier.getId(), supplier);
   }

   public void placeSupplierOrder(String supplierId, Map<String, Integer> productQuantities) {
       Supplier supplier = suppliers.get(supplierId);
       if (supplier != null) {
           supplier.placeOrder(productQuantities);
       }
   }

   // 退款处理
   public void processRefund(String orderId, String reason) {
       Order order = findOrderById(orderId);
       if (order != null) {
           Refund refund = new Refund(order, reason);
           refunds.add(refund);
           order.setStatus(OrderStatus.REFUNDED);
       }
   }

   // 客户支持
   public void createSupportTicket(String username, String issue) {
       User user = users.get(username);
       if (user != null) {
           String ticketId = "TICKET-" + System.currentTimeMillis();
           customerSupport.put(ticketId, new Customer(user, issue));
       }
   }

   public void resolveSupportTicket(String ticketId, String resolution) {
       Customer supportTicket = customerSupport.get(ticketId);
       if (supportTicket != null) {
           supportTicket.setResolution(resolution);
           supportTicket.setStatus(TicketStatus.RESOLVED);
       }
   }

   // 营销活动
   public void createMarketingCampaign(String name, LocalDateTime startDate, LocalDateTime endDate) {
       MarketingCampaign campaign = new MarketingCampaign(name, startDate, endDate);
       marketingCampaigns.add(campaign);
   }

   public void addProductToMarketingCampaign(String campaignName, String productId) {
       Product product = findProductById(productId);
       if (product != null) {
           for (MarketingCampaign campaign : marketingCampaigns) {
               if (campaign.getName().equals(campaignName)) {
                   campaign.addProduct(product);
                   break;
               }
           }
       }
   }

   // 数据分析
   public void recordAnalyticsData(String metric, String value) {
       AnalyticsData data = analyticsData.get(metric);
       if (data == null) {
           data = new AnalyticsData(metric);
           analyticsData.put(metric, data);
       }
       data.addDataPoint(value);
   }

   public Map<String, List<String>> getAnalyticsReport() {
       Map<String, List<String>> report = new HashMap<>();
       for (Map.Entry<String, AnalyticsData> entry : analyticsData.entrySet()) {
           report.put(entry.getKey(), entry.getValue().getDataPoints());
       }
       return report;
   }

   // 辅助方法
   private Order findOrderById(String orderId) {
       for (Order order : orders) {
           if (order.getId().equals(orderId)) {
               return order;
           }
       }
       return null;
   }

   private Product findProductById(String productId) {
       for (Product product : products) {
           if (product.getId().equals(productId)) {
               return product;
           }
       }
       return null;
   }

   // 内部类定义
   private class User {
       private String username;
       private String password;
       private String email;
       private Map<String, String> profile = new HashMap<>();

       public User(String username, String password, String email) {
           this.username = username;
           this.password = password;
           this.email = email;
       }

       public boolean authenticate(String inputPassword) {
           return this.password.equals(inputPassword);
       }

       public void updateProfile(Map<String, String> updates) {
           profile.putAll(updates);
       }

       // Getters and setters
   }

   private class Product {
       private String id;
       private String name;
       private String description;
       private String category;
       private BigDecimal price;
       private int stock;
       private List<Review> reviews = new ArrayList<>();

       // Constructor, getters, and setters

       public void addReview(Review review) {
           reviews.add(review);
       }
   }

   private class Order {
       private String id;
       private User user;
       private List<OrderItem> items;
       private OrderStatus status;
       private LocalDateTime orderDate;
       private Coupon appliedCoupon;

       public Order(User user, List<OrderItem> items) {
           this.id = "ORDER-" + System.currentTimeMillis();
           this.user = user;
           this.items = items;
           this.status = OrderStatus.CREATED;
           this.orderDate = LocalDateTime.now();
       }

       public void applyCoupon(Coupon coupon) {
           this.appliedCoupon = coupon;
       }

       // Getters and setters
   }

   private class OrderItem {
       private Product product;
       private int quantity;

       // Constructor, getters, and setters
   }

   private enum OrderStatus {
       CREATED, PAID, SHIPPED, DELIVERED, CANCELLED, REFUNDED
   }

   private class Category {
       private String name;
       private List<Product> products = new ArrayList<>();

       public Category(String name) {
           this.name = name;
       }

       public void addProduct(Product product) {
           products.add(product);
       }

       // Getters and setters
   }

   private class Transaction {
       private String id;
       private Order order;
       private String paymentMethod;
       private BigDecimal amount;
       private LocalDateTime transactionDate;

       public Transaction(Order order, String paymentMethod, BigDecimal amount) {
           this.id = "TRANS-" + System.currentTimeMillis();
           this.order = order;
           this.paymentMethod = paymentMethod;
           this.amount = amount;
           this.transactionDate = LocalDateTime.now();
       }

       // Getters and setters
   }

   private class Coupon {
       private String code;
       private BigDecimal discountAmount;
       private LocalDateTime expiryDate;

       public Coupon(String code, BigDecimal discountAmount, LocalDateTime expiryDate) {
           this.code = code;
           this.discountAmount = discountAmount;
           this.expiryDate = expiryDate;
       }

       public boolean isValid() {
           return LocalDateTime.now().isBefore(expiryDate);
       }

       // Getters and setters
   }

   private class Review {
       private User user;
       private Product product;
       private int rating;
       private String comment;
       private LocalDateTime reviewDate;

       public Review(User user, Product product, int rating, String comment) {
           this.user = user;
           this.product = product;
           this.rating = rating;
           this.comment = comment;
           this.reviewDate = LocalDateTime.now();
       }

       // Getters and setters
   }

   private class Supplier {
       private String id;
       private String name;
       private String contactInfo;

       public void placeOrder(Map<String, Integer> productQuantities) {
           // 实现供应商订单逻辑
       }

       // Getters and setters
   }

   private class Shipment {
       private String id;
       private Order order;
       private String trackingNumber;
       private ShipmentStatus status;
       private LocalDateTime shipmentDate;

       public Shipment(Order order) {
           this.id = "SHIP-" + System.currentTimeMillis();
           this.order = order;
           this.trackingNumber = generateTrackingNumber();
           this.status = ShipmentStatus.PROCESSING;
           this.shipmentDate = LocalDateTime.now();
       }

       private String generateTrackingNumber() {
           // 实现跟踪号生成逻辑
           return "TN" + System.currentTimeMillis();
       }

       // Getters and setters
   }

   private enum ShipmentStatus {
       PROCESSING, IN_TRANSIT, DELIVERED
   }

   private class Warehouse {
       private String id;
       private String name;
       private String location;
       private Map<Product, Integer> inventory = new HashMap<>();

       public void addStock(Product product, int quantity) {
           inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
       }

       public void removeStock(Product product, int quantity) {
           int currentStock = inventory.getOrDefault(product, 0);
           if (currentStock >= quantity) {
               inventory.put(product, currentStock - quantity);
           } else {
               throw new IllegalArgumentException("Insufficient stock");
           }
       }

// Getters and setters