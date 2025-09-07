class SqlOrderRepository implements OrderRepository { public void save(String id){ System.out.println("Saved order " + id + " to SQL"); } }
