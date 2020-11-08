package canvas.transformations;

import canvas.commons.Matrice;

/**
 * Transformation est une classe représentant une transformation linéaire au travers d'une matrice 3x3.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public abstract class Transformation {
    /**
     * Matrice représentant la transformation linéaire.
     */
    protected Matrice matrice;

    /**
     * Construit une Transformation et instancie la matrice associée.
     */
    public Transformation() {
        this.matrice = new Matrice(3, 3);
    }

    /**
     * Retourne la matrice associée à la transformation.
     * @return La matrice associée.
     */
    public Matrice getMatrice() {
        return matrice;
    }
}
