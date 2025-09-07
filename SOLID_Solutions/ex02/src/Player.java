class Player {
    private final Decoder decoder;
    private final Renderer renderer;
    private final FrameCache cache;
    Player(Decoder d, Renderer r, FrameCache c){ decoder=d; renderer=r; cache=c; }
    void play(byte[] fileBytes){
        Frame f = decoder.decode(fileBytes);
        cache.put(f);
        renderer.render(f);
        System.out.println("Cached last frame? " + (cache.last()!=null));
    }
}
