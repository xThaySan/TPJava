package canvas.transformations;

/**
 * Translation est une classe représentant une translation linéaire.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Translation extends Transformation {
    /**
     * Valeur de la translation en X.
     */
    private double tx;
    /**
     * Valeur de la translation en Y.
     */
    private double ty;

    /**
     * Construit une Translation.
     * @param t Valeur de la translation en X et en Y.
     */
    public Translation(double t) {
        this(t, t);
    }

    /**
     * Construit une Translation.
     * @param tx Valeur de la translation en X.
     * @param ty Valeur de la translation en Y.
     */
    public Translation(double tx, double ty) {
        super();
        this.tx = tx;
        this.ty = ty;
        this.matrice.setValeur(0, 2, this.tx);
        this.matrice.setValeur(1, 2, this.ty);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"TRANSLATION\"" + ",\n";
        resultat += "\t" + "\"X\": " + "\"" + this.tx + "\"" + ",\n";
        resultat += "\t" + "\"Y\": " + "\"" + this.ty + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
