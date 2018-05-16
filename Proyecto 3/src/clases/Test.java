package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Test {
	
	int pk_test;
	Usuario usuario;
	Timestamp tiempo_inicio, tiempo_final;
	String codigo_test;
	ArrayList<Enunciada> enunciadas;
	
	public Test(Usuario usuario, Timestamp tiempo_inicio, Timestamp tiempo_final) {
		super();
		this.usuario = usuario;
		this.tiempo_inicio = tiempo_inicio;
		this.tiempo_final = tiempo_final;
	}
	
	public Test(ResultSet rs) {
		enunciadas = new ArrayList<Enunciada>();
		try {
			pk_test= rs.getInt("pk_test");
			tiempo_inicio = rs.getTimestamp("tiempo_inicio");
			tiempo_final = rs.getTimestamp("tiempo_final");
			codigo_test = rs.getString("codigo_test");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getPk_test() {
		return pk_test;
	}

	public void setPk_test(int pk_test) {
		this.pk_test = pk_test;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Timestamp getTiempo_inicio() {
		return tiempo_inicio;
	}

	public void setTiempo_inicio(Timestamp tiempo_inicio) {
		this.tiempo_inicio = tiempo_inicio;
	}

	public Timestamp getTiempo_final() {
		return tiempo_final;
	}

	public void setTiempo_final(Timestamp tiempo_final) {
		this.tiempo_final = tiempo_final;
	}

	public ArrayList<Enunciada> getEnunciadas() {
		return enunciadas;
	}

	public void setEnunciadas(ArrayList<Enunciada> enunciadas) {
		this.enunciadas = enunciadas;
	}
	
	
	
	
	

}
