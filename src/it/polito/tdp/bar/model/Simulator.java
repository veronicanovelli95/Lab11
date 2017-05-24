package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Event.EventType;


public class Simulator {
	
	private int NS;
	private PriorityQueue<Event> coda;
	private PriorityQueue<Gruppo> attesa;
	private int tavoliOccupati = 0;
	private List<Tavolo> tavoli=new LinkedList<Tavolo>();
	private int soddisfatti=0;
	private int insoddisfatti=0;
	private int totali=0;
	
	
	public Simulator() {
		popolaTavoli();
		this.coda = new PriorityQueue<Event>();
		
	}
	
	
	
	public void popolaTavoli(){
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(10));
		
		for(int i=0; i<5;i++)
			tavoli.add(new Tavolo(8));
		
		for(int i=0; i<5;i++)
			tavoli.add(new Tavolo(6));
		
		for(int i=0; i<6;i++)
			tavoli.add(new Tavolo(4));

		Collections.sort(tavoli);
	}
	
	
	
	public void addGruppo(Gruppo g, int time) {
		Event e1 = new Event(g, time, it.polito.tdp.bar.model.Event.EventType.ARRIVO_GRUPPO_CLIENTI) ;
		Event e2= new Event(g,(time + g.getDurata()),EventType.TAVOLO_LIBERO);
		coda.add(e1) ;
		coda.add(e2) ;
	}
	
	
	
   public List<Integer> run() {
		
		while(!coda.isEmpty()) {
			Event e = coda.poll() ;
			
			switch(e.getType()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				
				    totali += e.getGruppo().getNumPersone();
				    
				   Tavolo tavolo = controlla(e);
				    
				    if(tavolo != null){
				    	e.getGruppo().setTavolo(tavolo);
						tavolo.setStato(false);
						soddisfatti += e.getGruppo().getNumPersone();
						break;
					}		
			
					else if (tavolo==null){
							float discr = e.getGruppo().getTolleranza();
							Random r = new Random();
							float rand =(float) r.nextFloat();
							
							if(rand<discr){
							   soddisfatti += e.getGruppo().getNumPersone();
							   break;
							}
						
							else{
								insoddisfatti += e.getGruppo().getNumPersone();
							    break;
							}	
						
					}
						
			     break;
						
						
				
			case TAVOLO_LIBERO:
				if(e.getGruppo().getTavolo()!=null)
				e.getGruppo().getTavolo().setStato(true);
				break;
		
				
				
			}}
		
		
		List<Integer> ris= new ArrayList<Integer>();
		ris.add(totali);
		ris.add(soddisfatti);
		ris.add(insoddisfatti);
		
		return ris;
			
			
}

		
  public Tavolo controlla(Event e){
			
			Tavolo tavolo=null;
		
			for(Tavolo t : tavoli){
				if(e.getGruppo().getNumPersone()>= (0.5*t.getNumPosti())){
					
					tavolo=t;
					break;
				}
			}
				
		return tavolo;
			
		}
}
  

