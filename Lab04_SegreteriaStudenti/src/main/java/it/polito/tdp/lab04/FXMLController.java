package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;
	List<Corso> corsi=new ArrayList<>();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> scegliCorso;

    @FXML
    private Button cercaIscritti;

    @FXML
    private Button cercaCorsi;

    @FXML
    private Button iscrivi;

    @FXML
    private TextField matricola;

    @FXML
    private TextField nome;

    @FXML
    private TextField cognome;
    
    @FXML
    private CheckBox complAuto;

    @FXML
    private TextArea risultato;

    @FXML
    private Button reset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	int mat=Integer.parseInt(matricola.getText());
    	for(Corso s:model.getCorsiDelloStudente(mat)) {
    		risultato.appendText(s.toStringEsteso()+"\n");
    	}
    }

    @FXML
    void doCercaiscritti(ActionEvent event) {
    	String nomeCorso=scegliCorso.getValue();
    	Corso co=null;
    	for(Corso c:model.getTuttiICorsi()) {
    		if(nomeCorso.equals(c.getNome())){
    			co=c;
    		}
    	}
    	List<Studente> stu=model.getGliStudentiIscrittiAlCorso(co);
    	for(Studente s:stu) {
    		risultato.appendText(s.toString()+"\n");
    	}
    }
    
    @FXML
    void doComplAuto(ActionEvent event) {
    	int matri=Integer.parseInt(this.matricola.getText());
    	Studente s=model.cercaStudenteDaMatricola(matri);
    	this.nome.setText(s.getNome());
    	this.cognome.setText(s.getCognome());
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	 matricola.clear();
    	 nome.clear();
    	 cognome.clear();
    	 risultato.clear();
    }

    @FXML
    void doScegliCorso(ActionEvent event) {
    	 matricola.clear();
    	 nome.clear();
    	 cognome.clear();
    	 risultato.clear();
    }
    @FXML
    void initialize() {
        assert scegliCorso != null : "fx:id=\"scegliCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cercaIscritti != null : "fx:id=\"cercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cercaCorsi != null : "fx:id=\"cercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert iscrivi != null : "fx:id=\"iscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert complAuto != null : "fx:id=\"complAuto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		scegliCorso.getItems().addAll(model.getTuttiICorsiPerTendina());
	}
}