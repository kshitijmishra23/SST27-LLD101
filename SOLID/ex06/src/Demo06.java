public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        
        System.out.println("=== Bird Release Demo ===");
        
        Bird sparrow = new Sparrow("Jack");
        Bird penguin = new Penguin("Waddles");
        
        System.out.println("--- Releasing Sparrow ---");
        aviary.releaseBird(sparrow);
        
        System.out.println("\n--- Releasing Penguin ---");
        aviary.releaseBird(penguin);
        
        System.out.println("\n--- Penguin Special Abilities ---");
        ((Penguin) penguin).swim();
        
        System.out.println("\n--- Flying Bird Demo ---");
        FlyingBird flyingBird = new Sparrow("Sky");
        aviary.releaseFlyingBird(flyingBird);
    }
}
