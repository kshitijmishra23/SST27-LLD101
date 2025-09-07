class SingleFrameCache implements FrameCache {
    private Frame last;
    public void put(Frame f){ last = f; }
    public Frame last(){ return last; }
}
