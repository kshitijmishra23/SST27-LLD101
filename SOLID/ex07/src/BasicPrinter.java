public class BasicPrinter extends Machine implements PrintFunctionality {
    @Override
    public void print(String text) {
        System.out.println("Print: " + text);
    }
}
