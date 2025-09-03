public class MultiFunctionPrinter implements Printer, Scanner, FaxMachine {
    @Override
    public void print(String text) {
        System.out.println("Printing: " + text);
    }
    
    @Override
    public void scan(String destinationPath) {
        System.out.println("Scanning document to: " + destinationPath);
    }
    
    @Override
    public void fax(String phoneNumber) {
        System.out.println("Sending fax to: " + phoneNumber);
    }
}
