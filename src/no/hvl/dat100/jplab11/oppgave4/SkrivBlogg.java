package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		String filsti = Paths.get(mappe, filnavn).toString();

        try (PrintWriter writer = new PrintWriter(filsti)) {
            writer.print(samling.toString());
            return true; 
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return false; 
        }
    }

		
	}

