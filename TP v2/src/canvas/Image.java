package canvas;

import canvas.form.Form;
import canvas.transform.Transformable;

import java.util.Vector;

public class Image implements Transformable {
    private Vector<Form> forms;

    public Vector<Form> getForms() {
        return forms;
    }

    public void sortByPerimeter() {

    }

    public void sortByArea() {

    }

    @Override
    public void translate(double t) {
        for (Form form: this.forms) {
            form.translate(t);
        }
    }

    @Override
    public void translate(double tx, double ty) {
        for (Form form: this.forms) {
            form.translate(tx, ty);
        }
    }

    @Override
    public void rotate(double degree) {
        for (Form form: this.forms) {
            form.rotate(degree);
        }
    }

    @Override
    public void rotate(double degree, double cx, double cy) {
        for (Form form: this.forms) {
            form.rotate(degree, cx, cy);
        }
    }

    @Override
    public void scale(double s) {
        for (Form form: this.forms) {
            form.scale(s);
        }
    }

    @Override
    public void scale(double sx, double sy) {
        for (Form form: this.forms) {
            form.scale(sx, sy);
        }
    }

    @Override
    public void reflect() {
        for (Form form: this.forms) {
            form.reflect();
        }
    }

    @Override
    public void reflectX() {
        for (Form form: this.forms) {
            form.reflectX();
        }
    }

    @Override
    public void reflectY() {
        for (Form form: this.forms) {
            form.reflectY();
        }
    }
}
