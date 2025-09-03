public class Sparrow extends Bird implements FlyingBird {
    public Sparrow(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        fly();
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying: Flap flap!");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet tweet!");
    }
}
