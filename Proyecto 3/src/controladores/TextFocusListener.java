package controladores;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import acceso_a_datos.Checker;
import acceso_a_datos.InfoMsg;
import interfaz.TextFieldGroup;
import interfaz.TextFieldGroupRel;

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
		
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		InfoMsg info;
		switch(tFGroup.getTipo()) {
		case "strict":
			info = checker.checkStringStrict(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "pass":
			info = checker.checkPassword(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "flex":
			info = checker.checkStringFlex(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "strict2":
			info = checker.checkStringStrict(tFGroup.getTextF().getText(), 2);
			tFGroup.showInfo(info);
			break;
		case "dni":
			info = checker.checkStringStrict(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "email":
			info = checker.checkEmail(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "rel":
			if (tFGroup instanceof TextFieldGroupRel) {
				TextFieldGroupRel tFGroupRel = (TextFieldGroupRel)tFGroup; 
				TextFieldGroup rel = tFGroupRel.getRel();
				switch(tFGroupRel.getRelType()) {
				case "similitud":
					info = checker.checkSimilitud(tFGroupRel.getTextF().getText(), rel.getTextF().getText(), rel.isCheck());
					tFGroupRel.showInfo(info);
					break;
				case "correspondencia":
					info = checker.checkCorrespondencia(tFGroupRel.getTextF().getText(), rel.getTextF().getText());
					tFGroupRel.showInfo(info);
					break;
				}
			}
			
			
		}
		
	}
	

}
