package Forms;

import java.util.Vector;

public class Polygon extends Form {
    private Vector<Point> points;

    public Polygon(double... points) throws IllegalArgumentException {
        super();
        if (points.length % 2 != 0) throw new IllegalArgumentException("Nombre de points incorrect");

        this.points = new Vector<Point>();

        for (int i = 0; i < points.length; i += 2) {
            this.points.add(new Point(points[i], points[i+1]));
        }
    }

    @Override
    public void Draw() {

    }

    @Override
    public String toSVG() {
        String str = "<polygon";
        str += " xmlns=\"" + Form.xmlns + "\"";

        str += " points=\"";
        int length = this.points.size();
        for (int i = 0; i < length; i++) {
            Point p = points.get(i);
            str += p.getX() + "," + p.getY() + (i < length-1 ? " " : "");
        }
        str += "\"";

        str += " stroke=\"black\"";
        str += " fill=\"none\"";
        return str + "/>";
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + points +
                ", Matrix=" + this.matrix +
                '}';
    }
}
