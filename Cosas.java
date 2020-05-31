package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Cosas {
	
	protected int x, y;
	protected JPanel MiJP;
	private String icono;
	
	public Cosas(JPanel MiJ, int x, int y) {
		this.MiJP=MiJ;
		this.x = x;
		this.y = y;
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
	
	public JPanel getMiJP() {
		return this.MiJP;
	}
	
	public void setMiJP(JPanel MiJ) {
		this.MiJP = MiJ;
	}
	
	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
		this.setIcono("");
	}
}
