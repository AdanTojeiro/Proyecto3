package acceso_a_datos;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	GestorUsuarios gestorUsuarios;

	public Checker(GestorUsuarios gestorUsuarios) {
		this.gestorUsuarios = gestorUsuarios;
	}

	public InfoMsg checkPassword(String s) {
		InfoMsg info;
		Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}");
		Matcher mat = pat.matcher(s);
		if (mat.matches()) {
			info = new InfoMsg("Contraseña valida", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
		} else {
			Pattern pat2 = Pattern.compile("(?=.*[0-9])(?=\\S+$).{1,}");
			Matcher mat2 = pat2.matcher(s);
			if (!mat2.matches()) {
				info = new InfoMsg("Debe incluir un numero", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			} else {
				pat2 = Pattern.compile("(?=.*[a-z])(?=\\S+$).{1,}");
				mat2 = pat2.matcher(s);
				if (!mat2.matches()) {
					info = new InfoMsg("Debe incluir una minuscula", "/imagenes/error_black_32px.png", false,
							COLOR_ERROR);
				} else {
					pat = Pattern.compile("(?=.*[A-Z])(?=\\S+$).{1,}");
					mat2 = pat2.matcher(s);
					if (!mat2.matches()) {
						info = new InfoMsg("Debe incluir una mayuscula", "/imagenes/error_black_32px.png", false,
								COLOR_ERROR);
					} else {
						info = new InfoMsg("Minimo 8 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
					}
				}
			}
		}
		return info;
	}

	public InfoMsg checkStringStrict(String s) {
		// Solo letras, sin espacios maximo 20 caracteres
		InfoMsg info;

		Pattern pat = Pattern.compile("^[a-zA-Z]{2,20}$");
		Matcher mat = pat.matcher(s);
		if (mat.matches()) {
			info = new InfoMsg("Nombre valido", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
		} else {
			if (s.length() > 20) {
				info = new InfoMsg("Maximo 20 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			} else {
				if (s.length() < 2) {
					info = new InfoMsg("Minimo 2 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
				} else {
					info = new InfoMsg("Solo puede incluir letras", "/imagenes/error_black_32px.png", false,
							COLOR_ERROR);
				}
			}
		}

		return info;
	}

	public InfoMsg checkStringFlex(String s) {
		// Solo letras, numeros y guiones, sin espacios maximo 20 caracteres
		// Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		// "^[a-zA-Z0-9_-]{4,20}$"

		InfoMsg info = null;

		Pattern pat = Pattern.compile("^[a-zA-Z0-9_-]{4,20}$");
		Matcher mat = pat.matcher(s);
		if (mat.matches()) {
			// Cumple formato
			if (!gestorUsuarios.buscarUsuarioExacto("nick", s)) {
				info = new InfoMsg("Nick valido", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
			} else {
				info = new InfoMsg("El nick no esta disponible", "/imagenes/error_black_32px.png", false,
						COLOR_ERROR);
			}

		} else {
			if (s.length() > 20) {
				info = new InfoMsg("Maximo 20 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			} else {
				if (s.length() < 4) {
					info = new InfoMsg("Minimo 4 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
				} else {
					info = new InfoMsg("Solo letras, numeros y guiones", "/imagenes/error_black_32px.png", false,
							COLOR_ERROR);
				}

			}

		}
		return info;
	}

	public InfoMsg checkEmail(String s) {
		// Formato Email.
		InfoMsg info = null;
		
		Pattern pat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(s);
		
		if(mat.matches()) {
			if (!gestorUsuarios.buscarUsuarioExacto("email", s)) {
			info = new InfoMsg("Email valido", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
			} else {
				info = new InfoMsg("Este email ya esta en uso", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			}
		} else {
			info = new InfoMsg("Formato no reconocido", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
		}
		
		return info;
	}

	public InfoMsg checkStringStrict(String s, int nCadenas) {
		// Divide la cadena en subCadeanes en cada espacio en blanco. Comprueba que el
		// numero de cadenas coincide
		// con nCadenas y aplica checkStringStrict a cada una de las cadenas.
		String[] apellidos = s.split(" ");
		InfoMsg info, infoS1, infoS2;
		if (apellidos.length == nCadenas) {
			infoS1 = checkStringStrict(apellidos[0]);
			infoS2 = checkStringStrict(apellidos[1]);
			if (infoS1.isCheck() && infoS2.isCheck()) {
				info = new InfoMsg("Apellidos validos", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
			} else {
				if (infoS1.isCheck()) {
					if (apellidos[1].length() > 20) {
						info = new InfoMsg("Maximo 20 caracteres por apellido", "/imagenes/error_black_32px.png", false,
								COLOR_ERROR);
					} else {
						if (apellidos[1].length() < 2) {
							info = new InfoMsg("Minimo 2 caracteres por apellido", "/imagenes/error_black_32px.png",
									false, COLOR_ERROR);
						} else {
							info = infoS2;
						}
					}
				} else {
					if (apellidos[0].length() > 20) {
						info = new InfoMsg("Maximo 20 caracteres por apellido", "/imagenes/error_black_32px.png", false,
								COLOR_ERROR);
					} else {
						if (apellidos[0].length() < 2) {
							info = new InfoMsg("Minimo 2 caracteres por apellido", "/imagenes/error_black_32px.png",
									false, COLOR_ERROR);
						} else {
							info = infoS1;
						}
					}
				}

			}

		} else {
			if (apellidos.length > 2) {
				info = new InfoMsg("Maximo 2 apellidos", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			} else {
				info = new InfoMsg("Minimo 2 apellidos", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			}

		}
		return info;
	}
	
	public InfoMsg checkStringFlexKey(String s) {
		// Solo letras, numeros y guiones, sin espacios maximo 20 caracteres
		// Reconvertimos la cadana a primera mayuscula, siguientes minusculas.
		// "^[a-zA-Z0-9_-]{4,20}$"
		//La cadena debe existir dentro de la base de datos ene l campo indicado

		InfoMsg info = null;

		Pattern pat = Pattern.compile("^[a-zA-Z0-9_-]{4,20}$");
		Matcher mat = pat.matcher(s);
		if (mat.matches()) {
			// Cumple formato
				if(gestorUsuarios.buscarUsuarioExacto("nick", s)){
					info = new InfoMsg("Usuario encontrado", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
				} else {
					info = new InfoMsg("El usuario no existe", "/imagenes/error_black_32px.png", false,
							COLOR_ERROR);
			}

		} else {
			if (s.length() > 20) {
				info = new InfoMsg("Maximo 20 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			} else {
				if (s.length() < 4) {
					info = new InfoMsg("Minimo 4 caracteres", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
				} else {
					info = new InfoMsg("Solo letras, numeros y guiones", "/imagenes/error_black_32px.png", false,
							COLOR_ERROR);
				}

			}

		}
		return info;
	}


	public InfoMsg checkDNI(String s) {
		// Comprueba longitud = 9 empieza por numero o x | y | z (NIE), comprobara que
		// la letra coincide
		// segun el numero y que no esta registrado en la BBDD
		InfoMsg info = null;

		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E', 'T' };

		
			if (!gestorUsuarios.buscarUsuarioExacto("dni", s)) {
				if (s.length() > 0) {
					char pL = s.charAt(0);
					switch (pL) {

					case 'x' | 'X':
						s = "0" + s.substring(1);
						break;
					case 'y' | 'Y':
						s = "1" + s.substring(1);
						break;
					case 'z' | 'Z':
						s = "2" + s.substring(1);
						break;

					}
				}
				Pattern pat = Pattern.compile("\\d{8}[a-zA-Z]");
				Matcher mat = pat.matcher(s);

				if (mat.matches()) {
					int nDNI = Integer.parseInt(s.substring(0, 8));
					int resto = nDNI % 23;
					char letra = s.charAt(8);

					if (Character.toUpperCase(letra) == letras[resto]) {
						info = new InfoMsg("DNI valido", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
					} else {
						info = new InfoMsg("La letra no coincide", "/imagenes/error_black_32px.png", false,
								COLOR_ERROR);
					}
				} else {
					info = new InfoMsg("Formato incorrecto", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
				}

			} else {
				info = new InfoMsg("Este DNI ya esta en uso", "/imagenes/error_black_32px.png", false, COLOR_ERROR);
			}
		
		return info;
	}

	public InfoMsg checkSimilitud(String sPrincipal, String sRelacionada, boolean check) {
		InfoMsg info = null;
		if(check) {
			if (sPrincipal.equals(sRelacionada)) {
				info = new InfoMsg("Las contraseñas coinciden", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
			} else {
				info = new InfoMsg("Las contraseñas no coinciden", "/imagenes/error_black_32px.png", false,
						COLOR_ERROR);
			}
		} else {
			info = checkPassword(sRelacionada);
			if (info.isCheck()) {
				info = checkSimilitud(sPrincipal, sRelacionada, true);
			}
		}
		return info;
	}

	public InfoMsg checkCorrespondencia(String sPrincipal, String sRelacionada, boolean check) {
		InfoMsg info = null;
		Encriptador enc = new Encriptador();
		if(check) {
					if(enc.compararMD5(sPrincipal, gestorUsuarios.getPassword("nick", sRelacionada))) {
						info = new InfoMsg("Contraseña Correcta", "/imagenes/checkbox_32px.png", true, COLOR_CHECK);
					} else {
						info = new InfoMsg("Contraseña incorrecta", "/imagenes/error_black_32px.png", false,
								COLOR_ERROR);
					}
			
		} else {
			info = new InfoMsg("Usuario no encontrado", "/imagenes/error_black_32px.png", false,
					COLOR_ERROR);
		}
		return info;
	}
	
	

}
