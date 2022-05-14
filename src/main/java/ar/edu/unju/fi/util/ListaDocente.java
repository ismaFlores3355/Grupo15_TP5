package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Docente;


public class ListaDocente {
	
	private ArrayList<Docente> docentes;
	
	public ListaDocente() {
		
		docentes = new ArrayList<Docente>();
		
		docentes.add(new Docente(1005,"Patricia","Sanchez","patri@gmail.com","3888642713"));
		docentes.add(new Docente(1924,"Maria","Lazarte","mari_La@gmail.com","3887584123"));
		docentes.add(new Docente(1155,"Ismael","Garcia","Garcia_F@gmail.com","3888756238"));
		docentes.add(new Docente(1425,"Ruben","Mamani","ru_mamani@gmail.com","3888756238"));
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

}
