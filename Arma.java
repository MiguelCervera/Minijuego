package juego;

import javax.swing.JPanel;

public class Arma extends Cosas{

	public Arma(JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantIt = c;
		this.setIcono("src/juego/imagenes/Arma.png");
	}
	
	public void recoger(Link l, Arma a) {
		if(l.getArma() >= 0 && l.getArma() < 50) {
			l.setArma(l.getArma() + a.cantIt);
			if(l.getArma() > 50)
				l.setArma(50);
			a.setX(-300);
			a.setY(-300);
		} else {
			a.setX(-300);
			a.setY(-300);
		}
	}
	
	@Override
	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
		this.setIcono("src/juego/imagenes/Arma.png");
	}
}
