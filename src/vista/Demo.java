package vista;

import java.awt.BorderLayout;

/*
 * @Author : Carlos Capriel.
 * 
 * Ventana principal, este es el contenedor principal de la vista.
 * 
 * */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo extends JFrame{
	
	private JPanel pnlCenter;
	public PanelCapturaDimension pnlDatos = new PanelCapturaDimension();
	public PanelDeMinas pnlMinado;
	public Demo() {
		crearVentana();
	}

	public void crearVentana() {
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		setSize(260, 260);
		setTitle("Busca minas.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().add(pnlDatos, BorderLayout.NORTH);
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
	}
	
	public void crearPanelMinado(int largo, int ancho) {
		pnlCenter.removeAll();
		pnlMinado = new PanelDeMinas(ancho, largo);
		pnlCenter.add(pnlMinado, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}

