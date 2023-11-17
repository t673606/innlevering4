package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	// TODO - objekt variable
	
	private String bildeUrl;
	
	public Bilde() {
	
	super();
	this.bildeUrl = "";
	
	}
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.bildeUrl = url;
		
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.bildeUrl = url;
	}
	
	public String getUrl() {
		
		return bildeUrl;


	}

	public void setUrl(String url) {
		this.bildeUrl = url;
	}

	@Override
	public String toString() {
		
		return "BILDE\n" + super.toString() + "\n" + bildeUrl + "\n";
		


	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		return "";
				
	}
}
