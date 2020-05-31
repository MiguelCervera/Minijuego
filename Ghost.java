package juego;

import javax.swing.JPanel;

public class Ghost extends Personaje{	

	public Ghost(JPanel MiJ, int s) {
		super(MiJ, s);
		this.setDireccion("src/juego/imagenes/Ghost.png");
	}

	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
	}
}
