package controladores;


import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import acceso_a_datos.Checker;
import acceso_a_datos.InfoMsg;
import acceso_a_datos.MysqlC;
import interfaz.grupos.TextFieldGroup;

public class TextFocusListener implements FocusListener {

	TextFieldGroup tFGroup;
	Checker checker;
	MysqlC mysqlc = new MysqlC();
	private final Color COLOR_DANGER = new Color(222, 69, 69);
	
	public TextFocusListener(TextFieldGroup tFGroup, Checker checker) {
		super();
		this.tFGroup = tFGroup;
		this.checker = checker;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
		if (tFGroup.getTextF().getText().equals(tFGroup.getDefaultText())) {
			tFGroup.getTextF().setText("");
		}
		if(mysqlc.testConnection()) {
			tFGroup.setConnected(true);
		} else {
			tFGroup.setConnected(false);
			tFGroup.showInfo(new InfoMsg("Imposible conectar a la base de datos", "/imagenes/error_black_32px.png", false, COLOR_DANGER));
		}
		
		

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		if (tFGroup.getTextF().getText().equals("")) {
			tFGroup.reset();
		}
		
	}

}
