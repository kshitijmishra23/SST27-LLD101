public class OvernightShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 120.0 + 10.0 * weightKg;
    }
}
