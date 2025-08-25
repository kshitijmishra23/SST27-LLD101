public class WalletPaymentService implements PaymentService {
    @Override
    public String pay(double amount){
        return "Wallet debit: " + amount;
    }
}
