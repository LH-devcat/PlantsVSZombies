package modele;

import java.awt.Point;
import java.util.ArrayList;

/*
 * Un pistoPois se declenche lorsqu'un zombie est 
 * sous sa port�e (toute la ligne). Il tire des projectiles tous les 5
 * temps
 */
public class PistoPois extends Plante {

	public PistoPois(int x, int y, Environnement e) {
		super(x, y, 50, e);
		// A Completer car un pisto Pois a sans doute des attributs propres
	}

	@Override
	public void evolue() {
		// TO DO
	}

	/*
	 * cr�e un projectile et l'ajoute � l'environnement
	 */
	private void tire() {
		// TO DO
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }

}
