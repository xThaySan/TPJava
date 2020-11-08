package canvas.transformations;

import canvas.commons.Matrice;
import canvas.commons.Point;

/**
 * Rotation est une classe représentant une rotation linéaire autour d'un point.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Rotation extends Transformation {
    /**
     * Degrés de rotation.
     */
    protected double degres;
    /**
     * Centre de rotation.
     */
    protected Point centre;

    /**
     * Construit une rotation en degrés autour de l'origine.
     * @param degres Degrés de rotation.
     */
    public Rotation(double degres) {
        this(degres, 0, 0);
    }

    /**
     * Construit une rotation en degrés autour d'un point.
     * @param degres Degrés de rotation.
     * @param cx Coordonnée X du centre de rotation.
     * @param cy Coordonnée Y du centre de rotation.
     */
    public Rotation(double degres, double cx, double cy) {
        super();
        this.degres = degres;
        this.centre = new Point(cx, cy);
        double rad = this.degres * Math.PI / 180;

        // Réalise une translation vers le centre de rotation
        this.matrice.setValeur(0,2, cx);
        this.matrice.setValeur(1,2, cy);

        // Multiplie cette translation par la rotation
        Matrice R = new Matrice(3, 3);
        R.setValeur(0, 0, Math.cos(rad));
        R.setValeur(0, 1, -Math.sin(rad));
        R.setValeur(1, 0, Math.sin(rad));
        R.setValeur(1, 1, Math.cos(rad));
        this.matrice = this.matrice.multiplier(R);

        // Multiplie le tout par la translation inverse pour revenir à l'origine
        R = new Matrice(3, 3);
        R.setValeur(0,2, -cx);
        R.setValeur(1,2, -cy);
        this.matrice = this.matrice.multiplier(R);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"ROTATION\"" + ",\n";
        resultat += "\t" + "\"CENTRE\": " + "\"" + this.centre + "\"" + ",\n";
        resultat += "\t" + "\"DEGRES\": " + "\"" + this.degres + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
