package interfaz.grupos;

public class SesionSteup {
	
	private OptionGroup opciones;
	private DisplayGroup displays;
	
	
	public SesionSteup(OptionGroup opciones, DisplayGroup displays) {
		super();
		this.opciones = opciones;
		this.displays = displays;
	}

	public void abrirVistaDeSesion() {
		opciones.getNav_panel().setVisible(true);
	}
	
	public void cerrarVistaDeSesion() {
		opciones.getNav_panel().setVisible(false);
		
	}

}
