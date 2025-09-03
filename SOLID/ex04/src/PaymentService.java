
public class PaymentService {
    private final PaymentProcessor cardProcessor;
    private final PaymentProcessor upiProcessor;
    private final PaymentProcessor walletProcessor;
    
    public PaymentService() {
        this.cardProcessor = new CardPaymentProcessor();
        this.upiProcessor = new UpiPaymentProcessor();
        this.walletProcessor = new WalletPaymentProcessor();
    }
    
    public String processPayment(Payment payment) {
        PaymentProcessor processor = getPaymentProcessor(payment.getProvider());
        return processor.process(payment.getAmount());
    }
    
    private PaymentProcessor getPaymentProcessor(String provider) {
        switch (provider.toUpperCase()) {
            case "CARD":
                return cardProcessor;
            case "UPI":
                return upiProcessor;
            case "WALLET":
                return walletProcessor;
            default:
                throw new IllegalArgumentException("Unsupported payment provider: " + provider);
        }
    }
}