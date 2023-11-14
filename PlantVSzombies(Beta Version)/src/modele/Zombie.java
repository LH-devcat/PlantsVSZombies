package modele;

import java.awt.Point;

public abstract class Zombie extends PersoMobile {
	// numero permet d'identifier les zombies : les zombies de base auront tous
	// un numero different
	// les autres auront le meme numero que leur zombie de base.
	protected int numero;

	public int getNumero() {
		return numero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Zombie && numero == ((Zombie) obj).numero)
			return true;
		else
			return false;
	}

        /**
         * supprime le perso pris en paramettre
         * @param p Perso
         */
	protected void mange(Perso p) {

                    if(p!=null){
                        p.recoitDegat(this.getDegatCauses());
                    }
                    else
                        throw new RuntimeException("FATAL ERROR : Un zombie ne peut pas manger une plante qui n'existe pas\n");

	}

	/*
	 * les zombies reagissent differement aux attaques de perso : certaines
	 * armures par exemple ne protègent pas de certains projectiles On laisse au
	 * Zombie qui recoit l'attaque se debrouiller pour savoir les degats qu'il
	 * doit s'infliger en fonction du perso qui lui inflige.
	 */
	public abstract void recoitAttaque(Projectile p);

	/*
	 * definit pour qui un zombie constitue un obstacle
	 */
	@Override
	public boolean estObstaclePour(Perso pe) {
		// TODO
                return((pe.getPosition().x+pe.getLargeur()+1) == this.getPosition().x);
	}

	public abstract int getPv();
}
