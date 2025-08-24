class ExpressShipment implements Shipment {
    double weight;

    public ExpressShipment(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateCost() {
        double baseCost = 80;
        double weightPerKg = 8;
        return baseCost + weightPerKg * weight;
    }
}