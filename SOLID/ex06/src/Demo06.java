public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        aviary.release(new FlyingBird());
        //aviary.release(new Penguin()); // runtime error
    }
}
