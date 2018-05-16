package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pregunta {
	
	int pk_pregunta;
	String enunciado, codigo_pregunta;
	char indiceCorrecto;
	Respuesta[] respuestas;
	
	
	public Pregunta(String enunciado, char indiceCorrecto, Respuesta[] respuestas) {
		super();
		this.enunciado = enunciado;
		this.indiceCorrecto = indiceCorrecto;
		this.respuestas = respuestas;
	}


	public Pregunta(ResultSet rs) {
		// TODO Auto-generated constructor stub
		try {
			pk_pregunta = rs.getInt("pk_pregunta");
			enunciado = rs.getString("enunciado");
			codigo_pregunta = rs.getString("codigo_pregunta");
			indiceCorrecto = rs.getString("indice_correcto").charAt(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int getPk_pregunta() {
		return pk_pregunta;
	}


	public void setPk_pregunta(int pk_pregunta) {
		this.pk_pregunta = pk_pregunta;
	}


	public String getEnunciado() {
		return enunciado;
	}


	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


	public char getIndiceCorrecto() {
		return indiceCorrecto;
	}


	public void setIndiceCorrecto(char indiceCorrecto) {
		this.indiceCorrecto = indiceCorrecto;
	}


	public Respuesta[] getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(Respuesta[] respuestas) {
		this.respuestas = respuestas;
	}


	public String getCodigo_pregunta() {
		return codigo_pregunta;
	}


	public void setCodigo_pregunta(String codigo_pregunta) {
		this.codigo_pregunta = codigo_pregunta;
	}
	
	
	
	

}
