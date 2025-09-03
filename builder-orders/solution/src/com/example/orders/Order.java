package com.example.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines; // immutable view
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder b) {
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine l : b.lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        this.lines = List.copyOf(copy);
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
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

    public static final class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder id(String id) { this.id = id; return this; }
        public Builder customerEmail(String email) { this.customerEmail = email; return this; }
        public Builder addLine(String sku, int qty, int unitPriceCents) {
            lines.add(new OrderLine(Objects.requireNonNull(sku, "sku"), qty, unitPriceCents));
            return this;
        }
        public Builder discountPercent(Integer d) { this.discountPercent = d; return this; }
        public Builder expedited(boolean v) { this.expedited = v; return this; }
        public Builder notes(String n) { this.notes = n; return this; }

        public Order build() {
            Objects.requireNonNull(id, "id");
            Objects.requireNonNull(customerEmail, "customerEmail");
            if (!PricingRules.isValidEmail(customerEmail)) throw new IllegalArgumentException("invalid email");
            if (!PricingRules.isValidDiscount(discountPercent)) throw new IllegalArgumentException("discount must be 0..100");
            if (lines.isEmpty()) throw new IllegalArgumentException("at least one order line required");
            return new Order(this);
        }
    }
}
