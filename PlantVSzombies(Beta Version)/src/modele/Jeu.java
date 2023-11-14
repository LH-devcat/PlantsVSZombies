package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Jeu {

	private Environnement environnement;
	private int hauteurJardin;
	private int largeurJardin;
	private int nbTour = 0;

	// vous aurez sans doute des attributs a ajouter pour gérer les sous,
	// le départ des zombies etc ...

	public Jeu(int lignes, int cols) {
		largeurJardin = cols * 100;
		hauteurJardin = lignes * 100;
		environnement = new Environnement(lignes, cols);
	}

	/*
	 * Pour avoir une notion de temps
	 */
	public int getNbTour() {
		return nbTour;
	}
        /**
         * Renvoie l'environnement
         * @return Environnement
         */
	public Environnement getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public void Initialisation2() {
		// pour l'instant, on fait une initialisation dans le main
		Noix plante1 = new Noix(0, 0, environnement);
		Noix plante2 = new Noix(400, 1, environnement);
                
		Plante plante3 = new PistoPois(0, 2, environnement);
		Noix plante4 = new Noix(0, 3, environnement);
		Noix plante5 = new Noix(0, 4, environnement);
                
                //System.err.println("Creation des tournesols");
		Tournesol p2 = new Tournesol(200, 1, environnement);
		Tournesol p3 = new Tournesol(200, 2, environnement);
                Tournesol p5 = new Tournesol(200, 0, environnement);
                
		Noix p4 = new Noix(300, 3, environnement);
                
		Zombie z = new Perchiste(new ZombieDeBase(new Point(largeurJardin, 1),1, environnement));
		Zombie z2 = new ZombieDeBase(new Point(largeurJardin, 2), 2,environnement);
		ZombieDeBase z3 = new ZombieDeBase(new Point(largeurJardin, 4), 5,environnement);
		ZombieDeBase z4 = new ZombieDeBase(new Point(250, 4), 5, environnement);
                ZombieDeBase z5 = new ZombieDeBase(new Point(largeurJardin, 3), 5, environnement);
                ZombieDeBase z6 = new ZombieDeBase(new Point(largeurJardin, 1), 5, environnement);
                ZombieDeBase z7 = new ZombieDeBase(new Point(largeurJardin, 0), 5, environnement);
                
		z4.changeDirection();
		environnement.ajoute(plante1);
		environnement.ajoute(plante2);
		environnement.ajoute(plante3);
		environnement.ajoute(plante4);
		environnement.ajoute(plante5);
		environnement.ajoute(p2);
		environnement.ajoute(p3);
		environnement.ajoute(p4);
                environnement.ajoute(p5);
		environnement.ajoute(z);
		environnement.ajoute(z2);
		environnement.ajoute(z3);
		environnement.ajoute(z4);
                environnement.ajoute(z5);
                environnement.ajoute(z6);
                environnement.ajoute(z7);
	}

	public boolean estFini() {
		// TODO
         
            int i = 0;
            int j;
            boolean fini= false;
            
            while(i < environnement.nbreLigne() && !fini){
                
                j=0;
                
                while (j < environnement.getLignePersos(i).size() && !fini){
                if(environnement.getLignePersos(i).get(j).getPosition().x < 0 ){
                    fini = true;
                   
                }
                
                j++;
              }
                
                i++;
            }
             
            
		return fini;
	}

        /**
         * méthode qui permet de vérifier si un zombie est arrivé au bout
         * ou bien s'il y plus de zombie
         * @return 
         */
	public boolean perdu() {
		// TO DO
            boolean perd= false;
            
            if(this.estFini())
            {
            
                int i = 0;
                int j;
                
            
                while(i < environnement.nbreLigne() && !perd){
                j=0;
                while (j < environnement.getLignePersos(i).size() && !perd){
                if(environnement.getLignePersos(i).get(j).getPosition().x < 0 ){
                    perd = true;
                   
                }
                
                j++;
              }
                
                i++;
            }
            }
                
                
		return((perd && !gagne()||(!perd) && gagne()));
	}

	public boolean gagne() {
		// TO DO
		return false;
	}

        /**
         * Fait un tour de jeu
         */
	public void unTour() {
            int arg=environnement.evolue();
            System.err.println("arg : "+arg);
	}

        /**
         * Renvoie la hauteur du jardin
         * @return int
         */
	public int getHauteurJardin() {
		return hauteurJardin;
	}

        /**
         * Renvoie la largeur du jatdin
         * @return  int
         */
	public int getLargeurJardin() {
		return largeurJardin;
	}

}
