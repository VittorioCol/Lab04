package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	CorsoDAO cdao=new CorsoDAO();
	StudenteDAO sdao=new StudenteDAO();
	
	public Model() {
		}
	
	public List<String> getTuttiICorsiPerTendina(){
		List<String> res= new ArrayList<>();
		res.add("");
		for(Corso c:cdao.getTuttiICorsi()) {
			res.add(c.toString());
		}
		Collections.sort(res);
		return res;
	}
	
	public List<Corso> getTuttiICorsi(){
		return cdao.getTuttiICorsi();
	}
	
	public List<Studente> getTuttiGliStudenti(){
		return sdao.getTuttiGliStudenti();
	}
	
	public Studente cercaStudenteDaMatricola(int matricola){
		Studente ris=null;
		List<Studente> sList=sdao.getTuttiGliStudenti();
		for(Studente s:sList) {
			if(s.getMatricola()==matricola) {
				ris=s;
				break;
			}
		}
		return ris;
	}
	
	public List<Studente> getGliStudentiIscrittiAlCorso(Corso corso){
		return cdao.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiDelloStudente(int matricola) {
		return sdao.getCorsiDelloStudente(matricola);
	}
}
