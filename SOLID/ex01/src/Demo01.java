

public class Demo01 {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        OrderService orderService = new OrderService(emailService);
        
        System.out.println("=== Order Processing Demo ===");
        orderService.processOrder("customer@shop.com", 100.0);
        
        System.out.println("\n=== Second Order ===");
        orderService.processOrder("another@shop.com", 250.0);
    }
}
