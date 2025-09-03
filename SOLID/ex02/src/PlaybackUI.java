public class PlaybackUI {
    public void displayPlaybackStatus(int bytesCount) {
        System.out.println("\u25B6 Playing " + bytesCount + " bytes");
    }
    
    public void showCacheStatus(boolean hasCachedFrame) {
        System.out.println("Cached last frame? " + hasCachedFrame);
    }
}
