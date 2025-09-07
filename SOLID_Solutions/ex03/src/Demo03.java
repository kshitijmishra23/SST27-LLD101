public class Demo03 {
    public static void main(String[] args) {
        ShippingCostCalculator calc = new ShippingCostCalculator();
        calc.register("STANDARD", new StandardPolicy());
        calc.register("EXPRESS", new ExpressPolicy());
        calc.register("OVERNIGHT", new OvernightPolicy());
        calc.register("DRONE", s -> 30 + 12*s.weightKg);
        System.out.println(calc.cost(new Shipment("EXPRESS", 2.0)));
        System.out.println(calc.cost(new Shipment("DRONE", 1.0)));
    }
}
