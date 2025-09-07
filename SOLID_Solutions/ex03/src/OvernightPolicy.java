class OvernightPolicy implements ShippingPolicy { public double cost(Shipment s){ return 120 + 10*s.weightKg; } }
