package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import clases.Enunciada;
import interfaz.Ventana;
import interfaz.componentes.JRespuestaBtn;

public class RespuestaBtnListener implements MouseListener {
	
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	private JRespuestaBtn btn;
	
	
	

	public RespuestaBtnListener(Ventana ventana, JRespuestaBtn btn) {
		super();
		this.ventana = ventana;
		this.btn = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		boolean correcto = false;
		if(ventana.getPreguntaActual().getIndiceCorrecto() == btn.getIndice()) {
			correcto = true;
		}
		ventana.getGestorTest().añadirEnunciada(ventana.getTestActual(), ventana.getPreguntaActual(), btn.getIndice(), correcto);
		ventana.getTestActual().getEnunciadas().add(new Enunciada(ventana.getPreguntaActual(), btn.getIndice(), correcto));
		if(ventana.getTestActual().getEnunciadas().size() < 30) {
			ventana.actualizarPregunta(ventana.getGestorTest().getPreguntaDisponible(ventana.getTestActual()));
		} else {
			ventana.completarTest(ventana.getGestorTest().getNumeroAciertos(ventana.getTestActual()));
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		btn.setBackground(COLOR_HOVER);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		btn.setBackground(COLOR_BACKGROUND);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
