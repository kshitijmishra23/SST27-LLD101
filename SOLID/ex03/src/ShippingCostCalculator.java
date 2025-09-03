public class ShippingCostCalculator {
    private final ShippingStrategy standardShipping;
    private final ShippingStrategy expressShipping;
    private final ShippingStrategy overnightShipping;
    
    public ShippingCostCalculator() {
        this.standardShipping = new StandardShippingStrategy();
        this.expressShipping = new ExpressShippingStrategy();
        this.overnightShipping = new OvernightShippingStrategy();
    }
    
    public double calculateCost(Shipment shipment) {
        ShippingStrategy strategy = getShippingStrategy(shipment.getType());
        return strategy.calculateCost(shipment.getWeightKg());
    }
    
    private ShippingStrategy getShippingStrategy(String shippingType) {
        switch (shippingType.toUpperCase()) {
            case "STANDARD":
                return standardShipping;
            case "EXPRESS":
                return expressShipping;
            case "OVERNIGHT":
                return overnightShipping;
            default:
                throw new IllegalArgumentException("Unknown shipping type: " + shippingType);
        }
    }
}
