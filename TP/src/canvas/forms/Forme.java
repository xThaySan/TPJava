package canvas.forms;
import canvas.commons.Matrice;
import canvas.transformations.*;
import java.util.Vector;

/**
 * Forme est une classe représentant une forme dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public abstract class Forme implements Transformable, Comparable<Forme> {
    /**
     * Liste des transformations appliquées à la forme.
     */
    protected Vector<Transformation> transformations;

    /**
     * Construit une Forme et instancie la liste des transformations associées.
     */
    public Forme() {
        this.transformations = new Vector<Transformation>();
    }

    /**
     * Calcul et renvoie la matrice consolidée la forme.
     *
     * @return La matrice consolidée des transformations dans l'ordre FIFO.
     */
    public Matrice consolidate() {
        Matrice R = new Matrice(3, 3);
        for (Transformation transformation: this.transformations) {
            R = R.multiplier(transformation.getMatrice());
        }
        return R;
    }

    /**
     * Détermine et retourne le périmètre de la forme.
     *
     * @return Le périmètre de la forme.
     */
    public abstract double getPerimetre();

    /**
     * Détermine et retourne l'aire de la forme.
     *
     * @return L'aire de la forme.
     */
    public abstract double getAire();



    // IMPLEMENTS TRANSFORMABLE

    /**
     * Fait une translation de la forme.
     *
     * @param t Distance de translation en X et en Y.
     */
    @Override
    public void translation(double t) {
        this.transformations.add(new Translation(t));
    }

    /**
     * Fait une translation de la forme.
     *
     * @param tx Distance de translation en X.
     * @param ty Distance de translation en Y.
     */
    @Override
    public void translation(double tx, double ty) {
        this.transformations.add(new Translation(tx, ty));
    }

    /**
     * Fait une rotation de la forme autour de l'origine.
     *
     * @param degree Degrés de rotation autour de l'origine.
     */
    @Override
    public void rotation(double degree) {
        this.transformations.add(new Rotation(degree));
    }

    /**
     * Fait une rotation de la forme autour d'un point.
     *
     * @param degree Degrés de rotation autour du point (cx, cy).
     * @param cx Coordonnée en X du point (cx, cy).
     * @param cy Coordonnée en Y du point (cx, cy).
     */
    @Override
    public void rotation(double degree, double cx, double cy) {
        this.transformations.add(new Rotation(degree, cx, cy));
    }
    /**
     * Fait une homothétie de la forme depuis l'origine.
     *
     * @param s Coefficient mumtiplicateur de l'homothétie en X et en Y.
     */
    @Override
    public void homothetie(double s) {
        this.transformations.add(new Homothetie(s));
    }

    /**
     * Fait une homothétie de la forme depuis l'origine.
     *
     * @param sx Coefficient mumtiplicateur de l'homothétie en X.
     * @param sy Coefficient mumtiplicateur de l'homothétie en Y.
     */
    @Override
    public void homothetie(double sx, double sy) {
        this.transformations.add(new Homothetie(sx, sy));
    }

    /**
     * Fait une symétrie centrale autour du point (cx, cy).
     *
     * @param cx Coordonnée en X du point (cx, cy).
     * @param cy Coordonnée en Y du point (cx, cy).
     */
    @Override
    public void symetrieCentrale(double cx, double cy) {
        this.transformations.add(new SymetrieCentrale(cx, cy));
    }

    /**
     * Fait une symétrie axiale autour de la droite passant par (x0, y0) et (x1, y1).
     *
     * @param x0 Coordonnée en X du point (x0, y0).
     * @param y0 Coordonnée en Y du point (x0, y0).
     * @param x1 Coordonnée en X du point (x1, y1).
     * @param y1 Coordonnée en Y du point (x1, y1).
     */
    @Override
    public void symetrieAxiale(double x0, double y0, double x1, double y1) {
        this.transformations.add(new SymetrieAxiale(x0, y0, x1, y1));
    }



    // IMPLEMENTS TRANSFORMABLE

    /**
     * Compare les formes en fonction du périmètre de celles-ci
     *
     * @param forme Forme avec laquelle est effectué la comparaison.
     * @return La différence entre les périmètres des formes.
     */
    @Override
    public int compareTo(Forme forme) {
        return Double.compare(this.getPerimetre(), forme.getPerimetre());
    }
}
