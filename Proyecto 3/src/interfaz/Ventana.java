package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.*;

import acceso_a_datos.Checker;
import acceso_a_datos.GestorSesiones;
import acceso_a_datos.GestorUsuarios;
import acceso_a_datos.MysqlC;
import clases.Sesion;
import clases.Usuario;
import controladores.FormBtnListener;
import controladores.FrameDrager;
import controladores.NavRegListener;
import controladores.OptionListener;
import controladores.SesionBtnListener;
import controladores.TextFieldKeyListener;
import controladores.TextFocusListener;
import interfaz.componentes.JDisplay;
import interfaz.componentes.JFormBtn;
import interfaz.componentes.JFormDisplay;
import interfaz.componentes.JControlLabel;
import interfaz.componentes.JOption;
import interfaz.componentes.JPopUp;
import interfaz.componentes.JNavLabel;
import interfaz.grupos.DisplayGroup;
import interfaz.grupos.OptionGroup;
import interfaz.grupos.SesionSteup;
import interfaz.grupos.TextFieldGroup;
import interfaz.grupos.TextFieldGroupRel;
import interfaz.listas.JRowList;
import controladores.ControlLabelListener;
import controladores.EntrarComoListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Toolkit;

public class Ventana {

	// ACCESO A DATOS INICIO
	private MysqlC mysqlc;
	private GestorUsuarios gestorUsuarios;
	private GestorSesiones gestorSesiones;
	private Checker checker;

	// DATOS DE SESION
	private Sesion sesionActual;

	// DATA
	private Usuario RegData = new Usuario();

	// GRUPOS
	private ArrayList<JOption> listaOpciones_invitado = new ArrayList<JOption>();
	private ArrayList<JOption> listaOpciones_alumno = new ArrayList<JOption>();
	private ArrayList<JOption> listaOpciones_profesor = new ArrayList<JOption>();
	private ArrayList<JOption> listaOpciones_administrador = new ArrayList<JOption>();
	private ArrayList<JOption> listaOpciones_desarrollador = new ArrayList<JOption>();

	private ArrayList<JDisplay> listaDisplays_invitado = new ArrayList<JDisplay>();
	private ArrayList<JDisplay> listaDisplays_alumno = new ArrayList<JDisplay>();
	private ArrayList<JDisplay> listaDisplays_profesor = new ArrayList<JDisplay>();
	private ArrayList<JDisplay> listaDisplays_administrador = new ArrayList<JDisplay>();
	private ArrayList<JDisplay> listaDisplays_desarrollador = new ArrayList<JDisplay>();

	private ArrayList<JFormDisplay> grupo_reg = new ArrayList<JFormDisplay>();

	// COLORES
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_SELECTED = new Color(85, 65, 118);
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_CHECK = new Color(50, 205, 50);

	// SESIONS_STEUP
	private SesionSteup invitado, alumno, profesor, administrador, desarrollador;
	private OptionGroup opciones_invitado, opciones_alumno, opciones_profesor, opciones_administrador,
			opciones_desarrollador;
	private DisplayGroup displays;

	// COMPONENTES INICIO

	// Estructura
	private JFrame frmHacentest;
	private JPanel background_panel, side_panel, center_panel;
	private JPopUp popUp_panel;
	private JButton focusFixer;

	// 1-Side panel
	private JPanel logo_panel, nav_panel;

	// 1.1-Logo panel
	private JLabel logo_imagen, logo_texto;

	// 1.2-Nav Panel
	private JPanel navPanel_invitado, navPanel_alumno, navPanel_profesor, navPanel_administrador,
			navPanel_desarrollador;

	// 1.2.1-Index nav
	// Invitado
	private JOption opt_login, opt_reg, opt_info, opt_soporte;
	private JLabel opt_login_ico, opt_login_text, opt_reg_ico, opt_reg_text, opt_info_ico, opt_info_text,
			opt_soporte_ico, opt_soporte_text;
	// Alumno
	private JOption opt_iniciarTest, opt_estadisticas_alumno, opt_cerrarSesion_alumno, opt_soporte_alumno;
	private JLabel opt_iniciarTest_ico, opt_iniciarTest_text, opt_estadisticas_alumno_ico, opt_estadisticas_alumno_text,
			opt_soporte_alumno_ico, opt_soporte_alumno_text, opt_cerrarSesion_alumno_ico, opt_cerrarSesion_alumno_text;
	// Profesor
	private JOption opt_estadisticas_profesor, opt_entrarComo_profesor, opt_cerrarSesion_profesor, opt_soporte_profesor;
	private JLabel opt_estadisticas_profesor_ico, opt_entrarComo_profesor_ico, opt_entrarComo_profesor_text,
			opt_soporte_profesor_ico, opt_soporte_profesor_text, opt_cerrarSesion_profesor_ico,
			opt_cerrarSesion_profesor_text;
	// Admin
	private JOption opt_verUsuarios, opt_soporte_administrador, opt_entrarComo_administrador,
			opt_cerrarSesion_administrador;
	private JLabel opt_verUsuarios_ico, opt_verUsuarios_text, opt_soporte_administrador_ico,
			opt_soporte_administrador_text, opt_entrarComo_administrador_ico, opt_entrarComo_administrador_text,
			opt_cerrarSesion_administrador_ico, opt_cerrarSesion_administrador_text;
	// Desarrollador
	private JOption opt_verUsuarios_desarrollador, opt_entrarComo_desarrollador, opt_anadirPregunta,
			opt_cerrarSesion_desarrollador;
	private JLabel opt_verUsuarios_desarrollador_ico, opt_verUsuarios_desarrollador_text,
			opt_entrarComo_desarrollador_ico, opt_entrarComo_desarrollador_text, opt_anadirPregunta_ico,
			opt_anadirPregunta_text, opt_cerrarSesion_desarrollador_ico, opt_cerrarSesion_desarrollador_text;

	// 2-Center panel
	private JPanel titulo_panel, display_panel;

	// 2.1-Titulo panel
	private JControlLabel close_lbl, minimize_lbl;
	private JLabel titulo_ico, titulo_text;
	private JSeparator separador_titulo;

	// 2.2-Displays
	private JDisplay display_index, display_login, display_reg, display_info, display_soporte, display_verUsuarios,
			display_mostrarUsuario;

	// 2.2.1-Index display
	private JLabel mensaje_index;

	// 2.2.2-Login display
	private JPanel login_password_panel;
	private JLabel imagen_central_login;
	private JFormBtn login_iniciar_FormBtn;
	private JLabel login_iniciar_formBtn_text;

	// 2.2.2.1-Login_nick_panel
	private JPanel login_nick_info_panel;
	private JLabel login_nick_info_ico, login_nick_info_text;

	// 2.2.2.2-Login_pass_panel
	private JPanel login_password_info_panel;
	private JLabel login_password_icon, login_password_info_ico, login_password_info_text;
	private JPasswordField login_password_textF;
	private JSeparator login_password_separator;

	// 2.2.3-ReG display
	private JPanel reg_stepbar_panel;
	private JFormDisplay reg_form_step_1_panel, reg_form_step_2_panel, reg_form_step_3_panel;
	private JNavLabel reg_next_navLabel, reg_back_navLabel;
	private JLabel reg_form_ico, reg_form_titulo;
	private JSeparator reg_form_separator;

	// 2.2.3.1-Stepbar
	private JSeparator reg_stepbar_1_to_2_separator, reg_stepbar_2_to_3_separator;
	private JLabel reg_stepbar_1_ico, reg_stepbar_2_ico, reg_stepbar_3_ico, reg_stepbar_1_arrow_ico,
			reg_stepbar_2_arrow_ico, reg_stepbar_3_arrow_ico;

	// 2.2.3.2-Form 1
	private JPanel reg_nick_panel, reg_password_panel, reg_password_check_panel;

	// 2.2.3.2.1-Nick panel
	private JSeparator reg_nick_separator;
	private JLabel reg_nick_ico, reg_nick_info_ico, reg_nick_info_text;
	private JTextField reg_nick_textF;
	private JPanel reg_nick_info_panel;

	// 2.2.3.2.2-Password panel
	private JSeparator reg_password_separator;
	private JLabel reg_password_ico, reg_password_info_ico, reg_password_info_text;
	private JPasswordField reg_password_textF;
	private JPanel reg_password_info_panel;

	// 2.2.3.2.3-Password check panel
	private JPanel reg_password_check_info_panel;
	private JSeparator reg_password_check_separator;
	private JLabel reg_password_check_ico, reg_password_check_info_ico, reg_password_check_info_text;
	private JPasswordField reg_password_check_textF;

	// 2.2.3.3-Form 2
	private JPanel reg_name_panel, reg_apellido_panel, reg_dni_panel;

	// 2.2.3.3.1-Name panel
	private JPanel reg_name_info_panel;
	private JSeparator reg_name_separator;
	private JLabel reg_name_ico, reg_name_info_ico, reg_name_info_text;
	private JTextField reg_name_textF;

	// 2.2.3.3.2-Apellido panel
	private JPanel reg_apellido_info_panel;
	private JSeparator reg_apellido_separator;
	private JLabel reg_apellido_ico, reg_apellido_info_ico, reg_apellido_info_text;
	private JTextField reg_apellido_textF;

	// 2.2.3.3.3-DNI panel
	private JPanel reg_dni_info_panel;
	private JSeparator reg_dni_separator;
	private JLabel reg_dni_ico, reg_dni_info_ico, reg_dni_info_text;
	private JTextField reg_dni_textF;

	// 2.2.3.3-Form 3
	private JPanel reg_email_panel;

	// 2.2.3.3.1-Email panel
	private JPanel reg_email_info_panel;
	private JSeparator reg_email_separator;
	private JLabel reg_email_ico, reg_email_info_ico, reg_email_info_text;
	private JTextField reg_email_textF;

	// 2.2.3.3.2-Confirmar Button
	private JFormBtn reg_confirmar_FormBtn;
	private JLabel reg_confirmar_formBtn_text;

	// 2.2.4-Info display
	// 2.2.5-Soporte display
	// 2.2.6- Mostrar Usuario

	// 2.2.7-Ver usuarios
	private JPanel verUsuarios_contenedor, verUsuarios_nick_info_panel, verUsuarios_nick_panel;
	private JScrollPane verUsuarios_scroll;
	private JSeparator verUsuarios_nick_separator;
	private JTextField verUsuarios_nick_textF;
	private JLabel verUsuarios_nick_info_ico, verUsuarios_nick_info_text, verUsuarios_nick_icon;
	private JRowList listUpdater_verUsuarios;

	// 3-PopUp Panel
	private JLabel popUp_ico, popUp_text;
	private JControlLabel popUp_salir_labelControl;

