package acceso_a_datos;

import org.apache.commons.codec.digest.DigestUtils;

public class Encriptador {
	
	public String encriptarMD5(String cadena) {
	
		return DigestUtils.md5Hex(cadena);
	}
	
	public boolean compararMD5(String cadena, String encriptada) {
		boolean control =  false;
		if (this.encriptarMD5(cadena).equals(encriptada)) {
			control = true;
		}
		return control;
	}

}
