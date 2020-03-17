package vista;
/*
 * @Author: Carlos Capriel
 * 
 * @info: El panel que contiene el disenio de la ventana que capturara los datos de dimension del campo minado.
 * */
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCapturaDimension extends JPanel implements ActionListener{
	
	public JTextField txtLargo;
	public JTextField txtAncho;
	public JButton btnIniciar;
	
	public PanelCapturaDimension() {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		agregarComponentes();
	}
	
	public void agregarComponentes() {
		GridBagConstraints constrains =  new GridBagConstraints();
		
		JLabel lblLargo = new JLabel("   Largo:  ");
		constrains.gridx = 0;///Con la variable gridx, le decimos en columna se situara el componente(solo funciona con este layou utilizado).
		constrains.gridy = 0;/// Con la variable gridy, le decimos en que fila se situra en el componente(solo funciona con este layou utilizado).
		constrains.fill = GridBagConstraints.NONE;/// modificamos esta variable para indicar en que direccion se estirara el componente(vertical, horizonal o ambossentidos).
		add(lblLargo, constrains);///Agregado al contenedor
		
		txtLargo =  new JTextField();
		constrains.gridx = 1;
		constrains.gridy = 0;
		constrains.weightx = 1.0;///Modificamos esta variable en 1 para indicar que esta columna del layout se estirara
		constrains.fill = GridBagConstraints.HORIZONTAL;/// El componente se "estirara" en direccion horizontal.
		add(txtLargo, constrains);
		txtLargo.addActionListener(this);
		
		JLabel lblAncho =  new JLabel("  Ancho:  ");
		constrains.gridx = 2;
		constrains.gridy = 0;
		constrains.weightx = 0.0;
		constrains.fill = GridBagConstraints.NONE;
		add(lblAncho, constrains);
		
		txtAncho =  new JTextField();
		constrains.gridx = 3;
		constrains.gridy = 0;
		constrains.weightx = 1.0;
		constrains.fill = GridBagConstraints.HORIZONTAL;
		add(txtAncho, constrains);
		
		btnIniciar = new JButton("Iniciar");
		constrains.gridx = 4;
		constrains.gridy = 0;
		constrains.weightx = 0.0;
		constrains.fill = GridBagConstraints.NONE;
		add(btnIniciar, constrains);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			txtAncho.requestFocus();
	}
	
}
