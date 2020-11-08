package canvas.forms;

import canvas.commons.Point;
import canvas.transformations.Transformation;

import java.util.Vector;

/**
 * Polygone est une classe représentant un polygone dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Polygone extends Forme {
    /**
     * Liste des points du polygone.
     */
    private Vector<Point> points;

    /**
     * Construit un Polygone à partir d'une liste de points.
     * @param points Liste de coordonnées de points (x0, y0, x1, y1, ..., xn, yn).
     */
    public Polygone(double... points) {
        if (points.length < 6) throw new IllegalArgumentException("Le nombre de coordonnées doit être d'au moins 6 pour créer 3 points");
        if (points.length % 2 != 0) throw new IllegalArgumentException("Le nombre de coordonnées doit être pair pour créer des points");

        this.points = new Vector<>();
        for (int i = 0; i < points.length; i += 2) {
            this.points.add(new Point(points[i], points[i+1]));
        }
    }

    @Override
    public double getPerimetre() {
        double result = 0;
        int length = this.points.size();
        for (int i = 0; i < length; i++) {
            result += this.points.get(i).distanceTo(points.get((i+1) % length));
        }
        return result;
    }

    @Override
    public double getAire() {
        double resultat = 0;
        int index = 0;
        int size = this.points.size();
        while(index < size) {
            resultat += this.points.get(index).getX() * this.points.get((index+1) % size).getY();
            resultat -= this.points.get(index).getY() * this.points.get((index+1) % size).getX();
            index++;
        }
        return Math.abs(resultat) / 2;
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

        if (!(obj instanceof Polygone)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Polygone polygone = (Polygone) obj;

        // Compare the data members and return accordingly
        boolean resultat = true;
        int index = 0;
        int size = this.points.size();
        while (resultat && index < size) {
            if (!polygone.points.contains(this.points.get(index))) resultat = false;
            index++;
        }
        return resultat;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"POLYGON\"" + ",\n";
        resultat += "\t" + "\"POINTS\": " + "[" + "\n";

        int index = 0;
        int size = this.points.size();
        for(Point point: this.points) {
            resultat += "\t\t\"" + point + "\"" + (index < size-1 ? "," : "") + "\n";
            index++;
        }

        resultat += "\t" + "]" + ",\n";
        resultat += "\t" + "\"PERIMETRE\": " + "\"" + this.getPerimetre() + "\"" + ",\n";
        resultat += "\t" + "\"AIRE\": " + "\"" + this.getAire() + "\"" + ",\n";
        resultat += "\t" + "\"TRANSFORMATIONS\": " + "[" + "\n";

        index = 0;
        size = this.transformations.size();
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
