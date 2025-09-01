package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private Integer discountPercent; // 0..100 expected, but not enforced
    private boolean expedited;
    private String notes;

    public Order(String id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
    }

    public Order(String id, String customerEmail, Integer discountPercent) {
        this(id, customerEmail);
        this.discountPercent = discountPercent;
    }

    public void addLine(OrderLine line) { lines.add(line); }
    public void setDiscountPercent(Integer discountPercent) { this.discountPercent = discountPercent; }
    public void setExpedited(boolean expedited) { this.expedited = expedited; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; } // leaks internal list
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
