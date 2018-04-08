package interfaz;



import javax.swing.JLabel;

public class NavLabel extends JLabel {
	
	private String ico_path;
	private String ico_hover_path;
	private String function;
	private String grupo;
	private int actualIndex = 1;
	
	public NavLabel(String ico_path, String ico_hover_path, String grupo, String function) {
		super();
		this.ico_path = ico_path;
		this.ico_hover_path = ico_hover_path;
		this.grupo = grupo;
		this.function = function;
	}

	public String getIco_path() {
		return ico_path;
	}

	public void setIco_path(String ico_path) {
		this.ico_path = ico_path;
	}

	public String getIco_hover_path() {
		return ico_hover_path;
	}

	public void setIco_hover_path(String ico_jover_path) {
		this.ico_hover_path = ico_jover_path;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getActualIndex() {
		return actualIndex;
	}

	public void setActualIndex(int actualIndex) {
		this.actualIndex = actualIndex;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	

	

}
