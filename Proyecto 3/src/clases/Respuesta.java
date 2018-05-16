package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Respuesta {
	
	int pk_respuesta, fk_pregunta;
	String texto;
	char indice;
	
	public Respuesta(String texto, char indice) {
		super();
		this.texto = texto;
		this.indice = indice;
	}

	public Respuesta(ResultSet rs) {
		try {
			pk_respuesta = rs.getInt("pk_respuesta");
			fk_pregunta = rs.getInt("fk_pregunta");
			texto= rs.getString("texto");
			indice= rs.getString("indice").charAt(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPk_respuesta() {
		return pk_respuesta;
	}

	public void setPk_respuesta(int pk_respuesta) {
		this.pk_respuesta = pk_respuesta;
	}

	public int getFk_pregunta() {
		return fk_pregunta;
	}

	public void setFk_pregunta(int fk_pregunta) {
		this.fk_pregunta = fk_pregunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public char getIndice() {
		return indice;
	}

	public void setIndice(char indice) {
		this.indice = indice;
	}
	
	
	

}
