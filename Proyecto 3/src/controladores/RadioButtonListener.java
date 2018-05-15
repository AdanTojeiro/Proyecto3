package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class RadioButtonListener implements ActionListener {
	
	JRadioButton rbp, rb1, rb2;
	
	
	public RadioButtonListener(JRadioButton rbp, JRadioButton rb1, JRadioButton rb2) {
		super();
		this.rbp = rbp;
		this.rb1 = rb1;
		this.rb2 = rb2;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(rbp.isSelected()) {
			rb1.setSelected(false);
			rb2.setSelected(false);
		} else {
			rb1.setSelected(true);
		}

	}

}
