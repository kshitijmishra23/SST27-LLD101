public class WalletPaymentProcessor implements PaymentProcessor {
    @Override
    public String process(double amount) {
        return "Wallet debit: $" + String.format("%.2f", amount);
    }
}
