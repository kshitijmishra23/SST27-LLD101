public class UpiPaymentProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Paid via UPI: $" + String.format("%.2f", amount);
    }
}
