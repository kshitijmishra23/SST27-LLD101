public class SqlOrderRepository implements OrderRepository {
    @Override
    public void save(String id) {
        System.out.println("Saved order " + id + " to SQL database");
    }
    
    @Override
    public String findById(String id) {
        System.out.println("Retrieved order " + id + " from SQL database");
        return "Order_" + id;
    }
    
    @Override
    public void delete(String id) {
        System.out.println("Deleted order " + id + " from SQL database");
    }
}
