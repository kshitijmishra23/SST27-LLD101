public class Demo01 {
    public static void main(String[] args) {
        OrderService svc = new OrderService(new PriceCalculator(0.18), new EmailNotifier());
        svc.checkout("a@shop.com", 100.0);
    }
}
