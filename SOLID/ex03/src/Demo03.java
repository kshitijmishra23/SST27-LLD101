public class Demo03 {
    public static void main(String[] args) {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        
        System.out.println("=== Shipping Cost Calculator Demo ===");
        
        Shipment standardShipment = new Shipment("STANDARD", 2.5);
        System.out.println("Standard shipping (2.5kg): $" + calculator.calculateCost(standardShipment));
        
        Shipment expressShipment = new Shipment("EXPRESS", 1.0);
        System.out.println("Express shipping (1.0kg): $" + calculator.calculateCost(expressShipment));
        
        Shipment overnightShipment = new Shipment("OVERNIGHT", 0.5);
        System.out.println("Overnight shipping (0.5kg): $" + calculator.calculateCost(overnightShipment));
    }
}
