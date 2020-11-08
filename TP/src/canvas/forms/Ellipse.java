package canvas.forms;

import canvas.commons.Point;
import canvas.transformations.Transformation;

/**
 * Ellipse est une classe représentant une ellipse dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Ellipse extends Forme {
    /**
     * Le centre de l'Ellipse
     */
    protected Point centre;
    /**
     * Le rayon en X
     */
    protected double rx;
    /**
     * Le rayon en Y
     */
    protected double ry;

    /**
     * Construit une Ellipse à partir du point (cx, cy) et du rayon en X et en Y.
     * @param cx Coordonnée X du centre.
     * @param cy Coordonnée Y du centre.
     * @param rx Rayon en X.
     * @param ry Rayon en Y.
     */
    public Ellipse(double cx, double cy, double rx, double ry) {
        this.centre = new Point(cx, cy);
        this.rx = rx;
        this.ry = ry;
    }



    // EXTENDS FORME

    @Override
    public double getPerimetre() {
        double a = Math.pow(this.rx, 2);
        double b = Math.pow(this.ry, 2);
        return 2 * Math.PI * Math.sqrt((a + b) / 2);
    }

    @Override
    public double getAire() {
        return Math.PI * this.rx * this.ry;
    }



    // OVERRIDE OBJECT
    /**
     * Comparer avec un objet et retourne vrai si les deux sont égaux.
     * @param obj Objet avec lequel comparer.
     * @return Vrai si les objets sont égaux.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Ellipse)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Ellipse ellipse = (Ellipse) obj;

        // Compare the data members and return accordingly
        return this.centre == ellipse.centre
                && Double.compare(this.rx, ellipse.rx) == 0
                && Double.compare(this.ry, ellipse.ry) == 0;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"ELLIPSE\"" + ",\n";
        resultat += "\t" + "\"CENTRE\": " + "\"" + this.centre + "\"" + ",\n";
        resultat += "\t" + "\"RAYON_X\": " + "\"" + this.rx + "\"" + ",\n";
        resultat += "\t" + "\"RAYON_Y\": " + "\"" + this.rx + "\"" + ",\n";
        resultat += "\t" + "\"PERIMETRE\": " + "\"" + this.getPerimetre() + "\"" + ",\n";
        resultat += "\t" + "\"AIRE\": " + "\"" + this.getAire() + "\"" + ",\n";
        resultat += "\t" + "\"TRANSFORMATIONS\": " + "[" + "\n";

        int index = 0;
        int size = this.transformations.size();
        for(Transformation transformation: this.transformations) {
            resultat += (transformation + "\"" + (index < size-1 ? "," : "") + "\n").replaceAll("(?m)^", "\t\t");
            index++;
        }

        resultat += "\t" + "]" + ",\n";
        resultat += "\t" + "\"MATRICE\": " + this.consolidate().toString().replaceAll("(?m)^", "\t").replaceFirst("\t", "") + "\n";
        resultat += "}";
        return resultat;
    }
}
