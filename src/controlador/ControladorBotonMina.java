package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.BotonMina;

public class ControladorBotonMina implements ActionListener{
	private BotonMina btn;
	public ControladorBotonMina(BotonMina btn) {
		this.btn = btn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hola " + btn.getPosx() + " y: "+ btn.getPosy());
	}

}
