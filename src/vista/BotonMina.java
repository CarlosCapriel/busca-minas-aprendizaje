package vista;
/*
 * @Author: Carlos Capriel.
 * 
 * @info: Clase BotonMina, contendra propiedades de las minas
 * */
import javax.swing.JButton;

import controlador.ControladorBotonMina;

public class BotonMina extends JButton{
	
	private boolean mina;
	private short posx;
	private short posy;
	private ControladorBotonMina listenerBtnMina;
	public BotonMina(short posx, short posy, boolean mina) {
		this.posx = posx;
		this.posy = posy;
		this.mina = mina;
		listenerBtnMina = new ControladorBotonMina(this);
		addActionListener(listenerBtnMina);
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public short getPosx() {
		return posx;
	}

	public void setPosx(short posx) {
		this.posx = posx;
	}

	public short getPosy() {
		return posy;
	}

	public void setPosy(short posy) {
		this.posy = posy;
	}
		
}
