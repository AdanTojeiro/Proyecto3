package clases;

public class Respuesta {
	
	int pk_respuesta, fk_pregunta;
	String texto;
	char indice;
	
	public Respuesta(String texto, char indice) {
		super();
		this.texto = texto;
		this.indice = indice;
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
