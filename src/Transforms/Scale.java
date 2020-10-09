package Transforms;

public class Scale extends Transformation {
    private double x;
    private double y;

    public Scale(double x) {
        this(x, x);
    }

    public Scale(double x, double y) {
        super();

        this.matrix.set(0, 0, x);
        this.matrix.set(1, 1, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
