public class StandardShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 50.0 + 5.0 * weightKg;
    }
}
