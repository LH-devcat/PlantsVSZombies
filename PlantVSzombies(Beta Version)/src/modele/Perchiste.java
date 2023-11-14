package modele;

import java.awt.Point;

public class Perchiste extends ZombieDecore {

	public Perchiste(ZombieDeBase z) {
		zdb = z;
		possedeSonAccessoire = true;
		environnement = zdb.getEnvironnement();
		numero = zdb.numero;
	}

	public void evolue() {
		// TO DO
	}

	private void sauteApres(Perso p) {
		// TO DO
	}

	@Override
	public void recoitAttaque(Projectile pe) {
		// TO DO

	}

	@Override
	public void recoitDegat(int degat) {
		// TO DO

	}

	@Override
	public int getPv() {
		// TODO Auto-generated method stub
		return 0;
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }

}
