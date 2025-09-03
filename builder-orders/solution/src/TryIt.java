import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order o = new Order.Builder()
                .id("o2")
                .customerEmail("a@b.com")
                .addLine(l1.getSku(), l1.getQuantity(), l1.getUnitPriceCents())
                .addLine(l2.getSku(), l2.getQuantity(), l2.getUnitPriceCents())
                .discountPercent(10)
                .build();
        System.out.println("Total after discount: " + o.totalAfterDiscount());
        // mutate original lines; order should remain stable
        // (solution OrderLine is immutable; but even if external lines change, Order makes copies)
        System.out.println("Lines in order: " + o.getLines().size());
    }
}
