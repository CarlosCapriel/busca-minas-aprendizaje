package modelo;
/*
 * @Author: Carlos Capriel
 * 
 * */
public class Modelo {
	private int largo;
	private int ancho;
	
	public Modelo() {
		largo = 0;
		ancho = 0;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
//	metodo que devuelve true/false si el numero generado es > 50, esto para establecer las minas aleatoriamente
	public boolean establecerMina() {
		return Math.random()*100+1 > 50;
	}
}
