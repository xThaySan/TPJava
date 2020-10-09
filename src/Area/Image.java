package Area;

import Transforms.Matrix;
import Conversion.SVG;
import Forms.Ellipse;
import Forms.Form;
import Forms.Line;
import Forms.Polygon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Image implements SVG {
    static private final Pattern ALLOW_ID_REGEX = Pattern.compile("^[a-zA-Z0-9_]+$");

    private Matrix matrix;
    private List<Form> forms;
    private String id;

    public Image(String id) throws InstantiationException {
        if (!ALLOW_ID_REGEX.matcher(id).find()) throw new InstantiationException("ID is not valid;");
        this.id = id;
        this.matrix = new Matrix(3, 3);
        this.forms = new ArrayList<Form>();
    }

    public Line Line(double x1, double y1, double x2, double y2) {
        Line line = null;
        try {
            line = new Line(x1, y1, x2, y2);
            forms.add(line);
        } catch (Exception e) {
            System.out.println(e);
        }
        return line;
    }

    public Polygon Polygon(double... points) {
        Polygon polygon = null;
        try {
            polygon = new Polygon(points);
            forms.add(polygon);
        } catch (Exception e) {
            System.out.println(e);
        }
        return polygon;
    }

    public Ellipse Ellipse(double cx, double cy, double rx, double ry) {
        Ellipse ellipse = null;
        try {
            ellipse = new Ellipse(cx, cy, rx, ry);
            forms.add(ellipse);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ellipse;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toSVG() {
        String str = "<g id=\"" + this.id + "\">";
            for (Form form: this.forms) {
                str += form.toSVG();
            }
        str += "</g>";
        return str;
    }
}
