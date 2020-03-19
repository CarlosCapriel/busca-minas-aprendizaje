package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import vista.BotonMina;

public class ControladorBotonMina implements ActionListener{
	private BotonMina btn;
	private ArrayList<BotonMina> arrayBtnMina;

	public ControladorBotonMina(BotonMina btn) {
		this.btn = btn;
	}
	public ControladorBotonMina() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			btn = (BotonMina) e.getSource();
			System.out.println("hola " + btn.getPosx() + " y: "+ btn.getPosy() + btn.isMinado());
			if (btn.isMinado()) {
				for (int i = 0; i < arrayBtnMina.size(); ++i) {/// Si el boton esta minado recorremos todo el array que contiene las instancias
					arrayBtnMina.get(i).setEnabled(false);///para que no se pueda precionar asi el juego practicamente esta terminado.
					if (arrayBtnMina.get(i).isMinado()) {
						arrayBtnMina.get(i).setBackground(Color.RED);///A los minados les cambiamos tambien el color
					}
				}
			} else {
				btn.setEnabled(false);
			}
	}
	public void setArrayBtnMina(ArrayList<BotonMina> arrayBtnMina) {
		this.arrayBtnMina = arrayBtnMina;
	}
	
}
