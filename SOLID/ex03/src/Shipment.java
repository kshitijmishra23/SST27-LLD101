public class Shipment {
    private final String type;
    private final double weightKg;
    
    public Shipment(String type, double weightKg) {
        this.type = type;
        this.weightKg = weightKg;
    }
    
    public String getType() {
        return type;
    }
    
    public double getWeightKg() {
        return weightKg;
    }
}