package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acceso_a_datos.Checker;
import acceso_a_datos.InfoMsg;
import interfaz.grupos.TextFieldGroup;
import interfaz.grupos.TextFieldGroupRel;

public class TextFieldKeyListener implements KeyListener {
	
	TextFieldGroup tFGroup;
	Checker checker;
	
	

	public TextFieldKeyListener(TextFieldGroup tFGroup, Checker checker) {
		super();
		this.tFGroup = tFGroup;
		this.checker = checker;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
			info = checker.checkDNI(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "email":
			info = checker.checkEmail(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "flex_key":
			info = checker.checkStringFlexKey(tFGroup.getTextF().getText());
			tFGroup.showInfo(info);
			break;
		case "rel":
			if (tFGroup instanceof TextFieldGroupRel) {
				TextFieldGroupRel tFGroupRel = (TextFieldGroupRel)tFGroup; 
				TextFieldGroup rel = tFGroupRel.getRel();
				switch(tFGroupRel.getRelType()) {
				case "similitud":
					info = checker.checkSimilitud(tFGroupRel.getTextF().getText(), rel.getTextF().getText(),rel.isCheck());
					tFGroupRel.showInfo(info);
					break;
				case "correspondencia":
					info = checker.checkCorrespondencia(tFGroupRel.getTextF().getText(), rel.getTextF().getText(),rel.isCheck());
					tFGroupRel.showInfo(info);
					break;			
				}
			}
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
			
			
		}
		
	}
	


		
		



