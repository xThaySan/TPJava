package canvas.forms;

import canvas.transformations.Transformation;

/**
 * Cercle est une classe représentant un cercle dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Cercle extends Ellipse {
    /**
     * Construit un Cercle à partir du point (cx, cy) et du rayon r.
     * @param cx Coordonnée X du centre.
     * @param cy Coordonnée Y du centre.
     * @param r Rayon du cercle.
     */
    public Cercle(double cx, double cy, double r) {
        super(cx, cy, r, r);
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

        if (!(obj instanceof Cercle)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Cercle cercle = (Cercle) obj;

        // Compare the data members and return accordingly
        return this.centre == cercle.centre
                && Double.compare(this.rx, cercle.rx) == 0
                && Double.compare(this.ry, cercle.ry) == 0;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"CERCLE\"" + ",\n";
        resultat += "\t" + "\"CENTRE\": " + "\"" + this.centre + "\"" + ",\n";
        resultat += "\t" + "\"RAYON\": " + "\"" + this.rx + "\"" + ",\n";
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
