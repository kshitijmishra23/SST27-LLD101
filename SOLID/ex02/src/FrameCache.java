public class FrameCache {
    private Frame lastFrame;
    
    public void storeLastFrame(Frame frame) {
        this.lastFrame = frame;
    }
    
    public boolean hasLastFrame() {
        return lastFrame != null;
    }
    
    public Frame getLastFrame() {
        return lastFrame;
    }
}
