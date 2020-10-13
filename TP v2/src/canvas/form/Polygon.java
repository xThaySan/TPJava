package canvas.form;

import java.util.Vector;

public class Polygon extends Form {
    private Vector<Point> points;

    public Polygon(double... points) {
        if (points.length < 6) throw new IllegalArgumentException("Le nombre de coordonnées doit être d'au moins 6 pour créer 3 points");
        if (points.length % 2 != 0) throw new IllegalArgumentException("Le nombre de coordonnées doit être pair pour créer des points");

        this.points = new Vector<>();
        for (int i = 0; i < points.length; i += 2) {
            this.points.add(new Point(points[i], points[i+1]));
        }
    }

    @Override
    public double getPerimeter() {
        double result = 0;
        int length = this.points.size();
        for (int i = 0; i < length; i++) {
            result += this.points.get(i).distanceTo(points.get((i+1) % length));
        }
        return result;
    }

    @Override
    public double getArea() {
        return -1;
    }

    @Override
    public Form draw() {
        return null;
    }
}
