public class Car implements Vehicle, EnginePowered {
    private boolean engineRunning = false;
    private int currentSpeed = 0;
    
    @Override
    public void move() {
        if (engineRunning && currentSpeed > 0) {
            System.out.println("Car is driving at speed " + currentSpeed);
        } else if (!engineRunning) {
            System.out.println("Car cannot move - engine is off");
        } else {
            System.out.println("Car is stationary");
        }
    }
    
    @Override
    public void stop() {
        currentSpeed = 0;
        System.out.println("Car stopped");
    }
    
    @Override
    public void startEngine() {
        engineRunning = true;
        System.out.println("Car engine started");
    }
    
    @Override
    public void stopEngine() {
        engineRunning = false;
        currentSpeed = 0;
        System.out.println("Car engine stopped");
    }
    
    public void accelerate(int speed) {
        if (engineRunning) {
            currentSpeed = speed;
            System.out.println("Car accelerated to speed " + speed);
        } else {
            System.out.println("Cannot accelerate - engine is off");
        }
    }
}
