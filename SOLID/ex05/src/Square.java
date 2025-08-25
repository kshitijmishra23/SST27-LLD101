class Square implements Shape {
    private int side;

    void setSide(int side) { this.side = side; }

    @Override
    public int area() {
        return side * side;
    }
}