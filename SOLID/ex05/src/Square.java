
public class Square {
    private final int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public int getSide() {
        return side;
    }
    
    public int calculateArea() {
        return side * side;
    }
    
    public int calculatePerimeter() {
        return 4 * side;
    }
}