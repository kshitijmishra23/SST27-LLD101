public class Demo05 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(1,1);
        System.out.println(Geometry.areaAfterResizeRectangle(r)); // 20
        Square s = new Square(4);
        s.setSide(5);
        System.out.println(s.area()); // 25
    }
}
