package canvas.transformations;

/**
 * SymetrieCentrale est une classe représentant une symétrie centrale linéaire autour de l'origine.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class SymetrieCentrale extends Rotation {
    /**
     * Construit une Symétrie centrale autour d'un point.
     * @param cx Coordonnée X du centre de symétrie.
     * @param cy Coordonnée Y du centre de symétrie.
     */
    public SymetrieCentrale(double cx, double cy) { super(180, cx, cy); }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"SYMETRIE CENTRALE\"" + ",\n";
        resultat += "\t" + "\"CENTRE\": " + "\"" + this.centre + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
