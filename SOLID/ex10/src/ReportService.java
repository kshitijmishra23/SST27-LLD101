public class ReportService {
    private final Logger logger;
    
    public ReportService(Logger logger) {
        this.logger = logger;
    }
    
    public void generateDailyReport() {
        logger.logInfo("Starting daily report generation...");
        System.out.println("=== Daily Report ===");
        System.out.println("Date: " + java.time.LocalDate.now());
        System.out.println("Sales: $15,420");
        System.out.println("Orders: 127");
        System.out.println("Customers: 89");
        logger.log("Daily report generated successfully");
    }
    
    public void generateWeeklyReport() {
        logger.logInfo("Starting weekly report generation...");
        System.out.println("=== Weekly Report ===");
        System.out.println("Week: " + java.time.LocalDate.now().get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear()));
        System.out.println("Total Sales: $98,750");
        System.out.println("Total Orders: 892");
        System.out.println("New Customers: 45");
        logger.log("Weekly report generated successfully");
    }
    
    public void generateErrorReport(String error) {
        logger.logError("Error occurred during report generation: " + error);
        System.out.println("Error report logged to system");
    }
}