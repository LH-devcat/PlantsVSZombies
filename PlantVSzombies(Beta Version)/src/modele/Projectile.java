package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Projectile extends PersoMobile {
	// pleins d'attributs � inventer et un constructeur

	@Override
	public void evolue() {
		// To DO
	}

	@Override
	public void recoitDegat(int degat) {
		// To DO
	}

	@Override
	public int getLargeur() {
		// To DO
		return 0;
	}

	@Override
	public Point getPosition() {
		// To DO
		return new Point(-1, -1);
	}

	@Override
	public boolean estMort() {
		// To DO
		return false;
	}

	@Override
	public void meurt() {
		// To DO
	}

	@Override
	public int getDegatCauses() {
		// To DO
		return 0;
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		// To DO
		return false;
	}

	@Override
	public void ralentir() {
		// TODO Auto-generated method stub
	}

	@Override
	public void changeDirection() {
		// To DO
	}

	@Override
	public void setPosition(Point nouveau) {
		// To DO
	}

	@Override
	public boolean vaVersAvant() {
		// TODO Auto-generated method stub
		return false;
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }


}
