package modele;

import java.awt.Point;

public abstract class Plante extends Perso {
	protected int ligne;
	protected int col;
	protected int pv;

	public Plante(int x, int y, int pvie, Environnement e) {
		ligne = y;
		col = x;
		pv = pvie;
		environnement = e;
	}

	@Override
	public void recoitDegat(int degat) {
		this.pv-=degat;
                System.out.println(this.pv);
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		// TO DO
		return (this.col+this.getLargeur()+1== p.getPosition().x);
	}

	@Override
	public int getLargeur() {
		// les plantes occupent toute la case
		return 99;
	}

	public int getPv() {
		return this.pv;
	}

	@Override
	public Point getPosition() {
		return new Point(col, ligne);
	}

	@Override
	public boolean estMort() {
		return this.pv == 0;
	}

	@Override
	public void meurt() {
		
            
            
	}
        
        public abstract Soleil getSoleilThis();

	@Override
	public int getDegatCauses() {
		// par defaut, une plante ne cause aucun degat.
		return 0;
	}

}
