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
		 if(mysqlc.isConectada()) {
			Encriptador enc = new Encriptador();
			Date fecha = new Date(new java.util.Date().getTime());
			String nombreTabla = "usuario";
			String campos = "nick, pass, nombre, apellidos, dni, email, fecha_registro";
			String value = "'"+usuario.getNick()+"', '"+enc.encriptarMD5(usuario.getPass())+"', '"+usuario.getNombre()+"', '"+usuario.getApellidos()+"', '"+usuario.getDni()+"', '"+usuario.getEmail()+"', '"+fecha+"'";
			 if(mysqlc.insertInto(nombreTabla, campos, value)){
				 control = true;
			 }
		 }
		 return control;
			
	 }
	
	public boolean actualizarEstadoUsuario(String estado, String where) {
		 boolean control = false;
		 if(mysqlc.isConectada()) {
			 if(mysqlc.Update("usuario", "estado='"+estado+"'", where)){
				 control = true;
			 }
		 }
		 return control;
			
	 }
	 
	 public boolean buscarUsuarioExacto(String campo, String value) {
		 boolean control = false;
		 if(mysqlc.isConectada()) {
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
		 return control;
			
	 }
	 
	 public ResultSet getUsuarioFilter(String value) {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("usuario","(nick LIKE '%"+value+"%' OR dni LIKE '%"+value+"%' OR estado LIKE '%"+value+"%'OR acceso LIKE '%"+value+"%') AND pk_usuario > 1");
		 }
		 return rs;
			
	 }
	 
	 public ResultSet getUsuario(String campo, String value) {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("usuario"," "+campo+"='" + value + "'");
		 }
		 return rs;
			
	 }
	 
	 public ResultSet getAllUsuarios() {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("usuario", "pk_usuario > 1");
		 }
		 return rs;
			
	 }
	 
	 public String getPassword(String campo, String value) {
		 String pass = "";
		 if(mysqlc.isConectada()) {
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
		 return pass;
	 }
	 
	 

}
