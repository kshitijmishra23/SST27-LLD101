class Square implements Shape { private int side; Square(int side){ this.side = side; } void setSide(int side){ this.side = side; } public int area(){ return side*side; } }
