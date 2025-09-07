public class Demo02 {
    public static void main(String[] args) {
        Player p = new Player(new PassthroughDecoder(), new ConsoleRenderer(), new SingleFrameCache());
        p.play(new byte[]{1,2,3,4});
        p.play(new byte[]{9,9});
    }
}
