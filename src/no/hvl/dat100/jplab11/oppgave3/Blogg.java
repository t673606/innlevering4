package no.hvl.dat100.jplab11.oppgave3;

import javax.management.relation.RoleInfoNotFoundException;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	
	Innlegg[] innleggSamling;
	int nesteLedige = 0;
	

	public Blogg() {
		innleggSamling = new Innlegg[20];	
	}

	public Blogg(int lengde) {
		innleggSamling = new Innlegg[lengde];
		nesteLedige = 0;

	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		return innleggSamling;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		boolean funnet = false;
		int pos = 0;
		
		while (pos < nesteLedige && !funnet) {
			if (innleggSamling[pos].erLik(innlegg) ) {
				funnet = true;
			}
			else {
				pos ++;
			}
		}
		
		if (funnet) {
			return pos;
		}
		else {
			return -1;
		}
		
		
		
		
	}
	
	// sjekker om finn innlegg gir meg -1 for funnet, returnerer svaret som er boolean verdi

	public boolean finnes(Innlegg innlegg) {
		
		if (finnInnlegg(innlegg) == -1) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public boolean ledigPlass() {
	    return nesteLedige < innleggSamling.length;
	}

	
	public boolean leggTil(Innlegg innlegg) {

		boolean ny = finnInnlegg(innlegg) == -1;

		if (ny && nesteLedige < innleggSamling.length) {
			innleggSamling[nesteLedige] = innlegg;
			nesteLedige++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		
		StringBuilder asString = new StringBuilder();
        asString.append(getAntall()).append("\n");

        for (int i = 0; i < nesteLedige; i++) {
            asString.append(innleggSamling[i].toString());
        }

        return asString.toString();
    }
	

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		if (nesteLedige == innleggSamling.length) {
			
			Innlegg[] utvidetSamling = new Innlegg[innleggSamling.length * 2];
			
			for (int i = 0; i < nesteLedige; i++) {
				utvidetSamling[i] = innleggSamling[i];
			}
			
			innleggSamling = utvidetSamling;
		}
		
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean ny = finnInnlegg(innlegg) == -1;

		if (ny) {
			if (nesteLedige >= innleggSamling.length) {
				utvid();
			}
			
			innleggSamling[nesteLedige] = innlegg;
			return true;
		}
		else {
			return false;
			
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		
		if (pos != -1) {
			for (int i = pos; i < nesteLedige - 1; i++) {
				innleggSamling[i] = innleggSamling[i +1];
				
			}
			innleggSamling[nesteLedige-1] = null;
			nesteLedige--;
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}