package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {

	/*public static List<Parola> getAnagrammi() {
		String sql = "SELECT * FROM parola p WHERE p.id < '3' ";
		List<Parola> parole = new LinkedList<Parola>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");

				Parola p = new Parola(id, nome);
				parole.add(p);
			}
			conn.close();
			rs.close();
			st.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return parole;
	}*/
	
	public List <String> anagrammate (String parola){
		
		Parola p = new Parola (0, parola);
		List <String> fatte = p.anagrammi(parola);
		return fatte;
		
	}
	
	
	public boolean isCorrect (String p) {
		boolean corretto=false;
		
		String sql =" SELECT p.id, p.nome "
				+ "FROM parola p "
				+ "WHERE p.nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, p);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				Parola pp = new Parola(id, nome);
				if(pp.getNome().equals(p))
					corretto = true;
			}
			conn.close();
			rs.close();
			st.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	return corretto;
	}
}
