package vista;
import java.awt.GridLayout;
import java.util.ArrayList;

/*
 * @Author: Carlos Capriel
 * @info: Clase contendra todos los botoenes del juego, solo botones que posiblemente, tengan minas, la instancia
 * 	de la clase ControladorBoton es un mismo listener para todos los botones.
 * */
import javax.swing.JPanel;

import controlador.ControladorBotonMina;

public class PanelDeMinas extends JPanel{
	
	private int largo;
	private int ancho;
	public ArrayList<BotonMina> btnMinas;
	private ControladorBotonMina btnControla;
	public static int contadorNoMinas;///Contaro el numero de botones que no tienen minas para ir disminuyendo
									///Cuando uno de estos sea encontrado se disminuira y cuando sea == 0, se pensara que ya gano.
	public PanelDeMinas(int largo, int ancho) {
		setLayout(new GridLayout(largo, ancho));
		this.largo = largo;
		this.ancho = ancho;
		btnControla = new ControladorBotonMina();
		contadorNoMinas = 0;
		agregarBotones();
	}
	public void agregarBotones() {
		btnMinas = new ArrayList<BotonMina>();
		int pivote = 0;
		contadorNoMinas = 0;
		for (int i = 1; i <= largo; ++i) {
			for (int j = 1; j <= ancho; ++j) {
				btnMinas.add(new BotonMina((short)j, (short)i, establecerMina()));
				add(btnMinas.get(pivote));
				btnMinas.get(pivote).addActionListener(btnControla);
				contadorNoMinas += (btnMinas.get(pivote).isMinado() == false) ? 1 : 0;
				++pivote;
			}
		}
		btnControla.setArrayBtnMina(btnMinas);
		btnControla.setNumMaxColumns(ancho);
		btnControla.setNumMaxFilas(largo);
	}
//	metodo que devuelve true/false si el numero generado es > 50, esto para establecer las minas aleatoriamente
	public boolean establecerMina() {
		return Math.random()*100+1 > 50;
	}
}
