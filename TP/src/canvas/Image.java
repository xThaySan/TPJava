package canvas;

import canvas.forms.Forme;
import canvas.transformations.Transformable;

import java.util.*;

/**
 * Image est une classe représentant une image composée de plusieurs formes.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Image implements Transformable, Set<Forme>, Comparable<Image> {
    /**
     * Liste des formes de l'image.
     */
    private Set<Forme> formes;

    /**
     * Construit une Image et instancie sa liste de formes.
     */
    public Image() {
        this.formes = new TreeSet<>();
    }

    /**
     * Calcul la somme des périmètres des formes de l'image.
     * @return Le périmètre associé à l'image.
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
     * Liste les périmètres des formes composants l'image.
     * @return la liste des périmètres des formes de l'image.
     */
    private ArrayList<Double> listePerimetres() {
        ArrayList<Double> liste = new ArrayList<>();
        for(Forme forme: this.formes) {
            liste.add(forme.getPerimetre());
        }
        return liste;
    }

    /**
     * Calcul la somme des aires des formes de l'image.
     * @return L'aire associée à l'image.
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
     * Liste les aires des formes composants l'image.
     * @return la liste des aires des formes de l'image.
     */
    private ArrayList<Double> listeAires() {
        ArrayList<Double> liste = new ArrayList<>();
        for(Forme forme: this.formes) {
            liste.add(forme.getAire());
        }
        return liste;
    }

    /**
     * Compte le nombre de formes dont le périmètre est inférieur à une limite.
     * @param limite Périmètre maximal des formes.
     * @return Le nombre de formes répondants au critère.
     */
    public int nbFormesInferieurA(double limite) {
        ArrayList<Double> perimetres = this.listePerimetres();
        int resultat = 0;
        for(Double perimetre: perimetres) {
            resultat += perimetre < limite ? 1 : 0;
        }
        return resultat;
    }



    // IMPLEMENTS TRANSFORMABLE

    /**
     * Applique la translation à toutes les formes composants l'image.
     * @param t Valeur de la translation en X et en Y.
     */
    @Override
    public void translation(double t) {
        for(Forme forme: this.formes) forme.translation(t);
    }

    /**
     * Applique la translation à toutes les formes composants l'image.
     * @param tx Valeur de la translation en X.
     * @param ty Valeur de la translation en Y.
     */
    @Override
    public void translation(double tx, double ty) {
        for(Forme forme: this.formes) forme.translation(tx, ty);
    }

    /**
     * Applique la rotation à toutes les formes composants l'image.
     * @param degree Valeur en degrés de la rotation.
     */
    @Override
    public void rotation(double degree) {
        for(Forme forme: this.formes) forme.rotation(degree);
    }

    /**
     * Applique la rotation à toutes les formes composants l'image.
     * @param degree Valeur en degrés de la rotation.
     * @param cx Coordonné X du point centrail.
     * @param cy Coordonné Y du point centrail.
     */
    @Override
    public void rotation(double degree, double cx, double cy) {
        for(Forme forme: this.formes) forme.rotation(degree, cx, cy);
    }

    /**
     * Applique l'homothétie à toutes les formes composants l'image.
     * @param s Coefficient en X et en Y de l'homothétie.
     */
    @Override
    public void homothetie(double s) {
        for(Forme forme: this.formes) forme.homothetie(s);
    }

    /**
     * Applique l'homothétie à toutes les formes composants l'image.
     * @param sx Coefficient en X de l'homothétie.
     * @param sy Coefficient en Y de l'homothétie.
     */
    @Override
    public void homothetie(double sx, double sy) {
        for(Forme forme: this.formes) forme.homothetie(sx, sy);
    }

    /**
     * Applique la symétrie centrale à toutes les formes composants l'image.
     * @param cx Coordonné X du point.
     * @param cy Coordonné Y du point.
     */
    @Override
    public void symetrieCentrale(double cx, double cy) {
        for(Forme forme: this.formes) forme.symetrieCentrale(cx, cy);
    }

    /**
     * Applique la symétrie axiale à toutes les formes composants l'image.
     * @param x0 Coordonné X du premier point.
     * @param y0 Coordonné Y du premier point.
     * @param x1 Coordonné X du second point.
     * @param y1 Coordonné Y du second point.
     */
    @Override
    public void symetrieAxiale(double x0, double y0, double x1, double y1) {
        for(Forme forme: this.formes) forme.symetrieAxiale(x0, y0, x1, y1);
    }



    // SET IMPLEMENTS
    /**
     * Retourne le nombre de formes qui composent l'image.
     * @return Le nombre de formes qui composent l'image.
     */
    @Override
    public int size() {
        return this.formes.size();
    }

    /**
     * Retourne vrai si l'image ne possède pas de forme.
     * @return Vrai si l'image ne possède pas de forme.
     */
    @Override
    public boolean isEmpty() {
        return this.formes.isEmpty();
    }

    /**
     * Retourne vrai si l'image contient l'objet.
     * @param o L'objet à évaluer.
     * @return Vrai si l'image contient l'objet.
     */
    @Override
    public boolean contains(Object o) {
        return this.formes.contains(o);
    }

    /**
     * Retourne l'iterateur de la liste de formes.
     * @return L'iterateur de la liste de formes.
     */
    @Override
    public Iterator iterator() {
        return this.formes.iterator();
    }

    /**
     * Transforme la liste de formes de l'image en tableau et le renvoie.
     * @return Un tableau contenant les formes de l'image.
     */
    @Override
    public Object[] toArray() {
        return this.formes.toArray();
    }

    /**
     * Ajoute une forme à l'image.
     * @param forme Forme à ajouter.
     * @return Vrai si l'ajout a réussie.
     */
    @Override
    public boolean add(Forme forme) {
        return this.formes.add(forme);
    }

    /**
     * Supprime une forme de l'image.
     * @param o Objet à supprimer.
     * @return Vrai si la suppression a réussie.
     */
    @Override
    public boolean remove(Object o) {
        return this.remove(o);
    }

    /**
     * Ajoute une collection de formes à l'image.
     * @param c Collection de formes à ajouter.
     * @return Vrai si l'ajout a réussie.
     */
    @Override
    public boolean addAll(Collection c) {
        return this.formes.addAll(c);
    }

    /**
     * Supprime toutes les formes de l'image.
     */
    @Override
    public void clear() {
        this.formes.clear();
    }

    /**
     * Supprime une collection de formes à l'image.
     * @param c Collection de formes à supprimer.
     * @return Vrai si la suppression a réussie.
     */
    @Override
    public boolean removeAll(Collection c) {
        return this.formes.removeAll(c);
    }

    /**
     * Supprime toutes les formes de l'image n'étant pas dans la collection.
     * @param c Une collection de formes.
     * @return Vrai si la liste des formes a changée.
     */
    @Override
    public boolean retainAll(Collection c) {
        return this.formes.retainAll(c);
    }

    /**
     * Retourne vrai si l'image contient toutes les formes de la collection.
     * @param c Collection de formes à évaluer.
     * @return Vrai si l'image contient tous les formes de la collection.
     */
    @Override
    public boolean containsAll(Collection c) {
        return this.formes.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.formes.toArray(a);
    }



    // IMPLEMENTS COMPARABLE

    @Override
    public int compareTo(Image image) {
        double a1 = this.getAire();
        double a2 = image.getAire();
        return Double.compare(a1, a2);
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

        if (!(obj instanceof Image)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Image image = (Image) obj;

        return image.containsAll(this.formes) && this.containsAll(image.formes);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"IMAGE\"" + ",\n";
        resultat += "\t" + "\"FORMES\": " + "[" + "\n";

        int index = 0;
        int size = this.formes.size();
        for(Forme forme : this.formes) {
            resultat += (forme + (index < size-1 ? "," : "") + "\n").replaceAll("(?m)^", "\t\t");
            index++;
        }

        resultat += "\t" + "]" + ",\n";
        resultat += "\t" + "\"PERIMETRE\": " + "\"" + this.getPerimetre() + "\"" + ",\n";
        resultat += "\t" + "\"AIRE\": " + "\"" + this.getPerimetre() + "\"" + "\n";
        resultat += "}";
        return resultat;
    }
}
