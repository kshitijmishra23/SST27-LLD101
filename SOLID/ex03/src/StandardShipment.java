class StandardShipment implements Shipment {
    private final double weight;

    public StandardShipment(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateCost() {
        double baseCost = 50;
        double weightPerKg = 5;
        return baseCost + weightPerKg * weight;
    }
}