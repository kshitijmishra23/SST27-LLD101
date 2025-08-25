class Rectangle implements Shape {
    private int w, h;

    void setWidth(int w) { this.w = w; }
    void setHeight(int h) { this.h = h; }

    @Override
    public int area() {
        return w * h;
    }
}