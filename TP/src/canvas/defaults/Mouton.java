package canvas.defaults;

import canvas.Dessin;
import canvas.Fresque;
import canvas.Image;
import canvas.forms.Cercle;
import canvas.forms.Ellipse;
import canvas.forms.Forme;
import canvas.forms.Polygone;

/**
 * Mouton est une classe représentant une fresque dessinant un mouton, il s'agit d'un des exemples.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Mouton extends Exemple {

    public Mouton() {
        this.fresque = new Fresque();

        Dessin mouton = new Dessin();

        Forme visage = new Cercle(0, 0, 20);
        Forme nez = new Cercle(0, 0, 10);
        nez.translation(-15, 10);
        Forme oeil = new Cercle(0, 0, 3);
        nez.translation(-5, -5);

        Image tete = new Image();
        tete.add(visage);
        tete.add(nez);
        tete.add(oeil);

        Image corps = new Image();
        Forme ventre = new Ellipse(0, 0, 60, 30);
        corps.add(ventre);

        Forme ad = new Polygone(0, 0, 10, 0, 10, 40, 0, 40);
        ad.translation(20,40);
        ad.rotation(10);
        Forme ag = new Polygone(0, 0, 9, 0, 9, 40, 0, 40);
        ag.translation(30,42);
        ag.rotation(-10);
        Forme Ad = new Polygone(0, 0, 9, 0, 9, 39, 0, 39);
        Ad.translation(80,40);
        Ad.rotation(-5);
        Forme Ag = new Polygone(1, 0, 9, 0, 9, 39, 1, 39);
        Ag.translation(90,42);
        Ag.rotation(-25);

        Image jambes = new Image();
        jambes.add(ad);
        jambes.add(ag);
        jambes.add(Ad);
        jambes.add(Ag);



        this.fresque.add(mouton);
        mouton.add(tete);
        mouton.add(corps);
        mouton.add(jambes);
    }
}
