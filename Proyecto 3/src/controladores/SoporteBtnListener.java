package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Consulta;
import interfaz.Ventana;
import interfaz.grupos.TextFieldGroup;

public class SoporteBtnListener implements MouseListener {
	
	JTextArea textArea;
	TextFieldGroup textFieldGroup;
	Ventana ventana;
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private final Color COLOR_DISABLED = new Color(128, 128, 128);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	
	

	public SoporteBtnListener(JTextArea textArea, TextFieldGroup textFieldGroup, Ventana ventana) {
		super();
		this.textArea = textArea;
		this.textFieldGroup = textFieldGroup;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		boolean control = false;
		if(ventana.getSesionActual() == null) {
			control = ventana.getGestorConsultas().generarConsultaInvitado(new Consulta(textFieldGroup.getTextF().getText(), textArea.getText()));
		} else {
			 control = ventana.getGestorConsultas().generarConsulta(new Consulta(ventana.getSesionActual().getUsuario(), textFieldGroup.getTextF().getText(), textArea.getText()));
		}
		if(control) {
			ventana.reniciarFormularioSoporte();
			ventana.showPopUp("nuevaconsulta");
			ventana.getFocusFixer().requestFocus();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!textFieldGroup.isCheck() || textArea.getText().equals("")) {
			e.getComponent().setEnabled(false);
			e.getComponent().setBackground(COLOR_DISABLED);
		} else {
			e.getComponent().setEnabled(true);
			e.getComponent().setBackground(COLOR_HOVER);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setBackground(COLOR_CHECK);
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
