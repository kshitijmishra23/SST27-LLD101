public class Demo09 {
    public static void main(String[] args) {
        OrderController prod = new OrderController(new SqlOrderRepository());
        prod.create("ORD-1");
        OrderController test = new OrderController(new InMemoryOrderRepository());
        test.create("ORD-2");
    }
}
