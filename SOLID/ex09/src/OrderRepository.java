public interface OrderRepository {
    void save(Order order);
    Order findById(String orderId);
}
