package juego;

import javax.swing.JPanel;

public class Broncas extends Personaje{
	
	private String Sentido;
	
	Broncas(JPanel MiJ, int x, int y, int s){
		super(MiJ, s);
		this.x = x;
		this.y = y;
		this.Sentido = "ESTE";
	}
	
	public void movimientoBroncas() {
		if (this.x<0) {
			this.Sentido = "ESTE";
			this.x = this.x+10;
			this.setDireccion("src/juego/imagenes/Broncas_Derecha.png");
		}
		else if (this.x>this.getPanel().getWidth()-100) {
			this.Sentido = "OESTE";
			this.x=this.x-10;
			this.setDireccion("src/juego/imagenes/Broncas_Izquierda.png");
		}
		
		else if(this.Sentido.equals("ESTE")) {
			this.x=this.x+10;
			this.setDireccion("src/juego/imagenes/Broncas_Derecha.png");
		}
		
		else if(this.Sentido.equals("OESTE")) {
			this.x=this.x-10;
			this.setDireccion("src/juego/imagenes/Broncas_Izquierda.png");
		}
	}
	
	public void spawn() {
		this.x = ((int) (Math.random() * 550));
		this.y = ((int) (Math.random() * 480));
	}
}
