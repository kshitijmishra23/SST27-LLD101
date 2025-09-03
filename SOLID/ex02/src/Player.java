public class Player {
    private final MediaDecoder mediaDecoder;
    private final FrameCache frameCache;
    private final PlaybackUI playbackUI;
    
    public Player() {
        this.mediaDecoder = new MediaDecoder();
        this.frameCache = new FrameCache();
        this.playbackUI = new PlaybackUI();
    }
    
    public void play(byte[] fileBytes) {
        Frame decodedFrame = mediaDecoder.decodeFrame(fileBytes);
        frameCache.storeLastFrame(decodedFrame);
        playbackUI.displayPlaybackStatus(fileBytes.length);
        playbackUI.showCacheStatus(frameCache.hasLastFrame());
    }
}