package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

public class Sesion {

	private Usuario usuario;
	private Timestamp tiempo_inicio;
	private String codigo;

	public Sesion(ResultSet rs , String codigo) {
		super();
		usuario = setUsuario(rs);
		this.codigo = codigo;
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

	

}
