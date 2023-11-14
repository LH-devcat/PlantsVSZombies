package vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import modele.Jeu;

public class VueJardin {
	private Jeu jeu;
	private JFrame fenetre = new JFrame("une partie");
	private DessinJardin dessin;

	/** Creates a new instance of vueJeu */

	public VueJardin(Jeu j) {
		jeu = j;
		this.dessin = new DessinJardin(this.jeu);
		fenetre.setTitle("Jardin");
		fenetre.setSize(new Dimension(jeu.getLargeurJardin(), jeu.getHauteurJardin()));
		fenetre.setResizable(false);
                
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.setContentPane(dessin);
		fenetre.setBackground(Color.WHITE);
                
		fenetre.setVisible(true);

		go1();
	}

	public void go1() {
		while (!jeu.estFini()) {
			dessin.repaint(); // mise à jour du dessin
			this.jeu.unTour();
			try {
				Thread.sleep(200);                             
                                System.out.println("un Tour");
                                //System.out.println("Est fini : "+jeu.estFini());
                                
                                
			} catch (InterruptedException e) {
                            
				e.printStackTrace();
			}
		}
                
                System.out.println(jeu.estFini());
                
		if (jeu.perdu()) {
			System.out.println("Perdu: ");
		} else {
			System.out.println("Gagne: ");
		}

	}

}
