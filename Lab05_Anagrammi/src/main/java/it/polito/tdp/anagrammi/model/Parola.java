package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Parola {
	
	private int id;
	private String nome;
	public Parola(int id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Parola: " + nome;
	}
	
	public List <String> anagrammi (String parola){
		List <String> risultato = new LinkedList <String>();
		permuta("", parola, 0, risultato);
		return risultato;
		
	}
	
	public void permuta(String parziale, String lettere, int livello, List <String> risultato) {
		
		if(lettere.length()==0)
			risultato.add(parziale);
		else {
			for(int i=0; i<lettere.length(); i++) {
				char tentativo =lettere.charAt(i);
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, i)+ lettere.substring(i+1);
				
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato);
			}
		}
		
	}
	

}
