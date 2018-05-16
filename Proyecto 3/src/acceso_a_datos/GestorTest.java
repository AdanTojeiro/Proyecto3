package acceso_a_datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import clases.Pregunta;
import clases.Respuesta;
import clases.Test;
import clases.Usuario;

public class GestorTest {

	private MysqlC mysqlc;

	public GestorTest(MysqlC mysqlc) {
		this.mysqlc = mysqlc;
	}

	public boolean añadirPregunta(Pregunta pregunta) {
		boolean control = false;
		String codigo_pregunta = generarCodigo(getAllPreguntas(), '#', "codigo_pregunta");
		if (mysqlc.isConectada()) {
			String nombreTabla = "pregunta";
			String campos = "enunciado, indice_correcto, codigo_pregunta";
			String value = "'" + pregunta.getEnunciado() + "', '" + pregunta.getIndiceCorrecto() + "', '"
					+ codigo_pregunta + "'";
			if (mysqlc.insertInto(nombreTabla, campos, value)) {
				ResultSet rs = getPregunta("codigo_pregunta", codigo_pregunta);
				Respuesta[] respuestas = pregunta.getRespuestas();
				try {
					if (rs.next()) {
						int fk_pregunta = rs.getInt("pk_pregunta");

						for (int y = 0; y < respuestas.length; y++) {
							respuestas[y].setFk_pregunta(fk_pregunta);
						}

						int i = 0;

						while (i < respuestas.length && añadirRespuesta(respuestas[i])) {
							i++;
						}

						if (i == respuestas.length) {
							control = true;
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return control;
	}

	private boolean añadirRespuesta(Respuesta respuesta) {
		boolean control = false;
		if (mysqlc.isConectada()) {
			String nombreTabla = "respuesta";
			String campos = "texto, indice, fk_pregunta";
			String value = "'" + respuesta.getTexto() + "', '" + respuesta.getIndice() + "', "
					+ respuesta.getFk_pregunta();
			if (mysqlc.insertInto(nombreTabla, campos, value)) {
				control = true;
			}
		}
		return control;
	}

	public ResultSet getPregunta(String campo, String value) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("pregunta", " " + campo + "='" + value + "'");
		}
		return rs;

	}

	public ResultSet getAllPreguntas() {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("pregunta");
		}
		return rs;

	}
	
	public ResultSet getAllTest() {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("test");
		}
		return rs;

	}

	public String generarCodigo(ResultSet rs, char identificador, String campo) {
		boolean seguir = true;
		String codigo = "";
		while (seguir) {
			seguir = false;
			codigo = randomCodigo(identificador);
			try {
				rs.beforeFirst();
				while (rs.next()) {
					if (codigo.equals(rs.getString(campo))) {
						seguir = true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return codigo;
	}

	private String randomCodigo(char identificador) {
		Random rng = new Random();
		String codigo = ""+identificador;
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'k', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z' };
		char c;
		int n;
		while (codigo.length() < 15) {
			c = letras[rng.nextInt(letras.length)];
			n = numeros[rng.nextInt(numeros.length)];
			codigo = codigo + c + n;
		}
		return codigo;
	}
	
	
	
	public ResultSet getTest(String campo, String value) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("test", " " + campo + "='" + value + "'");
		}
		return rs;

	}
	
	public ResultSet getEnunciada(String campo, String value) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("enuncian", " " + campo + "='" + value + "'");
		}
		return rs;

	}
	
	public ResultSet getRespuesta(String where) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("respuesta", where);
		}
		return rs;

	}
	
	public ResultSet getTest(String where) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("test", where);
		}
		return rs;

	}
	
	public ResultSet getPregunta(String campo, String value, String modificador) {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("pregunta", " " + campo + " " + modificador +" "+ value);
		}
		return rs;

	}
	
	
	public Pregunta getPreguntaDisponible(Test test) {
		Pregunta pregunta = null;
		ResultSet rs = getPregunta("pk_pregunta", "(SELECT enuncian.fk_pregunta FROM enuncian WHERE fk_test="+test.getPk_test()+")", "NOT IN");
		try {
			if(rs.next()) {
				Random rng = new Random();
				int nIteraciones = rng.nextInt(100);
				int contador = 0;
				
				while(contador < nIteraciones) {
					if(rs.next()) {
						contador++;
					}else {
						rs.beforeFirst();
						if(rs.next()) {
							contador++;
						}
					}
					
				}
				pregunta = new Pregunta(rs);
				Respuesta ra = null;
				Respuesta rb = null;
				Respuesta rc = null;
				ResultSet rsa = getRespuesta("fk_pregunta="+pregunta.getPk_pregunta()+" AND indice ='a'");
				ResultSet rsb = getRespuesta("fk_pregunta="+pregunta.getPk_pregunta()+" AND indice ='b'");
				ResultSet rsc = getRespuesta("fk_pregunta="+pregunta.getPk_pregunta()+" AND indice ='c'");
				if (rsa.next()) {
					ra = new Respuesta(rsa);
				}
				if (rsb.next()) {
					rb = new Respuesta(rsb);
				}
				if (rsc.next()) {
					rc = new Respuesta(rsc);
				}
				Respuesta[] respuestas = {ra, rb, rc};
				pregunta.setRespuestas(respuestas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pregunta;
	}
	
	public Test empezarTest(Usuario usuario) {
		Test test = null;
		String codigo_test = generarCodigo(getAllTest(),'$', "codigo_test");
		
		if(mysqlc.isConectada()) {
			String nombreTabla = "test";
			String campos = "fk_usuario, codigo_test";
			String value = usuario.getPk_usuario()+", '"+codigo_test+"'";;
			mysqlc.insertInto(nombreTabla, campos, value);
					
		}
			
		
		ResultSet rs = getTest("codigo_test='"+codigo_test+"'");
		try {
			if(rs.next()) {
				test = new Test(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return test;
	}
	
	public void añadirEnunciada(Test test, Pregunta pregunta, char indice, boolean correcto) {
		
		if(mysqlc.isConectada()) {
			String nombreTabla = "enuncian";
			String campos = "fk_test, fk_pregunta, respuesta, correcto";
			String value = test.getPk_test()+","+pregunta.getPk_pregunta()+", '"+indice+"', "+correcto;
			mysqlc.insertInto(nombreTabla, campos, value);
				
		}
		
	}

}
