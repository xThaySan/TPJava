package Forms;

import Transforms.Matrix;

public class Line extends Form {
    private Point p1;
    private Point p2;

    public Line(double x1, double y1, double x2, double y2) {
        super();
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    @Override
    public void Draw() {
        Matrix H = new Matrix(this.matrix);

        Matrix P = new Matrix(3, 1);
        P.set(0, 0, this.p1.getX());
        P.set(1, 0, this.p1.getY());
        P.set(2, 0, 1);

        System.out.println("P=" + P);
        System.out.println("H=" + H);
        H.Multiply(P);
        System.out.println("H=" + H);
    }

    @Override
    public String toSVG() {
        String str = "<line";
        str += " xmlns=\"" + Form.xmlns + "\"";
        str += " x1=\"" + this.p1.getX() + "\"";
        str += " y1=\"" + this.p1.getY() + "\"";
        str += " x2=\"" + this.p2.getX() + "\"";
        str += " y2=\"" + this.p2.getY() + "\"";
        str += " stroke=\"black\"";
        str += " fill=\"none\"";
        str += "/>";
        return str;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", Matrix=" + this.matrix +
                '}';
    }
}
