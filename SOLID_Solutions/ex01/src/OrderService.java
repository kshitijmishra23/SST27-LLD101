class OrderService {
    private final PriceCalculator calculator;
    private final Notifier notifier;
    OrderService(PriceCalculator calculator, Notifier notifier) {
        this.calculator = calculator; this.notifier = notifier;
    }
    void checkout(String customerEmail, double subtotal) {
        double total = calculator.totalWithTax(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}
