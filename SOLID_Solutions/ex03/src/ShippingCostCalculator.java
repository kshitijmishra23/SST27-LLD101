import java.util.HashMap;
import java.util.Map;
class ShippingCostCalculator {
    private final Map<String, ShippingPolicy> policies = new HashMap<>();
    void register(String type, ShippingPolicy policy){ policies.put(type, policy); }
    double cost(Shipment s){
        ShippingPolicy p = policies.get(s.type);
        if (p==null) throw new IllegalArgumentException("Unknown type: " + s.type);
        return p.cost(s);
    }
}
