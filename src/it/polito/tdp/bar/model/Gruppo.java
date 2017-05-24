package it.polito.tdp.bar.model;

import java.util.Random;

public class Gruppo {
    private int numPersone;
    private int durata;
    private float tolleranza;
    private Tavolo tavolo;

	public Gruppo() {
		super();
		this.numPersone = (int)(Math.random()*10);
		
		this.tolleranza = (float)Math.random();
		if(tolleranza>0.9)
			tolleranza= (float) 0.9;
		
		Random r = new Random();
		this.durata =(int) (60+r.nextFloat()*60);
	
		
	}

	public int getDurata() {
		return durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public int getNumPersone() {
		return numPersone;
	}

	@Override
	public String toString() {
		return "Gruppi [numPersone=" + numPersone + "]";
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
    
    
}
