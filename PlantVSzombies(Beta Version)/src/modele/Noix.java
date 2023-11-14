package modele;

public class Noix extends Plante {

	public Noix(int x, int y, Environnement e) {
		super(x, y, 10, e);
	}

	@Override
	public void evolue() {
		// TODO
            
	}
        
        @Override
        public Soleil getSoleilThis(){
        
            return(null);
        }

}
