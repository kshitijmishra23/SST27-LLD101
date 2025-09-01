package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
final public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    public Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = builder.lines.stream()
                    .map(line -> new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()))
                    .toList();
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }
    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines;
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder setLines(List<OrderLine> lines) {
            this.lines = lines;
            return this;
        }

        public Builder setDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(this.customerEmail)) {
                throw new IllegalArgumentException("Invalid customer email: " + this.customerEmail);
            }
            if (!PricingRules.isValidDiscount(this.discountPercent)) {
                throw new IllegalArgumentException("Invalid discount: " + this.discountPercent);
            }
            if (PricingRules.isEmptyLines(this.lines)) {
                throw new IllegalArgumentException("Order must contain at least one line");
            }
            return new Order(this);
        }
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() {
        return new ArrayList<>(lines);
    }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}