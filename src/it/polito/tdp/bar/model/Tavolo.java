package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>  {
	public enum TavoloStatus { OCCUPATO,LIBERO }
	private int numPosti;
    private TavoloStatus stato;
	public Tavolo(int numPosti) {
		super();
		this.numPosti = numPosti;
		this.stato = TavoloStatus.LIBERO;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public TavoloStatus getStato() {
		return stato;
	}

	public void setStato(boolean b) {
		if(b==true)
		    this.stato = TavoloStatus.LIBERO;
		else
			this.stato = TavoloStatus.OCCUPATO;
	}

	@Override
	public int compareTo(Tavolo o) {
		if(numPosti > o.numPosti)
			return 1;
		if(numPosti == o.numPosti)
			return 0;
		else
			return -1;
	}
	
	
	
	

}
