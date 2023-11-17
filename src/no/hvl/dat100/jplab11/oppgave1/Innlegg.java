package no.hvl.dat100.jplab11.oppgave1;

import java.sql.Date;

import javax.management.loading.PrivateClassLoader;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {
	
	// TODO - deklarering av objektvariable
	private int id;
	private String bruker;
	private String dato;
	private int antallLikes;
	
	public Innlegg() {
		
		this.id = 0;
		this.bruker = "";
		this.dato = "";
		this.antallLikes = 0;
	}
	
	public Innlegg(int id, String bruker, String dato) {

		// TODO 
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.antallLikes = 0;
		
		
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.antallLikes = likes;
		
		
	}
	
	public String getBruker() {
		
		return bruker;
		

	}

	public void setBruker(String bruker) {
		
		this.bruker = bruker;
		
	}

	public String getDato() {
		
		return dato;
		
		
		
	}

	public void setDato(String dato) {
		
		this.dato = dato;
		
	}

	public int getId() {
		
		 return id;


	}
	
	public void setId(int id) {
		
		this.id = id;
		
	}

	public int getLikes() {
		
		return antallLikes;

	}
	
	public void doLike () {

		antallLikes++;
		
	}
	
	public boolean erLik(Innlegg innlegg) {
		
		return this.id == innlegg.getId();

	}
	
	@Override
	public String toString() {
		
		return id + "\n" + bruker + "\n" + dato + "\n" + antallLikes + "\n";

	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		return "";
	}
}
