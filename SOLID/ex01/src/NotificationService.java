public interface NotificationService {
    void sendOrderConfirmation(String customerEmail, double total);
}
