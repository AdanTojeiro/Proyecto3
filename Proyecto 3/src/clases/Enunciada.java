package clases;

public class Enunciada {

	Pregunta pregunta;
	char respuesta;
	boolean correcta;
	
	public Enunciada(Pregunta pregunta, char respuesta, boolean correcta) {
		super();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public char getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(char respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	
	
	
	


}
