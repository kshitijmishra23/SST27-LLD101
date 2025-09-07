class ExpressPolicy  implements ShippingPolicy { public double cost(Shipment s){ return 80 + 8*s.weightKg; } }
