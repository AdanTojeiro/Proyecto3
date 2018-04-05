package interfaz;

import java.awt.Color;
import javax.swing.*;

import controladores.FrameDrager;
import controladores.OptionListener;
import controladores.WindowListener;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

public class Ventana {

	private JFrame frame;
	private JPanel background_panel, side_panel, center_panel, logo_panel, nav_panel, index_nav, titulo_panel,
			user_error_panel, password_error_panel, password_text_panel, display_panel, user_textPanel;
	private JDisplay display_index, display_login, display_reg, display_info, display_soporte;
	private JPanelOpt opt_login, opt_reg, opt_info, opt_soporte;
	private JLabelControl close_lbl, minimize_lbl;
	private JLabel logo_imagen, logo_texto, opt_login_ico, opt_login_text, opt_reg_ico, opt_reg_text, opt_info_ico,
			opt_info_text, opt_soporte_ico, opt_soporte_text, mensaje_index, user_icon_text, titulo_ico,
			user_error_ico, user_error_text, password_icon_text, password_error_ico, password_error_text,  titulo_text, imagen_central_login;
	private ArrayList<JPanelOpt> opciones_index = new ArrayList<JPanelOpt>();
	private ArrayList<JDisplay> grupo_displays = new ArrayList<JDisplay>();
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_SELECTED = new Color(85, 65, 118);
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private FrameDrager drager;
	private JTextField password_textF, user_textF;
	private JSeparator separador_titulo, password_separator, user_separator;

	public static void main(String[] args) {
		
	}

	public Ventana() {
		initialize();
	}

