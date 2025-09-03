public class EmailClient implements NotificationService {
    @Override
    public void sendOrderConfirmation(String customerEmail, double total) {
        String message = "Thank you for your order! Your total amount is $" + String.format("%.2f", total);
        send(customerEmail, message);
    }

    void send(String to, String body) {
        System.out.println("[EMAIL to=" + to + "] " + body);
    }
}

