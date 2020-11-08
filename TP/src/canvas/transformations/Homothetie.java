package canvas.transformations;

/**
 * Homothetie est une classe représentant une homothétie linéaire depuis l'origine.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Homothetie extends Transformation {
    /**
     * Valeur de l'homothétie en X.
     */
    private double sx;
    /**
     * Valeur de l'homothétie en Y.
     */
    private double sy;

    /**
     * Construit une Translation.
     * @param s Valeur de l'homothétie en X et en Y.
     */
    public Homothetie(double s) {
        this(s, s);
    }

    /**
     * Construit une Translation.
     * @param sx Valeur de l'homothétie en X.
     * @param sy Valeur de l'homothétie en Y.
     */
    public Homothetie(double sx, double sy) {
        super();
        this.sx = sx;
        this.sy = sy;
        this.matrice.setValeur(0, 0, this.sx);
        this.matrice.setValeur(1, 1, this.sy);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"HOMOTHETIE\"" + ",\n";
        resultat += "\t" + "\"X\": " + "\"" + this.sx + "\"" + ",\n";
        resultat += "\t" + "\"Y\": " + "\"" + this.sy + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
