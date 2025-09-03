public class Rectangle {
    protected final int width;
    protected final int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int calculateArea() {
        return width * height;
    }
}