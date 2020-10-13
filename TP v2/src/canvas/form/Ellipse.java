package canvas.form;

public class Ellipse extends Form {
    private Point center;
    private double rx;
    private double ry;

    public Ellipse(double cx, double cy, double r) {
        this(cx, cy, r, r);
    }

    public Ellipse(double cx, double cy, double rx, double ry) {
        this.center = new Point(cx, cy);
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public double getPerimeter() {
        double a = Math.pow(this.rx, 2);
        double b = Math.pow(this.ry, 2);
        return 2 * Math.PI * Math.sqrt((a + b) / 2);
    }

    @Override
    public double getArea() {
        return Math.PI * this.rx * this.ry;
    }

    @Override
    public Form draw() {
        return null;
    }
}
