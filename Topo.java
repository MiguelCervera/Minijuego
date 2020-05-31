package juego;

import javax.swing.JPanel;

public class Topo extends Personaje{
	
	private String Sentido;
	
	Topo(JPanel MiJ, int x, int y, int s){
		super(MiJ, s);
		this.x = x;
		this.y = y;
		this.Sentido = "NORTE";
	}
	
	public void movimientoTopo() {
		if (this.y<0) {
			this.Sentido = "NORTE";
			this.y = this.y+10;
			this.setDireccion("src/juego/imagenes/Broncas_Derecha.png");
		}
		else if (this.y>this.getPanel().getHeight()-100) {
			this.Sentido = "SUR";
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/Broncas_Izquierda.png");
		}
		
		else if(this.Sentido.equals("NORTE")) {
			this.y=this.y+10;
			this.setDireccion("src/juego/imagenes/Broncas_Derecha.png");
		}
		
		else if(this.Sentido.equals("SUR")) {
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/Broncas_Izquierda.png");
		}
	}
}
