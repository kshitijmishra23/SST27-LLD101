public class Demo10 {
    public static void main(String[] args) {
        System.out.println("=== Report Service Demo ===");
        
        // Using console logger
        Logger consoleLogger = new ConsoleLogger();
        ReportService consoleReportService = new ReportService(consoleLogger);
        
        System.out.println("--- Console Logging ---");
        consoleReportService.generateDailyReport();
        
        System.out.println("\n--- File Logging ---");
        
        // Using file logger
        Logger fileLogger = new FileLogger("reports.log");
        ReportService fileReportService = new ReportService(fileLogger);
        
        fileReportService.generateWeeklyReport();
        fileReportService.generateErrorReport("Network timeout");
        
        System.out.println("\n--- Multiple Logger Demo ---");
        
        // Demonstrating different loggers
        ReportService multiLoggerService = new ReportService(new ConsoleLogger());
        multiLoggerService.generateDailyReport();
    }
}
