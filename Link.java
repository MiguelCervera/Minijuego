package juego;

import javax.swing.JPanel;

public class Link extends Personaje{
	
	private int salud, escudo, arma;
	
	Link(JPanel MiJ, int s, int e, int a){
		super(MiJ, s);
		this.escudo = e;
		this.arma = a;
	}
	
	public int getEscudo() {
		return this.escudo;
	}
	
	public int getArma() {
		return this.arma;
	}
	
	public void setEscudo(int e) {
		this.escudo = e;
	}
	
	public void setArma(int a) {
		this.arma = a;
	}
}
