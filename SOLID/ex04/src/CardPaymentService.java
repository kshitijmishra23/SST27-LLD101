public class CardPaymentService implements PaymentService{
    @Override
    public String pay(double amount){
        return "Charged card: " + amount;
    }
    
}
