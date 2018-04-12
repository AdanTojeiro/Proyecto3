package acceso_a_datos;

import java.awt.Color;

public class InfoMsg {

		private String text;
		private String ico_path;
		private boolean check;
		private Color color;
		
		public InfoMsg(String text, String ico_path, boolean check, Color color) {
			super();
			this.text = text;
			this.ico_path = ico_path;
			this.check = check;
			this.color = color;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getIco_path() {
			return ico_path;
		}

		public void setIco_path(String ico_path) {
			this.ico_path = ico_path;
		}

		public boolean isCheck() {
			return check;
		}

		public void setCheck(boolean check) {
			this.check = check;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
		
		
		
		
}
