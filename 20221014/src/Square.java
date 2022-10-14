public class Square extends Shape {
    private int side;

    public void setSide(int s) {
        side = s;
    }

    public int getSide() {
        return side;
    }

    public float calcArea() {
        return side * side;
    }

}
