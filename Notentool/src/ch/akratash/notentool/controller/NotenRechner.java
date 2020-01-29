package ch.akratash.notentool.controller;

import ch.akratash.notentool.model.Noten;

public class NotenRechner {
	
	public final static int MAX_GW = 4;
	public final static int MAX_N = 6;
	public final static int MIN_N_GW = 1;
	
	public double berechne(Noten note) {
		double summe =+ (note.getNote()*note.getGewichtung());
		
		return summe;
	}

}
