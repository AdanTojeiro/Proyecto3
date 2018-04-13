package principal;

import java.awt.EventQueue;

import interfaz.Ventana;

public class Launcher {
	/*
	 * Autor: Adan Jarillo Merida
	 * Version: en Desarrollo 0.4
	 * 
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
