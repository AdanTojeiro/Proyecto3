package acceso_a_datos;

public class Checker {
	
	MysqlC mysqlc;
	
	public boolean checkPassword(String s) {
		boolean control = false;
		return control;
	} 
	
	public boolean checkStringStrict(String s) {
		//Solo letras, sin espacios maximo 20 caracteres
		//Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		boolean control = false;
		return control;
	}
	
	public boolean checkStringFlex(String s) {
		//Solo letras, numeros y guiones, sin espacios maximo 20 caracteres
		//Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		boolean control = false;
		return control;
	}
	
	public boolean checkEmail(String s) {
		//Formato Email.
		boolean control = false;
		return control;
	}
	
	
	public boolean checkStringStrict(String s, int nCadenas) {
		//Divide la cadena en subCadeanes en cada espacio en blanco. Comprueba que el numero de cadenas coincide
		//con nCadenas y aplica checkStringStrict a cada una de las cadenas.
		boolean control = false;
		return control;
		
	}
	
	public boolean checkDNI(String s) {
		//Comprueba longitud = 9 empieza por numero o x | y | z (NIE), comprobara que la letra coincide
		//segun el numero y que no esta registrado en la BBDD
		boolean control = false;
		return control;
	}
	

}
