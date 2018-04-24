package interfaz.grupos;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TextFieldGroupRel extends TextFieldGroup {
	
	TextFieldGroup rel;
	String relType;
	
	public TextFieldGroupRel(JPanel content_panel, JPanel info_panel, JLabel textF_icon, JLabel info_ico,
			JLabel info_text, JTextField textF, JSeparator separator, ArrayList<TextFieldGroup> grupo_logico, TextFieldGroup rel, String relType) {
		super(content_panel, info_panel, textF_icon, info_ico, info_text, textF, separator, "rel", grupo_logico);
		// TODO Auto-generated constructor stub
		this.rel = rel;
		this.relType = relType;
	}

	public TextFieldGroup getRel() {
		return rel;
	}

	public void setRel(TextFieldGroup rel) {
		this.rel = rel;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	

}
