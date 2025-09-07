class PriceCalculator {
    private final double taxRate;
    PriceCalculator(double taxRate) { this.taxRate = taxRate; }
    double totalWithTax(double subtotal) { return subtotal + subtotal * taxRate; }
}
