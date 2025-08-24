
public class Demo04 {
    public static void main(String[] args) {
        // System.out.println(new PaymentService().pay(new Payment("UPI", 499)));
        PaymentService ps = new UPIPaymentService();
        System.out.println(ps.pay(499));
    }
}
