package juego;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Disparo extends Cosas{
	
	protected int daño;

	public Disparo(JPanel MiJ, int x, int y) {
		super(MiJ, x, y);
		
	}
	
	public void movimientoDisparo(int c) {
		if (c == 2) {
			this.x = this.x+10;
			this.setIcono("src/juego/imagenes/FlechaDerecha.png");
		}
		else if (c == 1) {
			this.x=this.x-10;
			this.setIcono("src/juego/imagenes/FlechaIzquierda.png");
		}
		
		else if(c == 4) {
			this.x=this.x+10;
			this.setIcono("src/juego/imagenes/FlechaAbajo.png");
		}
		
		else if (c == 3){
			this.x=this.x-10;
			this.setIcono("src/juego/imagenes/FlechaArriba.png");
		}
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public int getDaño() {
		return this.daño;
	}
	
}
