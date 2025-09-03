public class Demo08 {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Demo ===");
        
        // Bicycle - human powered vehicle
        Bicycle bicycle = new Bicycle();
        bicycle.pedal(15);
        bicycle.move();
        bicycle.brake();
        bicycle.stop();
        
        System.out.println("\n=== Car Demo ===");
        
        // Car - engine powered vehicle
        Car car = new Car();
        car.startEngine();
        car.accelerate(60);
        car.move();
        car.stop();
        car.stopEngine();
        
        System.out.println("\n=== Electric Car Demo ===");
        
        // Electric car - engine powered and rechargeable
        ElectricCar electricCar = new ElectricCar();
        System.out.println("Battery level: " + electricCar.getBatteryLevel() + "%");
        electricCar.startEngine();
        electricCar.accelerate(80);
        electricCar.move();
        electricCar.recharge(5.0);
        electricCar.accelerate(40);
        electricCar.stop();
        electricCar.stopEngine();
    }
}