	// [ ]COMPONENTES LOGICOS
	// Formulario Login
	private ArrayList<TextFieldGroup> login_grupo_logico = new ArrayList<TextFieldGroup>();
	private TextFieldGroup login_nick_tfg;
	private TextFieldGroup login_password_tfg;
	// Formulario registro
	private ArrayList<TextFieldGroup> reg_grupo_logico = new ArrayList<TextFieldGroup>();
	private TextFieldGroup reg_nick_tfg, reg_password_tfg, reg_name_tfg, reg_apellido_tfg, reg_dni_tfg, reg_email_tfg;
	private TextFieldGroup reg_password_check_tfg;
	//Formulario soporte 
	private ArrayList<TextFieldGroup> soporte_grupo_logico = new ArrayList<TextFieldGroup>();
	private TextFieldGroup soporte_asunto_tfg, soporte_textArea_tfg;
	// Buscador verUsuarios
	private TextFieldGroup verUsuarios_nick_tfg;
	private JLabel acceso_text_mostrarUsuario;
	private JPanel login_nick_panel;
	private JSeparator login_nick_separator;
	private JLabel login_nick_icon;
	private JTextField login_nick_textF;
	private JPanel nick_panel_mostrarUsuario;
	private JSeparator nick_separator_mostrarUsuario;
	private JLabel nick_ico_mostrarUsuario;
	private JLabel nick_text_mostrarUsuario;
	private JPanel nombre_panel_mostrarUsuario;
	private JSeparator nombre_separator_mostrarUsuario;
	private JLabel nombre_ico_mostrarUsuario;
	private JLabel nombre_text_mostrarUsuario;
	private JPanel apellidos_panel_mostrarUsuario;
	private JSeparator apellidos_separator_mostrarUsuario;
	private JLabel apellidos_ico_mostrarUsuario;
	private JLabel apellidos_text_mostrarUsuario;
	private JPanel dni_panel_mostrarUsuario;
	private JSeparator dni_separator_mostrarUsuario;
	private JLabel dni_ico_mostrarUsuario;
	private JLabel dni_text_mostrarUsuario;
	private JPanel email_panel_mostrarUsuario;
	private JSeparator email_separator_mostrarUsuario;
	private JLabel email_ico_mostrarUsuario;
	private JLabel email_text_mostrarUsuario;
	private JPanel fechar_panel_mostrarUsuario;
	private JSeparator fechar_separator_mostrarUsuario;
	private JLabel fechar_ico_mostrarUsuario;
	private JLabel fechar_text_mostrarUsuario;
	private JLabel tiempoDeUso_ico_mostrarUsuario;
	private JLabel tiempoDeUso_text_mostrarUsuario;
	private JLabel acceso_ico_mostrarUsuario;
	private JLabel estado_text_mostrarUsuario;
	private JLabel estado_ico_mostrarUsuario;
	private JPanel accesoCambio_panel_mostrarUsuario;
	private JLabel label_1;
	private JLabel label_2;
	private JSeparator separator_1;
	private JPanel estadoCambio_panel_mostrarUsuario;
	private JLabel accesoCambio_bajar_mostrarUsuario;
	private JLabel accesoCambio_subir_mostrarUsuario;
	private JSeparator separator;
	// ---------------------------------------------------------------
	private JDisplay display_cerrarSesion;
	private JPanel cerrarSesion_btn_panel;
	private JLabel cerrarSesion_btn_text;
	// ---------------------------------------------------------------
	private JDisplay display_entrarComo;
	private JPanel entrarComo_alumno_btn_panel;
	private JLabel entrarComo_alumno_btn_text;
	private JLabel entrarComo_alumno_btn_ico;
	private JPanel entrarComo_profesor_btn_panel;
	private JLabel entrarComo_profesor_btn_text;
	private JLabel entrarComo_profesor_btn_ico;
	private JPanel entrarComo_administrador_btn_panel;
	private JLabel entrarComo_administrador_btn_text;
	private JLabel entrarComo_administrador_btn_ico;
	// --------------------------------------------------------------
	private JLabel mensaje_info;
	private JLabel java_ico;
	private JLabel eclipse_ico;
	private JLabel mysql_ico;
	private JPanel soporte_asunto_panel;
	// --------------------------------------------------------------
	private JSeparator soporte_asunto_separator;
	private JLabel soporte_asunto_icon;
	private JTextField soporte_asunto_textF;
	private JPanel soporte_asunto_info_panel;
	private JLabel soporte_asunto_info_ico;
	private JLabel soporte_asunto_info_text;
	private JLabel soporte_caracteres_text;
	private JFormBtn soporte_enviar_FormBtn;
	private JLabel soporte_enviar_formBtn_text;

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * INICIALIZACION COMPONENTES
	 */

	public Ventana() {
		mysqlc = new MysqlC();
		gestorUsuarios = new GestorUsuarios(mysqlc);
		gestorSesiones = new GestorSesiones(mysqlc, gestorUsuarios);
		checker = new Checker(gestorUsuarios);
		initialize();
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	// Inicializacion de componentes
	private void initialize() {
		// Frame
		frmHacentest = new JFrame();
		frmHacentest.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/imagenes/hacentestico.png")));
		frmHacentest.setTitle("Hacentest");
		frmHacentest.setBounds(100, 100, 1100, 700);
		frmHacentest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHacentest.setUndecorated(true);
		frmHacentest.setVisible(true);
		frmHacentest.getContentPane().setLayout(null);
		frmHacentest.setResizable(false);
		FrameDrager drager = new FrameDrager(frmHacentest);
		frmHacentest.addMouseListener(drager);
		frmHacentest.addMouseMotionListener(drager);

		cargarPopUpPanel();
		cargarEstructura();
		cargarSesionSteups();
		cargarDisplays();
		cargarNavPanelInvitado();
		cargarNavPanelAlumno();
		cargarNavPanelProfesor();
		cargarNavPanelAdministrador();
		cargarNavPanelDesarrollador();

		// Comprobar driver

		if (mysqlc.testConnection()) {

		} else {
			this.showPopUp("mysqlerror");
		}

	}

	// Estructura

	private void cargarEstructura() {
		// Background Panel
		background_panel = new JPanel();
		background_panel.setBounds(0, 0, 1100, 700);
		frmHacentest.getContentPane().add(background_panel);
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

		focusFixer = new JButton("");
		focusFixer.setBounds(42, 0, 1, 1);
		frmHacentest.getContentPane().add(focusFixer);

		cargarCenterPanel();
		cargarSidePanel();

	}

	private void cargarSidePanel() {
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
	}

	private void cargarCenterPanel() {
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
		close_lbl = new JControlLabel(0, "/imagenes/salir_32px.png", "/imagenes/salir_hover_32px.png");
		close_lbl.setIcon(new ImageIcon(Ventana.class.getResource(close_lbl.getPathIco())));
		close_lbl.setBounds(762, 0, 32, 40);
		titulo_panel.add(close_lbl);
		close_lbl.addMouseListener(new ControlLabelListener(close_lbl, this));

		minimize_lbl = new JControlLabel(1, "/imagenes/minimizar_32px.png", "/imagenes/minimizar_hover_32px.png");
		minimize_lbl.setIcon(new ImageIcon(Ventana.class.getResource(minimize_lbl.getPathIco())));
		minimize_lbl.setBounds(730, 0, 32, 40);
		titulo_panel.add(minimize_lbl);
		minimize_lbl.addMouseListener(new ControlLabelListener(minimize_lbl, this));

		// Display panel
		display_panel = new JPanel();
		display_panel.setBounds(0, 148, 800, 552);
		center_panel.add(display_panel);
		display_panel.setLayout(null);
		display_panel.setOpaque(false);
	}

	private void cargarPopUpPanel() {
		// PopUp Panel
		popUp_panel = new JPopUp();
		popUp_panel.setBounds(5, 540, 290, 150);
		frmHacentest.getContentPane().add(popUp_panel);
		popUp_panel.setBackground(Color.RED);
		popUp_panel.setLayout(null);

		popUp_ico = new JLabel("");
		popUp_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/info_96px.png")));
		popUp_ico.setBounds(8, 31, 96, 96);
		popUp_panel.add(popUp_ico);

		popUp_text = new JLabel("");
		popUp_text.setVerticalAlignment(SwingConstants.TOP);
		popUp_text.setHorizontalAlignment(SwingConstants.LEFT);
		popUp_text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		popUp_text.setForeground(Color.WHITE);
		popUp_text.setBounds(105, 32, 173, 96);
		popUp_panel.add(popUp_text);
		popUp_panel.setVisible(false);

		popUp_salir_labelControl = new JControlLabel(2, "/imagenes/salir_black_16px.png", "/imagenes/salir_16px.png");
		popUp_salir_labelControl.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/salir_black_16px.png")));
		popUp_salir_labelControl.setBounds(256, 13, 16, 16);
		popUp_panel.add(popUp_salir_labelControl);
		popUp_salir_labelControl.addMouseListener(new ControlLabelListener(popUp_salir_labelControl, this));

		popUp_panel.setIco(popUp_ico);
		popUp_panel.setText(popUp_text);
		popUp_panel.setControl(popUp_salir_labelControl);
	}

	// Inicializacion de Grupos

	private void cargarSesionSteups() {
		// Carga los grupos de componentes utilizados durante la aplicacion
		opciones_invitado = new OptionGroup();
		opciones_alumno = new OptionGroup();
		opciones_profesor = new OptionGroup();
		opciones_administrador = new OptionGroup();
		opciones_desarrollador = new OptionGroup();

		displays = new DisplayGroup(titulo_ico, titulo_text, this);

		invitado = new SesionSteup(opciones_invitado, displays);
		alumno = new SesionSteup(opciones_alumno, displays);
		profesor = new SesionSteup(opciones_profesor, displays);
		administrador = new SesionSteup(opciones_administrador, displays);
		desarrollador = new SesionSteup(opciones_desarrollador, displays);
	}

	// DISPLAYS

	private void cargarDisplays() {

		/*cargarDisplayIndex();
		cargarDisplayLogin();
		cargarDisplayReg();*/
		cargarDisplaySoporte();
		/*cargarDisplayInfo();
		cargarDisplayVerUsuarios();
		cargarDisplayMostrarUsuario();
		cargarDisplayCerrarSesion();
		cargarDisplayEntrarComo();*/

	}

	private void cargarDisplayIndex() {
		// --> Display index
		display_index = new JDisplay("Bienvenid@", "/imagenes/index_96px.png", displays);
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
	}

	private void cargarDisplayLogin() {
		// --> Display Login
		display_login = new JDisplay("Iniciar sesion", "/imagenes/login_96px.png", displays);
		display_login.setBounds(0, 0, 800, 552);
		display_panel.add(display_login);
		display_login.setLayout(null);
		display_login.setOpaque(false);
		display_login.setVisible(false);

		imagen_central_login = new JLabel("");
		imagen_central_login.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_96px.png")));
		imagen_central_login.setBounds(352, 27, 96, 96);
		display_login.add(imagen_central_login);
/*
		login_nick_panel = new JPanel();
		login_nick_panel.setBounds(204, 144, 390, 96);
		display_login.add(login_nick_panel);
		login_nick_panel.setOpaque(false);
		login_nick_panel.setLayout(null);

		login_nick_separator = new JSeparator();
		login_nick_separator.setBounds(52, 41, 328, 2);
		login_nick_panel.add(login_nick_separator);

		login_nick_icon = new JLabel("");
		login_nick_icon.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		login_nick_icon.setBounds(10, 11, 32, 32);
		login_nick_panel.add(login_nick_icon);

		login_nick_textF = new JTextField("Usuario");
		login_nick_textF.setHorizontalAlignment(SwingConstants.LEFT);
		login_nick_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_nick_textF.setForeground(Color.WHITE);
		login_nick_textF.setBounds(52, 11, 328, 25);
		login_nick_panel.add(login_nick_textF);
		login_nick_textF.setColumns(10);
		login_nick_textF.setBackground(COLOR_SELECTED);
		login_nick_textF.setBorder(null);

		login_nick_info_panel = new JPanel();
		login_nick_info_panel.setBounds(10, 50, 370, 32);
		login_nick_panel.add(login_nick_info_panel);
		login_nick_info_panel.setBackground(COLOR_ERROR);
		login_nick_info_panel.setLayout(null);
		login_nick_info_panel.setVisible(false);

		login_nick_info_ico = new JLabel("");
		login_nick_info_ico.setBounds(0, 0, 32, 32);
		login_nick_info_panel.add(login_nick_info_ico);
		login_nick_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));

		login_nick_info_text = new JLabel("Error");
		login_nick_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_nick_info_text.setBounds(42, 0, 328, 32);
		login_nick_info_panel.add(login_nick_info_text);
*/
		login_password_panel = new JPanel();
		login_password_panel.setLayout(null);
		login_password_panel.setOpaque(false);
		login_password_panel.setBounds(204, 251, 390, 96);
		display_login.add(login_password_panel);

		login_password_separator = new JSeparator();
		login_password_separator.setBounds(52, 41, 328, 2);
		login_password_panel.add(login_password_separator);

		login_password_icon = new JLabel("");
		login_password_icon.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/pass_32px.png")));
		login_password_icon.setBounds(10, 11, 32, 32);
		login_password_panel.add(login_password_icon);

		login_password_textF = new JPasswordField("Contrase\u00F1a");
		login_password_textF.setHorizontalAlignment(SwingConstants.LEFT);
		login_password_textF.setForeground(Color.WHITE);
		login_password_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_password_textF.setColumns(10);
		login_password_textF.setBorder(null);
		login_password_textF.setBackground(new Color(85, 65, 118));
		login_password_textF.setBounds(52, 11, 328, 25);
		login_password_panel.add(login_password_textF);

		login_password_info_panel = new JPanel();
		login_password_info_panel.setLayout(null);
		login_password_info_panel.setBackground(new Color(219, 186, 70));
		login_password_info_panel.setBounds(10, 50, 370, 32);
		login_password_panel.add(login_password_info_panel);
		login_password_info_panel.setVisible(false);

		login_password_info_ico = new JLabel("");
		login_password_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		login_password_info_ico.setBounds(0, 0, 32, 32);
		login_password_info_panel.add(login_password_info_ico);

		login_password_info_text = new JLabel("Error");
		login_password_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		login_password_info_text.setBounds(42, 0, 328, 32);
		login_password_info_panel.add(login_password_info_text);

		login_iniciar_FormBtn = new JFormBtn("login", login_grupo_logico);
		login_iniciar_FormBtn.setBounds(275, 450, 258, 62);
		display_login.add(login_iniciar_FormBtn);
		login_iniciar_FormBtn.setLayout(null);
		login_iniciar_FormBtn.setBackground(new Color(50, 205, 50));
		login_iniciar_FormBtn.addMouseListener(new FormBtnListener(login_iniciar_FormBtn, this));

		login_iniciar_formBtn_text = new JLabel("Iniciar sesi\u00F3n");
		login_iniciar_formBtn_text.setHorizontalAlignment(SwingConstants.CENTER);
		login_iniciar_formBtn_text.setForeground(Color.WHITE);
		login_iniciar_formBtn_text.setFont(new Font("Tahoma", Font.BOLD, 25));
		login_iniciar_formBtn_text.setBounds(10, 0, 238, 62);
		login_iniciar_FormBtn.add(login_iniciar_formBtn_text);

		// Componentes logicos formulario Login
		login_nick_tfg = new TextFieldGroup(login_nick_panel, login_nick_info_panel, login_nick_icon,
				login_nick_info_ico, login_nick_info_text, login_nick_textF, login_nick_separator, "flex_key",
				login_grupo_logico);
		login_password_tfg = new TextFieldGroupRel(login_password_panel, login_password_info_panel, login_password_icon,
				login_password_info_ico, login_password_info_text, login_password_textF, login_password_separator,
				login_grupo_logico, login_nick_tfg, "correspondencia");

		// Listener login
		login_nick_textF.addKeyListener(new TextFieldKeyListener(login_nick_tfg, checker));
		login_password_textF.addKeyListener(new TextFieldKeyListener(login_password_tfg, checker));
		login_nick_textF.addKeyListener(new TextFieldKeyListener(login_password_tfg, checker));

		login_nick_textF.addFocusListener(new TextFocusListener(login_nick_tfg, checker));
		login_password_textF.addFocusListener(new TextFocusListener(login_password_tfg, checker));
	}

	private void cargarDisplayReg() {
		// --> Display Reg
		display_reg = new JDisplay("Crear una cuenta", "/imagenes/reg_96px.png", displays);
		display_reg.setBounds(0, 0, 800, 552);
		display_panel.add(display_reg);
		display_reg.setLayout(null);
		display_reg.setOpaque(false);
		display_reg.setVisible(false);

		// Reg Stepbar
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
		reg_stepbar_2_arrow_ico.setVisible(false);

		reg_stepbar_3_arrow_ico = new JLabel("");
		reg_stepbar_3_arrow_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/arrow_down_32px.png")));
		reg_stepbar_3_arrow_ico.setBounds(738, 0, 32, 28);
		reg_stepbar_panel.add(reg_stepbar_3_arrow_ico);
		reg_stepbar_3_arrow_ico.setVisible(false);

		// Reg form 1

		reg_form_step_1_panel = new JFormDisplay("Datos de la cuenta", "/imagenes/user_info_64px.png", grupo_reg, 1,
				false, true);
		reg_form_step_1_panel.setOpaque(false);
		reg_form_step_1_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_1_panel);
		reg_form_step_1_panel.setLayout(null);

		reg_nick_panel = new JPanel();
		reg_nick_panel.setLayout(null);
		reg_nick_panel.setOpaque(false);
		reg_nick_panel.setBounds(31, 11, 390, 96);
		reg_form_step_1_panel.add(reg_nick_panel);

		reg_nick_separator = new JSeparator();
		reg_nick_separator.setBounds(52, 41, 328, 2);
		reg_nick_panel.add(reg_nick_separator);

		reg_nick_ico = new JLabel("");
		reg_nick_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		reg_nick_ico.setBounds(10, 11, 32, 32);
		reg_nick_panel.add(reg_nick_ico);

		reg_nick_textF = new JTextField("Nick");
		reg_nick_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_nick_textF.setForeground(Color.WHITE);
		reg_nick_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_nick_textF.setColumns(10);
		reg_nick_textF.setBorder(null);
		reg_nick_textF.setBackground(new Color(85, 65, 118));
		reg_nick_textF.setBounds(52, 11, 328, 25);
		reg_nick_panel.add(reg_nick_textF);

		reg_nick_info_panel = new JPanel();
		reg_nick_info_panel.setLayout(null);
		reg_nick_info_panel.setBackground(new Color(219, 186, 70));
		reg_nick_info_panel.setBounds(10, 50, 370, 32);
		reg_nick_panel.add(reg_nick_info_panel);
		reg_nick_info_panel.setVisible(false);

		reg_nick_info_ico = new JLabel("");
		reg_nick_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_nick_info_ico.setBounds(0, 0, 32, 32);
		reg_nick_info_panel.add(reg_nick_info_ico);

		reg_nick_info_text = new JLabel("Error");
		reg_nick_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_nick_info_text.setBounds(42, 0, 328, 32);
		reg_nick_info_panel.add(reg_nick_info_text);

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
		reg_password_info_panel.setVisible(false);

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
		reg_password_check_info_panel.setVisible(false);

		reg_password_check_info_ico = new JLabel("");
		reg_password_check_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_password_check_info_ico.setBounds(0, 0, 32, 32);
		reg_password_check_info_panel.add(reg_password_check_info_ico);

		reg_password_check_info_text = new JLabel("Error");
		reg_password_check_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_password_check_info_text.setBounds(42, 0, 328, 32);
		reg_password_check_info_panel.add(reg_password_check_info_text);

		// Reg form 2

		reg_form_step_2_panel = new JFormDisplay("Datos del usuario", "/imagenes/user_info_64px.png", grupo_reg, 2,
				true, true);
		reg_form_step_2_panel.setOpaque(false);
		reg_form_step_2_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_2_panel);
		reg_form_step_2_panel.setLayout(null);
		reg_form_step_2_panel.setVisible(false);

