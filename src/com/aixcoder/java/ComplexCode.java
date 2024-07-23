package com.aixcoder.java;

public class ComplexCode {
    // 处理订单的方法
    public void processOrder(Order order) {
        // 根据订单类型进行处理
        switch (order.getType()) {
            // 如果订单类型是标准订单
            case "STANDARD":
                // 如果订单金额大于1000
                if (order.getAmount() > 1000) {
                    // 根据客户类型进行处理
                    switch (order.getCustomer().getType()) {
                        // 如果客户类型是VIP
                        case "VIP":
                            // 应用10%的折扣
                            applyDiscount(order, 0.1);
                            break;
                        // 如果客户类型是常规客户
                        case "REGULAR":
                            // 应用5%的折扣
                            applyDiscount(order, 0.05);
                            break;
                    }
                } else {
                    // 如果客户类型是VIP
                    if (order.getCustomer().getType().equals("VIP")) {
                        // 应用5%的折扣
                        applyDiscount(order, 0.05);
                    }
                }
                break;
            // 如果订单类型是express订单
            case "EXPRESS":
                // 如果订单金额大于2000
                if (order.getAmount() > 2000) {
                    // 根据客户类型进行处理
                    switch (order.getCustomer().getType()) {
                        // 如果客户类型是VIP
                        case "VIP":
                            // 应用15%的折扣
                            applyDiscount(order, 0.15);
                            break;
                        // 如果客户类型是常规客户
                        case "REGULAR":
                            // 应用10%的折扣
                            applyDiscount(order, 0.1);
                            break;
                    }
                } else {
                    // 如果客户类型是VIP
                    if (order.getCustomer().getType().equals("VIP")) {
                        // 应用10%的折扣
                        applyDiscount(order, 0.1);
                    }
                }
                break;
        }
    }

    private void applyDiscount(Order order, double discountRate) {
        // Apply discount logic
    }

    class Order {
        private String type;
        private double amount;
        private Customer customer;

        public Order(String type, double amount, Customer customer) {
            this.type = type;
            this.amount = amount;
            this.customer = customer;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public Customer getCustomer() {
            return customer;
        }

        public static class Customer {
            private String type;

            public Customer(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }
        }
    }

}
