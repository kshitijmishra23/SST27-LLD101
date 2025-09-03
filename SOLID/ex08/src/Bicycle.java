public class Bicycle implements Vehicle, HumanPowered {
    private int currentSpeed = 0;
    
    @Override
    public void move() {
        if (currentSpeed > 0) {
            System.out.println("Bicycle is moving at speed " + currentSpeed);
        } else {
            System.out.println("Bicycle is stationary");
        }
    }
    
    @Override
    public void stop() {
        currentSpeed = 0;
        System.out.println("Bicycle stopped");
    }
    
    @Override
    public void pedal(int effort) {
        currentSpeed = effort;
        System.out.println("Pedaling with effort " + effort + ", speed: " + currentSpeed);
    }
    
    @Override
    public void brake() {
        currentSpeed = Math.max(0, currentSpeed - 5);
        System.out.println("Braking, new speed: " + currentSpeed);
    }
}