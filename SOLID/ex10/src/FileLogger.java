public class FileLogger implements Logger {
    private final String logFile;
    
    public FileLogger(String logFile) {
        this.logFile = logFile;
    }
    
    @Override
    public void log(String message) {
        System.out.println("[FILE_LOG:" + logFile + "] " + message);
    }
    
    @Override
    public void logError(String error) {
        System.err.println("[FILE_ERROR:" + logFile + "] " + error);
    }
    
    @Override
    public void logInfo(String info) {
        System.out.println("[FILE_INFO:" + logFile + "] " + info);
    }
}
