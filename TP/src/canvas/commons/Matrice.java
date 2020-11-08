package canvas.commons;

import java.util.Arrays;

/**
 * Matrice est une classe représentant une matrice nxm dimension et permettant de les multiplier entre elles.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Matrice {
    /**
     * Nombre de lignes de la matrice.
     */
    private int hauteur;
    /**
     * Nombre de colonnes de la matrice.
     */
    private int largeur;
    /**
     * Matrice de valeurs.
     */
    private double[][] matrice;

    /**
     * Construit une matrice et instancie sa matrice de valeur.
     * @param hauteur Nombre de lignes de la matrice.
     * @param largeur Nombre de colonnes de la matrice.
     */
    public Matrice(int hauteur, int largeur) {
        if(largeur <= 0) throw new IllegalArgumentException("Une matrice ne peut pas avoir une taille nulle ou négative");
        if(hauteur <= 0) throw new IllegalArgumentException("Une matrice ne peut pas avoir une taille nulle ou négative");


        this.hauteur = hauteur;
        this.largeur = largeur;
        this.matrice = new double[this.hauteur][this.largeur];

        if (this.largeur == this.hauteur) {
            for (int i = 0; i < this.hauteur; i++) {
                this.matrice[i][i] = 1;
            }
        }
    }

    /**
     * Multiplie la matrice par une seconde matrice.
     * @param B Seconde matrice.
     * @return Le produit matriciel des deux matrices.
     */
    public Matrice multiplier(Matrice B) {
        if(this.largeur != B.hauteur) throw new ArithmeticException("Les matrices ne peuvent pas être multipliée");

        Matrice R = new Matrice(this.hauteur, B.largeur);
        for (int ligne = 0; ligne < this.hauteur; ligne++) {
            for (int colonne = 0; colonne < B.largeur; colonne++) {
                double resultat = 0;
                for (int i = 0; i < this.largeur; i++) {
                    resultat += this.matrice[ligne][i] * B.matrice[i][colonne];
                }
                R.matrice[ligne][colonne] = resultat;
            }
        }

        return R;
    }

    /**
     * Retourne la valeur à une position précise.
     * @param ligne Numéro de la ligne.
     * @param colonne Numéroe de la colonne.
     * @return Valeur contenue dans la matrice de valeur à la position spécifiée.
     */
    public double getValeur(int ligne, int colonne) {
        if (ligne < 0 || ligne >= this.hauteur || colonne < 0 || colonne >= this.largeur) throw new IndexOutOfBoundsException("Tentative d'accès à des cases en dehors de la matrice");
        return this.matrice[ligne][colonne];
    }

    /**
     * Définit une valeur à une position précise dans la matrice.
     * @param ligne Numéro de la ligne.
     * @param colonne Numéro de la colonne.
     * @param valeur Valeur à définir.
     */
    public void setValeur(int ligne, int colonne, double valeur) {
        if (ligne < 0 || ligne >= this.hauteur || colonne < 0 || colonne >= this.largeur) throw new IndexOutOfBoundsException("Tentative d'accès à des cases en dehors de la matrice");
        this.matrice[ligne][colonne] = valeur;
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

        if (!(obj instanceof Matrice)) {
            return false;
        }

        Matrice matrice = (Matrice) obj;

        if (Double.compare(this.largeur, matrice.largeur) != 0) return false;
        if (Double.compare(this.hauteur, matrice.hauteur) != 0) return false;

        boolean resultat = true;
        int ligne = 0;
        while (resultat && ligne < this.hauteur) {
            int colonne = 0;
            while (resultat && colonne < this.largeur) {
                if (Math.abs(this.matrice[ligne][colonne] - matrice.matrice[ligne][colonne]) > 0.00000000001) resultat = false;
                colonne++;
            }
            ligne++;
        }
        return resultat;
    }

    /**
     * Retourne une version textuelle de l'objet.
     * @return Une forme textuelle représentant l'objet.
     */
    @Override
    public String toString() {
        String resultat = "{\n";
        resultat += "\t" + "\"TYPE\": " + "\"MATRICE\"" + ",\n";
        resultat += "\t" + "\"VALEUR\": " + "[" + "\n";

        for(int ligne = 0; ligne < this.hauteur; ligne++) {
            resultat += "\t\t\"" + Arrays.toString(this.matrice[ligne]) + "\"" + (ligne != this.hauteur - 1 ? "," : "") + "\n";
        }

        resultat += "\t" + "]" + "\n";
        resultat += "}";
        return resultat;
    }
}
