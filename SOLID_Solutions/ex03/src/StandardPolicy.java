class StandardPolicy implements ShippingPolicy { public double cost(Shipment s){ return 50 + 5*s.weightKg; } }
