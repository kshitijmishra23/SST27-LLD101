import java.util.HashMap;
import java.util.Map;
class PaymentRegistry {
    private final Map<String, PaymentProcessor> map = new HashMap<>();
    void register(PaymentProcessor proc){ map.put(proc.providerName(), proc); }
    PaymentProcessor of(String provider){ return map.get(provider); }
}
