package principal;

import controlador.Controlador;
import modelo.Modelo;
import vista.Demo;

public class PrincipalBuscaMinas {
	public static void main(String[] args) {
		Modelo modelo =  new Modelo();
		Demo window = new Demo();	
		window.setVisible(true);
		Controlador controloador = new Controlador(window, modelo);
	}
}
