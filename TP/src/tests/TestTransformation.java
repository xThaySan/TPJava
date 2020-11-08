package tests;

import canvas.commons.Matrice;
import canvas.commons.Point;
import canvas.transformations.*;

/**
 * TestTransformation est une classe de test unitaires visant la classe Transformation et ses héritiers.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class TestTransformation extends TestUnitaire {

    /**
     * Lance la totalité des tests.
     */
    static public void start() {
        System.out.println("# TESTS UNITAIRES DES TRANSFORMATIONS #");
        TestTransformation.translation1();
        TestTransformation.translation2();
        TestTransformation.homothetie1();
        TestTransformation.homothetie2();
        TestTransformation.rotation1();
        TestTransformation.symetrie1();
        System.out.println("#######################################\n");
    }

    static public void translation1() {
        System.out.print("Test de translation n°1: ");
        Point p = new Point(0, 0);
        Transformation t = new Translation(10, 15);

        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, 10);
        R.setValeur(1, 0, 15);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void translation2() {
        System.out.print("Test de translation n°2: ");
        Point p = new Point(23, -4);
        Transformation t = new Translation(-5, -10);

        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, 18);
        R.setValeur(1, 0, -14);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void homothetie1() {
        System.out.print("Test d'homothetie n°1: ");

        Point p = new Point(0, 0);
        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Transformation t = new Homothetie(2);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, 0);
        R.setValeur(1, 0, 0);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void homothetie2() {
        System.out.print("Test d'homothetie n°2: ");

        Point p = new Point(-4, 5);
        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Transformation t = new Homothetie(2, -3);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, -8);
        R.setValeur(1, 0, -15);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void rotation1() {
        System.out.print("Test de rotation n°1: ");

        Point p = new Point(1, 0);
        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Transformation t = new Rotation(90);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, 0);
        R.setValeur(1, 0, 1);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void symetrie1() {
        System.out.print("Test de symetrie centrale n°1: ");

        Point p = new Point(10, 10);
        Matrice P = new Matrice(3, 1);
        P.setValeur(0, 0, p.getX());
        P.setValeur(1, 0, p.getY());
        P.setValeur(2, 0, 1);

        Transformation t = new SymetrieCentrale(50, 50);

        Matrice R = new Matrice(3, 1);
        R.setValeur(0, 0, 90);
        R.setValeur(1, 0, 90);
        R.setValeur(2, 0, 1);

        if (t.getMatrice().multiplier(P).equals(R)) System.out.println("ok");
        else System.out.println("FAUX");
    }
}
