public class Demo07 {
    public static void main(String[] args) {
        Printer p = new BasicPrinter();
        new PrintClient().printReceipt(p, "Hello");
    }
}
