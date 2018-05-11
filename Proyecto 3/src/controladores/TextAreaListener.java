package controladores;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TextAreaListener implements FocusListener, KeyListener {

	JTextArea textArea;
	JLabel textLbl;
	private final Color COLOR_DANGER = new Color(222, 69, 69);
	
	

	public TextAreaListener(JTextArea textArea, JLabel textLbl) {
		super();
		this.textArea = textArea;
		this.textLbl = textLbl;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(textArea.getText().equals("")) {
			textLbl.setText("Maximo 300 caracteres");
		} else {
			
			textLbl.setText(textArea.getText().length()+"/300 caracteres.");
			if(textArea.getText().length() > 300) {
				textLbl.setForeground(COLOR_DANGER);
			}else {
				textLbl.setForeground(Color.WHITE);
			}
		}
	}
		

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(textArea.getText().equals("Describre detalladamente la incidencia.")) {
			textArea.setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(textArea.getText().equals("")) {
			textArea.setText("Describre detalladamente la incidencia.");
		}
		
	}

}
