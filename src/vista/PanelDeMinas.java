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
	public ArrayList<JButton> btnMinas;
	
	public PanelDeMinas(int largo, int ancho) {
		setLayout(new GridLayout(largo, ancho));
		this.largo = largo;
		this.ancho = ancho;
		agregarBotones();
	}
	public void agregarBotones() {
		btnMinas = new ArrayList<JButton>();
		int pivote = 0;
		for (int i = 1; i <= largo; ++i) {
			for (int j = 1; j <= ancho; ++j) {
				btnMinas.add(new BotonMina((short)j, (short)i, true));
				add(btnMinas.get(pivote));
				++pivote;
			}
		}
	}
}
