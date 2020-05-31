package juego;

import javax.swing.JPanel;

public class Escudo extends Cosas{
	
	private int cantEsc;

	public Escudo (JPanel MiJ, int x, int y, int c) {
		super(MiJ, x, y);
		this.cantEsc = c;
	}

	public int getCantEsc() {
		return cantEsc;
	}

	public void setCantEsc(int cantEsc) {
		this.cantEsc = cantEsc;
	}
	
	public void recogerEsc(Link l, Escudo e) {
		if(l.getEscudo() > 0 && l.getEscudo() < 100) {
			l.setEscudo(l.getEscudo() + e.cantEsc);
			if(l.getEscudo() > 100)
				l.setEscudo(100);
		}
	}
}
