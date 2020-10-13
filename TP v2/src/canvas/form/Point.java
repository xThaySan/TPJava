package canvas.form;

import canvas.transform.Matrix;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Matrix getVector() {
        Matrix R = new Matrix(3, 1);
        R.setValue(0, 0, this.x);
        R.setValue(1, 0, this.y);
        R.setValue(2, 0, 1);
        return R;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
