package Transforms;

import Forms.Point;

public class Rotation extends Transformation {
    private double angle;
    private Point center;

    public Rotation(double degree) {
        this(degree, 0, 0);
    }

    public Rotation(double degree, double cx, double cy) {
        super();

        this.angle = degree;
        this.center = new Point(cx, cy);

        // Translate
        this.matrix.set(0, 2, cx);
        this.matrix.set(1, 2, cy);

        // Rotate
        Matrix rotation = new Matrix(3, 3);
        rotation.set(0, 0, Math.cos(Math.toRadians(degree)));
        rotation.set(0, 1, -Math.sin(Math.toRadians(degree)));
        rotation.set(1, 0, Math.sin(Math.toRadians(degree)));
        rotation.set(1, 1, Math.cos(Math.toRadians(degree)));
        this.matrix.Multiply(rotation);

        // Restore Translate
        Matrix translation = new Matrix(3, 3);
        translation.set(0, 2, -cx);
        translation.set(1, 2, -cy);
        this.matrix.Multiply(translation);
    }

    public double getAngle() {
        return angle;
    }

    public Point getCenter() {
        return center;
    }
}
