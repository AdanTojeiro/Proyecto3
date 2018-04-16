package interfaz;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import acceso_a_datos.InfoMsg;

public class TextFieldGroup {
	
	private JPanel content_panel;
	private JPanel info_panel;
	private JLabel textF_icon, info_ico, info_text;
	private JTextField textF;
	private JSeparator separator;
	private String tipo, defaultText;
	private boolean check;
	private ArrayList<TextFieldGroup> grupo_logico;
	
	

	public TextFieldGroup(JPanel content_panel, JPanel info_panel, JLabel textF_icon, JLabel info_ico, JLabel info_text,
			JTextField textF, JSeparator separator, String tipo, ArrayList<TextFieldGroup> grupo_logico) {
		super();
		this.content_panel = content_panel;
		this.info_panel = info_panel;
		this.textF_icon = textF_icon;
		this.info_ico = info_ico;
		this.info_text = info_text;
		this.textF = textF;
		this.separator = separator;
		this.tipo = tipo;
		check = false;
		defaultText = textF.getText();
		grupo_logico.add(this);
	}
	
	public void  hideInfo() {
		info_panel.setVisible(false);
	}
	
	public void  showInfo(InfoMsg info) {
		info_panel.setVisible(true);
		info_panel.setBackground(info.getColor());
		info_text.setText(info.getText());
		info_ico.setIcon(new ImageIcon(this.getClass().getResource(info.getIco_path())));
		check = info.isCheck();
	}

	public JPanel getContent_panel() {
		return content_panel;
	}

	public void setContent_panel(JPanel content_panel) {
		this.content_panel = content_panel;
	}

	public JPanel getInfo_panel() {
		return info_panel;
	}

	public void setInfo_panel(JPanel info_panel) {
		this.info_panel = info_panel;
	}

	public JLabel getTextF_icon() {
		return textF_icon;
	}

	public void setTextF_icon(JLabel textF_icon) {
		this.textF_icon = textF_icon;
	}

	public JLabel getInfo_ico() {
		return info_ico;
	}

	public void setInfo_ico(JLabel info_ico) {
		this.info_ico = info_ico;
	}

	public JLabel getInfo_text() {
		return info_text;
	}

	public void setInfo_text(JLabel info_text) {
		this.info_text = info_text;
	}

	public JTextField getTextF() {
		return textF;
	}

	public void setTextF(JTextField textF) {
		this.textF = textF;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public ArrayList<TextFieldGroup> getGrupo_logico() {
		return grupo_logico;
	}

	public void setGrupo_logico(ArrayList<TextFieldGroup> grupo_logico) {
		this.grupo_logico = grupo_logico;
	}
	
	public void reset() {
		textF.setText(defaultText);
		info_panel.setVisible(false);
		check = false;
	}
	
	
	
	
	
	

}
