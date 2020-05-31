package juego;

import javax.swing.JPanel;

public class Corazon extends Cosas{
	
	private int cantSan;

	public Corazon(JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantSan = c;
	}

	public int getCantSan() {
		return cantSan;
	}

	public void setCantSan(int cantSan) {
		this.cantSan = cantSan;
	}
	
	public void recogerCor(Link l, Corazon c) {
		if(l.getSalud() > 0 && l.getSalud() < 100) {
			l.setSalud(l.getSalud() + c.cantSan);
			if(l.getSalud() > 100)
				l.setSalud(100);
		}
	}
}
