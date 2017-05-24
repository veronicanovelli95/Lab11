package it.polito.tdp.bar.model;



public class Event implements Comparable<Event> {
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI,
		TAVOLO_LIBERO
	}
	private EventType type ;
	int tempo ;
	Gruppo gruppo;
	
	public Event(Gruppo g,int t, EventType type) {
		this.gruppo	=g;
		this.type=type;
		this.tempo=t;
	}

	public EventType getType() {
		return type;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	@Override
	public int compareTo(Event o) {
	
		if(this.tempo> o.getTempo())
		return 1;
		else if(this.tempo == o.getTempo())
			return 0;
		else 
			return -1;
	}

	public int getTempo() {
		return tempo;
	}

	
	
	
	
	
	
	
}
