package Forms;

import Transforms.Matrix;
import Conversion.SVG;

public abstract class Form implements SVG {
    static final protected String xmlns = "http://www.w3.org/2000/svg";
    protected Matrix matrix;

    public Form() {
       this.matrix = new Matrix(3, 3);
    }

    public void Translate(double x, double y) {
        Matrix translation = new Matrix(3, 3);
        translation.set(0, 2, x);
        translation.set(1, 2, y);
        this.matrix.Multiply(translation);
    }

    public void Rotate(double degree) {
        Matrix rotation = new Matrix(3, 3);
        rotation.set(0, 0, Math.cos(degree));
        rotation.set(0, 1, -Math.sin(degree));
        rotation.set(1, 0, Math.sin(degree));
        rotation.set(1, 1, Math.cos(degree));
        this.matrix.Multiply(rotation);
    }

    public abstract void Draw();

    @Override
    public String toString() {
        return "Form{" +
                "Matrix=" + this.matrix +
                '}';
    }
}
