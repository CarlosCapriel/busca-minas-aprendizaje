package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.BotonMina;
import vista.PanelDeMinas;
/*
 * @Author: Carlos Capriel
 * @info:  se implementa un unico listener para todos los botones, aqui mismo se cuentan las minas que un boton tiene a su alrededor.
 * 
 * */
public class ControladorBotonMina implements ActionListener{
	private BotonMina btn;
	private ArrayList<BotonMina> arrayBtnMina;
	private int numMaxFilas;
	private int numMaxColumns;
	private int posx;
	private int posy;
	private int indexArray;
	private int contadorMinas;
	public ControladorBotonMina(BotonMina btn) {
		this.btn = btn;
	}
	public ControladorBotonMina() {
		// TODO Auto-generated constructor stub
		contadorMinas = 0;
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
//				JOptionPane.showMessageDialog(null, "Perdedor!!!!", "Perdedor!!!", JOptionPane.OK_OPTION);
			} else {
				posy = btn.getPosy();
				posx = btn.getPosx();
				indexArray = numMaxColumns*(posy-1) + (posx-1);///Encontramos el indice en que se encuentra el boton en el ArrayList
				arrayBtnMina.get(indexArray).setText(contarMinas()+"");
				arrayBtnMina.get(indexArray).setEnabled(false);
				PanelDeMinas.contadorNoMinas--;///Disminuimos ya que se encontro un btn no minado
			}
			if(PanelDeMinas.contadorNoMinas == 0) {
				for (int i = 0; i < arrayBtnMina.size(); ++i) {
					arrayBtnMina.get(i).setEnabled(false);
					if (arrayBtnMina.get(i).isMinado()) {
						arrayBtnMina.get(i).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					}
				}
				JOptionPane.showMessageDialog(null, "Felicidades has ganado !!!!", "Felicitaciones !!!", JOptionPane.PLAIN_MESSAGE);
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
	public int contarMinas() {
//		Todos las posiciones posibles de los btns (ezquinas infer izquier, arriba, super izquierda, debajo etc.
//		estan en el ultimo else que es el caso cuando se tiene que evaluar en los alrededores de ese btn los ocho btn circundantes
//		el caso mas claro es cuando el boton esta en el centro.
		if (posx == 1 && posy == 1) {///Caso que estes en la esquina superior izquierda
			
			contadorMinas = 0;
			System.out.println("in "+indexArray + "maxC " + numMaxColumns);
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(numMaxColumns).isMinado()) ? 1 : 0;///El indice del array comienza en 0 + numMaxCols
			contadorMinas += (arrayBtnMina.get(numMaxColumns+1).isMinado()) ? 1 : 0;///Llevaria al btn de 2da fila 1era columna, +1 
																					///sera el siguiente
		} else if ((posx == 1) && (posy == numMaxFilas)) {///Caso para cuando este en la esquina inferior izquierda
			
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns-1)).isMinado()) ? 1 : 0;
		
		} else if ((posx == numMaxColumns) && (posy == 1)) {///Caso para cuando estes en la esquina superior derecha
			
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns-1)).isMinado()) ? 1 : 0;
		
		} else if ((posx == numMaxColumns) && (posy == numMaxFilas)) {///Caso para cuando este en la esquina inferior derecha
		
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns+1)).isMinado()) ? 1 : 0;
		
		} else if (posx == 1) {///Caso para cuando este en la primera columna, sin importar fila y no es una esquina,
								///  se esta seguro por esos casos se evaluaron en los anteriores filtros.
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns+1)).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns-1)).isMinado()) ? 1 : 0;
		
		} else if (posy == 1) {///Caso para cuando se este en la primera fila sin importar columna y no es esquina
			
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns-1)).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns+1).isMinado()) ? 1 : 0;
			
		} else if (posx == numMaxColumns) {///Caso para cuando se este en la ultima columna sin importar fila y no es esquina.
			
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;///El que esta a la izquierda
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns+1)).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns-1)).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns).isMinado()) ? 1 : 0;
			
		} else if(posy == numMaxFilas) {///Caso para cuando se este en la ultima fila y sin importar columna y no es esquina.
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;///El que esta a la izquierda
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;///El que esta a la derecha
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns+1)).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns-1)).isMinado()) ? 1 : 0;
		} else {///El ultimo caso para cuando no sea ninguno de los anteriores es decir se tenga que evaluar los 8 cuadros alrededor de este.
			contadorMinas = 0;
			contadorMinas += (arrayBtnMina.get(indexArray-1).isMinado()) ? 1 : 0;///El que esta a la izquierda
			contadorMinas += (arrayBtnMina.get(indexArray+1).isMinado()) ? 1 : 0;///El que esta a la derecha
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns+1)).isMinado()) ? 1 : 0; ///El que esta en la  esquina supr izquier
			contadorMinas += (arrayBtnMina.get(indexArray-numMaxColumns).isMinado()) ? 1 : 0;///El que esta arriba
			contadorMinas += (arrayBtnMina.get(indexArray-(numMaxColumns-1)).isMinado()) ? 1 : 0;///El que esta en la  esquina supr derecha
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns-1)).isMinado()) ? 1 : 0;///El que esta en la  esquina infer izquier
			contadorMinas += (arrayBtnMina.get(indexArray+numMaxColumns).isMinado()) ? 1 : 0; ///El que esta debajo
			contadorMinas += (arrayBtnMina.get(indexArray+(numMaxColumns+1)).isMinado()) ? 1 : 0;///El que esta en la  esquina infer derecha
		}
		return contadorMinas;
	}
}
