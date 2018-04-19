package clases;

import java.sql.Date;
import java.sql.ResultSet;

public class Sesion {
	
	private Usuario usuario;
	private Date fecha_inicio;
	
	
	
	public Sesion(ResultSet rs) {
		super();
		usuario = setUsuario(rs);
		fecha_inicio =  new Date(new java.util.Date().getTime());
	}
	
	public Usuario setUsuario(ResultSet rs) {
		Usuario usuario = new Usuario(rs);
		return usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	

}
