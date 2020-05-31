package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Personaje {
	
	protected int x, y;
	protected JPanel MiJP;
	protected String Direccion;
	protected int salud;
	
	public Personaje(JPanel MiJ, int salud) {
		x = 0;
		y = 0;
		this.salud = salud;
		this.MiJP = MiJ;
	}
	
	public String getDireccion() {
		return this.Direccion;
	}
	
	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
	
	public void setCoordX(int x) {
		this.x = x;
	}
	
	public void setCoordY(int y) {
		this.y = y;
	}
	
	public JPanel getPanel() {
		return this.MiJP;
	}
	
	public int CoordX() {
		return this.x;
	}
	
	public int CoordY() {
		return this.y;
	}

	public int getSalud() {
		return this.salud;
	}
	
	public void setSalud(int s) {
		this.salud = s;
	}

}
