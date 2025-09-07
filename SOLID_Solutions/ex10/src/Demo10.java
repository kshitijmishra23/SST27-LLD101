public class Demo10 {
    public static void main(String[] args) {
        ReportService svc = new ReportService(new ConsoleLogger());
        svc.generate();
    }
}
