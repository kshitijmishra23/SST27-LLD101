package com.example.orders;

import java.util.List;

public final class PricingRules {
    private PricingRules() {}

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean isValidDiscount(Integer d) {
        return d == null || (d >= 0 && d <= 100);
    }

    public static boolean isEmptyLines( List<OrderLine> lines) {
        return lines == null || lines.isEmpty();
    }
}