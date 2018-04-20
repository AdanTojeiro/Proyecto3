package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

public class Sesion {

	private Usuario usuario;
	private Timestamp tiempo_inicio;
	private String codigo;

	public Sesion(ResultSet rs) {
		super();
		usuario = setUsuario(rs);
		tiempo_inicio = new Timestamp(new java.util.Date().getTime());
	}

	public Usuario setUsuario(ResultSet rs) {
		usuario = new Usuario(rs);
		return usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Timestamp getTiempo_inicio() {
		return tiempo_inicio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void generarCodigo(ResultSet rs) {
		boolean seguir = true;
		while (seguir) {
			seguir = false;
			codigo = randomCodigo();
			try {
				rs.beforeFirst();
				while (rs.next()) {
					if (codigo.equals(rs.getString("codigo"))) {
						seguir = true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String randomCodigo() {
		Random rng = new Random();
		codigo = "@";
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'k', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z' };
		char c;
		int n;
		while (codigo.length() < 15) {
			c = letras[rng.nextInt(letras.length)];
			n = numeros[rng.nextInt(numeros.length)];
			codigo = codigo + c + n;
		}
		return codigo;
	}

}
