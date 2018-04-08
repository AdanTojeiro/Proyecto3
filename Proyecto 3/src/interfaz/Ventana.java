package interfaz;

import java.awt.Color;
import javax.swing.*;

import controladores.FrameDrager;
import controladores.NavLabelListener;
import controladores.OptionListener;
import controladores.WindowListener;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

public class Ventana {

	private JFrame frame;
	private JPanel background_panel, side_panel, center_panel, logo_panel, nav_panel, index_nav, titulo_panel,
			login_nick_error_panel, login_password_error_panel, login_password_text_panel, display_panel,
			login_nick_textPanel;
	private JDisplay display_index, display_login, display_reg, display_info, display_soporte;
	private JPanelOpt opt_login, opt_reg, opt_info, opt_soporte;
	private JLabelControl close_lbl, minimize_lbl;
	private JLabel logo_imagen, logo_texto, opt_login_ico, opt_login_text, opt_reg_ico, opt_reg_text, opt_info_ico,
			opt_info_text, opt_soporte_ico, opt_soporte_text, mensaje_index, login_nick_icon_text, titulo_ico,
			login_nick_error_ico, login_nick_error_text, login_password_icon_text, login_password_error_ico,
			login_password_error_text, titulo_text, imagen_central_login;
	private ArrayList<JPanelOpt> opciones_index = new ArrayList<JPanelOpt>();
	private ArrayList<JDisplay> grupo_displays = new ArrayList<JDisplay>();
	private ArrayList<JFormDisplay> grupo_reg = new ArrayList<JFormDisplay>();
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_SELECTED = new Color(85, 65, 118);
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private FrameDrager drager;
	private JTextField login_password_textF, login_nick_textF;
	private JSeparator separador_titulo, login_password_separator, login_nick_separator;
	private JPanel reg_stepbar_panel;
	private JPanel reg_nick_panel;
	private JSeparator reg_nick_panel_separator;
	private JLabel reg_nick_panel_ico;
	private JTextField reg_nick_panel_textF;
	private JPanel reg_nick_panel_info_panel;
	private JLabel reg_nick_panel_info_ico;
	private JLabel reg_nick_panel_info_text;
	private JPanel reg_password_panel;
	private JSeparator reg_password_separator, reg_stepbar_1_to_2_separator, reg_stepbar_2_to_3_separator;
	private JLabel reg_password_ico;
	private JPasswordField reg_password_textF;
	private JPanel reg_password_info_panel;
	private JLabel reg_password_info_ico;
	private JLabel reg_password_info_text;
	private JLabel reg_step_ico;
	private JLabel reg_step_titulo;
	private JSeparator reg_form_1_step_separator;
	private JPanel reg_password_check_panel;
	private JSeparator reg_password_check_separator;
	private JLabel reg_password_check_ico;
	private JPasswordField reg_password_check_textF;
	private JPanel reg_password_check_info_panel;
	private JLabel reg_password_check_info_ico;
	private JLabel reg_password_check_info_text;
	private NavLabel reg_next_navLabel, reg_back_navLabel;
	private JLabel reg_stepbar_1_ico, reg_stepbar_2_ico, reg_stepbar_3_ico, reg_stepbar_1_arrow_ico, reg_stepbar_2_arrow_ico, reg_stepbar_3_arrow_ico;
	private JFormDisplay reg_form_step_1_panel, reg_form_step_2_panel, reg_form_step_3_panel;
	
	

	public static void main(String[] args) {

	}

