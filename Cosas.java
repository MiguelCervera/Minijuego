package juego;

import javax.swing.*;

public abstract class Cosas {
	
	protected int cantIt;
	protected int x, y;
	protected JPanel MiJP;
	private String icono;
	
	public Cosas(JPanel MiJ, int x, int y) {
		this.MiJP=MiJ;
		this.x = x;
		this.y = y;
	}
	
	public int getCantIt() {
		return this.cantIt;
	}
	
	public void setCantIt(int cantIt) {
		this.cantIt = cantIt;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	public JPanel getPanel() {
		return this.MiJP;
	}
	
	public void setMiJP(JPanel MiJ) {
		this.MiJP = MiJ;
	}
	
	public abstract void spawn();
	
	
}
