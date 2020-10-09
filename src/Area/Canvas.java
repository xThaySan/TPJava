package Area;

import Transforms.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private Matrix matrix;
    private List<Image> images;

    public Canvas() {
        this.matrix = new Matrix(3, 3);
        this.images = new ArrayList<Image>();
    }

    public Image getImage(String id) {
        Image toRet = null;
        for (Image image : this.images) {
            if (image.getId() == id) toRet = image;
        }
        return toRet;
    }

    public void newImage(String id) throws InstantiationException {
        if (this.getImage(id) != null) throw new InstantiationException("Image with id \"" + id + "\" already exist");

    }
}
