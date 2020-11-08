import canvas.Dessin;
import canvas.Fresque;
import canvas.Image;
import canvas.commons.Matrice;
import canvas.commons.Point;
import canvas.defaults.Coeur;
import canvas.defaults.Mouton;
import canvas.forms.*;
import canvas.transformations.Homothetie;
import canvas.transformations.Rotation;
import canvas.transformations.Translation;
import tests.TestMatrice;
import tests.TestTransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) Main.help();
        else {
            switch (args[0]) {
                case "-version": Main.version();
                    break;
                case "-coeur": System.out.println(new Coeur().getFresque());
                    break;
                case "-mouton": System.out.println(new Mouton().getFresque());
                    break;
                case "-test":
                    TestMatrice.start();
                    TestTransformation.start();
                    break;
                default:
                    Main.help();
            }
        }
    }

    public static void help() {
        System.out.println("Les arguments sont à la suite de la class Main, fichier source ou -jar <jarfile>");
        System.out.println("Les options disponibles sont:\n");
        System.out.println("-coeur");
        System.out.println("\tAffiche la fresque d'un Coeur");
        System.out.println("-mouton");
        System.out.println("\tAffiche la fresque d'un Mouton");
        System.out.println("-aide");
        System.out.println("\tAffiche l'aide du fichier");
        System.out.println("-version");
        System.out.println("\tAffiche la version du fichier");
        System.out.println("-test");
        System.out.println("\tLance les tests unitaires");
    }

    public static void version() {
        System.out.println("Il s'agit de la version 1.0 de \"Dessine moi un mouton\"\n");
    }
}
