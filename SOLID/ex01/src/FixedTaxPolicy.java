public class FixedTaxPolicy implements TaxPolicy {
    private final double rate;

    public FixedTaxPolicy(double rate) {
        this.rate = rate;
    }

    @Override
    public double getTaxRate() {
        return rate;
    }
}