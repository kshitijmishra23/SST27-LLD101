public abstract class Bird {
    protected String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void move();
    
    public void makeSound() {
        System.out.println("Bird sound");
    }
}