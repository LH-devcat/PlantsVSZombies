package modele;

import java.awt.Point;

public class ZombieMoustiquaire extends ZombieDecore {
	private int pvArmure;

	public ZombieMoustiquaire(Zombie z) {
		zdb = z;
		possedeSonAccessoire = true;
		environnement = zdb.environnement;
		numero = zdb.numero;
		pvArmure = 50;
	}

	@Override
	public void recoitAttaque(Projectile pe) {
		// TO DO
	}

	@Override
	public void evolue() {
		// TO DO
	}

	// pour test
	public int getPvArmure() {
		return pvArmure;
	}

	public Zombie getZdb() {
		return zdb;
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