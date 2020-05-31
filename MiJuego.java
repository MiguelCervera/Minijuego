package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class MiJuego extends JFrame {

	private JPanel contentPane;
	Link player;
	private int dif;
	private int mov, salIt, salEn;
	private int card;
	private boolean dibujaGhost = false;

	public MiJuego(int d) {
		
		if (d == 0) {
			mov = 100;
			salIt = 25;
			salEn = 40;
		} else if (d == 1) {
			mov = 50;
			salIt = 20;
			salEn = 50;
		}
		
		setTitle("Mini Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		player = new Link(panel, 100, 0, 10);
		Broncas broncas = new Broncas(panel, 80, 130, salEn);
		Topo topo = new Topo(panel, 100, 26, salEn);
		Ghost ghost = new Ghost(panel, salEn);
		
		JLabel lblSalud = new JLabel("Salud: " + player.getSalud());
		lblSalud.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEscudo = new JLabel("Escudo: " + player.getEscudo());
		lblEscudo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblArma = new JLabel("Arma: " + player.getArma());
		lblArma.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblSalud)
							.addComponent(lblArma, Alignment.TRAILING))
						.addComponent(lblEscudo, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSalud)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEscudo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblArma)
					.addContainerGap(446, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/Fondo.png")));
		panel.add(lblNewLabel);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
						
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/izquierda.png");
						card = 1;
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(player.CoordX()<(panel.getWidth()-100)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/derecha.png");
						card = 2;
					}
					break;
				case KeyEvent.VK_UP:
					if(player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");
						card = 3;
					}
					break;
				case KeyEvent.VK_DOWN:
					if(player.CoordY()<(panel.getWidth()-200)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");
						card = 4;
					}
					break;
				case KeyEvent.VK_B:
					if(player.getArma()> 0) {
						player.setArma(player.getArma()-1);
						lblArma.setText("Arma: " + String.valueOf(player.getArma()));
						Disparo d = new Disparo(panel, player.CoordX(), player.CoordY());
						d.movimientoDisparo(card);
					} break;
				} 
			}
		});
				
		Timer reloj = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent er) {
				if(!dibujaGhost) {
					dibujaGhost = true;
					ghost.spawn();
					
				}
				else
					dibujaGhost = false;
			}
		});	
		
		reloj.start();
		
		Timer reloj2 = new Timer(mov, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				topo.getPanel().update(panel.getGraphics());
				broncas.getPanel().update(panel.getGraphics());
				player.getPanel().update(panel.getGraphics());
				
				if(dibujaGhost) {
					ghost.getPanel().update(panel.getGraphics());
					
					ImageIcon ImagenGhost = new ImageIcon(ghost.getDireccion());
					panel.getGraphics().drawImage(ImagenGhost.getImage(), ghost.CoordX(), ghost.CoordY(), panel);
				
					panel.getGraphics().drawImage(null, 10, 80, null);
				}
				
				ImageIcon MiImagen = new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);
				
				broncas.movimientoBroncas();
				ImageIcon ImagenBroncas = new ImageIcon(broncas.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
				
				topo.movimientoTopo();
				ImageIcon ImagenTopo = new ImageIcon(topo.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topo.CoordX(), topo.CoordY(), panel);
				
				panel.getGraphics().drawImage(null, 10, 80, null);
			}
		});	
		
		reloj2.start();
	}
}
