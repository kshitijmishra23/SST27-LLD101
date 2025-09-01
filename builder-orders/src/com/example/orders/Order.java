package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Telescoping constructors + setters. Allows invalid states.
 *  * Immutable Order built via Builder. All validation centralized in build().

 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines; // stored as defensive deep copy
    private final Integer discountPercent; // 0..100 inclusive
    private final boolean expedited;
    private final String notes;

    private Order(String id,
                  String customerEmail,
                  List<OrderLine> lines,
                  Integer discountPercent,
                  boolean expedited,
                  String notes) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.lines = lines; // already defensively copied and unmodifiable in builder
        this.discountPercent = discountPercent;
        this.expedited = expedited;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }

    /**
     * Returns an unmodifiable defensive deep copy of lines to avoid external mutation.
     */
    public List<OrderLine> getLines() {
        List<OrderLine> copy = new ArrayList<>(lines.size());
        for (OrderLine l : lines) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        return Collections.unmodifiableList(copy);
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

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> pendingLines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = Objects.requireNonNull(id, "id");
            this.customerEmail = Objects.requireNonNull(customerEmail, "customerEmail");
        }

        public Builder addLine(OrderLine line) {
            if (line != null) pendingLines.add(line);
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) for (OrderLine l : lines) addLine(l);
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format");
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be null or between 0 and 100");
            }
            if (pendingLines.isEmpty()) {
                throw new IllegalArgumentException("At least one order line is required");
            }

            // Defensive deep copy of lines
            List<OrderLine> copied = new ArrayList<>(pendingLines.size());
            for (OrderLine l : pendingLines) {
                if (l == null) continue;
                copied.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
            }
            if (copied.isEmpty()) {
                throw new IllegalArgumentException("At least one non-null order line is required");
            }
            List<OrderLine> unmodifiable = Collections.unmodifiableList(copied);

            return new Order(id, customerEmail, unmodifiable, discountPercent, expedited, notes);
        }
    }
}
