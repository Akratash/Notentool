package ch.akratash.notentool;

import java.util.Scanner;

import ch.akratash.notentool.controller.NotenRechner;
import ch.akratash.notentool.model.Noten;
public class App {
	
	private Scanner scanner = new Scanner(System.in);
	private Noten note;
	private double[] ergebnisse = new double[10];
	private int totGewichtung = 0;
	private double notenSchnitt = 0;
	public int notenAnzahl;

	private int index = -1;

	public static void main(String[] args) {
		
		new App();

	}
	
	private App() {
		System.out.println("[Noten-Tool-Start]");
		gibEin();
		gibAus();
		
	}
	
	private void gibEin() {
		int z�hler = 0;
		NotenRechner nRechner = new NotenRechner();
		note = new Noten();
		System.out.print("[Geben Sie die anzahl Noten ein] > ");
		notenAnzahl = scanner.nextInt();
		while(z�hler<notenAnzahl) {
			System.out.print("\n[Noteneingabe] > ");
			double mark = scanner.nextDouble();
			System.out.print("\n[Gewichtung 1-4] > ");
			int gew = scanner.nextInt();
			
			totGewichtung += gew;
			note.setNote(mark);
			note.setGewichtung(gew);
			
			
			mark = nRechner.berechne(note);
			ergebnisse[++index]=mark;
			z�hler++;
			
		}
	}
	
	
	private void gibAus() {
		for (int i = 0; i < ergebnisse.length; i++) {
			notenSchnitt += ergebnisse[i];
		}
		notenSchnitt = notenSchnitt/totGewichtung;
		System.out.print("\n[Der Notenschnitt betr�gt] > ["+notenSchnitt+"]\n[Noten-Tool-Ende]");
	}
}