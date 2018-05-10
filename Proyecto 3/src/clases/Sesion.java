package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

public class Sesion {

	private Usuario usuario;
	private Timestamp tiempo_inicio;
	private String codigo;
	private boolean sesionPrincipal;
	
	
	public Sesion(ResultSet rs , String codigo) {
		super();
		usuario = new Usuario(rs);
		this.codigo = codigo;
		sesionPrincipal = true;
		
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

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

	public boolean isSesionPrincipal() {
		return sesionPrincipal;
	}

	public void setSesionPrincipal(boolean sesionPrincipal) {
		this.sesionPrincipal = sesionPrincipal;
	}

	

}
