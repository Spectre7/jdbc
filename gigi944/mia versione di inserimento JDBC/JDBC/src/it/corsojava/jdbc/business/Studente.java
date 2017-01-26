package it.corsojava.jdbc.business;

public class Studente {
	String nome;
	String cognome;
	String telefono;
	
	public Studente(String nome, String cognome, String telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
	
}
