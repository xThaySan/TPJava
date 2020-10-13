package canvas.form;

import canvas.transform.Matrix;

public class Line extends Form {
    private Point p0;
    private Point p1;

    public Line(double x0, double y0, double x1, double y1) {
        this.p0 = new Point(x0, y0);
        this.p1 = new Point(x1, y1);
    }

    @Override
    public double getPerimeter() {
        return this.p0.distanceTo(this.p1);
    }

    @Override
    public double getArea() {
        return 0;
    }

    public Line draw() {
        Matrix R = this.consolidate();

        Matrix p0 = R.multiply(this.p0.getVector());
        double x0 = p0.getValue(0,0);
        double y0 = p0.getValue(1,0);

        Matrix p1 = R.multiply(this.p1.getVector());
        double x1 = p1.getValue(0,0);
        double y1 = p1.getValue(1,0);

        return new Line(x0, y0, x1, y1);
    }

    @Override
    public String toString() {
        return "Line{from=" + p0 + ", to=" + p1 + "}";
    }
}
