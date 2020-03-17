package vista;
import java.awt.GridLayout;

import javax.swing.JButton;
/*
 * @Author: Carlos Capriel
 * @info: Clase contendra todos los botoenes del juego, solo botones que posiblemente, tengan minas,
 * */
import javax.swing.JPanel;

public class PanelDeMinas extends JPanel{
	
	private int largo;
	private int ancho;
	
	public PanelDeMinas(int largo, int ancho) {
		setLayout(new GridLayout(largo, ancho));
		this.largo = largo;
		this.ancho = ancho;
		agregarBotones();
	}
	public void agregarBotones() {
		for (int i = 0; i < largo*ancho; ++i) {
				add(new JButton());
		}
	}
	
}
