package canvas.transform;

public interface Transformable {
    public abstract void translate(double t);
    public abstract void translate(double tx, double ty);
    public abstract void rotate(double degree);
    public abstract void rotate(double degree, double cx, double cy);
    public abstract void scale(double s);
    public abstract void scale(double sx, double sy);
    public abstract void reflect();
    public abstract void reflectX();
    public abstract void reflectY();
}
