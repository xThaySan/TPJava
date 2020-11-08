package canvas;
import canvas.transformations.Transformable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;

/**
 * Dessin est une classe représentant un dessin composé de plusieurs images.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Dessin implements Transformable, Set<Image> {
    /**
     * Liste des images du dessin.
     */
    private Set<Image> images;

    /**
     * Construit un Dessin et instancie sa liste d'images.
     */
    public Dessin() {
        this.images = new TreeSet<>();
    }

    /**
     * Calcul la somme des périmètres des images du dessin.
     * @return Le périmètre associé au dessin.
     */
    public double getPerimetre() {
        double resultat = 0;
        ArrayList<Double> perimetres = this.listePerimetres();
        for (Double perimetre: perimetres) {
            resultat += perimetre;
        }
        return resultat;
    }

    /**
     * Liste les périmètres des images composants le dessin.
     * @return la liste des périmètres des images du dessin.
     */
    private ArrayList<Double> listePerimetres() {
        ArrayList<Double> liste = new ArrayList<>();
        for(Image image: this.images) {
            liste.add(image.getPerimetre());
        }
        return liste;
    }

    /**
     * Calcul la somme des aires des images du dessin.
     * @return L'aire associée au dessin.
     */
    public double getAire() {
        double resultat = 0;
        ArrayList<Double> aires = this.listeAires();
        for (Double aire: aires) {
            resultat += aire;
        }
        return resultat;
    }

    /**
     * Liste les aires des images composants le dessin.
     * @return la liste des aires des images du dessin.
     */
    private ArrayList<Double> listeAires() {
        ArrayList<Double> liste = new ArrayList<>();
        for(Image image: this.images) {
            liste.add(image.getAire());
        }
        return liste;
    }

    /**
     * Compte le nombre d'images dont l'aire est inférieur à une limite.
     * @param limite Aire maximale des images.
     * @return Le nombre d'images répondants au critère.
     */
    public int nbImagesInferieurA(double limite) {
        ArrayList<Double> aires = this.listeAires();
        int resultat = 0;
        for(Double aire: aires) {
            resultat += aire < limite ? 1 : 0;
        }
        return resultat;
    }



    // IMPLEMENTS TRANSFORMABLE

    /**
     * Applique la translation à toutes les images composants le dessin.
     * @param t Valeur de la translation en X et en Y.
     */
    @Override
    public void translation(double t) {
        for(Image image: this.images) image.translation(t);
    }

    /**
     * Applique la translation à toutes les images composants le dessin.
     * @param tx Valeur de la translation en X.
     * @param ty Valeur de la translation en Y.
     */
    @Override
    public void translation(double tx, double ty) {
        for(Image image: this.images) image.translation(tx, ty);
    }

    /**
     * Applique la rotation à toutes les images composants le dessin.
     * @param degree Valeur en degrés de la rotation.
     */
    @Override
    public void rotation(double degree) {
        for(Image image: this.images) image.rotation(degree);
    }

    /**
     * Applique la rotation à toutes les images composants le dessin.
     * @param degree Valeur en degrés de la rotation.
     * @param cx Coordonné X du point centrail.
     * @param cy Coordonné Y du point centrail.
     */
    @Override
    public void rotation(double degree, double cx, double cy) {
        for(Image image: this.images) image.rotation(degree, cx, cy);
    }

    /**
     * Applique l'homothétie à toutes les images composants le dessin.
     * @param s Coefficient en X et en Y de l'homothétie.
     */
    @Override
    public void homothetie(double s) {
        for(Image image: this.images) image.homothetie(s);
    }

    /**
     * Applique l'homothétie à toutes les images composants le dessin.
     * @param sx Coefficient en X de l'homothétie.
     * @param sy Coefficient en Y de l'homothétie.
     */
    @Override
    public void homothetie(double sx, double sy) {
        for(Image image: this.images) image.homothetie(sx, sy);
    }

    /**
     * Applique la symétrie centrale à toutes les images composants le dessin.
     * @param cx Coordonné X du point.
     * @param cy Coordonné Y du point.
     */
    @Override
    public void symetrieCentrale(double cx, double cy) {
        for(Image image: this.images) image.symetrieCentrale(cx, cy);
    }

    /**
     * Applique la symétrie axiale à toutes les images composants le dessin.
     * @param x0 Coordonné X du premier point.
     * @param y0 Coordonné Y du premier point.
     * @param x1 Coordonné X du second point.
     * @param y1 Coordonné Y du second point.
     */
    @Override
    public void symetrieAxiale(double x0, double y0, double x1, double y1) {
        for(Image image: this.images) image.symetrieAxiale(x0, y0, x1, y1);
    }



    // SET IMPLEMENTS

    @Override
    public int size() {
        return this.images.size();
    }

    @Override
    public boolean isEmpty() {
        return this.images.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.images.contains(o);
    }

    @Override
    public Iterator iterator() {
        return this.images.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.images.toArray();
    }

    @Override
    public boolean add(Image image) {
        return this.images.add((Image) image);
    }

    @Override
    public boolean remove(Object o) {
        return this.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return this.images.addAll(c);
    }

    @Override
    public void clear() {
        this.images.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return this.images.retainAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return this.images.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return this.images.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.images.toArray(a);
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

        if (!(obj instanceof Dessin)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Dessin dessin = (Dessin) obj;

        return dessin.containsAll(this.images) && this.containsAll(dessin.images);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"DESSIN\"" + ",\n";
        resultat += "\t" + "\"IMAGES\": " + "[" + "\n";

        int index = 0;
        int size = this.images.size();
        for(Image image: this.images) {
            resultat += (image + (index < size-1 ? "," : "") + "\n").replaceAll("(?m)^", "\t\t");
            index++;
        }

        resultat += "\t" + "]" + "\n";
        resultat += "}";
        return resultat;
    }
}
