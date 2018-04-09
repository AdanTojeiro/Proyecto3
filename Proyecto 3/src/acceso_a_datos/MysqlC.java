package acceso_a_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlC {

	private static Connection con;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/hacentest";
	private static  boolean conectada = false;
	
	
	
	public void Conectar() {
		con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			if(con != null) {
				System.out.println("MYSQL: Conexion establecida.");
				conectada = true;
			}
		} catch(ClassNotFoundException | SQLException e) {
			System.err.println("MYSQL: "+e+".");
		}
	}
	
	public boolean CheckMysqlC() {
		boolean control = false;
		con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			if(con != null) {
				System.out.println("MYSQL: Todos los datos correctos.");
				con = null;
			}
		} catch(ClassNotFoundException | SQLException e) {
			System.err.println("MYSQL: "+e+".");
		}
		return control;
	}
	
	public static void Desconectar() {
		con = null;
		if(con == null) {
			System.out.println("MYSQL: Fin de la conexion.");
			conectada = false;
		}
	}
	
	public Connection getCon() {
		return con;
	}

	public boolean isConectada() {
		return conectada;
	}
	//SQL STATEMENTS
	public void insertInto(String nombreTabla, String campos, String value) {
		String sql="INSERT INTO "+nombreTabla+" ("+campos+") VALUES ("+value+")";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			int n = stm.executeUpdate();
			if(n > 0 ) {
				System.out.println("MYSQL: Registro guardado con exito."+n+" rows afected.");
			}
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		
	}

	
	
	
}
