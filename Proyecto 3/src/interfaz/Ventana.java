package interfaz;

import java.awt.Color;


import javax.swing.*;

import acceso_a_datos.Checker;
import acceso_a_datos.MysqlC;
import clases.Sesion;
import clases.Usuario;
import controladores.FormBtnListener;
import controladores.FrameDrager;
import controladores.NavLabelListener;
import controladores.OptionListener;
import controladores.TextFieldKeyListener;
import controladores.TextFocusListener;
import controladores.ControlLabelListener;


import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Ventana {
	
	//ACCESO A DATOS INICIO////////////////////////////////////////////////////////////
	private MysqlC mysqlc;
	private Checker checker;
	//ACCESO A DATOS FIN///////////////////////////////////////////////////////////////
	
	//DATOS DE SESION
	private Sesion sesionActual;
	//DATOS DE SESION
	
	//DATA ////////////////////////////////////////////////////////////////////////////
	private Usuario RegData = new Usuario();
	//DATA ////////////////////////////////////////////////////////////////////////////
	
	//GRUPOS INICIO////////////////////////////////////////////////////////////////////
	private ArrayList<JPanelOpt> opciones_index = new ArrayList<JPanelOpt>();
	private ArrayList<JDisplay> grupo_displays = new ArrayList<JDisplay>();
	private ArrayList<JFormDisplay> grupo_reg = new ArrayList<JFormDisplay>();
	//GRUPOS FIN-//////////////////////////////////////////////////////////////////////
	
	//COLORES INICIO///////////////////////////////////////////////////////////////////
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_SELECTED = new Color(85, 65, 118);
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	//COLORES FIN//////////////////////////////////////////////////////////////////////
	
	//COMPONENTES INICIO///////////////////////////////////////////////////////////////
	//Estructura-----------------------------------------------------------------------
	private JFrame frame;
	private JPanel background_panel, side_panel, center_panel;
	private JPopUpPanel popUp_panel;
	//1-Side panel---------------------------------------------------------------------
	private JPanel logo_panel, nav_panel;
	//1.1-Logo panel-------------------------------------------------------------------
	private JLabel logo_imagen, logo_texto;
	//1.2-Nav Panel--------------------------------------------------------------------
	private JPanel index_nav;
	//1.2.1-Index nav------------------------------------------------------------------
	private JPanelOpt opt_login, opt_reg, opt_info, opt_soporte;
	//1.2.1.1-Opt_Login----------------------------------------------------------------
	private JLabel opt_login_ico, opt_login_text;
	//1.2.1.2-Opt_Reg------------------------------------------------------------------
	private JLabel  opt_reg_ico, opt_reg_text;
	//1.2.1.3-Opt_Info-----------------------------------------------------------------
	private JLabel opt_info_ico, opt_info_text;
	//1.2.1.4-Opt_Soporte--------------------------------------------------------------
	private JLabel opt_soporte_ico, opt_soporte_text;
	//2-Center panel-------------------------------------------------------------------
	private JPanel titulo_panel, display_panel;
	//2.1-Titulo panel-----------------------------------------------------------------
	private JLabelControl close_lbl, minimize_lbl;
	private JLabel titulo_ico, titulo_text;
	private JSeparator separador_titulo;
	//2.2-Displays----------------------------------------------------------------------
	private JDisplay display_index, display_login, display_reg, display_info, display_soporte;
	//2.2.1-Index display---------------------------------------------------------------
	private JLabel mensaje_index;
	//2.2.2-Login display---------------------------------------------------------------
	private JPanel login_password_panel, login_nick_panel;
	private JLabel imagen_central_login;
	private JFormBtn login_iniciar_FormBtn;
	private JLabel login_iniciar_formBtn_text;
	//2.2.2.1-Login_nick_panel----------------------------------------------------------
	private JPanel login_nick_info_panel;
	private JLabel login_nick_icon,login_nick_info_ico, login_nick_info_text;
	private JTextField login_nick_textF;
	private JSeparator login_nick_separator;
	//2.2.2.2-Login_pass_panel----------------------------------------------------------
	private JPanel login_password_info_panel;
	private JLabel login_password_icon, login_password_info_ico, login_password_info_text;
	private JPasswordField login_password_textF;
	private JSeparator login_password_separator;
	//2.2.3-Reg display-----------------------------------------------------------------
	private JPanel reg_stepbar_panel;
	private JFormDisplay reg_form_step_1_panel, reg_form_step_2_panel, reg_form_step_3_panel;
	private NavLabel reg_next_navLabel, reg_back_navLabel;
	private JLabel reg_form_ico, reg_form_titulo;
	private JSeparator reg_form_separator;
	//2.2.3.1-Stepbar-------------------------------------------------------------------
	private JSeparator reg_stepbar_1_to_2_separator, reg_stepbar_2_to_3_separator;
	private JLabel reg_stepbar_1_ico, reg_stepbar_2_ico, reg_stepbar_3_ico, reg_stepbar_1_arrow_ico, reg_stepbar_2_arrow_ico, reg_stepbar_3_arrow_ico;
	//2.2.3.2-Form 1--------------------------------------------------------------------
	private JPanel reg_nick_panel, reg_password_panel, reg_password_check_panel;
	//2.2.3.2.1-Nick panel--------------------------------------------------------------
	private JSeparator reg_nick_separator;
	private JLabel reg_nick_ico, reg_nick_info_ico, reg_nick_info_text;
	private JTextField reg_nick_textF;
	private JPanel reg_nick_info_panel;
	//2.2.3.2.2-Password panel----------------------------------------------------------
	private JSeparator reg_password_separator;
	private JLabel reg_password_ico, reg_password_info_ico, reg_password_info_text;
	private JPasswordField reg_password_textF;
	private JPanel reg_password_info_panel;
	//2.2.3.2.3-Password check panel----------------------------------------------------
	private JPanel reg_password_check_info_panel;
	private JSeparator reg_password_check_separator;
	private JLabel reg_password_check_ico, reg_password_check_info_ico, reg_password_check_info_text;
	private JPasswordField reg_password_check_textF;
	//2.2.3.3-Form 2--------------------------------------------------------------------
	private JPanel reg_name_panel, reg_apellido_panel, reg_dni_panel;
	//2.2.3.3.1-Name panel--------------------------------------------------------------
	private JPanel reg_name_info_panel;
	private JSeparator reg_name_separator;
	private JLabel reg_name_ico, reg_name_info_ico, reg_name_info_text;
	private JTextField reg_name_textF;	
	//2.2.3.3.2-Apellido panel----------------------------------------------------------
	private JPanel reg_apellido_info_panel;
	private JSeparator reg_apellido_separator;
	private JLabel reg_apellido_ico, reg_apellido_info_ico, reg_apellido_info_text;
	private JTextField reg_apellido_textF;
	//2.2.3.3.3-DNI panel---------------------------------------------------------------
	private JPanel reg_dni_info_panel;
	private JSeparator reg_dni_separator;
	private JLabel reg_dni_ico, reg_dni_info_ico, reg_dni_info_text;
	private JTextField reg_dni_textF;
	//2.2.3.3-Form 3--------------------------------------------------------------------
	private JPanel reg_email_panel;
	//2.2.3.3.1-Email panel
	private JPanel reg_email_info_panel;
	private JSeparator reg_email_separator;
	private JLabel reg_email_ico, reg_email_info_ico, reg_email_info_text;
	private JTextField reg_email_textF;
	//2.2.3.3.2-Confirmar Button
	private JFormBtn reg_confirmar_FormBtn;
	private JLabel reg_confirmar_formBtn_text;
	//2.2.4-Info display----------------------------------------------------------------
	//2.2.5-Soporte display-------------------------------------------------------------
	//3-PopUp Panel---------------------------------------------------------------------
	private JLabel popUp_ico, popUp_text;
	private JLabelControl popUp_salir_labelControl;
	//COMPONENTES FIN///////////////////////////////////////////////////////////////////
	
	//COMPONENTES LOGICOS///////////////////////////////////////////////////////////////
	//-Formulario Login-----------------------------------------------------------------
	private ArrayList<TextFieldGroup> login_grupo_logico = new ArrayList<TextFieldGroup>();
	private TextFieldGroup login_nick_tfg;
	private TextFieldGroup login_password_tfg;
	//-Formulario registro--------------------------------------------------------------
	private ArrayList<TextFieldGroup> reg_grupo_logico = new ArrayList<TextFieldGroup>();
	private TextFieldGroup reg_nick_tfg, reg_password_tfg, reg_name_tfg, reg_apellido_tfg, reg_dni_tfg, reg_email_tfg;
	private TextFieldGroup reg_password_check_tfg;
	//COMPONENTES LOGICOS///////////////////////////////////////////////////////////////
	
	public Ventana() {
		mysqlc = new MysqlC();
		checker = new Checker(mysqlc);
		initialize();
	}
	public MysqlC getMysqlc() {
		return mysqlc;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	//Inicializacion de componentes
	private void initialize() {
	
		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		FrameDrager drager = new FrameDrager(frame);
		frame.addMouseListener(drager);
		frame.addMouseMotionListener(drager);
		
		
		//PopUp Panel
		popUp_panel = new JPopUpPanel();
		popUp_panel.setBounds(5, 540, 290, 150);
		frame.getContentPane().add(popUp_panel);
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
		
		popUp_salir_labelControl = new JLabelControl(2, "/imagenes/salir_black_16px.png", "/imagenes/salir_16px.png");
		popUp_salir_labelControl.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/salir_black_16px.png")));
		popUp_salir_labelControl.setBounds(256, 13, 16, 16);
		popUp_panel.add(popUp_salir_labelControl);
		popUp_salir_labelControl.addMouseListener(new ControlLabelListener(popUp_salir_labelControl, this));
		
		popUp_panel.setIco(popUp_ico);
		popUp_panel.setText(popUp_text);
		popUp_panel.setControl(popUp_salir_labelControl);

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
		close_lbl.addMouseListener(new ControlLabelListener(close_lbl, this));

		minimize_lbl = new JLabelControl(1, "/imagenes/minimizar_32px.png", "/imagenes/minimizar_hover_32px.png");
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

		// --> Display Reg
		display_reg = new JDisplay("Crear una cuenta", "/imagenes/reg_96px.png", grupo_displays);
		display_reg.setBounds(0, 0, 800, 552);
		display_panel.add(display_reg);
		display_reg.setLayout(null);
		display_reg.setOpaque(false);
		display_reg.setVisible(false);
		
		//Reg Stepbar
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
		
		//Reg form 1
		
		reg_form_step_1_panel = new JFormDisplay("Datos de la cuenta", "/imagenes/user_info_64px.png", grupo_reg, 1, false, true);
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
		
		//Reg form 2
		
		reg_form_step_2_panel = new JFormDisplay("Datos del usuario", "/imagenes/user_info_64px.png", grupo_reg, 2, true, true);
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
				
		//Reg form 3
				
		reg_form_step_3_panel = new JFormDisplay("Confirmar datos", "/imagenes/user_info_64px.png", grupo_reg, 3, true, false);
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
		
		//Reg Nav labels
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
		reg_back_navLabel.setVisible(false);
		
		//Reg tittle
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
		
		//Componentes logicos formulario Login
		login_nick_tfg = new TextFieldGroup(login_nick_panel, login_nick_info_panel, login_nick_icon, login_nick_info_ico, login_nick_info_text,
				login_nick_textF,  login_nick_separator, "flex_key", login_grupo_logico);
		login_password_tfg = new TextFieldGroupRel(login_password_panel, login_password_info_panel, login_password_icon, login_password_info_ico, login_password_info_text,
				login_password_textF,  login_password_separator, login_grupo_logico, login_nick_tfg, "correspondencia");
		
		
		
		login_nick_textF.addKeyListener(new TextFieldKeyListener(login_nick_tfg, checker));
		login_password_textF.addKeyListener(new TextFieldKeyListener(login_password_tfg, checker));
		login_nick_textF.addKeyListener(new TextFieldKeyListener(login_password_tfg, checker));
		
		login_nick_textF.addFocusListener(new TextFocusListener(login_nick_tfg, checker));
		login_password_textF.addFocusListener(new TextFocusListener(login_password_tfg, checker));
		
		
		//Componentes logicos formulario Registro
		reg_nick_tfg = new TextFieldGroup(reg_nick_panel, reg_nick_info_panel, reg_nick_ico, reg_nick_info_ico, reg_nick_info_text,
				reg_nick_textF,  reg_nick_separator, "flex", reg_grupo_logico);
		reg_password_tfg = new TextFieldGroup(reg_password_panel, reg_password_info_panel, reg_password_ico, reg_password_info_ico, reg_password_info_text,
				reg_password_textF,  reg_password_separator, "pass", reg_grupo_logico);
		reg_name_tfg = new TextFieldGroup(reg_name_panel, reg_name_info_panel, reg_name_ico, reg_name_info_ico, reg_name_info_text,
				reg_name_textF,  reg_name_separator, "strict", reg_grupo_logico);
		reg_apellido_tfg = new TextFieldGroup(reg_apellido_panel, reg_apellido_info_panel, reg_apellido_ico, reg_apellido_info_ico, reg_apellido_info_text,
				reg_apellido_textF,  reg_apellido_separator, "strict2", reg_grupo_logico);
		reg_dni_tfg = new TextFieldGroup(reg_dni_panel, reg_dni_info_panel, reg_dni_ico, reg_dni_info_ico, reg_dni_info_text,
				reg_dni_textF,  reg_dni_separator, "dni", reg_grupo_logico);
		reg_email_tfg = new TextFieldGroup(reg_email_panel, reg_email_info_panel, reg_email_ico, reg_email_info_ico, reg_email_info_text,
				reg_email_textF,  reg_email_separator, "email", reg_grupo_logico);
		
		reg_password_check_tfg = new TextFieldGroupRel(reg_password_check_panel, reg_password_check_info_panel, reg_password_check_ico, reg_password_check_info_ico, reg_password_check_info_text,
				reg_password_check_textF,  reg_password_check_separator, reg_grupo_logico, reg_password_tfg, "similitud");
		
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
		
		//final
		if(!mysqlc.Conectar()) {
			this.showPopUp("mysqlerror");
			
		}


	}
	//PopUp control
	
	public void showPopUp(String type) {
		
		switch(type){
		case "mysqlerror":
			
			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>MYSQL: No se ha podido establecer la conexion con la base de datos</HTML>", "/imagenes/error_black_96px.png");
			break;
		
		case "useronline":
			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>El usuario con el que intentas inciar sesion esta: <b>ONLINE</b></HTML>", "/imagenes/error_black_96px.png");
			break;
		
		case "usersuspend":
			popUp_panel.errorStyle();
			popUp_panel.showPanel("<HTML>El usuario con el que intentas inciar sesion esta: <b>SUSPENDIDO</b></HTML>", "/imagenes/error_black_96px.png");
			break;
			
		case "regcomplete":
			
			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Cuenta creada con exito. Inicia sesion para disfrutar de la aplicacion</HTML>", "/imagenes/reg_96px.png");
			break;
		case "logincomplete":
			
			popUp_panel.infoStyle();
			popUp_panel.showPanel("<HTML>Sesion inciada con exito. Bienvenid@ "+sesionActual.getUsuario().getNick()+"</HTML>", "/imagenes/user_96px.png");
			break;	
		}
		
	}
	public void hidePopUp() {
		
		popUp_panel.setVisible(false);
		
	}

	//Display Setters
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
	
	public void setDisplay(JDisplay display, ArrayList<JDisplay> grupo, String option) {
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
		switch(option) {
		case "login":
			opt_login.setSelected(true);
			opt_reg.setSelected(false);
			opt_info.setSelected(false);
		}
	}
	
	public void resetRegForm(){
		reg_nick_tfg.reset();
		reg_password_tfg.reset();
		reg_name_tfg.reset();
		reg_apellido_tfg.reset();
		reg_dni_tfg.reset();
		reg_email_tfg.reset();
		reg_password_check_tfg.reset();
	}
	
	public void setRegDisplay(int index, String function) throws java.awt.IllegalComponentStateException  {
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
		reg_form_ico.setIcon(new ImageIcon(Ventana.class.getResource(selected.getIcoPath())));
		reg_form_titulo.setText(selected.getTitulo());
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
	
	//Sesion
	public void iniciarSesion(Sesion sesion) {
		sesionActual = sesion;
		
	}
	
	public Sesion getSesionActual() {
		return sesionActual;
	}
	
	public ResultSet getLoginResultSet() {
		ResultSet rs = mysqlc.selectFrom("usuario", "nick='"+login_nick_textF.getText()+"'");
		return rs;
	}
	//Data setters
	public void setRegData() {
		RegData.setNick(reg_nick_textF.getText());
		RegData.setPass(String.valueOf(reg_password_textF.getPassword()));
		RegData.setNombre(reg_name_textF.getText());
		RegData.setApellidos(reg_apellido_textF.getText());
		RegData.setDni(reg_dni_textF.getText());
		RegData.setEmail(reg_email_textF.getText());
	}
	//Set visible principal
	public void setVisible(boolean b) {
		frame.setVisible(true);

	}
	
	//Getters
	public JFrame getFrame() {
		return frame;
	}
	//Data getters
	public Usuario getRegData(){
			return RegData;
		}
		
	public void setFrame(JFrame frame) {
			this.frame = frame;
		}
	//displays
	public JDisplay getDisplay_index() {
		return display_index;
	}

	public JDisplay getDisplay_login() {
		return display_login;
	}

	public JDisplay getDisplay_reg() {
		return display_reg;
	}

	public JDisplay getDisplay_info() {
		return display_info;
	}

	public JDisplay getDisplay_soporte() {
		return display_soporte;
	}
}
