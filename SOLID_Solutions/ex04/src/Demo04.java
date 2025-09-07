public class Demo04 {
    public static void main(String[] args) {
        PaymentRegistry reg = new PaymentRegistry();
        reg.register(new CardProcessor());
        reg.register(new UpiProcessor());
        reg.register(new WalletProcessor());
        reg.register(new PaymentProcessor() {
            public String providerName(){ return "BNPL"; }
            public String pay(Payment p){ return "BNPL authorized: " + p.amount; }
        });
        PaymentService svc = new PaymentService(reg);
        System.out.println(svc.pay(new Payment("UPI", 499)));
        System.out.println(svc.pay(new Payment("BNPL", 999)));
    }
}
