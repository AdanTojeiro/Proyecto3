package acceso_a_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlC {

	private static Connection con;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/hacentest";
	private static  boolean conectada = false;
	
	
	
	public boolean Conectar() {
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
		return conectada;
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
				System.out.println("MYSQL: Registro guardado con exito. "+n+" rows afected.");
			}
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		
	}
	
	public void Update(String nombreTabla, String update, String where) {
		String sql="UPDATE "+nombreTabla+" SET "+update+" WHERE "+where;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			int n = stm.executeUpdate();
			if(n > 0 ) {
				System.out.println("MYSQL: Registro actualizado con exito. "+n+" rows afected.");
			}
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		
	}
	
	public ResultSet selectFrom(String nombreTabla, String where) {
		ResultSet rs = null;          
		String sql="SELECT * FROM "+nombreTabla+" WHERE "+where;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		return rs;
	}
	
	public ResultSet selectFrom(String nombreTabla) {
		ResultSet rs = null;          
		String sql="SELECT * FROM "+nombreTabla;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		return rs;
	}
	

	
	
	
}
