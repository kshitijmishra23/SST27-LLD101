package com.example.orders;

import java.util.List;
import java.util.Objects;

public class OrderService {
    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        Order.Builder b = new Order.Builder()
                .id(Objects.requireNonNull(id, "id"))
                .customerEmail(email)
                .discountPercent(discount)
                .expedited(expedited)
                .notes(notes);
        if (lines != null) {
            for (OrderLine l : lines) b.addLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents());
        }
        return b.build();
    }
}
