public class ExpressShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 80.0 + 8.0 * weightKg;
    }
}
