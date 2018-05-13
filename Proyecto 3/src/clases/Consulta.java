package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Consulta {
	
	private int pk_consulta;
	private Timestamp fecha;
	private Usuario usuario;
	private String asunto, descripcion;
	
	
	
	
	
	public Consulta(Usuario usuario, String asunto, String descripcion) {
		super();
		this.usuario = usuario;
		this.asunto = asunto;
		this.descripcion = descripcion;
	}
	
	public Consulta(String asunto, String descripcion) {
		super();
		this.asunto = asunto;
		this.descripcion = descripcion;
	}
	
	
	public Consulta(ResultSet rs) {
		try {
			usuario = new Usuario(rs);
			pk_consulta = rs.getInt("pk_consulta");
			fecha = rs.getTimestamp("fecha");
			asunto = rs.getString("asunto");
			descripcion = rs.getString("descripcion");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPk_consulta() {
		return pk_consulta;
	}
	public void setPk_consulta(int pk_consulta) {
		this.pk_consulta = pk_consulta;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
