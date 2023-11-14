package modele;

import java.awt.Point;

/* tous les perso du Jeu : zombies ET plantes
 * 
 */
public abstract class Perso {

	protected Environnement environnement; // la référence vers le jardin

	public abstract int getDegatCauses(); // les degats que cause la plante

	public abstract int getLargeur(); // la largeur de la plante

	/*
	 * retourne la position du perso dans le jardin sous la forme d'un
	 * point(x,y). x est entre 0 et largeurTerrain*100. y est entre 0 et
	 * hauteurTerrain. Par exemple, si le jardin est de 6 lignes et 7 cols, une
	 * position possible est(250,0) : ce point se situe dans la premi�re ligne
	 * du jardin (0) et au milieu de la 3e colonne du jardin.
	 */
	public abstract Point getPosition();

	public Environnement getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(Environnement env) {
		environnement = env;
	}

	/*
	 * retourne true ssi le perso est mort
	 */
	public abstract boolean estMort();

	/*
	 * fait mourir le perso
	 */
	public abstract void meurt();

	/*
	 * le perso recoit degat
	 */
	public abstract void recoitDegat(int degat);

	/*
	 * Le perso evolue
	 */
	public abstract void evolue();

	public int getLigne() {
		return this.getPosition().y;
	}

	public int getCol() {
		return this.getPosition().x / 100;
	}
        
        public abstract Soleil getSoleilThis();

	/*
	 * D�finit pour qui le type de perso est un obstacle
	 */
	public abstract boolean estObstaclePour(Perso p);

}
