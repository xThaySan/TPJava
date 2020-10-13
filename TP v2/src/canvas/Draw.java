package canvas;

import canvas.form.Form;
import canvas.transform.Transformable;

import java.util.Vector;

public class Draw implements Transformable {
    private Vector<Image> images;

    public Vector<Image> getImages() {
        return images;
    }

    public void sortByPerimeter() {

    }

    public void sortByArea() {

    }

    public int imagesLTPerimeter(double value) {
        return 0;
    }

    public int imagesGTPerimeter(double value) {
        return 0;
    }

    public int imagesLTArea(double value) {
        return 0;
    }

    public int imagesGTArea(double value) {
        return 0;
    }

    @Override
    public void translate(double t) {
        for (Image image: this.images) {
            image.translate(t);
        }
    }

    @Override
    public void translate(double tx, double ty) {
        for (Image image: this.images) {
            image.translate(tx, ty);
        }
    }

    @Override
    public void rotate(double degree) {
        for (Image image: this.images) {
            image.rotate(degree);
        }
    }

    @Override
    public void rotate(double degree, double cx, double cy) {
        for (Image image: this.images) {
            image.rotate(degree, cx, cy);
        }
    }

    @Override
    public void scale(double s) {
        for (Image image: this.images) {
            image.scale(s);
        }
    }

    @Override
    public void scale(double sx, double sy) {
        for (Image image: this.images) {
            image.scale(sx, sy);
        }
    }

    @Override
    public void reflect() {
        for (Image image: this.images) {
            image.reflect();
        }
    }

    @Override
    public void reflectX() {
        for (Image image: this.images) {
            image.reflectX();
        }
    }

    @Override
    public void reflectY() {
        for (Image image: this.images) {
            image.reflectY();
        }
    }
}
