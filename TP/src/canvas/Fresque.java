package canvas;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Fresque est une classe représentant une fresque composée de plusieurs dessins.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Fresque implements Set<Dessin> {
    /**
     * Liste des dessins de la fresque.
     */
    private Set<Dessin> dessins;

    /**
     * Construit une Fresque et instancie la liste des dessins.
     */
    public Fresque() {
        this.dessins = new LinkedHashSet<>();
    }


    // SET IMPLEMENTS

    /**
     * Retourne le nombre de dessins qui compose la fresque.
     * @return Le nombre de dessins de la fresque.
     */
    @Override
    public int size() {
        return this.dessins.size();
    }

    /**
     * Retourne vrai si la fresque ne possède pas de dessin.
     * @return Vrai si la fresque ne possède pas de dessin.
     */
    @Override
    public boolean isEmpty() {
        return this.dessins.isEmpty();
    }

    /**
     * Retourne vrai si la fresque contient l'objet.
     * @param o L'objet à évaluer.
     * @return Vrai si la fresque contient l'objet.
     */
    @Override
    public boolean contains(Object o) {
        return this.dessins.contains(o);
    }

    /**
     * Retourne l'iterateur de la liste de dessins.
     * @return L'iterateur de la liste de dessins.
     */
    @Override
    public Iterator iterator() {
        return this.dessins.iterator();
    }

    /**
     * Transforme la liste de dessins de la fresque en tableau et le renvoie.
     * @return Un tableau contenant les dessins de la fresque.
     */
    @Override
    public Object[] toArray() {
        return this.dessins.toArray();
    }

    /**
     * Ajoute un dessin à la fresque.
     * @param dessin Dessin à ajouter.
     * @return Vrai si l'ajout a réussie.
     */
    @Override
    public boolean add(Dessin dessin) {
        return this.dessins.add((Dessin) dessin);
    }

    /**
     * Supprime un dessin de la fresque.
     * @param o Dessin à supprimer.
     * @return Vrai si la suppression a réussie.
     */
    @Override
    public boolean remove(Object o) {
        return this.remove(o);
    }

    /**
     * Ajoute une collection de dessins à la fresque.
     * @param c Collection de dessins à ajouter.
     * @return Vrai si l'ajout a réussie.
     */
    @Override
    public boolean addAll(Collection c) {
        return this.dessins.addAll(c);
    }

    /**
     * Supprime tous les dessins de la fresque.
     */
    @Override
    public void clear() {
        this.dessins.clear();
    }

    /**
     * Supprime une collection de dessins à la fresque.
     * @param c Collection de dessins à supprimer.
     * @return Vrai si la suppression a réussie.
     */
    @Override
    public boolean removeAll(Collection c) {
        return this.dessins.retainAll(c);
    }

    /**
     * Supprime tous les dessins de la fresque n'étant pas dans la collection.
     * @param c Une collection de dessins.
     * @return Vrai si la liste des dessins a changée.
     */
    @Override
    public boolean retainAll(Collection c) {
        return this.dessins.retainAll(c);
    }

    /**
     * Retourne vrai si la fresque contient tous les dessins de la collection.
     * @param c Collection de dessins à évaluer.
     * @return Vrai si la fresque contient tous les dessins de la collection.
     */
    @Override
    public boolean containsAll(Collection c) {
        return this.dessins.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.dessins.toArray(a);
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

        if (!(obj instanceof Fresque)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Fresque fresque = (Fresque) obj;

        return fresque.containsAll(this.dessins) && this.containsAll(fresque.dessins);
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"FRESQUE\"" + ",\n";
        resultat += "\t" + "\"DESSINS\": " + "[" + "\n";

        int index = 0;
        int size = this.dessins.size();
        for(Dessin dessin: this.dessins) {
            resultat += (dessin + (index < size-1 ? "," : "") + "\n").replaceAll("(?m)^", "\t\t");
            index++;
        }

        resultat += "\t" + "]" + "\n";
        resultat += "}";
        return resultat;
    }
}
