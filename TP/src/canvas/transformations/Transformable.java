package canvas.transformations;

/**
 * Transformable est une interface permettant d'effectuer une transformation linéaire sur l'objet.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public interface Transformable {
    /**
     * Effectue une translation de valeur t en X et en Y.
     * @param t Valeur de la translation en X et en Y.
     */
    public abstract void translation(double t);

    /**
     * Effectue une translation.
     * @param tx Valeur de la translation en X.
     * @param ty Valeur de la translation en Y.
     */
    public abstract void translation(double tx, double ty);

    /**
     * Effectue une rotation autour du centre.
     * @param degree Valeur en degrés de la rotation.
     */
    public abstract void rotation(double degree);

    /**
     * Effectue une rotation autour d'un point central.
     * @param degree Valeur en degrés de la rotation.
     * @param cx Coordonné X du point centrail.
     * @param cy Coordonné Y du point centrail.
     */
    public abstract void rotation(double degree, double cx, double cy);

    /**
     * Effectue une homothétie depuis l'origine.
     * @param s Coefficient en X et en Y de l'homothétie.
     */
    public abstract void homothetie(double s);

    /**
     * Effectue une homothétie depuis l'origine.
     * @param sx Coefficient en X de l'homothétie.
     * @param sy Coefficient en Y de l'homothétie.
     */
    public abstract void homothetie(double sx, double sy);

    /**
     * Effectue une symétrie centrale autour d'un point.
     * @param cx Coordonné X du point.
     * @param cy Coordonné Y du point.
     */
    public abstract void symetrieCentrale(double cx, double cy);

    /**
     * Effectue une symétrie axiale autour d'un axe.
     * @param x0 Coordonné X du premier point.
     * @param y0 Coordonné Y du premier point.
     * @param x1 Coordonné X du second point.
     * @param y1 Coordonné Y du second point.
     */
    public abstract void symetrieAxiale(double x0, double y0, double x1, double y1);
}
