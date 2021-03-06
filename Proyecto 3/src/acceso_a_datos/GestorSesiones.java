package acceso_a_datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import clases.Sesion;

public class GestorSesiones {

	private MysqlC mysqlc;
	GestorUsuarios gestorUsuarios;

	public GestorSesiones(MysqlC mysqlc, GestorUsuarios gestorUsuarios) {
		super();
		this.mysqlc = mysqlc;
		this.gestorUsuarios = gestorUsuarios;
	}

	public ResultSet getAllSesions() {
		ResultSet rs = null;
		if (mysqlc.isConectada()) {
			// Cumple formato
			rs = mysqlc.selectFrom("sesion");
		}
		return rs;

	}

	public Sesion abrirSesion(ResultSet rs) {
		Sesion sesion = null;

		sesion = new Sesion(rs, generarCodigo(getAllSesions()));
		if (mysqlc.isConectada()) {
			mysqlc.insertInto("sesion", "codigo, tiempo_inicio, fk_usuario",
					"'" + sesion.getCodigo() + "', CURRENT_TIMESTAMP() , " + sesion.getUsuario().getPk_usuario());
		}
		return sesion;
	}
	
	public void cerrarSesion(Sesion sesion) {
		if (mysqlc.isConectada()) {
			mysqlc.Update("sesion", "tiempo_inicio = tiempo_inicio, tiempo_final= CURRENT_TIMESTAMP()", "codigo='"+sesion.getCodigo()+"'");
			String where = "nick='"+sesion.getUsuario().getNick()+"'";
			gestorUsuarios.actualizarEstadoUsuario("offline", where);
		}
	}

	public String generarCodigo(ResultSet rs) {
		boolean seguir = true;
		String codigo = "";
		while (seguir) {
			seguir = false;
			codigo = randomCodigo();
			try {
				rs.beforeFirst();
				while (rs.next()) {
					if (codigo.equals(rs.getString("codigo"))) {
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

	private String randomCodigo() {
		Random rng = new Random();
		String codigo = "@";
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

}
