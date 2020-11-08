package canvas.forms;

import canvas.commons.Point;
import canvas.transformations.Transformation;

/**
 * Ligne est une classe représentant une ligne dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Ligne extends Forme {
    /**
     * Point de départ de la ligne.
     */
    private Point p0;
    /**
     * Point d'arrivée de la ligne.
     */
    private Point p1;
    /**
     * Largeur de la ligne.
     */
    private double largeur;

    /**
     * Construit une Ligne à partir de 2 points et une largeur
     * @param x0 Coordonnée X du premier point.
     * @param y0 Coordonnée Y du premier point.
     * @param x1 Coordonnée X du second point.
     * @param y1 Coordonnée Y du second point.
     * @param largeur Largeur de la ligne.
     */
    public Ligne(double x0, double y0, double x1, double y1, double largeur) {
        this.p0 = new Point(x0, y0);
        this.p1 = new Point(x1, y1);
        this.largeur = largeur;
    }

    @Override
    public double getPerimetre() {
        return (this.largeur + this.p0.distanceTo(this.p1)) * 2;
    }

    @Override
    public double getAire() {
        return this.largeur * this.p0.distanceTo(this.p1);
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

        if (!(obj instanceof Ligne)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Ligne ligne = (Ligne) obj;

        // Compare the data members and return accordingly
        return this.p0 == ligne.p0
                && this.p1 == ligne.p1
                && Double.compare(this.largeur, ligne.largeur) == 0;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"LIGNE\"" + ",\n";
        resultat += "\t" + "\"P0\": " + "\"" + this.p0 + "\"" + ",\n";
        resultat += "\t" + "\"P1\": " + "\"" + this.p1 + "\"" + ",\n";
        resultat += "\t" + "\"LARGEUR\": " + "\"" + this.largeur + "\"" + ",\n";
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
        // .replaceAll("(?m)^", "\t\t") permet d'indenter chaque ligne récupérées.
        resultat += "\t" + "\"MATRICE\": " + this.consolidate().toString().replaceAll("(?m)^", "\t").replaceFirst("\t", "") + "\n";
        resultat += "}";
        return resultat;
    }
}
