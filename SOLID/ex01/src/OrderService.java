public class OrderService {
    TaxPolicy taxPolicy;
    MessageClient notifier;

    public OrderService(TaxPolicy taxPolicy, MessageClient notifier) {
        this.taxPolicy = taxPolicy;
        this.notifier = notifier;
    }

    private double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxPolicy.getTaxRate();
    }

    public void checkout(String customerContact, double subtotal) {
        double total = totalWithTax(subtotal);
        notifier.send(customerContact, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}
