package canvas.transform;

import canvas.form.Point;

public class Rotation extends Transformation {
    private double degree;
    private Point center;

    public Rotation(double degree) {
        this(degree, 0, 0);
    }

    public Rotation(double degree, double cx, double cy) {
        super();
        this.degree = degree;
        this.center = new Point(cx, cy);
        double rad = this.degree * Math.PI / 180;
        this.matrix.setValue(0, 0, Math.cos(rad));
        this.matrix.setValue(0, 1, -Math.sin(rad));
        this.matrix.setValue(1, 0, Math.sin(rad));
        this.matrix.setValue(1, 1, Math.cos(rad));
    }
}