	private void initialize() {

		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		drager = new FrameDrager(frame);
		frame.addMouseListener(drager);
		frame.addMouseMotionListener(drager);

		// Background Panel
		background_panel = new JPanel();
		background_panel.setBounds(0, 0, 1100, 700);
		frame.getContentPane().add(background_panel);
		background_panel.setLayout(null);

		// Estructura panels
		side_panel = new JPanel();
		side_panel.setBounds(0, 0, 300, 700);
		background_panel.add(side_panel);
		side_panel.setLayout(null);
		side_panel.setBackground(COLOR_BACKGROUND);

		center_panel = new JPanel();
		center_panel.setBounds(300, 0, 800, 700);
		background_panel.add(center_panel);
		center_panel.setBackground(COLOR_SELECTED);
		center_panel.setLayout(null);

		// Titulo panel
		titulo_panel = new JPanel();
		titulo_panel.setBounds(0, 0, 800, 148);
		center_panel.add(titulo_panel);
		titulo_panel.setLayout(null);
		titulo_panel.setOpaque(false);

		titulo_ico = new JLabel("");
		titulo_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/index_96px.png")));
		titulo_ico.setBounds(25, 23, 101, 102);
		titulo_panel.add(titulo_ico);

		titulo_text = new JLabel("Bienvenid@");
		titulo_text.setForeground(Color.WHITE);
		titulo_text.setFont(new Font("Tahoma", Font.PLAIN, 60));
		titulo_text.setBounds(136, 23, 529, 102);
		titulo_panel.add(titulo_text);

		separador_titulo = new JSeparator();
		separador_titulo.setBounds(10, 136, 780, 12);
		titulo_panel.add(separador_titulo);

		// Control labels
		close_lbl = new JLabelControl(0, "/imagenes/salir_32px.png", "/imagenes/salir_hover_32px.png");
		close_lbl.setIcon(new ImageIcon(Ventana.class.getResource(close_lbl.getPathIco())));
		close_lbl.setBounds(762, 0, 32, 40);
		titulo_panel.add(close_lbl);
		close_lbl.addMouseListener(new WindowListener(close_lbl, frame));

		minimize_lbl = new JLabelControl(1, "/imagenes/minimizar_32px.png", "/imagenes/minimizar_hover_32px.png");
		minimize_lbl.setIcon(new ImageIcon(Ventana.class.getResource(minimize_lbl.getPathIco())));
		minimize_lbl.setBounds(730, 0, 32, 40);
		titulo_panel.add(minimize_lbl);
		minimize_lbl.addMouseListener(new WindowListener(minimize_lbl, frame));

		// Display panel
		display_panel = new JPanel();
		display_panel.setBounds(0, 148, 800, 552);
		center_panel.add(display_panel);
		display_panel.setLayout(null);
		display_panel.setOpaque(false);

		// Contenido displays

		// --> Display index
		display_index = new JDisplay("Bienvenid@", "/imagenes/index_96px.png", grupo_displays);
		display_index.setBounds(0, 0, 800, 552);
		display_panel.add(display_index);
		display_index.setLayout(null);
		display_index.setOpaque(false);

		mensaje_index = new JLabel("<html><p>Gracias por instalar Hacentest<br><br>"
				+ "Para comenzar a utilizar la aplicación debes registrarte<br><br>"
				+ "Si ya dispones de una cuenta puedes iniciar sesión directamente<br><br>"
				+ "Para conocer más acerca de la aplicación visita la sección de información<br><br>"
				+ "Si necesitas asistencia consulta la sección de soporte<p><html>");
		mensaje_index.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje_index.setForeground(Color.WHITE);
		mensaje_index.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mensaje_index.setBounds(26, 46, 753, 276);
		display_index.add(mensaje_index);

		// --> Display Login
		display_login = new JDisplay("Iniciar sesion", "/imagenes/login_96px.png", grupo_displays);
		display_login.setBounds(0, 0, 800, 552);
		display_panel.add(display_login);
		display_login.setLayout(null);
		display_login.setOpaque(false);
		display_login.setVisible(false);

		imagen_central_login = new JLabel("");
		imagen_central_login.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_96px.png")));
		imagen_central_login.setBounds(352, 27, 96, 96);
		display_login.add(imagen_central_login);

		user_textPanel = new JPanel();
		user_textPanel.setBounds(204, 144, 390, 96);
		display_login.add(user_textPanel);
		user_textPanel.setOpaque(false);
		user_textPanel.setLayout(null);

		user_separator = new JSeparator();
		user_separator.setBounds(52, 41, 328, 2);
		user_textPanel.add(user_separator);

		user_icon_text = new JLabel("");
		user_icon_text.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		user_icon_text.setBounds(10, 11, 32, 32);
		user_textPanel.add(user_icon_text);

		user_textF = new JTextField("Usuario");
		user_textF.setHorizontalAlignment(SwingConstants.LEFT);
		user_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		user_textF.setForeground(Color.WHITE);
		user_textF.setBounds(52, 11, 328, 25);
		user_textPanel.add(user_textF);
		user_textF.setColumns(10);
		user_textF.setBackground(COLOR_SELECTED);
		user_textF.setBorder(null);

		user_error_panel = new JPanel();
		user_error_panel.setBounds(10, 50, 370, 32);
		user_textPanel.add(user_error_panel);
		user_error_panel.setBackground(COLOR_ERROR);
		user_error_panel.setLayout(null);

		user_error_ico = new JLabel("");
		user_error_ico.setBounds(0, 0, 32, 32);
		user_error_panel.add(user_error_ico);
		user_error_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));

		user_error_text = new JLabel("Error");
		user_error_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		user_error_text.setBounds(42, 0, 328, 32);
		user_error_panel.add(user_error_text);

		password_text_panel = new JPanel();
		password_text_panel.setLayout(null);
		password_text_panel.setOpaque(false);
		password_text_panel.setBounds(204, 251, 390, 96);
		display_login.add(password_text_panel);

		password_separator = new JSeparator();
		password_separator.setBounds(52, 41, 328, 2);
		password_text_panel.add(password_separator);

		password_icon_text = new JLabel("");
		password_icon_text.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/pass_32px.png")));
		password_icon_text.setBounds(10, 11, 32, 32);
		password_text_panel.add(password_icon_text);

		password_textF = new JPasswordField("Contrase\u00F1a");
		password_textF.setHorizontalAlignment(SwingConstants.LEFT);
		password_textF.setForeground(Color.WHITE);
		password_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		password_textF.setColumns(10);
		password_textF.setBorder(null);
		password_textF.setBackground(new Color(85, 65, 118));
		password_textF.setBounds(52, 11, 328, 25);
		password_text_panel.add(password_textF);

		password_error_panel = new JPanel();
		password_error_panel.setLayout(null);
		password_error_panel.setBackground(new Color(219, 186, 70));
		password_error_panel.setBounds(10, 50, 370, 32);
		password_text_panel.add(password_error_panel);

		password_error_ico = new JLabel("");
		password_error_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		password_error_ico.setBounds(0, 0, 32, 32);
		password_error_panel.add(password_error_ico);

		password_error_text = new JLabel("Error");
		password_error_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		password_error_text.setBounds(42, 0, 328, 32);
		password_error_panel.add(password_error_text);

		// --> Display Reg
		display_reg = new JDisplay("Crear una cuenta", "/imagenes/reg_96px.png", grupo_displays);
		display_reg.setBounds(0, 0, 800, 552);
		display_panel.add(display_reg);
		display_reg.setLayout(null);
		display_reg.setOpaque(false);
		display_reg.setVisible(false);
		// --> Display Info
		display_info = new JDisplay("Información", "/imagenes/info_96px.png", grupo_displays);
		display_info.setBounds(0, 0, 800, 552);
		display_panel.add(display_info);
		display_info.setLayout(null);
		display_info.setOpaque(false);
		display_info.setVisible(false);
		// --> Display Soporte
		display_soporte = new JDisplay("Soporte", "/imagenes/soporte_96px.png", grupo_displays);
		display_soporte.setBounds(0, 0, 800, 552);
		display_panel.add(display_soporte);
		display_soporte.setLayout(null);
		display_soporte.setOpaque(false);
		display_soporte.setVisible(false);

		// Logo panel
		logo_panel = new JPanel();
		logo_panel.setBounds(0, 0, 300, 137);
		side_panel.add(logo_panel);
		logo_panel.setOpaque(false);
		logo_panel.setLayout(null);

		logo_imagen = new JLabel("");
		logo_imagen.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/logo_96px.png")));
		logo_imagen.setBounds(92, 11, 96, 84);
		logo_panel.add(logo_imagen);

		logo_texto = new JLabel("HACENTEST");
		logo_texto.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
		logo_texto.setForeground(Color.WHITE);
		logo_texto.setBounds(35, 84, 223, 53);
		logo_panel.add(logo_texto);

		// Nav panel
		nav_panel = new JPanel();
		nav_panel.setBounds(0, 136, 300, 464);
		side_panel.add(nav_panel);
		nav_panel.setLayout(null);
		nav_panel.setOpaque(false);

		// Nav displays

		index_nav = new JPanel();
		index_nav.setBounds(0, 0, 300, 464);
		nav_panel.add(index_nav);
		index_nav.setOpaque(false);
		index_nav.setLayout(null);

		// Nav options

		// option login
		opt_login = new JPanelOpt(this, display_login, "Iniciar sesi\u00F3n", "/imagenes/login_32px.png",
				opciones_index);
		opt_login.setBounds(0, 11, 300, 48);
		index_nav.add(opt_login);
		opt_login.setBackground(COLOR_BACKGROUND);
		opt_login.setLayout(null);
		opt_login.addMouseListener(new OptionListener(opt_login));

		opt_login_ico = new JLabel("");
		opt_login_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_login.getIco_path())));
		opt_login_ico.setBounds(10, 0, 48, 48);
		opt_login.add(opt_login_ico);

		opt_login_text = new JLabel(opt_login.getText());
		opt_login_text.setForeground(Color.WHITE);
		opt_login_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_login_text.setBounds(68, 11, 222, 26);
		opt_login.add(opt_login_text);

		// option registro
		opt_reg = new JPanelOpt(this, display_reg, "Crear una cuenta", "/imagenes/reg_32px.png", opciones_index);
		opt_reg.setLayout(null);
		opt_reg.setBackground(new Color(54, 33, 89));
		opt_reg.setBounds(0, 59, 300, 48);
		index_nav.add(opt_reg);
		opt_reg.addMouseListener(new OptionListener(opt_reg));

		opt_reg_ico = new JLabel("");
		opt_reg_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_reg.getIco_path())));
		opt_reg_ico.setBounds(10, 0, 48, 48);
		opt_reg.add(opt_reg_ico);

		opt_reg_text = new JLabel("Crear una cuenta");
		opt_reg_text.setForeground(Color.WHITE);
		opt_reg_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_reg_text.setBounds(68, 11, 222, 26);
		opt_reg.add(opt_reg_text);

		// option info
		opt_info = new JPanelOpt(this, display_info, "Informaci\\u00F3n", "/imagenes/info_32px.png", opciones_index);
		opt_info.setLayout(null);
		opt_info.setBackground(new Color(54, 33, 89));
		opt_info.setBounds(0, 107, 300, 48);
		index_nav.add(opt_info);
		opt_info.addMouseListener(new OptionListener(opt_info));

		opt_info_ico = new JLabel("");
		opt_info_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_info.getIco_path())));
		opt_info_ico.setBounds(10, 0, 48, 48);
		opt_info.add(opt_info_ico);

		opt_info_text = new JLabel("Informaci\u00F3n");
		opt_info_text.setForeground(Color.WHITE);
		opt_info_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_info_text.setBounds(68, 11, 222, 26);
		opt_info.add(opt_info_text);

		// option soporte
		opt_soporte = new JPanelOpt(this, display_soporte, "Soporte", "/imagenes/soporte_32px.png", opciones_index);
		opt_soporte.setLayout(null);
		opt_soporte.setBackground(new Color(54, 33, 89));
		opt_soporte.setBounds(0, 155, 300, 48);
		index_nav.add(opt_soporte);
		opt_soporte.addMouseListener(new OptionListener(opt_soporte));

		opt_soporte_ico = new JLabel("");
		opt_soporte_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_soporte.getIco_path())));
		opt_soporte_ico.setBounds(10, 0, 48, 48);
		opt_soporte.add(opt_soporte_ico);

		opt_soporte_text = new JLabel("Soporte");
		opt_soporte_text.setForeground(Color.WHITE);
		opt_soporte_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_soporte_text.setBounds(68, 11, 222, 26);
		opt_soporte.add(opt_soporte_text);

		// Work zone -> Codigo efimero

	}

	public void setDisplay(JDisplay display, ArrayList<JDisplay> grupo) {
		Iterator<JDisplay> it = grupo.iterator();
		while (it.hasNext()) {
			JDisplay d = it.next();
			if (!d.equals(display)) {
				d.setVisible(false);
			}
		}
		display.setVisible(true);
		titulo_ico.setIcon(new ImageIcon(Ventana.class.getResource(display.getIcoPath())));
		titulo_text.setText(display.getTitulo());

	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}
}
