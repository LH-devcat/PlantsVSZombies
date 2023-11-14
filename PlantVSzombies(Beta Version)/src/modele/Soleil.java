package modele;

import java.awt.Point;

/*
 * Les soleils ont une durée de vie et font gagner une somme fixe 
 * lorsqu'ils sont cliqués. 
 */
public class Soleil extends Perso {

	// sans doute des attributs et des méthodes propres aux soleils
	// en plus des méthodes abstraites des super classesint y
    
        private int pv;         //Par defaut, à 1
        private int lifetime;   //durée de vie
        private int money;
        private int x;
        private int y;
        
        
        public Soleil(int x, int y)
        {
            this.x=x;
            this.y=y;
            this.pv=1;
            this.lifetime=16;
            this.money=25;
        }

	@Override
	public boolean estMort() {
		// TO DO
		return (this.pv==0);
	}

        /*
         * On diminue la durée de vie
         */
	@Override
	public void evolue() {
            
            if(!estMort()){
                
                if(lifetime > 0)
                    lifetime--;
                else
                    meurt();
            }
                
	}
        
        /**
         * Renvoie la classe dans laquelle
         * @return Soleil
         */
        @Override
        public Soleil getSoleilThis(){
        
            return(this);
        }

 
        public int getMoney(){
            return(this.money);
        }
        
	@Override
	public void recoitDegat(int degat) {
		// TO DO
	}

	@Override
	public int getLargeur() {
		// TO DO
		return 20;
	}
 

	@Override
	public Point getPosition() {
		// TO DO
		return new Point(x, y);
	}

	@Override
	public void meurt() {
		
            this.pv=0;
	}

	@Override
	public int getDegatCauses() {
		return 0;
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		// TO DO
		return false;
	}

}
