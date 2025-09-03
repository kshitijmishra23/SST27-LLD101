public class Demo09 {
    public static void main(String[] args) {
        System.out.println("=== Order Management Demo ===");
        
        // Using SQL repository
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController sqlController = new OrderController(sqlRepo);
        
        System.out.println("--- SQL Repository Operations ---");
        sqlController.createOrder("ORD001");
        sqlController.getOrder("ORD001");
        sqlController.removeOrder("ORD001");
        
        System.out.println("\n--- In-Memory Repository Operations ---");
        
        // Using in-memory repository for testing
        OrderRepository memoryRepo = new InMemoryOrderRepository();
        OrderController memoryController = new OrderController(memoryRepo);
        
        memoryController.createOrder("TEST001");
        memoryController.getOrder("TEST001");
        memoryController.createOrder("TEST002");
        memoryController.removeOrder("TEST001");
        memoryController.getOrder("TEST001"); // Should return null
    }
}
