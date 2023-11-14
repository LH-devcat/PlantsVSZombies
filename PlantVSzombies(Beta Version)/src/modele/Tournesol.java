package modele;

import java.awt.Point;
import java.util.ArrayList;

public class Tournesol extends Plante {

	// sans doute des attributs propre aux tournesols
        private Soleil soleil;

	public Tournesol(int x, int y, Environnement e) {
		// Un tournesol a 30 pv
		super(x, y, 30, e);
		// A completer
                //System.err.println("Creation soleil: constructeur tournesol");
                //soleil=new Soleil(this.getPosition().x+ this.getLargeur()-1 , this.getPosition().y);
                soleil=new Soleil(this.getPosition().x+ this.getLargeur()-1 , this.getPosition().y);
                this.environnement.ajouteSoleil(soleil);
	}

	@Override
	public void evolue() {
		// TODO
                
                //System.err.println("**********************Soleil : **** x "+this.soleil.getPosition().x+" **** y "+this.soleil.getPosition().y);
            
                if(soleil.estMort())
                {
                    //soleil=new Soleil(this.getPosition().x + this.getLargeur()-1 , this.getPosition().y);    
                    soleil=new Soleil(this.getPosition().x + this.getLargeur()-1 , this.getPosition().y); 
                    this.environnement.ajouteSoleil(soleil);
                }
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }

        
        

}
