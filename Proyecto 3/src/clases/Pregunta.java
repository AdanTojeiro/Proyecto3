package clases;

public class Pregunta {
	
	int pk_pregunta;
	String enunciado;
	char indiceCorrecto;
	Respuesta[] respuestas;
	
	
	public Pregunta(String enunciado, char indiceCorrecto, Respuesta[] respuestas) {
		super();
		this.enunciado = enunciado;
		this.indiceCorrecto = indiceCorrecto;
		this.respuestas = respuestas;
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
	
	
	
	

}
