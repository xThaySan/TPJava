package canvas.transform;

public class Scale extends Transformation {
    private double sx;
    private double sy;

    public Scale(double s) {
        this(s, s);
    }

    public Scale(double sx, double sy) {
        super();
        this.sx = sx;
        this.sy = sy;
        this.matrix.setValue(0, 0, this.sx);
        this.matrix.setValue(1, 1, this.sy);
    }
}
