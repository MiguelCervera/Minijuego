package juego;

import javax.swing.JPanel;

public class Arma extends Cosas{
	
	private int cantMun;

	public Arma(JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantMun = c;
	}

	public int getCantMun() {
		return cantMun;
	}

	public void setCantMun(int cantMun) {
		this.cantMun = cantMun;
	}
	
	public void recogerArm(Link l, Arma a) {
		if(l.getArma() > 0 && l.getArma() < 50) {
			l.setArma(l.getArma() + a.cantMun);
			if(l.getArma() > 50)
				l.setArma(50);
		}
	}
}
