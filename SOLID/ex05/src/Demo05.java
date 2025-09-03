
public class Demo05 {
    public static void main(String[] args) {
        System.out.println("=== Rectangle and Square Demo ===");
        
        Rectangle rectangle = new Rectangle(5, 4);
        System.out.println("Rectangle (5x4) area: " + rectangle.calculateArea());
        
        Square square = new Square(4);
        System.out.println("Square (4x4) area: " + square.calculateArea());
        System.out.println("Square (4x4) perimeter: " + square.calculatePerimeter());
        
        // Now both classes behave predictably and independently
        System.out.println("\n=== Independent Behavior ===");
        Rectangle newRect = new Rectangle(3, 6);
        System.out.println("New Rectangle (3x6) area: " + newRect.calculateArea());
        
        Square newSquare = new Square(5);
        System.out.println("New Square (5x5) area: " + newSquare.calculateArea());
    }
}
