package canvas.defaults;

import canvas.Dessin;
import canvas.Fresque;
import canvas.Image;
import canvas.forms.Cercle;
import canvas.forms.Polygone;

/**
 * Coeur est une classe représentant une fresque dessinant un coeur, il s'agit d'un des exemples.
 *
 * @author Assouedj - Guerrieri
 * @version 1.0
 */
public class Coeur extends Exemple {

    public Coeur() {
        this.fresque = new Fresque();

        Dessin dessin = new Dessin();
        this.fresque.add(dessin);

        Image image = new Image();
        dessin.add(image);

        Cercle cg = new Cercle(0, 0, 20);
        image.add(cg);

        Cercle cd = new Cercle(0, 0, 10);
        cd.translation(40, 0);
        cd.homothetie(2);
        image.add(cd);

        Polygone p = new Polygone(-20, 0, 60, 0, 20, 40);
        p.translation(0, 7);
        image.add(p);
    }

    public Fresque getFresque() {
        return fresque;
    }
}
