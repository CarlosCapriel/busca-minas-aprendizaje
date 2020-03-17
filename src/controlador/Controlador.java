package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.Demo;

public class Controlador implements ActionListener{
	private Demo vista;
	private Modelo modelo;
	
	public Controlador(Demo vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.pnlDatos.btnIniciar.addActionListener(this);
		this.vista.pnlDatos.txtAncho.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.setAncho(Integer.parseInt(vista.pnlDatos.txtAncho.getText()));
		modelo.setLargo(Integer.parseInt(vista.pnlDatos.txtLargo.getText()));
		vista.crearPanelMinado(modelo.getLargo(), modelo.getAncho());
	}

}
