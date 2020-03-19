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
	private int numMaxFilas;
	private int numMaxColumns;
	private int posx;
	private int posy;
	private int indexArray;
	public ControladorBotonMina(BotonMina btn) {
		this.btn = btn;
	}
	public ControladorBotonMina() {
		// TODO Auto-generated constructor stub
		numMaxColumns = 0;
		numMaxFilas = 0;
		posx = 0;
		posy = 0;
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
				posy = btn.getPosy();
				posx = btn.getPosx();
				indexArray = numMaxColumns*(posy-1) + (posx-1);///Encontramos el indice en que se encuentra el boton en el ArrayList
				arrayBtnMina.get(indexArray).setEnabled(false);
			}
	}
	public void setArrayBtnMina(ArrayList<BotonMina> arrayBtnMina) {
		this.arrayBtnMina = arrayBtnMina;
	}
	public void setNumMaxFilas(int numMaxFilas) {
		this.numMaxFilas = numMaxFilas;
	}
	public void setNumMaxColumns(int numMaxColumns) {
		this.numMaxColumns = numMaxColumns;
	}
	public void contarMinas() {
		if (posx == 1 && posy == 1) {///Caso que estes en la esquina superior izquierda
			
		} else if ((posx == 1) && (posy == numMaxFilas)) {///Caso para cuando este en la esquina inferior izquierda
			
		} else if ((posx == numMaxColumns) && (posy == 1)) {///Caso para cuando este en la esquina superior derecha
			
		} else if ((posx == numMaxColumns) && (posy == numMaxFilas)) {///Caso para cuando este en la esquina inferior derecha
			
		} else if (posx == 1) {///Caso para cuando este en la primera columna, sin importar fila y no es una esquina,
								///  se esta segura por esos casos se evaluaron en los anteriores filtros.
			
		} else if (posy == 1) {///Caso para cuando se este en la primera fila sin importar columna y no es esquina
			
		} else if (posx == numMaxColumns) {///Caso para cuando se este en la ultima columna sin importar fila y no es esquina.
			
		} else if(posy == numMaxFilas) {///Caso para cuando se este en la ultima fila y sin importar columna y no es esquina.
			
		} else {///El ultimo caso para cuando no sea ninguno de los anteriores es decir se tenga que evaluar los 8 cuadros alrededor de este.
			
		}
		
	}
}
