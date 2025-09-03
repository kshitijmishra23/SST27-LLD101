public class ElectricCar implements Vehicle, EnginePowered, Rechargeable {
    private boolean engineRunning = false;
    private int currentSpeed = 0;
    private double batteryLevel = 100.0;
    
    @Override
    public void move() {
        if (engineRunning && currentSpeed > 0 && batteryLevel > 0) {
            System.out.println("Electric car is driving at speed " + currentSpeed + " (Battery: " + batteryLevel + "%)");
        } else if (!engineRunning) {
            System.out.println("Electric car cannot move - engine is off");
        } else if (batteryLevel <= 0) {
            System.out.println("Electric car cannot move - battery is empty");
        } else {
            System.out.println("Electric car is stationary");
        }
    }
    
    @Override
    public void stop() {
        currentSpeed = 0;
        System.out.println("Electric car stopped");
    }
    
    @Override
    public void startEngine() {
        if (batteryLevel > 0) {
            engineRunning = true;
            System.out.println("Electric car engine started");
        } else {
            System.out.println("Cannot start engine - battery is empty");
        }
    }
    
    @Override
    public void stopEngine() {
        engineRunning = false;
        currentSpeed = 0;
        System.out.println("Electric car engine stopped");
    }
    
    @Override
    public void recharge(double kWh) {
        batteryLevel = Math.min(100.0, batteryLevel + kWh * 10);
        System.out.println("Recharged " + kWh + " kWh. New battery level: " + batteryLevel + "%");
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
    
    public void accelerate(int speed) {
        if (engineRunning && batteryLevel > 0) {
            currentSpeed = speed;
            batteryLevel = Math.max(0, batteryLevel - speed * 0.1);
            System.out.println("Electric car accelerated to speed " + speed + " (Battery: " + batteryLevel + "%)");
        } else if (!engineRunning) {
            System.out.println("Cannot accelerate - engine is off");
        } else {
            System.out.println("Cannot accelerate - battery is empty");
        }
    }
}
