package juego;

import javax.swing.JPanel;

public class Escudo extends Cosas {

	public Escudo (JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantIt = c;
		this.setIcono("src/juego/imagenes/Escudo.png");
	}
	
	
	public void recoger(Link l, Escudo e) {
		if(l.getEscudo() >= 0 && l.getEscudo() < 100) {
			l.setEscudo(l.getEscudo() + e.cantIt);
			if(l.getEscudo() > 100)
				l.setEscudo(100);
			e.setX(-300);
			e.setY(-300);
		} else {
			e.setX(-300);
			e.setY(-300);
		}
	}
	
	@Override
	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
		this.setIcono("src/juego/imagenes/Escudo.png");
	}
}