		reg_name_panel = new JPanel();
		reg_name_panel.setLayout(null);
		reg_name_panel.setOpaque(false);
		reg_name_panel.setBounds(31, 11, 390, 96);
		reg_form_step_2_panel.add(reg_name_panel);

		reg_name_separator = new JSeparator();
		reg_name_separator.setBounds(52, 41, 328, 2);
		reg_name_panel.add(reg_name_separator);

		reg_name_ico = new JLabel("");
		reg_name_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/name_32px.png")));
		reg_name_ico.setBounds(10, 11, 32, 32);
		reg_name_panel.add(reg_name_ico);

		reg_name_textF = new JTextField("Nombre");
		reg_name_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_name_textF.setForeground(Color.WHITE);
		reg_name_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_name_textF.setColumns(10);
		reg_name_textF.setBorder(null);
		reg_name_textF.setBackground(new Color(85, 65, 118));
		reg_name_textF.setBounds(52, 11, 328, 25);
		reg_name_panel.add(reg_name_textF);

		reg_name_info_panel = new JPanel();
		reg_name_info_panel.setLayout(null);
		reg_name_info_panel.setBackground(new Color(219, 186, 70));
		reg_name_info_panel.setBounds(10, 50, 370, 32);
		reg_name_panel.add(reg_name_info_panel);
		reg_name_info_panel.setVisible(false);

		reg_name_info_ico = new JLabel("");
		reg_name_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_name_info_ico.setBounds(0, 0, 32, 32);
		reg_name_info_panel.add(reg_name_info_ico);

		reg_name_info_text = new JLabel("Error");
		reg_name_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_name_info_text.setBounds(42, 0, 328, 32);
		reg_name_info_panel.add(reg_name_info_text);

		reg_apellido_panel = new JPanel();
		reg_apellido_panel.setLayout(null);
		reg_apellido_panel.setOpaque(false);
		reg_apellido_panel.setBounds(31, 118, 390, 96);
		reg_form_step_2_panel.add(reg_apellido_panel);

		reg_apellido_separator = new JSeparator();
		reg_apellido_separator.setBounds(52, 41, 328, 2);
		reg_apellido_panel.add(reg_apellido_separator);

		reg_apellido_ico = new JLabel("");
		reg_apellido_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/apellidos_32px.png")));
		reg_apellido_ico.setBounds(10, 11, 32, 32);
		reg_apellido_panel.add(reg_apellido_ico);

		reg_apellido_textF = new JTextField("Apellidos");
		reg_apellido_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_apellido_textF.setForeground(Color.WHITE);
		reg_apellido_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_apellido_textF.setColumns(10);
		reg_apellido_textF.setBorder(null);
		reg_apellido_textF.setBackground(new Color(85, 65, 118));
		reg_apellido_textF.setBounds(52, 11, 328, 25);
		reg_apellido_panel.add(reg_apellido_textF);

		reg_apellido_info_panel = new JPanel();
		reg_apellido_info_panel.setLayout(null);
		reg_apellido_info_panel.setBackground(new Color(219, 186, 70));
		reg_apellido_info_panel.setBounds(10, 50, 370, 32);
		reg_apellido_panel.add(reg_apellido_info_panel);
		reg_apellido_info_panel.setVisible(false);

		reg_apellido_info_ico = new JLabel("");
		reg_apellido_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_apellido_info_ico.setBounds(0, 0, 32, 32);
		reg_apellido_info_panel.add(reg_apellido_info_ico);

		reg_apellido_info_text = new JLabel("Error");
		reg_apellido_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_apellido_info_text.setBounds(42, 0, 328, 32);
		reg_apellido_info_panel.add(reg_apellido_info_text);

		reg_dni_panel = new JPanel();
		reg_dni_panel.setLayout(null);
		reg_dni_panel.setOpaque(false);
		reg_dni_panel.setBounds(31, 225, 390, 96);
		reg_form_step_2_panel.add(reg_dni_panel);

		reg_dni_separator = new JSeparator();
		reg_dni_separator.setBounds(52, 41, 328, 2);
		reg_dni_panel.add(reg_dni_separator);

		reg_dni_ico = new JLabel("");
		reg_dni_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/dni_32px.png")));
		reg_dni_ico.setBounds(10, 11, 32, 32);
		reg_dni_panel.add(reg_dni_ico);

		reg_dni_textF = new JTextField("DNI");
		reg_dni_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_dni_textF.setForeground(Color.WHITE);
		reg_dni_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_dni_textF.setColumns(10);
		reg_dni_textF.setBorder(null);
		reg_dni_textF.setBackground(new Color(85, 65, 118));
		reg_dni_textF.setBounds(52, 11, 328, 25);
		reg_dni_panel.add(reg_dni_textF);

		reg_dni_info_panel = new JPanel();
		reg_dni_info_panel.setLayout(null);
		reg_dni_info_panel.setBackground(new Color(219, 186, 70));
		reg_dni_info_panel.setBounds(10, 50, 370, 32);
		reg_dni_panel.add(reg_dni_info_panel);
		reg_dni_info_panel.setVisible(false);

		reg_dni_info_ico = new JLabel("");
		reg_dni_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_dni_info_ico.setBounds(0, 0, 32, 32);
		reg_dni_info_panel.add(reg_dni_info_ico);

		reg_dni_info_text = new JLabel("Error");
		reg_dni_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_dni_info_text.setBounds(42, 0, 328, 32);
		reg_dni_info_panel.add(reg_dni_info_text);

		// Reg form 3

		reg_form_step_3_panel = new JFormDisplay("Confirmar datos", "/imagenes/user_info_64px.png", grupo_reg, 3, true,
				false);
		reg_form_step_3_panel.setOpaque(false);
		reg_form_step_3_panel.setBounds(173, 161, 449, 363);
		display_reg.add(reg_form_step_3_panel);
		reg_form_step_3_panel.setLayout(null);
		reg_form_step_3_panel.setVisible(false);

		reg_email_panel = new JPanel();
		reg_email_panel.setLayout(null);
		reg_email_panel.setOpaque(false);
		reg_email_panel.setBounds(31, 11, 390, 96);
		reg_form_step_3_panel.add(reg_email_panel);

		reg_email_separator = new JSeparator();
		reg_email_separator.setBounds(52, 41, 328, 2);
		reg_email_panel.add(reg_email_separator);

		reg_email_ico = new JLabel("");
		reg_email_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/email_32px.png")));
		reg_email_ico.setBounds(10, 11, 32, 32);
		reg_email_panel.add(reg_email_ico);

		reg_email_textF = new JTextField("Correo electronico");
		reg_email_textF.setHorizontalAlignment(SwingConstants.LEFT);
		reg_email_textF.setForeground(Color.WHITE);
		reg_email_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_email_textF.setColumns(10);
		reg_email_textF.setBorder(null);
		reg_email_textF.setBackground(new Color(85, 65, 118));
		reg_email_textF.setBounds(52, 11, 328, 25);
		reg_email_panel.add(reg_email_textF);

		reg_email_info_panel = new JPanel();
		reg_email_info_panel.setLayout(null);
		reg_email_info_panel.setBackground(new Color(219, 186, 70));
		reg_email_info_panel.setBounds(10, 50, 370, 32);
		reg_email_panel.add(reg_email_info_panel);
		reg_email_info_panel.setVisible(false);

