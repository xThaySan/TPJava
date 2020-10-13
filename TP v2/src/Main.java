import canvas.form.Line;
import canvas.form.Point;
import canvas.transform.Matrix;
import canvas.transform.Rotation;
import canvas.transform.Transformation;
import canvas.transform.Translate;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(0, 0, 10, 10);
        line.rotate(10);
        line.translate(15, 25);
        System.out.println(line);
        System.out.println(line.draw());
    }
}
