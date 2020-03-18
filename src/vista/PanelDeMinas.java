package vista;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
/*
 * @Author: Carlos Capriel
 * @info: Clase contendra todos los botoenes del juego, solo botones que posiblemente, tengan minas,
 * */
import javax.swing.JPanel;

import controlador.ControladorBotonMina;

public class PanelDeMinas extends JPanel{
	
	private int largo;
	private int ancho;
	public ArrayList<BotonMina> btnMinas;
	
	public PanelDeMinas(int largo, int ancho) {
		setLayout(new GridLayout(largo, ancho));
		this.largo = largo;
		this.ancho = ancho;
		agregarBotones();
	}
	public void agregarBotones() {
		btnMinas = new ArrayList<BotonMina>();
		int pivote = 0;
		for (int i = 1; i <= largo; ++i) {
			for (int j = 1; j <= ancho; ++j) {
				btnMinas.add(new BotonMina((short)j, (short)i, establecerMina()));
				add(btnMinas.get(pivote));
				++pivote;
			}
		}
		
//		listenerBtnMina.setBotones(btnMinas);
	}
//	metodo que devuelve true/false si el numero generado es > 50, esto para establecer las minas aleatoriamente
	public boolean establecerMina() {
		return Math.random()*100+1 > 50;
	}
}
