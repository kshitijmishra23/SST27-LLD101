public class Demo01 {
    public static void main(String[] args) {
        var taxPolicy = new FixedTaxPolicy(0.18);
        MessageClient notifier = new EmailClient();
        OrderService orderService = new OrderService(taxPolicy, notifier);
        orderService.checkout("customer@example.com", 1000.0);
    }
}
