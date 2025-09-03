public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
    
    @Override
    public void logError(String error) {
        System.err.println("[ERROR] " + error);
    }
    
    @Override
    public void logInfo(String info) {
        System.out.println("[INFO] " + info);
    }
}