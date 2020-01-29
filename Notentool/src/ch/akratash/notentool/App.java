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
		int zähler = 0;
		NotenRechner nRechner = new NotenRechner();
		note = new Noten();
		System.out.print("[Geben Sie die anzahl Noten ein] > ");
		notenAnzahl = scanner.nextInt();
		while(zähler<notenAnzahl) {
			System.out.print("\n[Noteneingabe] > ");
			double mark = scanner.nextDouble();
			System.out.print("\n[Gewichtung 1-4] > ");
			int gew = scanner.nextInt();
			
			totGewichtung += gew;
			note.setNote(mark);
			note.setGewichtung(gew);
			
			
			mark = nRechner.berechne(note);
			ergebnisse[++index]=mark;
			zähler++;
			
		}
	}
	
	
	private void gibAus() {
		for (int i = 0; i < ergebnisse.length; i++) {
			notenSchnitt += ergebnisse[i];
		}
		notenSchnitt = notenSchnitt/totGewichtung;
		System.out.print("\n[Der Notenschnitt beträgt] > ["+notenSchnitt+"]\n[Noten-Tool-Ende]");
	}
}