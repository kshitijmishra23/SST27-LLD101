class ConsoleRenderer implements Renderer {
    public void render(Frame f){ System.out.println("▶ Playing " + (f.data==null?0:f.data.length) + " bytes"); }
}
