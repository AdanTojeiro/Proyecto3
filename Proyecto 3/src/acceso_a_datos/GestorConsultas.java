package acceso_a_datos;

import java.sql.ResultSet;

import clases.Consulta;

public class GestorConsultas {
	
	private MysqlC mysqlc;
	
	public GestorConsultas(MysqlC mysqlc) {
		super();
		this.mysqlc = mysqlc;
	}

	public boolean generarConsulta(Consulta consulta) {
		boolean control = false;
		if (mysqlc.isConectada()) {
			String nombreTabla = "consulta";
			String campos = "fecha, asunto, descripcion, fk_usuario";
			String value = "CURRENT_TIMESTAMP(), '"+consulta.getAsunto()+"', '"+consulta.getDescripcion()+"',"+consulta.getUsuario().getPk_usuario();
			if(mysqlc.insertInto(nombreTabla, campos, value)){
				 control = true;
			 }
		}
		return control;
	}
	
	public boolean generarConsultaInvitado(Consulta consulta) {
		boolean control = false;
		if (mysqlc.isConectada()) {
			String nombreTabla = "consulta";
			String campos = "fecha, asunto, descripcion, fk_usuario";
			String value = "CURRENT_TIMESTAMP(), '"+consulta.getAsunto()+"', '"+consulta.getDescripcion()+"', 1";
			if(mysqlc.insertInto(nombreTabla, campos, value)){
				 control = true;
			 }
		}
		return control;
	}
	
	public ResultSet getConsultaFilter(String value) {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("consulta inner join usuario on consulta.fk_usuario=usuario.pk_usuario","nick LIKE '%"+value+"%' OR fecha LIKE '%"+value+"%' OR acceso LIKE '%"+value+"%'OR asunto LIKE '%"+value+"%'");
		 }
		 return rs;
			
	 }
	
	public ResultSet getConsulta(String value) {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("consulta inner join usuario on consulta.fk_usuario=usuario.pk_usuario", value);
		 }
		 return rs;
			
	 }
	
	public ResultSet getAllConsultas() {
		 ResultSet rs = null;
		 if(mysqlc.isConectada()) {
			// Cumple formato
				rs = mysqlc.selectFrom("consulta inner join usuario on consulta.fk_usuario=usuario.pk_usuario");
		 }
		 return rs;
			
	 }

}
