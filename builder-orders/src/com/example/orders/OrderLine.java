package com.example.orders;

public class OrderLine {
    private String sku;
    private int quantity;
    private int unitPriceCents;

    public OrderLine(String sku, int quantity, int unitPriceCents) {
        this.sku = sku;
        this.quantity = quantity;
        this.unitPriceCents = unitPriceCents;
    }

    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public int getUnitPriceCents() { return unitPriceCents; }

    public void setQuantity(int q) { this.quantity = q; }
}
