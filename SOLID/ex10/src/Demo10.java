public class Demo10 {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        ReportService reportService = new ReportService(logger);
        reportService.generate();
    }
}
