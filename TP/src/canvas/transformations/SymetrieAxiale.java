package canvas.transformations;

import canvas.commons.Point;

/**
 * SymetrieAxiale est une classe représentant une symétrie axiale linéaire autour d'une droite.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class SymetrieAxiale extends Transformation {
    /**
     * Premier point de l'axe de symétrie.
     */
    private Point p0;
    /**
     * Second point de l'axe de symétrie.
     */
    private Point p1;

    /**
     * Construit une Symétrie axiale à partir de deux points définissants un axe.
     * @param x0 Coordonnée X du premier point.
     * @param y0 Coordonnée Y du premier point.
     * @param x1 Coordonnée X du second point.
     * @param y1 Coordonnée Y du second point.
     */
    public SymetrieAxiale(double x0, double y0, double x1, double y1) {
        if (x0 == x1 && y0 == y1) throw new IllegalArgumentException("Un axe ne peut être définie par deux points confondus.");
        this.p0 = new Point(x0, y0);
        this.p1 = new Point(x1, y1);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"SYMETRIE AXIALE\"" + ",\n";
        resultat += "\t" + "\"P0\": " + "\"" + this.p0 + "\"" + ",\n";
        resultat += "\t" + "\"P1\": " + "\"" + this.p1 + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
