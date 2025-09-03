public class Demo02 {
    public static void main(String[] args) {
        Player mediaPlayer = new Player();
        
        System.out.println("=== Media Player Demo ===");
        mediaPlayer.play(new byte[]{1, 2, 3, 4});
        
        System.out.println("\n=== Playing Another File ===");
        mediaPlayer.play(new byte[]{5, 6, 7, 8, 9, 10});
    }
}
