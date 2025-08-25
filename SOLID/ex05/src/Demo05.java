public class Demo05 {

    static int areaAfterResize(Shape s) {
        return s.area();
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setWidth(5);
        r.setHeight(4);
        System.out.println(areaAfterResize(r)); // 20

        Square sq = new Square();
        sq.setSide(4);
        System.out.println(areaAfterResize(sq)); // 16
    }
}
