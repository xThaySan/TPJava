package Forms;

public class Ellipse extends Form {
    private Point center;
    private double rx;
    private double ry;

    public Ellipse(double cx, double cy, double rx, double ry) {
        super();
        this.center = new Point(cx, cy);
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public void Draw() {

    }

    @Override
    public String toSVG() {
        String str = "<ellipse";
        str += " xmlns=\"" + Form.xmlns + "\"";
        str += " cx=\"" + this.center.getX() + "\"";
        str += " cy=\"" + this.center.getY() + "\"";
        str += " rx=\"" + this.rx + "\"";
        str += " ry=\"" + this.ry + "\"";
        str += " stroke=\"black\"";
        str += " fill=\"none\"";
        str += "/>";
        return str;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "center=" + center +
                ", rx=" + rx +
                ", ry=" + ry +
                ", Matrix=" + this.matrix +
                '}';
    }
}
