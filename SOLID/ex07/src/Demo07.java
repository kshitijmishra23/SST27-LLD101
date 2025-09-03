public class Demo07 {
    public static void main(String[] args) {
        System.out.println("=== Printer Demo ===");
        
        // Basic printer can only print
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World");
        
        System.out.println("\n=== Multi-Function Printer Demo ===");
        
        // Multi-function printer can do everything
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Important document");
        mfp.scan("/documents/scanned/");
        mfp.fax("+1-555-0123");
        
        System.out.println("\n=== Interface Segregation Demo ===");
        
        // We can use specific interfaces for specific needs
        Scanner scanner = mfp;
        scanner.scan("/backup/");
        
        FaxMachine fax = mfp;
        fax.fax("+1-555-0456");
    }
}
