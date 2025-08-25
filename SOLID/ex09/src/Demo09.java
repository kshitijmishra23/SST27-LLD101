public class Demo09 {
    public static void main(String[] args) {
        OrderRepository repository = new SqlOrderRepository();
        OrderController controller = new OrderController(repository);

        Order order = new Order("ORD-1");
        controller.create(order);
    }
}
