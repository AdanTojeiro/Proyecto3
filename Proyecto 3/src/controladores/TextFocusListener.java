package controladores;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import acceso_a_datos.Checker;
import interfaz.TextFieldGroup;


public class TextFocusListener implements FocusListener{
	
	
	
	TextFieldGroup tFGroup;
	Checker checker;
	
	

	public TextFocusListener(TextFieldGroup tFGroup, Checker checker) {
		super();
		this.tFGroup = tFGroup;
		this.checker = checker;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if(tFGroup.getTextF().getText().equals(tFGroup.getDefaultText())){
			tFGroup.getTextF().setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(tFGroup.getTextF().getText().equals("")) {
			tFGroup.reset();		
		}
		
	}
			
			
			
		
		

}
	


