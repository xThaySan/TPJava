package Transforms;

public class Translation extends Transformation {
    private double x;
    private double y;

    public Translation(double x) {
        this(x, 0);
    }

    public Translation(double x, double y) {
        super();
        this.x = x;
        this.y = y;

        this.matrix.set(0, 2, this.x);
        this.matrix.set(1, 2, this.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
