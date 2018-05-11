package clases;

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
