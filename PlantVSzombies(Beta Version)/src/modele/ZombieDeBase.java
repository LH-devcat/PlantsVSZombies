package modele;

import java.awt.Point;
import java.util.ArrayList;

public class ZombieDeBase extends Zombie {
	private int longueurPasNormal;
	private int pv;
	private Point position;
	private int largeur;
	private int degatsCauses;
	public /*static*/ int compteur = 0;
        
        private int ligneZ;

	public ZombieDeBase(Point origine, int depart, Environnement e) {
		longueurPasNormal = -10;    //Le pas du zombi
		position = origine;
		largeur = 20;
		pv = 50;    //pv : Invariant:  pv > 0
		degatsCauses = 2;   //Degats causés : Invariant:  degatsCauses > 0
		environnement = e; 
		numero = compteur;
		compteur++;
	}
        /**
         * Fait avancer le zombie
         */
	public void evolue() {
            
            if(this.position.x>=0)
            {   /*
                if (this.longueurPasNormal==0)
                    this.longueurPasNormal=-10;*/

                int i=0;
                boolean colision=false;
                
                //Deplacement du zombi
                this.position.x += this.longueurPasNormal;   //Mouvement du zombi
            
                //Affichage des informations de déplacements
                //System.out.println("Zombi courant \n x: "+this.position.x +"\ny :"+this.position.y);
                
                //Tant qu'on peut avancer
                while(i < environnement.getLignePersos(this.position.y).size() && !colision)
                {
                    if(environnement.getLignePersos(this.position.y).get(i)!=this)
                        colision=this.estObstaclePour(environnement.getLignePersos(this.position.y).get(i));
                    
                    if(!colision)
                        i++;
                }
                
                //Si on entre en collision
                if(colision)
                {
                    //compteur++;
                    System.out.println("MIAM, MIAM");
                    //this.longueurPasNormal=0;
                    this.position.x -= this.longueurPasNormal;   //Mouvement du zombi
                    this.mange(environnement.getLignePersos(this.position.y).get(i));
                    
                    
                }
                
            }
	}

	public int getDegatsCauses() {
		return degatsCauses;
	}

	// pour tests
	public void setDegatsCauses(int degatsCauses) {
		this.degatsCauses = degatsCauses;
	}

	@Override
	public void recoitAttaque(Projectile pe) {
		// To DO
	}

	@Override
	public void ralentir() {
		// To DO
	}

	@Override
	public void changeDirection() {

            this.longueurPasNormal= -this.longueurPasNormal;
	}

	@Override
	public int getLargeur() {
		return largeur;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public boolean estMort() {
		return (this.pv == 0);
	}

	@Override
	public void meurt() {
		// To DO
	}

	@Override
	public boolean vaVersAvant() {
	
		return(this.longueurPasNormal <0);
	}

	@Override
	public int getDegatCauses() {
	
		return degatsCauses;
	}

	@Override
	public void recoitDegat(int i) {
		this.pv-=i;
	}

	public int getPv() {
		return pv;
	}

	public int getLongueurPasNormal() {
		return longueurPasNormal;
	}

        
	@Override
	public void setPosition(Point nouveau) {
		this.position=nouveau;
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }
        
}
