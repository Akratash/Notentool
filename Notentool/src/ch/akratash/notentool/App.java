package ch.akratash.notentool;

import java.util.Scanner;

import ch.akratash.notentool.controller.NotenRechner;
import ch.akratash.notentool.model.Noten;
public class App {
	
	private Scanner scanner = new Scanner(System.in);
	private NotenRechner nRechner = new NotenRechner();
	private Noten note = new Noten();
	private double[] ergebnisse = new double[10];
	private int totGewichtung = 0;
	private double notenSchnitt = 0;
	private int index = -1;

	public static void main(String[] args) {
		
		new App();

	}
	
	private App() {
		System.out.println("[Noten-Tool-Start]");
		gibEin();
		gibAus();
		System.out.println("[Noten-Tool-Ende]");
		
	}
	
	private void gibEin() {
		int zähler = 0;
		System.out.print("[Geben Sie die anzahl Noten ein] > ");
		int notenAnzahl = scanner.nextInt();
		while(zähler<notenAnzahl) {
			
			System.out.print("\n[Noteneingabe (1-6)] > ");
			double mark = scanner.nextDouble();
			if(mark >= NotenRechner.MIN_N_GW && mark <= NotenRechner.MAX_N) {
				note.setNote(mark);
			}else {
				System.out.println("[Falsche Eingabe - Programm Ende]");
				System.exit(0);
			}
			
			System.out.print("\n[Gewichtung (1-4)] > ");
			int gew = scanner.nextInt();
			if(gew >= NotenRechner.MIN_N_GW && gew <= NotenRechner.MAX_GW) {
				note.setGewichtung(gew);
				totGewichtung += gew;
			}else {
				System.out.println("[Falsche Eingabe - Programm Ende]");
				System.exit(0);
			}
			
			
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
		System.out.print("\n[Der Notenschnitt beträgt] > ["+notenSchnitt+"]\n");
	}
}