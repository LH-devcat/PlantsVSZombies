package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import javax.swing.JPanel;

import modele.*;

public class DessinJardin extends JPanel {

	private Jeu leJeu;

	public DessinJardin(Jeu j) {
		this.leJeu = j;
		setFocusable(true);
		requestFocus();
		// on ecoute les clics de souris (sur les soleils etc...)
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
                                System .err.println("CLIC");
				testPressed(e.getX(), e.getY());
			}
		});
	}

        /**
         * Test le clic de la souris avec en parametre les postions de la souris lors du clic
         * @param x int
         * @param y int
         */
	private void testPressed(int x, int y) {
		// pour l'instant on ne teste que si on a clique sur un soleil.
		// il y aura autre chose après
		testClicSoleil(x, y);
	}

        /**
         * Verifie si on clique sur un soleil
         * @param x int
         * @param y int
         */
	public void testClicSoleil(int x, int y) {

            
            //System.err.println("----------------------- Souris: \n x :"+x+"\n y :"+y);
            
            for(int i=0; i<leJeu.getEnvironnement().getSoleils().size(); i++)
            {
                /*
                System.err.println("*****Soleil: \n x :"+leJeu.getEnvironnement().getSoleils().get(i).getPosition().x
                        +"\n x+largeur :"+
                        (leJeu.getEnvironnement().getSoleils().get(i).getPosition().x+leJeu.getEnvironnement().getSoleils().get(i).getLargeur()) );
                
                System.err.println(" y :"+(leJeu.getEnvironnement().getSoleils().get(i).getPosition().y*100+50)
                        +"\n y+largeur :"+
                        ( (leJeu.getEnvironnement().getSoleils().get(i).getPosition().y*100+50) +leJeu.getEnvironnement().getSoleils().get(i).getLargeur()) );
                */
                
                if ((x >= leJeu.getEnvironnement().getSoleils().get(i).getPosition().x && 
                        x <= (leJeu.getEnvironnement().getSoleils().get(i).getPosition().x + leJeu.getEnvironnement().getSoleils().get(i).getLargeur())) 
                        
                        &&
                        
                        (y>= leJeu.getEnvironnement().getSoleils().get(i).getPosition().y*100+50 &&
                            y <= ((leJeu.getEnvironnement().getSoleils().get(i).getPosition().y*100+50) + leJeu.getEnvironnement().getSoleils().get(i).getLargeur())) )
                {
                    leJeu.getEnvironnement().getSoleils().get(i).meurt();
                    System.err.println("Est mort");
                }
            }
            
            
	}

	public void paintComponent(Graphics g) {
		Perso p;
		// couleur de fond pour le rectangle qui est affich� pour
		// ne pas avoir de train�es mais des objets qui bougent
		g.setColor(Color.WHITE);
		// on dessine le rectangle afin qu'il prenne toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// on dessine les persos du jeu
		for (int i = 0; i < this.leJeu.getEnvironnement().nbreLigne(); i++) {
			for (int j = 0; j < this.leJeu.getEnvironnement().getLignePersos(i)
					.size(); j++) {
				p = leJeu.getEnvironnement().getLignePersos(i).get(j);
				if (p instanceof Plante) {
					dessinerPlante((Plante) p, g);
				}
				if (p instanceof Zombie) {
					dessinerZombie((Zombie) p, g);
				}
				if (p instanceof Projectile) {
					dessinerProjectile((Projectile) p, g);
				}
				if (p instanceof Soleil) {
					dessinerSoleil((Soleil) p, g);
				}
			}
		}
		for (Soleil s : this.leJeu.getEnvironnement().getSoleils()) {
			dessinerSoleil(s, g);
		}

	}

	private void dessinerSoleil(Soleil p, Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(p.getPosition().x, (p.getPosition().y * 100) + 50,
				p.getLargeur(), 20);
	}

	public void dessinerPlante(Plante p, Graphics g) {
		g.setColor(Color.green);
		g.fillOval(p.getPosition().x, (p.getPosition().y * 100), 100, 100);
	}

	public void dessinerZombie(Zombie z, Graphics g) {
		if (z instanceof ZombieDeBase) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.blue);
		}
		g.fillRect(z.getPosition().x, (z.getPosition().y * 100) + 50,
				z.getLargeur(), 30);
	}

	public void dessinerProjectile(Projectile p, Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(p.getPosition().x, (p.getPosition().y * 100) + 50, 10, 10);
	}

}
