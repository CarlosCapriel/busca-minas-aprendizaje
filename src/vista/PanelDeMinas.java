package vista;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
/*
 * @Author: Carlos Capriel
 * @info: Clase contendra todos los botoenes del juego, solo botones que posiblemente, tengan minas,
 * */
import javax.swing.JPanel;

public class PanelDeMinas extends JPanel{
	
	private int largo;
	private int ancho;
	public ArrayList<JButton> btnMinas = new ArrayList<JButton>();
	
	public PanelDeMinas(int largo, int ancho) {
		setLayout(new GridLayout(largo, ancho));
		this.largo = largo;
		this.ancho = ancho;
		agregarBotones();
	}
	public void agregarBotones() {
		for (int i = 0; i < largo; ++i) {
			for (int j = 0; j < ancho; ++j) {
				add(new BotonMina((short)i, (short)j, true));
			}
		}
	}
}
