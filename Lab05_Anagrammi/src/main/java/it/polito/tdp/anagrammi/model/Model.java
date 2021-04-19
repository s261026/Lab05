package it.polito.tdp.anagrammi.model;

import java.sql.SQLException;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	private ParolaDAO parolaDao;
	
	public Model() {
		parolaDao = new ParolaDAO();
	}
	
/*	public List<Parola> getAnagrammi() {
		return parolaDao.getAnagrammi();
	}*/
	
	public List <String> anagrammate (String parola){
	return parolaDao.anagrammate(parola);
	}
	
	public boolean isCorrect (String p) {
		return parolaDao.isCorrect(p);
	}

}
