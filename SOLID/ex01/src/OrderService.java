public class OrderService {
    private final double taxRate = 0.18;
    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public double calculateTotalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }

    public void processOrder(String customerEmail, double subtotal) {
        double total = calculateTotalWithTax(subtotal);
        notificationService.sendOrderConfirmation(customerEmail, total);
        System.out.println("Order stored in database successfully.");
    }
}