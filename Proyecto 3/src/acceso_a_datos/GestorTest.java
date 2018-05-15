package acceso_a_datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Pregunta;
import clases.Respuesta;

public class GestorTest {
	
	private MysqlC mysqlc;
	
	public GestorTest(MysqlC mysqlc) {
		this.mysqlc = mysqlc;
	}

	public boolean añadirPregunta(Pregunta pregunta) {
		 boolean control = false;
		 if(mysqlc.conectar()) {
			String nombreTabla = "pregunta";
			String campos = "enunciado, indice_correcto";
			String value = "'"+pregunta.getEnunciado()+"', '"+pregunta.getIndiceCorrecto()+"'";
			 if(mysqlc.insertInto(nombreTabla, campos, value)){
				 ResultSet rs = getPregunta("enunciado", pregunta.getEnunciado());
				 Respuesta[] respuestas = pregunta.getRespuestas(); 
				 try {
					if(rs.next()) {
						 int fk_pregunta = rs.getInt("pk_pregunta");
						 
						 for(int y = 0; y < respuestas.length; y++) {
							 respuestas[y].setFk_pregunta(fk_pregunta);
						 }
						 
						 int i = 0;
						
						 while(i < respuestas.length && añadirRespuesta(respuestas[i])) {
							 i++;
						 }
						
						 if(i == respuestas.length) {
							 control=true;
						 }
						 
						 
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
		 }
		 mysqlc.desconectar();
		
		 }
		 return control;
	}
	
	private boolean añadirRespuesta(Respuesta respuesta) {
		 boolean control = false;
		 if(mysqlc.conectar()) {
			String nombreTabla = "respuesta";
			String campos = "texto, indice, fk_pregunta";
			String value = "'"+respuesta.getTexto()+"', '"+respuesta.getIndice()+"', "+respuesta.getFk_pregunta();
			 if(mysqlc.insertInto(nombreTabla, campos, value)){
				 control = true;
			 }
		 }
		 mysqlc.desconectar();
		 return control;
	}
	
	 public ResultSet getPregunta(String campo, String value) {
		 ResultSet rs = null;
		 if(mysqlc.conectar()) {
			// Cumple formato
				rs = mysqlc.selectFrom("pregunta"," "+campo+"='" + value + "'");
		 }
		 mysqlc.desconectar();
		 return rs;
			
	 }

}
