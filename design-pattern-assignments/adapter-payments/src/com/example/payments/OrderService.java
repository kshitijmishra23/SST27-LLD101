package com.example.payments;

import java.util.Map;
import java.util.Objects;

public class OrderService {
    private final Map<String, PaymentGateway> gateways;

    public OrderService(Map<String, PaymentGateway> gateways) {
        this.gateways = Objects.requireNonNull(gateways, "gateways");
    }

    // Smell: still switches; your refactor should remove this by ensuring map contains adapters.
    public String charge(String provider, String customerId, int amountCents) {
        Objects.requireNonNull(provider, "provider");
        PaymentGateway gw = gateways.get(provider);
        if (gw == null) throw new IllegalArgumentException("unknown provider: " + provider);
        return gw.charge(customerId, amountCents);
    }
}
