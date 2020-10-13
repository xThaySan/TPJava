package canvas.form;

import canvas.transform.*;

import java.util.Vector;

public abstract class Form implements Transformable {
    private Vector<Transformation> transformations;

    public Form() {
        this.transformations = new Vector<>();
    }

    public Vector<Transformation> getTransformations() {
        return transformations;
    }

    public Matrix consolidate() {
        Matrix R = new Matrix(3, 3);
        for (Transformation transformation: this.transformations) {
            R = R.multiply(transformation.getMatrix());
        }
        return R;
    }

    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract Form draw();

    @Override
    public void translate(double t) {
        this.transformations.add(new Translate(t));
    }

    @Override
    public void translate(double tx, double ty) {
        this.transformations.add(new Translate(tx, ty));
    }

    @Override
    public void rotate(double degree) {
        this.transformations.add(new Rotation(degree));

    }

    @Override
    public void rotate(double degree, double cx, double cy) {
        this.transformations.add(new Rotation(degree, cx, cy));
    }

    @Override
    public void scale(double s) {
        this.transformations.add(new Scale(s));
    }

    @Override
    public void scale(double sx, double sy) {
        this.transformations.add(new Scale(sx, sy));
    }

    @Override
    public void reflect() {
        this.transformations.add(new Scale(-1, -1));
    }

    @Override
    public void reflectX() {
        this.transformations.add(new Scale(-1, 0));
    }

    @Override
    public void reflectY() {
        this.transformations.add(new Scale(0, -1));
    }
}
