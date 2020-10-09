package Transforms;

public abstract class Transformation {
    protected Matrix matrix;

    public Transformation() {
        this.matrix = new Matrix(3, 3);
    }

    public Matrix getMatrix() {
        return this.matrix;
    }
}
