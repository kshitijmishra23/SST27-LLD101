public interface OrderRepository {
    void save(String id);
    String findById(String id);
    void delete(String id);
}
