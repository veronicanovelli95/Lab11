package it.polito.tdp.bar.model;

import java.util.List;

public class Model {

	    int tempo=0;
	    Simulator sim;
	   
   public Model() {
			super();
	
   }
		
   public List<Integer> simula(){
		 sim = new Simulator();

		// definisci 2000gruppi
		for( int i=0; i<=2000;i++ ) {
			tempo= (int)(tempo+Math.random()*10);
			Gruppo g =new Gruppo();
			sim.addGruppo(g, tempo);
		}
		
		List<Integer> lista = sim.run();
		return lista;
	
   }
	
   
   
}		

