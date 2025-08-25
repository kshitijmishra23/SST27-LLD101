public class UPIPaymentService implements PaymentService {
    @Override
    public String pay(double amount){
        return "Paid via UPI: " + amount;
    }
}
