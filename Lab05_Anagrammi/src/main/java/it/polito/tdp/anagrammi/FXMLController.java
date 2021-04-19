package it.polito.tdp.anagrammi;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) throws SQLException {
    	
    	/*List <Parola> tutto = this.model.getAnagrammi();
    	String area ="";
    	
    	for (Parola p: tutto)
    		area+= p.toString()+"\n";
    	
    	this.txtAnagrammiCorretti.setText(area);*/
    	
    	String parolaInserita = this.txtParola.getText();
    	
    	if (Pattern.matches("[a-zA-Z]+", parolaInserita) == false) {
			this.txtAnagrammiCorretti.appendText("Numeri non permessi\n");
			this.txtAnagrammiErrati.appendText("Numeri non permessi\n");
			return;
		}

		else {
    	
    	boolean corretta = false;
    	List <String> ottenute = this.model.anagrammate(parolaInserita);
    	List <String> corrette = new LinkedList <String>();
    	List <String> errate = new LinkedList <String>();
    	
    	for (String s: ottenute)
    	{
    		//Parola p = new Parola (0, s);
    		corretta = this.model.isCorrect(s);
    		
        	if(corretta==true)
        		corrette.add(s);
        	
        	if(corretta ==false)
        		errate.add(s);
    	}
    	
    	String vivaLeOttenute="";
    	String uffaLeErrate="";
    	
    	for(String p: corrette)
    		vivaLeOttenute+=p+"\n";
    	
    	for (String p: errate)
    		uffaLeErrate+=p+"\n";
    	
    	this.txtAnagrammiCorretti.setText(vivaLeOttenute);
    	this.txtAnagrammiErrati.setText(uffaLeErrate);
    	
		}	
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	this.txtParola.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model;
		
	}
}
