package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Environnement {
	// chaque ligne est une liste de persos contenant les plantes,
	// projectiles et zombies de la ligne
	private int nbreCaseLargeurJardin;
	private ArrayList<ArrayList<Perso>> lesPersos;
	private ArrayList<Soleil> lesSoleils;

	public ArrayList<Perso> getLignePersos(int i) {
		return lesPersos.get(i);
	}

	public int nbreLigne() {
		return lesPersos.size();
	}

	public Environnement() {
		lesPersos = new ArrayList<ArrayList<Perso>>();
		lesSoleils = new ArrayList<Soleil>();
	}

	public Environnement(int lignes, int cols) {
		nbreCaseLargeurJardin = cols;
		lesSoleils = new ArrayList<Soleil>();
		lesPersos = new ArrayList<ArrayList<Perso>>();
		for (int i = 0; i < lignes; i++) {
			ArrayList<Perso> uneLigne = new ArrayList<Perso>();
			lesPersos.add(uneLigne);
		}
	}

	public int getNbreCaseLargeurJardin() {
		return nbreCaseLargeurJardin;
	}

	/*
	 * Fait évoluer tous les persos, ramasse les morts causés par cette
	 * évolution, et retourne les sous gagnés par les clics sur les soleils
	 */
	public int evolue() {
            
            int argent=0;
            
            for(int i=0; i<lesSoleils.size();i++)
            {
                this.lesSoleils.get(i).evolue();
            } 
              
            argent+=this.ramasserRessources();
            
            //System.err.println("Argent : "+argent);
            
            for(int i=0; i< lesPersos.size();i++)
            {
                for(int j=0; j<lesPersos.get(i).size();j++)
                {
                    lesPersos.get(i).get(j).evolue();
                }
                 
            }
           
            argent+=this.ramasserRessources();
            this.ramasseLesMorts();
            
            return argent;
	}

	/*
	 * Enleve de l'environnement les persos morts
	 */
	private void ramasseLesMorts() {

        for (int i = 0; i < lesPersos.size(); i++){
            for (int j = 0; j < lesPersos.get(i).size();j++){
              if (lesPersos.get(i).get(j).estMort()){
                lesPersos.get(i).remove(j);
                j--;
              }
            }
          }

        }

	/*
	 * Enleve de l'environnement les soleils qui ont été cliqués. Retourne les
	 * sous que cela rapporte
	 */
	private int ramasserRessources() {
		// TO DO
            
                int money = 0;
            
                for(int i=0; i<lesSoleils.size();i++)
                {
                    if (this.lesSoleils.get(i).estMort()){
                        money += this.lesSoleils.get(i).getMoney();
                        this.lesSoleils.remove(i);
                    }
                }
                
            
		return money;
	}

	/*
	 * ajoute un perso à l'environnement
	 */
	public void ajoute(Perso p) {
		// TODO
            lesPersos.get(p.getLigne()).add(p);
            
	}
        
        /**
         * Rajoute les soleils
         * @param s Soleil
         */
        public void ajouteSoleil(Soleil s)
        {
            lesSoleils.add(s);
        }

	public ArrayList<Soleil> getSoleils() {
		return lesSoleils;
	}

	/*
	 * pour test
	 */
	public boolean contains(Perso p) {
		int numLigne = p.getPosition().y;
		return this.getLignePersos(numLigne).contains(p);
	}

}
