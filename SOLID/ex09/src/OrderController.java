public class OrderController {
    private final OrderRepository orderRepository;
    
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public void createOrder(String id) {
        orderRepository.save(id);
        System.out.println("Created order: " + id);
    }
    
    public String getOrder(String id) {
        return orderRepository.findById(id);
    }
    
    public void removeOrder(String id) {
        orderRepository.delete(id);
        System.out.println("Removed order: " + id);
    }
}