package acceso_a_datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Usuario;

public class GestorUsuarios {
	
	private MysqlC mysqlc;
	
	 public GestorUsuarios(MysqlC mysqlc) {
		super();
		this.mysqlc = mysqlc;
	}

	public boolean registarUsuario(Usuario usuario) {
		 boolean control = false;
		 if(mysqlc.conectar()) {
			Encriptador enc = new Encriptador();
			Date fecha = new Date(new java.util.Date().getTime());
			String nombreTabla = "usuario";
			String campos = "nick, pass, nombre, apellidos, dni, email, fecha_registro";
			String value = "'"+usuario.getNick()+"', '"+enc.encriptarMD5(usuario.getPass())+"', '"+usuario.getNombre()+"', '"+usuario.getApellidos()+"', '"+usuario.getDni()+"', '"+usuario.getEmail()+"', '"+fecha+"'";
			 if(mysqlc.insertInto(nombreTabla, campos, value)){
				 control = true;
			 }
		 }
		 mysqlc.desconectar();
		 return control;
			
	 }
	
	public boolean actualizarEstadoUsuario(String estado, String where) {
		 boolean control = false;
		 if(mysqlc.conectar()) {
			 if(mysqlc.Update("usuario", "estado='"+estado+"'", where)){
				 control = true;
			 }
		 }
		 mysqlc.desconectar();
		 return control;
			
	 }
	 
	 public boolean buscarUsuarioExacto(String campo, String value) {
		 boolean control = false;
		 if(mysqlc.conectar()) {
			// Cumple formato
				ResultSet rs = mysqlc.selectFrom("usuario"," "+campo+"='" + value + "'");
				try {
					if (rs.next()) {
						control = true;
					} 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		 }
		 mysqlc.desconectar();
		 return control;
			
	 }
	 
	 public ResultSet getUsuario(String campo, String value) {
		 ResultSet rs = null;
		 if(mysqlc.conectar()) {
			// Cumple formato
				rs = mysqlc.selectFrom("usuario"," "+campo+"='" + value + "'");
		 }
		 mysqlc.desconectar();
		 return rs;
			
	 }
	 
	 public String getPassword(String campo, String value) {
		 String pass = "";
		 if(mysqlc.conectar()) {
			 ResultSet rs = mysqlc.selectFrom("usuario"," "+campo+"='" + value + "'");
				try {
					if(rs.next()) {
					pass = rs.getString("pass");	
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 mysqlc.desconectar();
		 return pass;
	 }
	 
	 

}
