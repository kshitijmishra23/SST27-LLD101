public class SqlOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Saved order " + order.getId() + " to SQL");
    }

    @Override
    public Order findById(String orderId) {
        // simulate fetch
        return new Order(orderId);
    }
}