	public Ventana() {
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
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

		login_nick_textPanel = new JPanel();
		login_nick_textPanel.setBounds(204, 144, 390, 96);
		display_login.add(login_nick_textPanel);
		login_nick_textPanel.setOpaque(false);
		login_nick_textPanel.setLayout(null);

		login_nick_separator = new JSeparator();
		login_nick_separator.setBounds(52, 41, 328, 2);
		login_nick_textPanel.add(login_nick_separator);

		login_nick_icon_text = new JLabel("");
		login_nick_icon_text.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		login_nick_icon_text.setBounds(10, 11, 32, 32);
		login_nick_textPanel.add(login_nick_icon_text);

		login_nick_textF = new JTextField("Usuario");
		login_nick_textF.setHorizontalAlignment(SwingConstants.LEFT);
		login_nick_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_nick_textF.setForeground(Color.WHITE);
		login_nick_textF.setBounds(52, 11, 328, 25);
		login_nick_textPanel.add(login_nick_textF);
		login_nick_textF.setColumns(10);
		login_nick_textF.setBackground(COLOR_SELECTED);
		login_nick_textF.setBorder(null);

		login_nick_error_panel = new JPanel();
		login_nick_error_panel.setBounds(10, 50, 370, 32);
		login_nick_textPanel.add(login_nick_error_panel);
		login_nick_error_panel.setBackground(COLOR_ERROR);
		login_nick_error_panel.setLayout(null);

		login_nick_error_ico = new JLabel("");
		login_nick_error_ico.setBounds(0, 0, 32, 32);
		login_nick_error_panel.add(login_nick_error_ico);
		login_nick_error_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));

		login_nick_error_text = new JLabel("Error");
		login_nick_error_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_nick_error_text.setBounds(42, 0, 328, 32);
		login_nick_error_panel.add(login_nick_error_text);

		login_password_text_panel = new JPanel();
		login_password_text_panel.setLayout(null);
		login_password_text_panel.setOpaque(false);
		login_password_text_panel.setBounds(204, 251, 390, 96);
		display_login.add(login_password_text_panel);

		login_password_separator = new JSeparator();
		login_password_separator.setBounds(52, 41, 328, 2);
		login_password_text_panel.add(login_password_separator);

		login_password_icon_text = new JLabel("");
		login_password_icon_text.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/pass_32px.png")));
		login_password_icon_text.setBounds(10, 11, 32, 32);
		login_password_text_panel.add(login_password_icon_text);

		login_password_textF = new JPasswordField("Contrase\u00F1a");
		login_password_textF.setHorizontalAlignment(SwingConstants.LEFT);
		login_password_textF.setForeground(Color.WHITE);
		login_password_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_password_textF.setColumns(10);
		login_password_textF.setBorder(null);
		login_password_textF.setBackground(new Color(85, 65, 118));
		login_password_textF.setBounds(52, 11, 328, 25);
		login_password_text_panel.add(login_password_textF);

		login_password_error_panel = new JPanel();
		login_password_error_panel.setLayout(null);
		login_password_error_panel.setBackground(new Color(219, 186, 70));
		login_password_error_panel.setBounds(10, 50, 370, 32);
		login_password_text_panel.add(login_password_error_panel);

		login_password_error_ico = new JLabel("");
		login_password_error_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		login_password_error_ico.setBounds(0, 0, 32, 32);
		login_password_error_panel.add(login_password_error_ico);

		login_password_error_text = new JLabel("Error");
		login_password_error_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_password_error_text.setBounds(42, 0, 328, 32);
		login_password_error_panel.add(login_password_error_text);

		// --> Display Reg
		display_reg = new JDisplay("Crear una cuenta", "/imagenes/reg_96px.png", grupo_displays);
		display_reg.setBounds(0, 0, 800, 552);
		display_panel.add(display_reg);
		display_reg.setLayout(null);
		display_reg.setOpaque(false);
		display_reg.setVisible(false);

		reg_stepbar_panel = new JPanel();
		reg_stepbar_panel.setBounds(10, 11, 780, 64);
		display_reg.add(reg_stepbar_panel);
		reg_stepbar_panel.setOpaque(false);
		reg_stepbar_panel.setLayout(null);

		reg_stepbar_1_ico = new JLabel("");
		reg_stepbar_1_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_1_32px.png")));
		reg_stepbar_1_ico.setBounds(10, 24, 32, 32);
		reg_stepbar_panel.add(reg_stepbar_1_ico);

		reg_stepbar_2_ico = new JLabel("");
		reg_stepbar_2_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_2_32px.png")));
		reg_stepbar_2_ico.setBounds(375, 24, 32, 32);
		reg_stepbar_panel.add(reg_stepbar_2_ico);

		reg_stepbar_3_ico = new JLabel("");
		reg_stepbar_3_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_3_32px.png")));
		reg_stepbar_3_ico.setBounds(738, 24, 32, 32);
		reg_stepbar_panel.add(reg_stepbar_3_ico);

		reg_stepbar_1_to_2_separator = new JSeparator();
		reg_stepbar_1_to_2_separator.setBounds(37, 39, 342, 2);
		reg_stepbar_panel.add(reg_stepbar_1_to_2_separator);

		reg_stepbar_2_to_3_separator = new JSeparator();
		reg_stepbar_2_to_3_separator.setBounds(401, 39, 342, 2);
		reg_stepbar_panel.add(reg_stepbar_2_to_3_separator);

		reg_stepbar_1_arrow_ico = new JLabel("");
		reg_stepbar_1_arrow_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/arrow_down_32px.png")));
		reg_stepbar_1_arrow_ico.setBounds(10, 0, 32, 28);
		reg_stepbar_panel.add(reg_stepbar_1_arrow_ico);

		reg_stepbar_2_arrow_ico = new JLabel("");
		reg_stepbar_2_arrow_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/arrow_down_32px.png")));
		reg_stepbar_2_arrow_ico.setBounds(375, 0, 32, 28);
		reg_stepbar_panel.add(reg_stepbar_2_arrow_ico);

		reg_stepbar_3_arrow_ico = new JLabel("");
		reg_stepbar_3_arrow_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/arrow_down_32px.png")));
		reg_stepbar_3_arrow_ico.setBounds(738, 0, 32, 28);
		reg_stepbar_panel.add(reg_stepbar_3_arrow_ico);

		reg_form_step_1_panel = new JFormDisplay("Datos de la cuenta", "/imagenes/user_info_64px.png", grupo_reg, 1, false, true);
		reg_form_step_1_panel.setOpaque(false);
		reg_form_step_1_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_1_panel);
		reg_form_step_1_panel.setLayout(null);
		
		reg_form_step_2_panel = new JFormDisplay("Datos del usuario", "/imagenes/user_info_64px.png", grupo_reg, 2, true, true);
		reg_form_step_2_panel.setOpaque(false);
		reg_form_step_2_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_2_panel);
		reg_form_step_2_panel.setLayout(null);
		reg_form_step_2_panel.setVisible(false);
		
		reg_form_step_3_panel = new JFormDisplay("Confirmar datos", "/imagenes/user_info_64px.png", grupo_reg, 3, true, false);
		reg_form_step_3_panel.setOpaque(false);
		reg_form_step_3_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_3_panel);
		reg_form_step_3_panel.setLayout(null);
		reg_form_step_3_panel.setVisible(false);

		reg_nick_panel = new JPanel();
		reg_nick_panel.setLayout(null);
		reg_nick_panel.setOpaque(false);
		reg_nick_panel.setBounds(31, 11, 390, 96);
		reg_form_step_1_panel.add(reg_nick_panel);

		reg_nick_panel_separator = new JSeparator();
		reg_nick_panel_separator.setBounds(52, 41, 328, 2);
		reg_nick_panel.add(reg_nick_panel_separator);

		reg_nick_panel_ico = new JLabel("");
		reg_nick_panel_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		reg_nick_panel_ico.setBounds(10, 11, 32, 32);
		reg_nick_panel.add(reg_nick_panel_ico);

		reg_nick_panel_textF = new JTextField("Nick");
		reg_nick_panel_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_nick_panel_textF.setForeground(Color.WHITE);
		reg_nick_panel_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_nick_panel_textF.setColumns(10);
		reg_nick_panel_textF.setBorder(null);
		reg_nick_panel_textF.setBackground(new Color(85, 65, 118));
		reg_nick_panel_textF.setBounds(52, 11, 328, 25);
		reg_nick_panel.add(reg_nick_panel_textF);

		reg_nick_panel_info_panel = new JPanel();
		reg_nick_panel_info_panel.setLayout(null);
		reg_nick_panel_info_panel.setBackground(new Color(219, 186, 70));
		reg_nick_panel_info_panel.setBounds(10, 50, 370, 32);
		reg_nick_panel.add(reg_nick_panel_info_panel);

		reg_nick_panel_info_ico = new JLabel("");
		reg_nick_panel_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_nick_panel_info_ico.setBounds(0, 0, 32, 32);
		reg_nick_panel_info_panel.add(reg_nick_panel_info_ico);

		reg_nick_panel_info_text = new JLabel("Error");
		reg_nick_panel_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_nick_panel_info_text.setBounds(42, 0, 328, 32);
		reg_nick_panel_info_panel.add(reg_nick_panel_info_text);

		reg_password_panel = new JPanel();
		reg_password_panel.setLayout(null);
		reg_password_panel.setOpaque(false);
		reg_password_panel.setBounds(31, 118, 390, 96);
		reg_form_step_1_panel.add(reg_password_panel);

		reg_password_separator = new JSeparator();
		reg_password_separator.setBounds(52, 41, 328, 2);
		reg_password_panel.add(reg_password_separator);

		reg_password_ico = new JLabel("");
		reg_password_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/pass_32px.png")));
		reg_password_ico.setBounds(10, 11, 32, 32);
		reg_password_panel.add(reg_password_ico);

		reg_password_textF = new JPasswordField("Contrase\u00F1a");
		reg_password_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_password_textF.setForeground(Color.WHITE);
		reg_password_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_password_textF.setColumns(10);
		reg_password_textF.setBorder(null);
		reg_password_textF.setBackground(new Color(85, 65, 118));
		reg_password_textF.setBounds(52, 11, 328, 25);
		reg_password_panel.add(reg_password_textF);

		reg_password_info_panel = new JPanel();
		reg_password_info_panel.setLayout(null);
		reg_password_info_panel.setBackground(new Color(219, 186, 70));
		reg_password_info_panel.setBounds(10, 50, 370, 32);
		reg_password_panel.add(reg_password_info_panel);

		reg_password_info_ico = new JLabel("");
		reg_password_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_password_info_ico.setBounds(0, 0, 32, 32);
		reg_password_info_panel.add(reg_password_info_ico);

		reg_password_info_text = new JLabel("Error");
		reg_password_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_password_info_text.setBounds(42, 0, 328, 32);
		reg_password_info_panel.add(reg_password_info_text);

		reg_password_check_panel = new JPanel();
		reg_password_check_panel.setLayout(null);
		reg_password_check_panel.setOpaque(false);
		reg_password_check_panel.setBounds(31, 225, 390, 96);
		reg_form_step_1_panel.add(reg_password_check_panel);

		reg_password_check_separator = new JSeparator();
		reg_password_check_separator.setBounds(52, 41, 328, 2);
		reg_password_check_panel.add(reg_password_check_separator);

		reg_password_check_ico = new JLabel("");
		reg_password_check_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/pass_check_32px.png")));
		reg_password_check_ico.setBounds(10, 11, 32, 32);
		reg_password_check_panel.add(reg_password_check_ico);

		reg_password_check_textF = new JPasswordField("Repite tu contrase\u00F1a");
		reg_password_check_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_password_check_textF.setForeground(Color.WHITE);
		reg_password_check_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_password_check_textF.setColumns(10);
		reg_password_check_textF.setBorder(null);
		reg_password_check_textF.setBackground(new Color(85, 65, 118));
		reg_password_check_textF.setBounds(52, 11, 328, 25);
		reg_password_check_panel.add(reg_password_check_textF);

		reg_password_check_info_panel = new JPanel();
		reg_password_check_info_panel.setLayout(null);
		reg_password_check_info_panel.setBackground(new Color(219, 186, 70));
		reg_password_check_info_panel.setBounds(10, 50, 370, 32);
		reg_password_check_panel.add(reg_password_check_info_panel);

		reg_password_check_info_ico = new JLabel("");
		reg_password_check_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_password_check_info_ico.setBounds(0, 0, 32, 32);
		reg_password_check_info_panel.add(reg_password_check_info_ico);

		reg_password_check_info_text = new JLabel("Error");
		reg_password_check_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_password_check_info_text.setBounds(42, 0, 328, 32);
		reg_password_check_info_panel.add(reg_password_check_info_text);

		reg_next_navLabel = new NavLabel("/imagenes/siguiente_96px.png", "/imagenes/siguiente_hover_96px.png", "reg", "next");
		reg_next_navLabel.setIcon(new ImageIcon(Ventana.class.getResource(reg_next_navLabel.getIco_path())));
		reg_next_navLabel.setBounds(694, 279, 96, 96);
		display_reg.add(reg_next_navLabel);
		reg_next_navLabel.addMouseListener(new NavLabelListener(reg_next_navLabel, this));

		reg_back_navLabel = new NavLabel("/imagenes/atras_96px.png", "/imagenes/atras_hover_96px.png", "reg", "back");
		reg_back_navLabel.setIcon(new ImageIcon(Ventana.class.getResource(reg_back_navLabel.getIco_path())));
		reg_back_navLabel.setBounds(10, 279, 96, 96);
		display_reg.add(reg_back_navLabel);
		reg_back_navLabel.addMouseListener(new NavLabelListener(reg_back_navLabel, this));

		reg_form_1_step_separator = new JSeparator();
		reg_form_1_step_separator.setBounds(183, 150, 429, 2);
		display_reg.add(reg_form_1_step_separator);

		reg_step_titulo = new JLabel("Datos de la cuenta");
		reg_step_titulo.setBounds(262, 86, 338, 64);
		display_reg.add(reg_step_titulo);
		reg_step_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		reg_step_titulo.setFont(new Font("Tahoma", Font.BOLD, 32));
		reg_step_titulo.setForeground(Color.WHITE);

		reg_step_ico = new JLabel("");
		reg_step_ico.setBounds(205, 86, 63, 62);
		display_reg.add(reg_step_ico);
		reg_step_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_info_64px.png")));
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
	
	public void setRegDisplay(int index, String function) {
		switch(function) {
		case "next":
			index++;
			break;
		case "back":
			index--;
			break;
		}
		JFormDisplay f;
		JFormDisplay selected = null;
		Iterator<JFormDisplay> it = grupo_reg.iterator();
		while(it.hasNext()) {
			f = it.next();
			f.setVisible(false);
			if(f.getIndex() == index) {
				selected = f;
			}
		}
		
		selected.setVisible(true);
		reg_step_ico.setIcon(new ImageIcon(Ventana.class.getResource(selected.getIcoPath())));
		reg_step_titulo.setText(selected.getTitulo());
		reg_next_navLabel.setVisible(selected.isNextChecker());
		reg_back_navLabel.setVisible(selected.isBackChecker());
		reg_next_navLabel.setActualIndex(index);
		reg_back_navLabel.setActualIndex(index);
		
		
		switch(index) {
		case 1:
			reg_stepbar_1_arrow_ico.setVisible(true);
			reg_stepbar_2_arrow_ico.setVisible(false);
			reg_stepbar_3_arrow_ico.setVisible(false);
			reg_stepbar_1_to_2_separator.setBackground(Color.WHITE);
			reg_stepbar_2_to_3_separator.setBackground(Color.WHITE);
			reg_stepbar_1_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_1_32px.png")));
			reg_stepbar_2_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_2_32px.png")));
			reg_stepbar_3_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_3_32px.png")));
			break;
		case 2:
			reg_stepbar_1_arrow_ico.setVisible(false);
			reg_stepbar_2_arrow_ico.setVisible(true);
			reg_stepbar_3_arrow_ico.setVisible(false);
			reg_stepbar_1_to_2_separator.setBackground(COLOR_CHECK);
			reg_stepbar_2_to_3_separator.setBackground(Color.WHITE);
			reg_stepbar_1_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_1_green_32px.png")));
			reg_stepbar_2_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_2_32px.png")));
			reg_stepbar_3_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_3_32px.png")));
			break;
		case 3:
			reg_stepbar_1_arrow_ico.setVisible(false);
			reg_stepbar_2_arrow_ico.setVisible(false);
			reg_stepbar_3_arrow_ico.setVisible(true);
			reg_stepbar_1_to_2_separator.setBackground(COLOR_CHECK);
			reg_stepbar_2_to_3_separator.setBackground(COLOR_CHECK);
			reg_stepbar_1_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_1_green_32px.png")));
			reg_stepbar_2_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_2_green_32px.png")));
			reg_stepbar_3_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/circ_3_green_32px.png")));
			break;
			
			
		}
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);

	}
}
