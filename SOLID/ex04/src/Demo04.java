
public class Demo04 {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        
        System.out.println("=== Payment Processing Demo ===");
        
        Payment cardPayment = new Payment("CARD", 150.0);
        System.out.println(paymentService.processPayment(cardPayment));
        
        Payment upiPayment = new Payment("UPI", 75.50);
        System.out.println(paymentService.processPayment(upiPayment));
        
        Payment walletPayment = new Payment("WALLET", 25.0);
        System.out.println(paymentService.processPayment(walletPayment));
    }
}
