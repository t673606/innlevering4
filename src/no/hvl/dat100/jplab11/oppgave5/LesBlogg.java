package no.hvl.dat100.jplab11.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        File fil = new File(mappe + File.separator + filnavn);

        try (Scanner scanner = new Scanner(fil)) {
            int antallInnlegg = Integer.parseInt(scanner.nextLine());
            Blogg blogg = new Blogg(antallInnlegg);

            for (int i = 0; i < antallInnlegg; i++) {
                String type = scanner.nextLine();
                int id = Integer.parseInt(scanner.nextLine());
                String bruker = scanner.nextLine();
                String dato = scanner.nextLine();
                int likes = Integer.parseInt(scanner.nextLine());
                String tekst = scanner.nextLine();

                if (type.equals(TEKST)) {
                    Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
                    blogg.leggTil(tekstInnlegg);
                } else if (type.equals(BILDE)) {
                    String url = scanner.nextLine();
                    Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                    blogg.leggTil(bildeInnlegg);
                }
            }

            return blogg;

        } catch (FileNotFoundException e) {
            // Håndterer eventuelle unntak under lesing av filen
            JOptionPane.showMessageDialog(null, "Filen ble ikke funnet: " + fil.getAbsolutePath());
            return null; // Returnerer null hvis det oppstår en feil
        }
    }
}
