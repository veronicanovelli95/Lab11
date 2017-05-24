package it.polito.tdp.bar;

import it.polito.tdp.bar.model.Model;
 import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextArea;

public class BarController {
    Model model;
   
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextArea txtResult;

        @FXML
        private Button btnSimula;

        
   @FXML
   void doSimula(ActionEvent event) {
	  List<Integer> risultati= model.simula();
	  
	  txtResult.appendText("Clienti totali: "+ risultati.get(0)+ "\n");
	  txtResult.appendText("Clienti soddisfatti: "+ risultati.get(1)+ "\n");
	  txtResult.appendText("Clienti insoddisfatti: "+ risultati.get(2)+ "\n");
	  
  
   }

    @FXML
   void initialize() {
            assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";
            assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    

	public void setModel(Model model) {
		this.model=model;
		
	}
	
}
