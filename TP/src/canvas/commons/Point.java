package canvas.commons;

/**
 * Point est une classe représentant les coordonnées d'un point dans un plan cartésien à 2 dimensions.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Point {
    /**
     * Coordonnée en X.
     */
    private double x;
    /**
     * Coordonnée en Y.
     */
    private double y;

    /**
     * Construit un Point aux coordonnées (x, y)
     * @param x Coordonnée en X.
     * @param y Coordonnée en Y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie la valeur de X.
     * @return La propriété X.
     */
    public double getX() {
        return x;
    }

    /**
     * Renvoie la valeur de Y.
     * @return La propriété Y.
     */
    public double getY() {
        return y;
    }

    /**
     * Calcule la distance avec le point passé.
     * @param p Point à évaluer.
     * @return La distance entre les deux points.
     */
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
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

        if (!(obj instanceof Point)) {
            return false;
        }

        Point point = (Point) obj;

        return Double.compare(this.x, point.x) == 0
                && Double.compare(this.y, point.y) == 0;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
