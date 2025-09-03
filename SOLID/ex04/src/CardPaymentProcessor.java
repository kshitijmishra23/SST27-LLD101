public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Charged card: $" + String.format("%.2f", amount);
    }
}
