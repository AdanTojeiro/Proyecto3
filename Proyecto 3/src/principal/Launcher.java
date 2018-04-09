package principal;

import java.awt.EventQueue;

import acceso_a_datos.MysqlC;
import interfaz.Ventana;

public class Launcher {
	/*
	 * Autor: Adan Jarillo Merida
	 * Version: en Desarrollo 0.3
	 * 
	 * 
	 */

	public static void main(String[] args) {
		
		MysqlC mysqlc = new MysqlC();
		mysqlc.Conectar();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana(mysqlc);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
