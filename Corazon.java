package juego;

import javax.swing.JPanel;

public class Corazon extends Cosas{

	public Corazon(JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantIt = c;
		this.setIcono("src/juego/imagenes/Corazon.png");
	}
	
	public void recoger(Link l, Corazon c) {
		if(l.getSalud() >= 0 && l.getSalud() < 100) {
			l.setSalud(l.getSalud() + c.cantIt);
			if(l.getSalud() > 100)
				l.setSalud(100);
			c.setX(-300);
			c.setY(-300);
		} else {
			c.setX(-300);
			c.setY(-300);
		}
	}
	
	@Override
	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
		this.setIcono("src/juego/imagenes/Corazon.png");
	}
}
