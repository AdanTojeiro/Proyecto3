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
	
	
	
	public boolean isConectada() {
		return conectada;
	}
	
	public boolean conectar() {
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
	
	public void desconectar(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		try {
			if(con.isClosed()) {
				System.out.println("MYSQL: Fin de la conexion.");
				conectada = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//SQL STATEMENTS
	public boolean insertInto(String nombreTabla, String campos, String value) {
		boolean control = false;
		String sql="INSERT INTO "+nombreTabla+" ("+campos+") VALUES ("+value+")";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			int n = stm.executeUpdate();
			if(n > 0 ) {
				control = true;
				System.out.println("MYSQL: Execute Insert( -> "+sql+" <-). Rows afected: "+n);
			}
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		return control;
		
	}
	
	public boolean Update(String nombreTabla, String update, String where) {
		boolean control = false;
		String sql="UPDATE "+nombreTabla+" SET "+update+" WHERE "+where;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			int n = stm.executeUpdate();
			if(n > 0 ) {
				control = true;
				System.out.println("MYSQL: Execute Update( -> "+sql+" <-). Rows afected: "+n);
			}
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		return control;
		
	}
	
	public ResultSet selectFrom(String nombreTabla, String where) {
		ResultSet rs = null;          
		String sql="SELECT * FROM "+nombreTabla+" WHERE "+where;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery(sql);
			System.out.println("MYSQL: Execute Query( -> "+sql+" <-)");
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
			System.out.println("MYSQL: Execute Query( -> "+sql+" <-)");
		} catch (SQLException e) {
			System.err.println("MYSQL: "+e);
		}
		return rs;
	}
	
	public void cerrarConexion() {
		try {
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
}
