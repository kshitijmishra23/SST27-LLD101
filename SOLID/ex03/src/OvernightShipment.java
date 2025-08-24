class OvernightShipment implements Shipment {
    private final double weight;

    public OvernightShipment(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateCost() {
        double baseCost = 120;
        double weightPerKg = 10;
        return baseCost + weightPerKg * weight;
    }
}