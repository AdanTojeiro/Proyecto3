package principal;

import java.awt.EventQueue;


import interfaz.Ventana;


public class Launcher {
	/*
	 * Autor: Adan Jarillo Merida
	 * Version: ALPHA 1.0.0
	 * test build a100	 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try {
					Ventana window = new Ventana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

}
	
}
