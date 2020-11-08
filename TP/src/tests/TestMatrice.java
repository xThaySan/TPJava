package tests;

import canvas.commons.Matrice;

/**
 * TestMatrice est une classe de test unitaires visant la classe Matrice
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class TestMatrice extends TestUnitaire {

    /**
     * Lance la totalité des tests.
     */
    static public void start() {
        System.out.println("# TESTS UNITAIRES DES MATRICES #");
        TestMatrice.multiplication1();
        TestMatrice.multiplication2();
        TestMatrice.multiplication3();
        TestMatrice.instanciation1();
        TestMatrice.instanciation2();
        System.out.println("#################################\n");
    }


    static public void multiplication1() {
        System.out.print("Test de muplication matricielle n°1: ");

        Matrice A = new Matrice(3, 3);
        Matrice B = new Matrice(3, 3);
        Matrice C = new Matrice(3, 3);

        if (A.multiplier(B).equals(C)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void multiplication2() {
        System.out.print("Test de muplication matricielle n°2: ");

        Matrice A = new Matrice(3, 3);
        A.setValeur(0, 0, 8);
        A.setValeur(0, 1, 2);
        A.setValeur(0, 2, 4);
        A.setValeur(1, 0, 3);
        A.setValeur(1, 1, 0);
        A.setValeur(1, 2, 5);
        A.setValeur(2, 0, 1);
        A.setValeur(2, 1, 6);
        A.setValeur(2, 2, 7);

        Matrice B = new Matrice(3, 3);
        B.setValeur(0, 0, 4);
        B.setValeur(0, 1, 5);
        B.setValeur(0, 2, 6);
        B.setValeur(1, 0, 2);
        B.setValeur(1, 1, 8);
        B.setValeur(1, 2, 3);
        B.setValeur(2, 0, 7);
        B.setValeur(2, 1, 6);
        B.setValeur(2, 2, 0);

        Matrice C = new Matrice(3, 3);
        C.setValeur(0, 0, 64);
        C.setValeur(0, 1, 80);
        C.setValeur(0, 2, 54);
        C.setValeur(1, 0, 47);
        C.setValeur(1, 1, 45);
        C.setValeur(1, 2, 18);
        C.setValeur(2, 0, 65);
        C.setValeur(2, 1, 95);
        C.setValeur(2, 2, 24);

        if (A.multiplier(B).equals(C)) System.out.println("ok");
        else System.out.println("FAUX");
    }

    static public void multiplication3() {
        System.out.print("Test de muplication matricielle n°3: ");

        Matrice A = new Matrice(3, 3);
        A.setValeur(0, 0, 8);
        A.setValeur(0, 1, 2);
        A.setValeur(0, 2, 4);
        A.setValeur(1, 0, 3);
        A.setValeur(1, 1, 0);
        A.setValeur(1, 2, 5);
        A.setValeur(2, 0, 1);
        A.setValeur(2, 1, 6);
        A.setValeur(2, 2, 7);

        Matrice B = new Matrice(2, 3);
        B.setValeur(0, 0, 4);
        B.setValeur(0, 1, 5);
        B.setValeur(0, 2, 6);
        B.setValeur(1, 0, 2);
        B.setValeur(1, 1, 8);
        B.setValeur(1, 2, 3);

        try {
            A.multiplier(B);
            System.out.println("FAUX");
        } catch (ArithmeticException e) {
            System.out.println("ok");
        }
    }

    static public void instanciation1() {
        System.out.print("Test d'instanciation de matrice n°1: ");
        try {
            new Matrice(0, 1);
            System.out.println("FAUX");
        } catch (IllegalArgumentException e) {
            System.out.println("ok");
        }
    }

    static public void instanciation2() {
        System.out.print("Test d'instanciation de matrice n°2: ");
        try {
            new Matrice(10, -5);
            System.out.println("FAUX");
        } catch (IllegalArgumentException e) {
            System.out.println("ok");
        }
    }
}
