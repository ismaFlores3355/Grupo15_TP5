package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;

public class ListaBeca {

	private ArrayList<Becas> becas;
	
	public ListaBeca() {
		becas = new ArrayList<Becas>();
		
		Docente docente1 = new Docente(100,"Pepe","Argento","pee_arg@gmail.com","3881587563");
		Docente docente2 = new Docente(101,"Abigail","Armella","abi_arme@gmail.com","3888123789");
		Docente docente3 = new Docente(102,"Lucio","Escobar","lucio_escobar@gmail.com","3888745213");
		
		Curso curso1 = new Curso(1,"Programacion Inicial",LocalDate.of(2022, 03, 15),LocalDate.of(2022, 06, 17),150,"Presencial",docente1,"desarollo");
		Curso curso2 = new Curso(2,"Programacion Media",LocalDate.of(2022, 05, 13),LocalDate.of(2022, 07, 20),100,"Presencial",docente2,"desarollo");
		Curso curso3 = new Curso(3,"Programacion Avanzada",LocalDate.of(2022, 06, 17),LocalDate.of(2022, 12, 23),50,"Virtual",docente3,"desarollo");
		
		becas.add(new Becas(1,curso1,LocalDate.of(2022, 03, 15),LocalDate.of(2022, 06, 17)));
		becas.add(new Becas(2,curso2,LocalDate.of(2022, 05, 06),LocalDate.of(2022, 07, 12)));
		becas.add(new Becas(3,curso3,LocalDate.of(2022, 05, 05),LocalDate.of(2022, 07, 10)));
	}
	
	//metodos
	public ArrayList<Becas> getBecas(){
		return becas;
	}
	public void setBecas(ArrayList<Becas> becas) {
		this.becas = becas;
	}
	
}