		reg_email_info_ico = new JLabel("");
		reg_email_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));
		reg_email_info_ico.setBounds(0, 0, 32, 32);
		reg_email_info_panel.add(reg_email_info_ico);

		reg_email_info_text = new JLabel("Error");
		reg_email_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		reg_email_info_text.setBounds(42, 0, 328, 32);
		reg_email_info_panel.add(reg_email_info_text);

		reg_confirmar_FormBtn = new JFormBtn("reg", reg_grupo_logico);
		reg_confirmar_FormBtn.setBackground(COLOR_CHECK);
		reg_confirmar_FormBtn.setBounds(100, 290, 258, 62);
		reg_form_step_3_panel.add(reg_confirmar_FormBtn);
		reg_confirmar_FormBtn.setLayout(null);
		reg_confirmar_FormBtn.addMouseListener(new FormBtnListener(reg_confirmar_FormBtn, this));

		reg_confirmar_formBtn_text = new JLabel("Crear cuenta");
		reg_confirmar_formBtn_text.setBounds(10, 0, 238, 62);
		reg_confirmar_FormBtn.add(reg_confirmar_formBtn_text);
		reg_confirmar_formBtn_text.setForeground(Color.WHITE);
		reg_confirmar_formBtn_text.setFont(new Font("Tahoma", Font.BOLD, 25));
		reg_confirmar_formBtn_text.setHorizontalAlignment(SwingConstants.CENTER);

		// Reg Nav labels
		reg_next_navLabel = new JNavLabel("/imagenes/siguiente_96px.png", "/imagenes/siguiente_hover_96px.png", "reg",
				"next");
		reg_next_navLabel.setIcon(new ImageIcon(Ventana.class.getResource(reg_next_navLabel.getIco_path())));
		reg_next_navLabel.setBounds(694, 279, 96, 96);
		display_reg.add(reg_next_navLabel);
		reg_next_navLabel.addMouseListener(new NavRegListener(reg_next_navLabel, this));

		reg_back_navLabel = new JNavLabel("/imagenes/atras_96px.png", "/imagenes/atras_hover_96px.png", "reg", "back");
		reg_back_navLabel.setIcon(new ImageIcon(Ventana.class.getResource(reg_back_navLabel.getIco_path())));
		reg_back_navLabel.setBounds(10, 279, 96, 96);
		display_reg.add(reg_back_navLabel);
		reg_back_navLabel.addMouseListener(new NavRegListener(reg_back_navLabel, this));
		reg_back_navLabel.setVisible(false);

		// Reg tittle
		reg_form_separator = new JSeparator();
		reg_form_separator.setBounds(183, 150, 429, 2);
		display_reg.add(reg_form_separator);

		reg_form_titulo = new JLabel("Datos de la cuenta");
		reg_form_titulo.setBounds(262, 86, 338, 64);
		display_reg.add(reg_form_titulo);
		reg_form_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		reg_form_titulo.setFont(new Font("Tahoma", Font.BOLD, 32));
		reg_form_titulo.setForeground(Color.WHITE);

		reg_form_ico = new JLabel("");
		reg_form_ico.setBounds(205, 86, 63, 62);
		display_reg.add(reg_form_ico);
		reg_form_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_info_64px.png")));

		// Componentes logicos formulario Registro
		reg_nick_tfg = new TextFieldGroup(reg_nick_panel, reg_nick_info_panel, reg_nick_ico, reg_nick_info_ico,
				reg_nick_info_text, reg_nick_textF, reg_nick_separator, "flex", reg_grupo_logico);
		reg_password_tfg = new TextFieldGroup(reg_password_panel, reg_password_info_panel, reg_password_ico,
				reg_password_info_ico, reg_password_info_text, reg_password_textF, reg_password_separator, "pass",
				reg_grupo_logico);
		reg_name_tfg = new TextFieldGroup(reg_name_panel, reg_name_info_panel, reg_name_ico, reg_name_info_ico,
				reg_name_info_text, reg_name_textF, reg_name_separator, "strict", reg_grupo_logico);
		reg_apellido_tfg = new TextFieldGroup(reg_apellido_panel, reg_apellido_info_panel, reg_apellido_ico,
				reg_apellido_info_ico, reg_apellido_info_text, reg_apellido_textF, reg_apellido_separator, "strict2",
				reg_grupo_logico);
		reg_dni_tfg = new TextFieldGroup(reg_dni_panel, reg_dni_info_panel, reg_dni_ico, reg_dni_info_ico,
				reg_dni_info_text, reg_dni_textF, reg_dni_separator, "dni", reg_grupo_logico);
		reg_email_tfg = new TextFieldGroup(reg_email_panel, reg_email_info_panel, reg_email_ico, reg_email_info_ico,
				reg_email_info_text, reg_email_textF, reg_email_separator, "email", reg_grupo_logico);

		reg_password_check_tfg = new TextFieldGroupRel(reg_password_check_panel, reg_password_check_info_panel,
				reg_password_check_ico, reg_password_check_info_ico, reg_password_check_info_text,
				reg_password_check_textF, reg_password_check_separator, reg_grupo_logico, reg_password_tfg,
				"similitud");

		// Listeners reg
		reg_nick_textF.addKeyListener(new TextFieldKeyListener(reg_nick_tfg, checker));
		reg_password_textF.addKeyListener(new TextFieldKeyListener(reg_password_tfg, checker));
		reg_name_textF.addKeyListener(new TextFieldKeyListener(reg_name_tfg, checker));
		reg_apellido_textF.addKeyListener(new TextFieldKeyListener(reg_apellido_tfg, checker));
		reg_dni_textF.addKeyListener(new TextFieldKeyListener(reg_dni_tfg, checker));
		reg_email_textF.addKeyListener(new TextFieldKeyListener(reg_email_tfg, checker));
		reg_password_check_textF.addKeyListener(new TextFieldKeyListener(reg_password_check_tfg, checker));
		reg_password_textF.addKeyListener(new TextFieldKeyListener(reg_password_check_tfg, checker));

		reg_nick_textF.addFocusListener(new TextFocusListener(reg_nick_tfg, checker));
		reg_password_textF.addFocusListener(new TextFocusListener(reg_password_tfg, checker));
		reg_name_textF.addFocusListener(new TextFocusListener(reg_name_tfg, checker));
		reg_apellido_textF.addFocusListener(new TextFocusListener(reg_apellido_tfg, checker));
		reg_dni_textF.addFocusListener(new TextFocusListener(reg_dni_tfg, checker));
		reg_email_textF.addFocusListener(new TextFocusListener(reg_email_tfg, checker));
		reg_password_check_textF.addFocusListener(new TextFocusListener(reg_password_check_tfg, checker));
	}

	private void cargarDisplaySoporte() {
		// --> Display Soporte
		display_soporte = new JDisplay("Soporte", "/imagenes/soporte_96px.png", displays);
		display_soporte.setBounds(0, 0, 800, 552);
		display_panel.add(display_soporte);
		display_soporte.setLayout(null);
		display_soporte.setOpaque(false);
		display_soporte.setVisible(false);
		
		soporte_asunto_panel = new JPanel();
		soporte_asunto_panel.setBounds(12, 30, 390, 96);
		display_soporte.add(soporte_asunto_panel);
		soporte_asunto_panel.setOpaque(false);
		soporte_asunto_panel.setLayout(null);

		soporte_asunto_separator = new JSeparator();
		soporte_asunto_separator.setBounds(52, 41, 328, 2);
		soporte_asunto_panel.add(soporte_asunto_separator);

		soporte_asunto_icon = new JLabel("");
		soporte_asunto_icon.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/asunto_32px.png")));
		soporte_asunto_icon.setBounds(10, 11, 32, 32);
		soporte_asunto_panel.add(soporte_asunto_icon);

		soporte_asunto_textF = new JTextField("Asunto");
		soporte_asunto_textF.setHorizontalAlignment(SwingConstants.LEFT);
		soporte_asunto_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		soporte_asunto_textF.setForeground(Color.WHITE);
		soporte_asunto_textF.setBounds(52, 11, 328, 25);
		soporte_asunto_panel.add(soporte_asunto_textF);
		soporte_asunto_textF.setColumns(10);
		soporte_asunto_textF.setBackground(COLOR_SELECTED);
		soporte_asunto_textF.setBorder(null);

		soporte_asunto_info_panel = new JPanel();
		soporte_asunto_info_panel.setBounds(10, 50, 370, 32);
		soporte_asunto_panel.add(soporte_asunto_info_panel);
		soporte_asunto_info_panel.setBackground(COLOR_ERROR);
		soporte_asunto_info_panel.setLayout(null);
		soporte_asunto_info_panel.setVisible(false);

		soporte_asunto_info_ico = new JLabel("");
		soporte_asunto_info_ico.setBounds(0, 0, 32, 32);
		soporte_asunto_info_panel.add(soporte_asunto_info_ico);
		soporte_asunto_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));

		soporte_asunto_info_text = new JLabel("Error");
		soporte_asunto_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		soporte_asunto_info_text.setBounds(42, 0, 328, 32);
		soporte_asunto_info_panel.add(soporte_asunto_info_text);
		
		JTextArea soporte_textArea = new JTextArea();
		soporte_textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
		soporte_textArea.setText("Describre detalladamente la incidencia.");
		soporte_textArea.setBounds(12, 127, 776, 239);
		display_soporte.add(soporte_textArea);
		
		soporte_caracteres_text = new JLabel("Maximo 300 caracteres");
		soporte_caracteres_text.setForeground(Color.WHITE);
		soporte_caracteres_text.setBounds(12, 366, 329, 47);
		display_soporte.add(soporte_caracteres_text);
		soporte_caracteres_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		soporte_enviar_FormBtn = new JFormBtn("soporte", soporte_grupo_logico);
		soporte_enviar_FormBtn.setBackground(COLOR_CHECK);
		soporte_enviar_FormBtn.setBounds(297, 436, 258, 62);
		display_soporte.add(soporte_enviar_FormBtn);
		soporte_enviar_FormBtn.setLayout(null);
		//soporte_enviar_FormBtn.addMouseListener(new FormBtnListener(reg_confirmar_FormBtn, this));

		soporte_enviar_formBtn_text = new JLabel("Enviar");
		soporte_enviar_formBtn_text.setBounds(10, 0, 238, 62);
		soporte_enviar_FormBtn.add(soporte_enviar_formBtn_text);
		soporte_enviar_formBtn_text.setForeground(Color.WHITE);
		soporte_enviar_formBtn_text.setFont(new Font("Tahoma", Font.BOLD, 25));
		soporte_enviar_formBtn_text.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void cargarDisplayInfo() {
		// --> Display Info
		display_info = new JDisplay("Información", "/imagenes/info_96px.png", displays);
		display_info.setBounds(0, 0, 800, 552);
		display_panel.add(display_info);
		display_info.setLayout(null);
		display_info.setOpaque(false);
		display_info.setVisible(false);

		mensaje_info = new JLabel(
				"<html><p>HACENTEST\u00A9<br><br>Aplicacion de simalacion de test para el carnet de conducir en Espa\u00F1a.<br><br>"
						+ "Version: D.0.7.1<br><br>Autor: Adan Jarillo Merida.<br><br>"
						+ "Desarrollado como proyecto de programacion para el ciclo de grado superiror de D.A.M. en CES Fuencarral curso 2017/2018.<p><html>");
		mensaje_info.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje_info.setForeground(Color.WHITE);
		mensaje_info.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mensaje_info.setBounds(50, 22, 700, 351);
		display_info.add(mensaje_info);

		java_ico = new JLabel("");
		java_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/javaico_96px.png")));
		java_ico.setBounds(225, 384, 96, 96);
		display_info.add(java_ico);

		eclipse_ico = new JLabel("");
		eclipse_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/eclipseico_96px.png")));
		eclipse_ico.setBounds(456, 384, 96, 96);
		display_info.add(eclipse_ico);

		mysql_ico = new JLabel("");
		mysql_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/mysqlico_96px.png")));
		mysql_ico.setBounds(341, 384, 96, 96);
		display_info.add(mysql_ico);
	}

	private void cargarDisplayVerUsuarios() {

		display_verUsuarios = new JDisplay("Buscar usuario", "/imagenes/buscar_96px.png", displays);
		display_verUsuarios.setBounds(0, 0, 800, 552);
		display_panel.add(display_verUsuarios);
		display_verUsuarios.setLayout(null);
		display_verUsuarios.setOpaque(false);
		display_verUsuarios.setVisible(false);

		verUsuarios_nick_panel = new JPanel();
		verUsuarios_nick_panel.setBounds(204, 0, 390, 96);
		display_verUsuarios.add(verUsuarios_nick_panel);
		verUsuarios_nick_panel.setOpaque(false);
		verUsuarios_nick_panel.setLayout(null);

		verUsuarios_nick_separator = new JSeparator();
		verUsuarios_nick_separator.setBounds(52, 41, 328, 2);
		verUsuarios_nick_panel.add(verUsuarios_nick_separator);

		verUsuarios_nick_icon = new JLabel("");
		verUsuarios_nick_icon.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/buscar_32px.png")));
		verUsuarios_nick_icon.setBounds(10, 11, 32, 32);
		verUsuarios_nick_panel.add(verUsuarios_nick_icon);

		verUsuarios_nick_textF = new JTextField("Buscar");
		verUsuarios_nick_textF.setHorizontalAlignment(SwingConstants.LEFT);
		verUsuarios_nick_textF.setFont(new Font("Tahoma", Font.BOLD, 20));
		verUsuarios_nick_textF.setForeground(Color.WHITE);
		verUsuarios_nick_textF.setBounds(52, 11, 328, 25);
		verUsuarios_nick_panel.add(verUsuarios_nick_textF);
		verUsuarios_nick_textF.setColumns(10);
		verUsuarios_nick_textF.setBackground(COLOR_SELECTED);
		verUsuarios_nick_textF.setBorder(null);

		verUsuarios_nick_info_panel = new JPanel();
		verUsuarios_nick_info_panel.setBounds(10, 50, 370, 32);
		verUsuarios_nick_panel.add(verUsuarios_nick_info_panel);
		verUsuarios_nick_info_panel.setBackground(COLOR_ERROR);
		verUsuarios_nick_info_panel.setLayout(null);
		verUsuarios_nick_info_panel.setVisible(false);

		verUsuarios_nick_info_ico = new JLabel("");
		verUsuarios_nick_info_ico.setBounds(0, 0, 32, 32);
		verUsuarios_nick_info_panel.add(verUsuarios_nick_info_ico);
		verUsuarios_nick_info_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/error_black_32px.png")));

		verUsuarios_nick_info_text = new JLabel("Error");
		verUsuarios_nick_info_text.setFont(new Font("Tahoma", Font.BOLD, 20));
		verUsuarios_nick_info_text.setBounds(42, 0, 328, 32);
		verUsuarios_nick_info_panel.add(verUsuarios_nick_info_text);

		verUsuarios_scroll = new JScrollPane();
		verUsuarios_scroll.setBorder(null);
		verUsuarios_scroll.setOpaque(false);

		verUsuarios_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		verUsuarios_scroll.setBounds(10, 90, 780, 450);
		display_verUsuarios.add(verUsuarios_scroll);

		verUsuarios_contenedor = new JPanel();
		verUsuarios_contenedor.setBackground(COLOR_SELECTED);
		verUsuarios_scroll.setViewportView(verUsuarios_contenedor);
		verUsuarios_contenedor.setLayout(new GridLayout(0, 1, 0, 20));

		ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();

		listUpdater_verUsuarios = new JRowList(listaUsers, verUsuarios_contenedor, this);
		listUpdater_verUsuarios.cargarLista();

		verUsuarios_nick_tfg = new TextFieldGroup(verUsuarios_nick_panel, verUsuarios_nick_info_panel,
				verUsuarios_nick_icon, verUsuarios_nick_info_ico, verUsuarios_nick_info_text, verUsuarios_nick_textF,
				verUsuarios_nick_separator, "buscar");

		verUsuarios_nick_textF.addKeyListener(new TextFieldKeyListener(verUsuarios_nick_tfg, checker, this));
		verUsuarios_nick_textF.addFocusListener(new TextFocusListener(verUsuarios_nick_tfg, checker));

	}

	private void cargarDisplayMostrarUsuario() {

		display_mostrarUsuario = new JDisplay("Mostrar usuario", "/imagenes/info_96px.png", displays);
		display_mostrarUsuario.setBounds(0, 0, 800, 552);
		display_panel.add(display_mostrarUsuario);
		display_mostrarUsuario.setLayout(null);
		display_mostrarUsuario.setOpaque(false);
		display_mostrarUsuario.setVisible(false);

		nick_panel_mostrarUsuario = new JPanel();
		nick_panel_mostrarUsuario.setLayout(null);
		nick_panel_mostrarUsuario.setOpaque(false);
		nick_panel_mostrarUsuario.setBounds(10, 11, 390, 52);
		display_mostrarUsuario.add(nick_panel_mostrarUsuario);

		nick_separator_mostrarUsuario = new JSeparator();
		nick_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		nick_panel_mostrarUsuario.add(nick_separator_mostrarUsuario);

		nick_ico_mostrarUsuario = new JLabel("");
		nick_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/user_text_32px.png")));
		nick_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		nick_panel_mostrarUsuario.add(nick_ico_mostrarUsuario);

		nick_text_mostrarUsuario = new JLabel("Nick");
		nick_text_mostrarUsuario.setForeground(Color.WHITE);
		nick_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		nick_panel_mostrarUsuario.add(nick_text_mostrarUsuario);

		nombre_panel_mostrarUsuario = new JPanel();
		nombre_panel_mostrarUsuario.setLayout(null);
		nombre_panel_mostrarUsuario.setOpaque(false);
		nombre_panel_mostrarUsuario.setBounds(10, 74, 390, 52);
		display_mostrarUsuario.add(nombre_panel_mostrarUsuario);

		nombre_separator_mostrarUsuario = new JSeparator();
		nombre_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		nombre_panel_mostrarUsuario.add(nombre_separator_mostrarUsuario);

		nombre_ico_mostrarUsuario = new JLabel("");
		nombre_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/name_32px.png")));
		nombre_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		nombre_panel_mostrarUsuario.add(nombre_ico_mostrarUsuario);

		nombre_text_mostrarUsuario = new JLabel("Nombre");
		nombre_text_mostrarUsuario.setForeground(Color.WHITE);
		nombre_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		nombre_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		nombre_panel_mostrarUsuario.add(nombre_text_mostrarUsuario);

		apellidos_panel_mostrarUsuario = new JPanel();
		apellidos_panel_mostrarUsuario.setLayout(null);
		apellidos_panel_mostrarUsuario.setOpaque(false);
		apellidos_panel_mostrarUsuario.setBounds(10, 137, 390, 52);
		display_mostrarUsuario.add(apellidos_panel_mostrarUsuario);

		apellidos_separator_mostrarUsuario = new JSeparator();
		apellidos_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		apellidos_panel_mostrarUsuario.add(apellidos_separator_mostrarUsuario);

		apellidos_ico_mostrarUsuario = new JLabel("");
		apellidos_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/apellidos_32px.png")));
		apellidos_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		apellidos_panel_mostrarUsuario.add(apellidos_ico_mostrarUsuario);

		apellidos_text_mostrarUsuario = new JLabel("Apellidos");
		apellidos_text_mostrarUsuario.setForeground(Color.WHITE);
		apellidos_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		apellidos_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		apellidos_panel_mostrarUsuario.add(apellidos_text_mostrarUsuario);

		dni_panel_mostrarUsuario = new JPanel();
		dni_panel_mostrarUsuario.setLayout(null);
		dni_panel_mostrarUsuario.setOpaque(false);
		dni_panel_mostrarUsuario.setBounds(10, 200, 390, 52);
		display_mostrarUsuario.add(dni_panel_mostrarUsuario);

		dni_separator_mostrarUsuario = new JSeparator();
		dni_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		dni_panel_mostrarUsuario.add(dni_separator_mostrarUsuario);

		dni_ico_mostrarUsuario = new JLabel("");
		dni_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/dni_32px.png")));
		dni_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		dni_panel_mostrarUsuario.add(dni_ico_mostrarUsuario);

		dni_text_mostrarUsuario = new JLabel("DNI");
		dni_text_mostrarUsuario.setForeground(Color.WHITE);
		dni_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		dni_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		dni_panel_mostrarUsuario.add(dni_text_mostrarUsuario);

		email_panel_mostrarUsuario = new JPanel();
		email_panel_mostrarUsuario.setLayout(null);
		email_panel_mostrarUsuario.setOpaque(false);
		email_panel_mostrarUsuario.setBounds(10, 263, 390, 52);
		display_mostrarUsuario.add(email_panel_mostrarUsuario);

		email_separator_mostrarUsuario = new JSeparator();
		email_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		email_panel_mostrarUsuario.add(email_separator_mostrarUsuario);

		email_ico_mostrarUsuario = new JLabel("");
		email_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/email_32px.png")));
		email_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		email_panel_mostrarUsuario.add(email_ico_mostrarUsuario);

		email_text_mostrarUsuario = new JLabel("Correo electronico");
		email_text_mostrarUsuario.setForeground(Color.WHITE);
		email_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		email_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		email_panel_mostrarUsuario.add(email_text_mostrarUsuario);

		fechar_panel_mostrarUsuario = new JPanel();
		fechar_panel_mostrarUsuario.setLayout(null);
		fechar_panel_mostrarUsuario.setOpaque(false);
		fechar_panel_mostrarUsuario.setBounds(10, 326, 390, 52);
		display_mostrarUsuario.add(fechar_panel_mostrarUsuario);

		fechar_separator_mostrarUsuario = new JSeparator();
		fechar_separator_mostrarUsuario.setBounds(52, 41, 328, 2);
		fechar_panel_mostrarUsuario.add(fechar_separator_mostrarUsuario);

		fechar_ico_mostrarUsuario = new JLabel("");
		fechar_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/fecha_32px.png")));
		fechar_ico_mostrarUsuario.setBounds(10, 11, 32, 32);
		fechar_panel_mostrarUsuario.add(fechar_ico_mostrarUsuario);

		fechar_text_mostrarUsuario = new JLabel("Fecha registro");
		fechar_text_mostrarUsuario.setForeground(Color.WHITE);
		fechar_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		fechar_text_mostrarUsuario.setBounds(52, 11, 328, 30);
		fechar_panel_mostrarUsuario.add(fechar_text_mostrarUsuario);

		tiempoDeUso_ico_mostrarUsuario = new JLabel("");
		tiempoDeUso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/time_96px.png")));
		tiempoDeUso_ico_mostrarUsuario.setBounds(410, 30, 96, 96);
		display_mostrarUsuario.add(tiempoDeUso_ico_mostrarUsuario);

		tiempoDeUso_text_mostrarUsuario = new JLabel("DD:HH:MM");
		tiempoDeUso_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		tiempoDeUso_text_mostrarUsuario.setForeground(Color.WHITE);
		tiempoDeUso_text_mostrarUsuario.setBounds(516, 50, 221, 47);
		display_mostrarUsuario.add(tiempoDeUso_text_mostrarUsuario);

		acceso_ico_mostrarUsuario = new JLabel("");
		acceso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/dev_96px.png")));
		acceso_ico_mostrarUsuario.setBounds(410, 282, 96, 96);
		display_mostrarUsuario.add(acceso_ico_mostrarUsuario);

		estado_text_mostrarUsuario = new JLabel("Acceso");
		estado_text_mostrarUsuario.setForeground(Color.WHITE);
		estado_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		estado_text_mostrarUsuario.setBounds(516, 175, 221, 47);
		display_mostrarUsuario.add(estado_text_mostrarUsuario);

		estado_ico_mostrarUsuario = new JLabel("");
		estado_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/online_96px.png")));
		estado_ico_mostrarUsuario.setBounds(410, 156, 96, 96);
		display_mostrarUsuario.add(estado_ico_mostrarUsuario);

		acceso_text_mostrarUsuario = new JLabel("Acceso");
		acceso_text_mostrarUsuario.setForeground(Color.WHITE);
		acceso_text_mostrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		acceso_text_mostrarUsuario.setBounds(516, 304, 221, 47);
		display_mostrarUsuario.add(acceso_text_mostrarUsuario);

		estadoCambio_panel_mostrarUsuario = new JPanel();
		estadoCambio_panel_mostrarUsuario.setOpaque(false);
		estadoCambio_panel_mostrarUsuario.setBounds(720, 165, 32, 68);
		display_mostrarUsuario.add(estadoCambio_panel_mostrarUsuario);
		estadoCambio_panel_mostrarUsuario.setLayout(null);

		accesoCambio_bajar_mostrarUsuario = new JLabel("");
		accesoCambio_bajar_mostrarUsuario
				.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/arrow_down_32px.png")));
		accesoCambio_bajar_mostrarUsuario.setBounds(0, 36, 32, 32);
		estadoCambio_panel_mostrarUsuario.add(accesoCambio_bajar_mostrarUsuario);

		accesoCambio_subir_mostrarUsuario = new JLabel("");
		accesoCambio_subir_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/subir_32px.png")));
		accesoCambio_subir_mostrarUsuario.setBounds(0, 0, 32, 32);
		estadoCambio_panel_mostrarUsuario.add(accesoCambio_subir_mostrarUsuario);

		separator = new JSeparator();
		separator.setBounds(0, 34, 32, 2);
		estadoCambio_panel_mostrarUsuario.add(separator);

		accesoCambio_panel_mostrarUsuario = new JPanel();
		accesoCambio_panel_mostrarUsuario.setLayout(null);
		accesoCambio_panel_mostrarUsuario.setOpaque(false);
		accesoCambio_panel_mostrarUsuario.setBounds(720, 294, 32, 68);
		display_mostrarUsuario.add(accesoCambio_panel_mostrarUsuario);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/bajar_32px.png")));
		label_1.setBounds(0, 36, 32, 32);
		accesoCambio_panel_mostrarUsuario.add(label_1);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/subir_32px.png")));
		label_2.setBounds(0, 0, 32, 32);
		accesoCambio_panel_mostrarUsuario.add(label_2);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 34, 32, 2);
		accesoCambio_panel_mostrarUsuario.add(separator_1);

	}

	private void cargarDisplayCerrarSesion() {
		// --> Display Info
		display_cerrarSesion = new JDisplay("Cerrar sesion", "/imagenes/cerrar_96px.png", displays);
		display_cerrarSesion.setBounds(0, 0, 800, 552);
		display_panel.add(display_cerrarSesion);
		display_cerrarSesion.setLayout(null);
		display_cerrarSesion.setOpaque(false);
		display_cerrarSesion.setVisible(false);

		cerrarSesion_btn_panel = new JPanel();
		cerrarSesion_btn_panel.setBackground(COLOR_BACKGROUND);
		cerrarSesion_btn_panel.setBounds(228, 200, 356, 150);
		display_cerrarSesion.add(cerrarSesion_btn_panel);
		cerrarSesion_btn_panel.setLayout(null);
		cerrarSesion_btn_panel.addMouseListener(new SesionBtnListener(this));

		cerrarSesion_btn_text = new JLabel("Cerrar sesion");
		cerrarSesion_btn_text.setHorizontalAlignment(SwingConstants.CENTER);
		cerrarSesion_btn_text.setFont(new Font("Tahoma", Font.BOLD, 34));
		cerrarSesion_btn_text.setForeground(Color.WHITE);
		cerrarSesion_btn_text.setBounds(10, 44, 336, 60);
		cerrarSesion_btn_panel.add(cerrarSesion_btn_text);

	}

	private void cargarDisplayEntrarComo() {
		// --> Display Info
		display_entrarComo = new JDisplay("Cerrar sesion", "/imagenes/cerrar_96px.png", displays);
		display_entrarComo.setBounds(0, 0, 800, 552);
		display_panel.add(display_entrarComo);
		display_entrarComo.setLayout(null);
		display_entrarComo.setOpaque(false);
		display_entrarComo.setVisible(false);

		entrarComo_alumno_btn_panel = new JPanel();
		entrarComo_alumno_btn_panel.setBackground(COLOR_BACKGROUND);
		entrarComo_alumno_btn_panel.setBounds(144, 38, 493, 150);
		display_entrarComo.add(entrarComo_alumno_btn_panel);
		entrarComo_alumno_btn_panel.setLayout(null);

		entrarComo_alumno_btn_text = new JLabel("Alumno");
		entrarComo_alumno_btn_text.setHorizontalAlignment(SwingConstants.LEFT);
		entrarComo_alumno_btn_text.setFont(new Font("Tahoma", Font.BOLD, 36));
		entrarComo_alumno_btn_text.setForeground(Color.WHITE);
		entrarComo_alumno_btn_text.setBounds(163, 46, 360, 60);
		entrarComo_alumno_btn_panel.add(entrarComo_alumno_btn_text);

		entrarComo_alumno_btn_ico = new JLabel("");
		entrarComo_alumno_btn_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/alumno_96px.png")));
		entrarComo_alumno_btn_ico.setBounds(41, 29, 96, 96);
		entrarComo_alumno_btn_panel.add(entrarComo_alumno_btn_ico);

		entrarComo_profesor_btn_panel = new JPanel();
		entrarComo_profesor_btn_panel.setLayout(null);
		entrarComo_profesor_btn_panel.setBackground(new Color(54, 33, 89));
		entrarComo_profesor_btn_panel.setBounds(144, 199, 493, 150);
		display_entrarComo.add(entrarComo_profesor_btn_panel);

		entrarComo_profesor_btn_text = new JLabel("Profesor");
		entrarComo_profesor_btn_text.setHorizontalAlignment(SwingConstants.LEFT);
		entrarComo_profesor_btn_text.setForeground(Color.WHITE);
		entrarComo_profesor_btn_text.setFont(new Font("Tahoma", Font.BOLD, 36));
		entrarComo_profesor_btn_text.setBounds(163, 46, 360, 60);
		entrarComo_profesor_btn_panel.add(entrarComo_profesor_btn_text);

		entrarComo_profesor_btn_ico = new JLabel("");
		entrarComo_profesor_btn_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/profesor_96px.png")));
		entrarComo_profesor_btn_ico.setBounds(41, 29, 96, 96);
		entrarComo_profesor_btn_panel.add(entrarComo_profesor_btn_ico);

		entrarComo_administrador_btn_panel = new JPanel();
		entrarComo_administrador_btn_panel.setLayout(null);
		entrarComo_administrador_btn_panel.setBackground(new Color(54, 33, 89));
		entrarComo_administrador_btn_panel.setBounds(144, 360, 493, 150);
		display_entrarComo.add(entrarComo_administrador_btn_panel);

		entrarComo_administrador_btn_text = new JLabel("Administrador");
		entrarComo_administrador_btn_text.setHorizontalAlignment(SwingConstants.LEFT);
		entrarComo_administrador_btn_text.setForeground(Color.WHITE);
		entrarComo_administrador_btn_text.setFont(new Font("Tahoma", Font.BOLD, 36));
		entrarComo_administrador_btn_text.setBounds(163, 46, 360, 60);
		entrarComo_administrador_btn_panel.add(entrarComo_administrador_btn_text);

		entrarComo_administrador_btn_ico = new JLabel("");
		entrarComo_administrador_btn_ico.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/admin_96px.png")));
		entrarComo_administrador_btn_ico.setBounds(41, 29, 96, 96);
		entrarComo_administrador_btn_panel.add(entrarComo_administrador_btn_ico);

		entrarComo_alumno_btn_panel.addMouseListener(new EntrarComoListener(this, entrarComo_alumno_btn_text));
		entrarComo_profesor_btn_panel.addMouseListener(new EntrarComoListener(this, entrarComo_profesor_btn_text));
		entrarComo_administrador_btn_panel
				.addMouseListener(new EntrarComoListener(this, entrarComo_administrador_btn_text));

	}
	// NavPanel inivitado

	private void cargarNavPanelInvitado() {
		// NavPanel invitado
		navPanel_invitado = new JPanel();
		navPanel_invitado.setBounds(0, 0, 300, 464);
		nav_panel.add(navPanel_invitado);
		navPanel_invitado.setOpaque(false);
		navPanel_invitado.setLayout(null);
		opciones_invitado.setNav_panel(navPanel_invitado);

		// Nav options

		// option login
		opt_login = new JOption(display_login, "Iniciar sesi\u00F3n", "/imagenes/login_32px.png", opciones_invitado);
		opt_login.setBounds(0, 11, 300, 48);
		navPanel_invitado.add(opt_login);
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
		opt_reg = new JOption(display_reg, "Crear una cuenta", "/imagenes/reg_32px.png", opciones_invitado);
		opt_reg.setLayout(null);
		opt_reg.setBackground(new Color(54, 33, 89));
		opt_reg.setBounds(0, 59, 300, 48);
		navPanel_invitado.add(opt_reg);
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
		opt_info = new JOption(display_info, "Informaci\\u00F3n", "/imagenes/info_32px.png", opciones_invitado);
		opt_info.setLayout(null);
		opt_info.setBackground(new Color(54, 33, 89));
		opt_info.setBounds(0, 107, 300, 48);
		navPanel_invitado.add(opt_info);
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
		opt_soporte = new JOption(display_soporte, "Soporte", "/imagenes/soporte_32px.png", opciones_invitado);
		opt_soporte.setLayout(null);
		opt_soporte.setBackground(new Color(54, 33, 89));
		opt_soporte.setBounds(0, 155, 300, 48);
		navPanel_invitado.add(opt_soporte);
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

	}

	// NavPanel Alumno

	private void cargarNavPanelAlumno() {
		// NavPanel alumno
		navPanel_alumno = new JPanel();
		navPanel_alumno.setBounds(0, 0, 300, 464);
		nav_panel.add(navPanel_alumno);
		navPanel_alumno.setOpaque(false);
		navPanel_alumno.setLayout(null);
		navPanel_alumno.setVisible(false);
		opciones_alumno.setNav_panel(navPanel_alumno);

		// Nav options

		// option iniciar test
		opt_iniciarTest = new JOption(display_login, "Iniciar test", "/imagenes/test_32px.png", opciones_alumno);
		opt_iniciarTest.setBounds(0, 11, 300, 48);
		navPanel_alumno.add(opt_iniciarTest);
		opt_iniciarTest.setBackground(COLOR_BACKGROUND);
		opt_iniciarTest.setLayout(null);
		opt_iniciarTest.addMouseListener(new OptionListener(opt_iniciarTest));

		opt_iniciarTest_ico = new JLabel("");
		opt_iniciarTest_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_iniciarTest.getIco_path())));
		opt_iniciarTest_ico.setBounds(10, 0, 48, 48);
		opt_iniciarTest.add(opt_iniciarTest_ico);

		opt_iniciarTest_text = new JLabel(opt_iniciarTest.getText());
		opt_iniciarTest_text.setForeground(Color.WHITE);
		opt_iniciarTest_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_iniciarTest_text.setBounds(68, 11, 222, 26);
		opt_iniciarTest.add(opt_iniciarTest_text);

		// option estadisticas alumno
		opt_estadisticas_alumno = new JOption(display_reg, "Estadisticas", "/imagenes/estadisticas_32px.png",
				opciones_alumno);
		opt_estadisticas_alumno.setLayout(null);
		opt_estadisticas_alumno.setBackground(new Color(54, 33, 89));
		opt_estadisticas_alumno.setBounds(0, 59, 300, 48);
		navPanel_alumno.add(opt_estadisticas_alumno);
		opt_estadisticas_alumno.addMouseListener(new OptionListener(opt_estadisticas_alumno));

		opt_estadisticas_alumno_ico = new JLabel("");
		opt_estadisticas_alumno_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_estadisticas_alumno.getIco_path())));
		opt_estadisticas_alumno_ico.setBounds(10, 0, 48, 48);
		opt_estadisticas_alumno.add(opt_estadisticas_alumno_ico);

		opt_estadisticas_alumno_text = new JLabel("Estadisticas");
		opt_estadisticas_alumno_text.setForeground(Color.WHITE);
		opt_estadisticas_alumno_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_estadisticas_alumno_text.setBounds(68, 11, 222, 26);
		opt_estadisticas_alumno.add(opt_estadisticas_alumno_text);

		// option soporte alumno
		opt_soporte_alumno = new JOption(display_info, "Soporte", "/imagenes/soporte_32px.png", opciones_alumno);
		opt_soporte_alumno.setLayout(null);
		opt_soporte_alumno.setBackground(new Color(54, 33, 89));
		opt_soporte_alumno.setBounds(0, 107, 300, 48);
		navPanel_alumno.add(opt_soporte_alumno);
		opt_soporte_alumno.addMouseListener(new OptionListener(opt_soporte_alumno));

		opt_soporte_alumno_ico = new JLabel("");
		opt_soporte_alumno_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_soporte_alumno.getIco_path())));
		opt_soporte_alumno_ico.setBounds(10, 0, 48, 48);
		opt_soporte_alumno.add(opt_soporte_alumno_ico);

		opt_soporte_alumno_text = new JLabel("Soporte");
		opt_soporte_alumno_text.setForeground(Color.WHITE);
		opt_soporte_alumno_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_soporte_alumno_text.setBounds(68, 11, 222, 26);
		opt_soporte_alumno.add(opt_soporte_alumno_text);

		// option cerrar sesion alumno
		opt_cerrarSesion_alumno = new JOption(display_cerrarSesion, "Cerrar sesion", "/imagenes/cerrar_32px.png",
				opciones_alumno);
		opt_cerrarSesion_alumno.setLayout(null);
		opt_cerrarSesion_alumno.setBackground(new Color(54, 33, 89));
		opt_cerrarSesion_alumno.setBounds(0, 155, 300, 48);
		navPanel_alumno.add(opt_cerrarSesion_alumno);
		opt_cerrarSesion_alumno.addMouseListener(new OptionListener(opt_cerrarSesion_alumno));

		opt_cerrarSesion_alumno_ico = new JLabel("");
		opt_cerrarSesion_alumno_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_cerrarSesion_alumno.getIco_path())));
		opt_cerrarSesion_alumno_ico.setBounds(10, 0, 48, 48);
		opt_cerrarSesion_alumno.add(opt_cerrarSesion_alumno_ico);

		opt_cerrarSesion_alumno_text = new JLabel("Cerrar sesion");
		opt_cerrarSesion_alumno_text.setForeground(Color.WHITE);
		opt_cerrarSesion_alumno_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_cerrarSesion_alumno_text.setBounds(68, 11, 222, 26);
		opt_cerrarSesion_alumno.add(opt_cerrarSesion_alumno_text);

	}

	// NavPanel Profesor

	private void cargarNavPanelProfesor() {
		// NavPanel alumno
		navPanel_profesor = new JPanel();
		navPanel_profesor.setBounds(0, 0, 300, 464);
		nav_panel.add(navPanel_profesor);
		navPanel_profesor.setOpaque(false);
		navPanel_profesor.setLayout(null);
		navPanel_profesor.setVisible(false);
		opciones_profesor.setNav_panel(navPanel_profesor);

		// Nav options

		// option estadisticas profesor
		opt_estadisticas_profesor = new JOption(display_login, "Estadisticas", "/imagenes/estadisticas_32px.png",
				opciones_profesor);
		opt_estadisticas_profesor.setBounds(0, 11, 300, 48);
		navPanel_profesor.add(opt_estadisticas_profesor);
		opt_estadisticas_profesor.setBackground(COLOR_BACKGROUND);
		opt_estadisticas_profesor.setLayout(null);
		opt_estadisticas_profesor.addMouseListener(new OptionListener(opt_estadisticas_profesor));

		opt_estadisticas_profesor_ico = new JLabel("");
		opt_estadisticas_profesor_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_estadisticas_profesor.getIco_path())));
		opt_estadisticas_profesor_ico.setBounds(10, 0, 48, 48);
		opt_estadisticas_profesor.add(opt_estadisticas_profesor_ico);

		opt_iniciarTest_text = new JLabel(opt_estadisticas_profesor.getText());
		opt_iniciarTest_text.setForeground(Color.WHITE);
		opt_iniciarTest_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_iniciarTest_text.setBounds(68, 11, 222, 26);
		opt_estadisticas_profesor.add(opt_iniciarTest_text);

		// option entrar como - profesor
		opt_entrarComo_profesor = new JOption(display_entrarComo, "Entrar como", "/imagenes/cambiar_32px.png",
				opciones_profesor);
		opt_entrarComo_profesor.setLayout(null);
		opt_entrarComo_profesor.setBackground(new Color(54, 33, 89));
		opt_entrarComo_profesor.setBounds(0, 59, 300, 48);
		navPanel_profesor.add(opt_entrarComo_profesor);
		opt_entrarComo_profesor.addMouseListener(new OptionListener(opt_entrarComo_profesor));

		opt_entrarComo_profesor_ico = new JLabel("");
		opt_entrarComo_profesor_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_entrarComo_profesor.getIco_path())));
		opt_entrarComo_profesor_ico.setBounds(10, 0, 48, 48);
		opt_entrarComo_profesor.add(opt_entrarComo_profesor_ico);

		opt_entrarComo_profesor_text = new JLabel("Entrar como");
		opt_entrarComo_profesor_text.setForeground(Color.WHITE);
		opt_entrarComo_profesor_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_entrarComo_profesor_text.setBounds(68, 11, 222, 26);
		opt_entrarComo_profesor.add(opt_entrarComo_profesor_text);

		// option soporte profesor
		opt_soporte_profesor = new JOption(display_info, "Soporte", "/imagenes/soporte_32px.png", opciones_profesor);
		opt_soporte_profesor.setLayout(null);
		opt_soporte_profesor.setBackground(new Color(54, 33, 89));
		opt_soporte_profesor.setBounds(0, 107, 300, 48);
		navPanel_profesor.add(opt_soporte_profesor);
		opt_soporte_profesor.addMouseListener(new OptionListener(opt_soporte_profesor));

		opt_soporte_profesor_ico = new JLabel("");
		opt_soporte_profesor_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_soporte_profesor.getIco_path())));
		opt_soporte_profesor_ico.setBounds(10, 0, 48, 48);
		opt_soporte_profesor.add(opt_soporte_profesor_ico);

		opt_soporte_profesor_text = new JLabel("Soporte");
		opt_soporte_profesor_text.setForeground(Color.WHITE);
		opt_soporte_profesor_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_soporte_profesor_text.setBounds(68, 11, 222, 26);
		opt_soporte_profesor.add(opt_soporte_profesor_text);

		// option cerrar sesion profesor
		opt_cerrarSesion_profesor = new JOption(display_cerrarSesion, "Cerrar sesion", "/imagenes/cerrar_32px.png",
				opciones_profesor);
		opt_cerrarSesion_profesor.setLayout(null);
		opt_cerrarSesion_profesor.setBackground(new Color(54, 33, 89));
		opt_cerrarSesion_profesor.setBounds(0, 155, 300, 48);
		navPanel_profesor.add(opt_cerrarSesion_profesor);
		opt_cerrarSesion_profesor.addMouseListener(new OptionListener(opt_cerrarSesion_profesor));

		opt_cerrarSesion_profesor_ico = new JLabel("");
		opt_cerrarSesion_profesor_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_cerrarSesion_profesor.getIco_path())));
		opt_cerrarSesion_profesor_ico.setBounds(10, 0, 48, 48);
		opt_cerrarSesion_profesor.add(opt_cerrarSesion_profesor_ico);

		opt_cerrarSesion_profesor_text = new JLabel("Cerrar sesion");
		opt_cerrarSesion_profesor_text.setForeground(Color.WHITE);
		opt_cerrarSesion_profesor_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_cerrarSesion_profesor_text.setBounds(68, 11, 222, 26);
		opt_cerrarSesion_profesor.add(opt_cerrarSesion_profesor_text);

	}

	// NavPanel Administrador

	private void cargarNavPanelAdministrador() {
		// NavPanel administrador
		navPanel_administrador = new JPanel();
		navPanel_administrador.setBounds(0, 0, 300, 464);
		nav_panel.add(navPanel_administrador);
		navPanel_administrador.setOpaque(false);
		navPanel_administrador.setLayout(null);
		navPanel_administrador.setVisible(false);
		opciones_administrador.setNav_panel(navPanel_administrador);

		// Nav options

		// option ver usuarios
		opt_verUsuarios = new JOption(display_verUsuarios, "Buscar usuario", "/imagenes/buscar_32px.png",
				opciones_administrador);
		opt_verUsuarios.setBounds(0, 11, 300, 48);
		navPanel_administrador.add(opt_verUsuarios);
		opt_verUsuarios.setBackground(COLOR_BACKGROUND);
		opt_verUsuarios.setLayout(null);
		opt_verUsuarios.addMouseListener(new OptionListener(opt_verUsuarios));

		opt_verUsuarios_ico = new JLabel("");
		opt_verUsuarios_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_verUsuarios.getIco_path())));
		opt_verUsuarios_ico.setBounds(10, 0, 48, 48);
		opt_verUsuarios.add(opt_verUsuarios_ico);

		opt_verUsuarios_text = new JLabel(opt_verUsuarios.getText());
		opt_verUsuarios_text.setForeground(Color.WHITE);
		opt_verUsuarios_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_verUsuarios_text.setBounds(68, 11, 222, 26);
		opt_verUsuarios.add(opt_verUsuarios_text);

		// option soporte administrador
		opt_soporte_administrador = new JOption(display_reg, "Soporte", "/imagenes/soporte_32px.png",
				opciones_administrador);
		opt_soporte_administrador.setLayout(null);
		opt_soporte_administrador.setBackground(new Color(54, 33, 89));
		opt_soporte_administrador.setBounds(0, 59, 300, 48);
		navPanel_administrador.add(opt_soporte_administrador);
		opt_soporte_administrador.addMouseListener(new OptionListener(opt_soporte_administrador));

		opt_soporte_administrador_ico = new JLabel("");
		opt_soporte_administrador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_soporte_administrador.getIco_path())));
		opt_soporte_administrador_ico.setBounds(10, 0, 48, 48);
		opt_soporte_administrador.add(opt_soporte_administrador_ico);

		opt_soporte_administrador_text = new JLabel("Soporte");
		opt_soporte_administrador_text.setForeground(Color.WHITE);
		opt_soporte_administrador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_soporte_administrador_text.setBounds(68, 11, 222, 26);
		opt_soporte_administrador.add(opt_soporte_administrador_text);

		// option entrar como (administrador)
		opt_entrarComo_administrador = new JOption(display_entrarComo, "Entrar como", "/imagenes/cambiar_32px.png",
				opciones_administrador);
		opt_entrarComo_administrador.setLayout(null);
		opt_entrarComo_administrador.setBackground(new Color(54, 33, 89));
		opt_entrarComo_administrador.setBounds(0, 107, 300, 48);
		navPanel_administrador.add(opt_entrarComo_administrador);
		opt_entrarComo_administrador.addMouseListener(new OptionListener(opt_entrarComo_administrador));

		opt_entrarComo_administrador_ico = new JLabel("");
		opt_entrarComo_administrador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_entrarComo_administrador.getIco_path())));
		opt_entrarComo_administrador_ico.setBounds(10, 0, 48, 48);
		opt_entrarComo_administrador.add(opt_entrarComo_administrador_ico);

		opt_entrarComo_administrador_text = new JLabel("Entrar como");
		opt_entrarComo_administrador_text.setForeground(Color.WHITE);
		opt_entrarComo_administrador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_entrarComo_administrador_text.setBounds(68, 11, 222, 26);
		opt_entrarComo_administrador.add(opt_entrarComo_administrador_text);

		// option cerrar sesion
		opt_cerrarSesion_administrador = new JOption(display_cerrarSesion, "Cerrar sesion", "/imagenes/cerrar_32px.png",
				opciones_administrador);
		opt_cerrarSesion_administrador.setLayout(null);
		opt_cerrarSesion_administrador.setBackground(new Color(54, 33, 89));
		opt_cerrarSesion_administrador.setBounds(0, 155, 300, 48);
		navPanel_administrador.add(opt_cerrarSesion_administrador);
		opt_cerrarSesion_administrador.addMouseListener(new OptionListener(opt_cerrarSesion_administrador));

		opt_cerrarSesion_administrador_ico = new JLabel("");
		opt_cerrarSesion_administrador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_cerrarSesion_administrador.getIco_path())));
		opt_cerrarSesion_administrador_ico.setBounds(10, 0, 48, 48);
		opt_cerrarSesion_administrador.add(opt_cerrarSesion_administrador_ico);

		opt_cerrarSesion_administrador_text = new JLabel("Cerrar sesion");
		opt_cerrarSesion_administrador_text.setForeground(Color.WHITE);
		opt_cerrarSesion_administrador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_cerrarSesion_administrador_text.setBounds(68, 11, 222, 26);
		opt_cerrarSesion_administrador.add(opt_cerrarSesion_administrador_text);
	}

	// NavPanel Desarrollador

	private void cargarNavPanelDesarrollador() {
		// NavPanel desarollador
		navPanel_desarrollador = new JPanel();
		navPanel_desarrollador.setBounds(0, 0, 300, 464);
		nav_panel.add(navPanel_desarrollador);
		navPanel_desarrollador.setOpaque(false);
		navPanel_desarrollador.setLayout(null);
		navPanel_desarrollador.setVisible(false);
		opciones_desarrollador.setNav_panel(navPanel_desarrollador);

		// Nav options

		// option ver usuarios desarollador
		opt_verUsuarios_desarrollador = new JOption(display_verUsuarios, "Ver usuarios", "/imagenes/buscar_32px.png",
				opciones_desarrollador);
		opt_verUsuarios_desarrollador.setBounds(0, 11, 300, 48);
		navPanel_desarrollador.add(opt_verUsuarios_desarrollador);
		opt_verUsuarios_desarrollador.setBackground(COLOR_BACKGROUND);
		opt_verUsuarios_desarrollador.setLayout(null);
		opt_verUsuarios_desarrollador.addMouseListener(new OptionListener(opt_verUsuarios_desarrollador));

		opt_verUsuarios_desarrollador_ico = new JLabel("");
		opt_verUsuarios_desarrollador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_verUsuarios_desarrollador.getIco_path())));
		opt_verUsuarios_desarrollador_ico.setBounds(10, 0, 48, 48);
		opt_verUsuarios_desarrollador.add(opt_verUsuarios_desarrollador_ico);

		opt_verUsuarios_desarrollador_text = new JLabel(opt_verUsuarios_desarrollador.getText());
		opt_verUsuarios_desarrollador_text.setForeground(Color.WHITE);
		opt_verUsuarios_desarrollador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_verUsuarios_desarrollador_text.setBounds(68, 11, 222, 26);
		opt_verUsuarios_desarrollador.add(opt_verUsuarios_desarrollador_text);

		// option entrar como - desarollador
		opt_entrarComo_desarrollador = new JOption(display_entrarComo, "Entrar como", "/imagenes/cambiar_32px.png",
				opciones_desarrollador);
		opt_entrarComo_desarrollador.setLayout(null);
		opt_entrarComo_desarrollador.setBackground(new Color(54, 33, 89));
		opt_entrarComo_desarrollador.setBounds(0, 59, 300, 48);
		navPanel_desarrollador.add(opt_entrarComo_desarrollador);
		opt_entrarComo_desarrollador.addMouseListener(new OptionListener(opt_entrarComo_desarrollador));

		opt_entrarComo_desarrollador_ico = new JLabel("");
		opt_entrarComo_desarrollador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_entrarComo_desarrollador.getIco_path())));
		opt_entrarComo_desarrollador_ico.setBounds(10, 0, 48, 48);
		opt_entrarComo_desarrollador.add(opt_entrarComo_desarrollador_ico);

		opt_entrarComo_desarrollador_text = new JLabel("Entrar como");
		opt_entrarComo_desarrollador_text.setForeground(Color.WHITE);
		opt_entrarComo_desarrollador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_entrarComo_desarrollador_text.setBounds(68, 11, 222, 26);
		opt_entrarComo_desarrollador.add(opt_entrarComo_desarrollador_text);

		// option añadir pregunta
		opt_anadirPregunta = new JOption(display_info, "Añadir pregunta", "/imagenes/pregunta_32px.png",
				opciones_desarrollador);
		opt_anadirPregunta.setLayout(null);
		opt_anadirPregunta.setBackground(new Color(54, 33, 89));
		opt_anadirPregunta.setBounds(0, 107, 300, 48);
		navPanel_desarrollador.add(opt_anadirPregunta);
		opt_anadirPregunta.addMouseListener(new OptionListener(opt_anadirPregunta));

		opt_anadirPregunta_ico = new JLabel("");
		opt_anadirPregunta_ico.setIcon(new ImageIcon(Ventana.class.getResource(opt_anadirPregunta.getIco_path())));
		opt_anadirPregunta_ico.setBounds(10, 0, 48, 48);
		opt_anadirPregunta.add(opt_anadirPregunta_ico);

		opt_anadirPregunta_text = new JLabel("Añadir pregunta");
		opt_anadirPregunta_text.setForeground(Color.WHITE);
		opt_anadirPregunta_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_anadirPregunta_text.setBounds(68, 11, 222, 26);
		opt_anadirPregunta.add(opt_anadirPregunta_text);

		// option cerrar sesion desarolloador
		opt_cerrarSesion_desarrollador = new JOption(display_cerrarSesion, "Cerrar sesion", "/imagenes/cerrar_32px.png",
				opciones_desarrollador);
		opt_cerrarSesion_desarrollador.setLayout(null);
		opt_cerrarSesion_desarrollador.setBackground(new Color(54, 33, 89));
		opt_cerrarSesion_desarrollador.setBounds(0, 155, 300, 48);
		navPanel_desarrollador.add(opt_cerrarSesion_desarrollador);
		opt_cerrarSesion_desarrollador.addMouseListener(new OptionListener(opt_cerrarSesion_desarrollador));

		opt_cerrarSesion_desarrollador_ico = new JLabel("");
		opt_cerrarSesion_desarrollador_ico
				.setIcon(new ImageIcon(Ventana.class.getResource(opt_cerrarSesion_desarrollador.getIco_path())));
		opt_cerrarSesion_desarrollador_ico.setBounds(10, 0, 48, 48);
		opt_cerrarSesion_desarrollador.add(opt_cerrarSesion_desarrollador_ico);

		opt_cerrarSesion_desarrollador_text = new JLabel("Cerrar sesion");
		opt_cerrarSesion_desarrollador_text.setForeground(Color.WHITE);
		opt_cerrarSesion_desarrollador_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opt_cerrarSesion_desarrollador_text.setBounds(68, 11, 222, 26);
		opt_cerrarSesion_desarrollador.add(opt_cerrarSesion_desarrollador_text);

	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * POPUP CONTROL
	 */

	public void showPopUp(String type) {

		switch (type) {
		case "mysqlerror":

			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>MYSQL: No se ha podido establecer la conexion con la base de datos</HTML>",
					"/imagenes/error_black_96px.png");
			break;

		case "useronline":
			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>El usuario con el que intentas inciar sesion esta: <b>ONLINE</b></HTML>",
					"/imagenes/error_black_96px.png");
			break;

		case "usersuspend":
			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>El usuario con el que intentas inciar sesion esta: <b>SUSPENDIDO</b></HTML>",
					"/imagenes/error_black_96px.png");
			break;

		case "regcomplete":

			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Cuenta creada con exito. Inicia sesion para disfrutar de la aplicacion</HTML>",
					"/imagenes/reg_96px.png");
			break;
		case "logincomplete":

			popUp_panel.infoStyle();
			popUp_panel.showPanel(
					"<HTML>Sesion inciada con exito. Bienvenid@ " + sesionActual.getUsuario().getNick() + "</HTML>",
					"/imagenes/user_96px.png");
			break;
		case "entrarcomoAlumno":

			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Sesion cambiada a modo alumno. Cierra la sesion para volver al modo "
					+ sesionActual.getUsuario().getAcceso() + "</HTML>", "/imagenes/alumno_96px.png");
			break;
		case "entrarcomoProfesor":

			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Sesion cambiada a modo profesor. Cierra la sesion para volver al modo "
					+ sesionActual.getUsuario().getAcceso() + "</HTML>", "/imagenes/profesor_96px.png");
			break;
		case "entrarcomoAdministrador":

			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Sesion cambiada a modo administrador. Cierra la sesion para volver al modo "
					+ sesionActual.getUsuario().getAcceso() + "</HTML>", "/imagenes/admin_96px.png");
			break;
		}
		// solucion al bug de solapamiento
		popUp_panel.setVisible(false);
		popUp_panel.setVisible(true);

	}

	public void hidePopUp() {

		popUp_panel.setVisible(false);

	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * DISPLAY CONTROL
	 */

	public void goTo(String displayName) {
		switch (displayName) {
		case "display_login":
			opt_login.setSelected(true);
			opt_reg.setSelected(false);
			opt_info.setSelected(false);
			displays.mostarDisplay(display_login);
			break;
		}
	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * CONTROL FORMULARIOS
	 */

	public ResultSet getLoginResultSet() {
		ResultSet rs = gestorUsuarios.getUsuario("nick", login_nick_textF.getText());
		return rs;
	}

	public void resetRegForm() {
		reg_nick_tfg.reset();
		reg_password_tfg.reset();
		reg_name_tfg.reset();
		reg_apellido_tfg.reset();
		reg_dni_tfg.reset();
		reg_email_tfg.reset();
		reg_password_check_tfg.reset();
	}

	public void setRegDisplay(int index, String function) throws java.awt.IllegalComponentStateException {
		focusFixer.requestFocus();
		switch (function) {
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
		while (it.hasNext()) {
			f = it.next();
			f.setVisible(false);
			if (f.getIndex() == index) {
				selected = f;
			}
		}

		selected.setVisible(true);
		reg_form_ico.setIcon(new ImageIcon(Ventana.class.getResource(selected.getIcoPath())));
		reg_form_titulo.setText(selected.getTitulo());
		reg_next_navLabel.setVisible(selected.isNextChecker());
		reg_back_navLabel.setVisible(selected.isBackChecker());
		reg_next_navLabel.setActualIndex(index);
		reg_back_navLabel.setActualIndex(index);

		switch (index) {
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

	private void setRegData() {
		RegData.setNick(reg_nick_textF.getText());
		RegData.setPass(String.valueOf(reg_password_textF.getPassword()));
		RegData.setNombre(reg_name_textF.getText());
		RegData.setApellidos(reg_apellido_textF.getText());
		RegData.setDni(reg_dni_textF.getText());
		RegData.setEmail(reg_email_textF.getText());
	}

	public Usuario getRegData() {
		setRegData();
		return RegData;
	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * SESION CONTROL
	 */

	public void iniciarSesion(Sesion sesion) {
		sesionActual = sesion;
	}

	public Sesion getSesionActual() {
		return sesionActual;
	}

	public void cambiarVistaSesion(String vista) {
		switch (vista.toLowerCase()) {

		case "invitado":
			alumno.cerrarVistaDeSesion();
			profesor.cerrarVistaDeSesion();
			administrador.cerrarVistaDeSesion();
			desarrollador.cerrarVistaDeSesion();
			// --
			sesionActual = null;
			// --
			displays.mostarDisplay(display_index);
			// --
			invitado.abrirVistaDeSesion();
			break;
		case "alumno":
			invitado.cerrarVistaDeSesion();
			profesor.cerrarVistaDeSesion();
			administrador.cerrarVistaDeSesion();
			desarrollador.cerrarVistaDeSesion();
			actualizarMostraUsuario(sesionActual.getUsuario());
			// --
			alumno.abrirVistaDeSesion();
			break;
		case "profesor":
			invitado.cerrarVistaDeSesion();
			alumno.cerrarVistaDeSesion();
			administrador.cerrarVistaDeSesion();
			desarrollador.cerrarVistaDeSesion();
			// --
			actualizarMostraUsuario(sesionActual.getUsuario());
			entrarComo_alumno_btn_panel.setVisible(true);
			entrarComo_profesor_btn_panel.setVisible(false);
			entrarComo_administrador_btn_panel.setVisible(false);
			// --
			profesor.abrirVistaDeSesion();
			break;
		case "administrador":
			invitado.cerrarVistaDeSesion();
			alumno.cerrarVistaDeSesion();
			profesor.cerrarVistaDeSesion();
			desarrollador.cerrarVistaDeSesion();
			// --
			actualizarMostraUsuario(sesionActual.getUsuario());
			entrarComo_alumno_btn_panel.setVisible(true);
			entrarComo_profesor_btn_panel.setVisible(true);
			entrarComo_administrador_btn_panel.setVisible(false);
			// --
			administrador.abrirVistaDeSesion();

			break;
		case "desarrollador":
			invitado.cerrarVistaDeSesion();
			alumno.cerrarVistaDeSesion();
			profesor.cerrarVistaDeSesion();
			administrador.cerrarVistaDeSesion();
			// --
			actualizarMostraUsuario(sesionActual.getUsuario());
			entrarComo_alumno_btn_panel.setVisible(true);
			entrarComo_profesor_btn_panel.setVisible(true);
			entrarComo_administrador_btn_panel.setVisible(true);
			// --
			desarrollador.abrirVistaDeSesion();
			break;
		}
		hidePopUp();

	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * FRAME CONTROL
	 */

	// Getters
	public JFrame getFrame() {
		return frmHacentest;
	}

	public JButton getFocusFixer() {
		return focusFixer;
	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * GESTORES DE DATOS
	 */

	public void setFocusFixer(JButton focusFixer) {
		this.focusFixer = focusFixer;
	}

	public GestorUsuarios getGestorUsuarios() {
		return gestorUsuarios;
	}

	public GestorSesiones getGestorSesiones() {
		return gestorSesiones;
	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * ACTUALIZAR LISTAS
	 */

	public void actualizarLista(ResultSet rs) {
		ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();
		try {
			while (rs.next()) {
				listaUsers.add(new Usuario(rs));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		listUpdater_verUsuarios.limpiarLista();
		listUpdater_verUsuarios.setLista(listaUsers);
		listUpdater_verUsuarios.cargarLista();
	}

	/*
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	 * ACTUALIZAR USUARIOS
	 */

	public void actualizarMostraUsuario(Usuario usuario) {

		nick_text_mostrarUsuario.setText(usuario.getNick());
		nombre_text_mostrarUsuario.setText(usuario.getNombre());
		apellidos_text_mostrarUsuario.setText(usuario.getApellidos());
		dni_text_mostrarUsuario.setText(usuario.getDni());
		email_text_mostrarUsuario.setText(usuario.getEmail());
		fechar_text_mostrarUsuario.setText(usuario.getFecha_registro().toString());
		acceso_text_mostrarUsuario.setText(usuario.getAcceso());
		estado_text_mostrarUsuario.setText(usuario.getEstado());

		switch (usuario.getAcceso()) {

		case "alumno":
			acceso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/alumno_96px.png")));
			break;
		case "profesor":
			acceso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/profesor_96px.png")));
			break;
		case "administrador":
			acceso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/admin_96px.png")));
			break;
		case "desarrollador":
			acceso_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/dev_96px.png")));
			break;

		}

		switch (usuario.getEstado()) {

		case "online":
			estado_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/online_96px.png")));
			break;
		case "offline":
			estado_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/offline_96px.png")));
			break;
		case "suspendido":
			estado_ico_mostrarUsuario.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/banned_96px.png")));
			break;

		}

		if (sesionActual.getUsuario().getAcceso().equals("administrador")
				|| sesionActual.getUsuario().getAcceso().equals("desarollador")) {
			estadoCambio_panel_mostrarUsuario.setVisible(true);
			accesoCambio_panel_mostrarUsuario.setVisible(true);
		} else {
			estadoCambio_panel_mostrarUsuario.setVisible(false);
			accesoCambio_panel_mostrarUsuario.setVisible(false);
		}

		displays.mostarDisplay(display_mostrarUsuario);

	}
}
