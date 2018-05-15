package controladores;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import acceso_a_datos.Checker;
import acceso_a_datos.InfoMsg;
import interfaz.Ventana;
import interfaz.grupos.TextFieldGroup;
import interfaz.grupos.TextFieldGroupRel;

public class TextFieldKeyListener implements KeyListener {
	
	TextFieldGroup tFGroup;
	Checker checker;
	Ventana ventana;
	private final Color COLOR_DANGER = new Color(222, 69, 69);
	

	public TextFieldKeyListener(TextFieldGroup tFGroup, Checker checker) {
		super();
		this.tFGroup = tFGroup;
		this.checker = checker;
	}
	
	public TextFieldKeyListener(TextFieldGroup tFGroup, Checker checker, Ventana ventana) {
		super();
		this.tFGroup = tFGroup;
		this.checker = checker;
		this.ventana = ventana;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e){
		InfoMsg info;
		if(tFGroup.isConnected()) {
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
		case "buscar":
			 ventana.actualizarListaUsuarios(checker.buscar(tFGroup.getTextF().getText()));
			break;
		case "consulta":
			 ventana.actualizarListaConsultas(checker.consultas(tFGroup.getTextF().getText()));
			break;	
		case "soporte":
			info = checker.checkFreeString(tFGroup.getTextF().getText(), 60);
			tFGroup.showInfo(info);
			break;
		case "enunciado":
			info = checker.checkFreeString(tFGroup.getTextF().getText(), 120);
			tFGroup.showInfo(info);
			break;
		case "respuesta":
			info = checker.checkFreeString(tFGroup.getTextF().getText(), 60);
			tFGroup.showInfo(info);
			break;	
		}
		} else {
			info = new InfoMsg("Imposible conectar a la base de datos", "/imagenes/error_black_32px.png", false, COLOR_DANGER);
			tFGroup.showInfo(info);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
			
			
		}
		
	}
	


		
		



