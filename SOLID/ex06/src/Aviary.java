public class Aviary {
    public void releaseBird(Bird bird) {
        System.out.println("Releasing " + bird.getName() + " from aviary");
        bird.move();
        System.out.println("Bird released successfully!");
    }
    
    public void releaseFlyingBird(FlyingBird flyingBird) {
        System.out.println("Releasing flying bird from aviary");
        flyingBird.fly();
        System.out.println("Flying bird released successfully!");
    }
}