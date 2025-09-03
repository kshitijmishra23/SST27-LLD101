public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " is waddling on the ground");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " honks: Honk honk!");
    }
    
    public void swim() {
        System.out.println(name + " is swimming gracefully");
    }
}