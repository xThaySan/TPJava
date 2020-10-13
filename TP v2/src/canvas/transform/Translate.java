package canvas.transform;

public class Translate extends Transformation {
    private double tx;
    private double ty;

    public Translate(double t) {
        this(t, t);
    }

    public Translate(double tx, double ty) {
        super();
        this.tx = tx;
        this.ty = ty;
        this.matrix.setValue(0, 2, this.tx);
        this.matrix.setValue(1, 2, this.ty);
    }
}
