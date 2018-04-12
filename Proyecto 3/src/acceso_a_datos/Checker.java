package acceso_a_datos;

import java.awt.Color;

public class Checker {
	
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	MysqlC mysqlc;
	
	public InfoMsg checkPassword(String s) {
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	} 
	
	public InfoMsg checkStringStrict(String s) {
		//Solo letras, sin espacios maximo 20 caracteres
		//Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	
	public InfoMsg checkStringFlex(String s) {
		//Solo letras, numeros y guiones, sin espacios maximo 20 caracteres
		//Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	
	public InfoMsg checkEmail(String s) {
		//Formato Email.
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	
	
	public InfoMsg checkStringStrict(String s, int nCadenas) {
		//Divide la cadena en subCadeanes en cada espacio en blanco. Comprueba que el numero de cadenas coincide
		//con nCadenas y aplica checkStringStrict a cada una de las cadenas.
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
		
	}
	
	public InfoMsg checkDNI(String s) {
		//Comprueba longitud = 9 empieza por numero o x | y | z (NIE), comprobara que la letra coincide
		//segun el numero y que no esta registrado en la BBDD
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	
	public InfoMsg checkSimilitud(String sPrincipal, String sRelacionada) {
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	
	public InfoMsg checkCorrespondencia(String sPrincipal, String sRelacionada) {
		InfoMsg info = new InfoMsg("Funsiona muyayo", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		return info;
	}
	

}
