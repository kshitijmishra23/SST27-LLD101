class PaymentService {
    private final PaymentRegistry registry;
    PaymentService(PaymentRegistry r){ this.registry=r; }
    String pay(Payment p){
        PaymentProcessor proc = registry.of(p.provider);
        if (proc==null) throw new RuntimeException("No provider: " + p.provider);
        return proc.pay(p);
    }
}
