package vista;
/*
 * @Author: Carlos Capriel.
 * 
 * @info: Clase BotonMina, contendra propiedades de las minas, en las varibles posx y posy, se almacenara
 * 	las coordenadas de este boton, que sirve para el algoritmo que marcara cuantas minas hay alrededor de las minas.
 * */
import javax.swing.JButton;

import controlador.ControladorBotonMina;

public class BotonMina extends JButton{
	
	private boolean minado;
	private short posx;
	private short posy;

	public BotonMina(short posx, short posy, boolean minado) {
		this.posx = posx;
		this.posy = posy;
		this.minado = minado;
		this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	}

	public boolean isMinado() {
		return minado;
	}

	public short getPosx() {
		return posx;
	}

	public short getPosy() {
		return posy;
	}

}
