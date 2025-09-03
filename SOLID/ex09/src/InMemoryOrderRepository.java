import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, String> orders = new HashMap<>();
    
    @Override
    public void save(String id) {
        orders.put(id, "Order_" + id);
        System.out.println("Saved order " + id + " to in-memory storage");
    }
    
    @Override
    public String findById(String id) {
        String order = orders.get(id);
        if (order != null) {
            System.out.println("Retrieved order " + id + " from in-memory storage");
            return order;
        } else {
            System.out.println("Order " + id + " not found in in-memory storage");
            return null;
        }
    }
    
    @Override
    public void delete(String id) {
        if (orders.remove(id) != null) {
            System.out.println("Deleted order " + id + " from in-memory storage");
        } else {
            System.out.println("Order " + id + " not found for deletion");
        }
    }
}
