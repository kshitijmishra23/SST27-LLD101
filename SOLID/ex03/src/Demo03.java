public class Demo03 {
    public static void main(String[] args) {
        Shipment s1 = new StandardShipment(2.0);
        Shipment s2 = new ExpressShipment(2.0);
        Shipment s3 = new OvernightShipment(2.0);
        System.out.println(s1.calculateCost());
        System.out.println(s2.calculateCost());
        System.out.println(s3.calculateCost());
    }
}
