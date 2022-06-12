package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;
@Component
public class ListaCurso {
	
	private ArrayList<Curso> cursos;

	
	
	public ListaCurso() {
		
		cursos = new ArrayList<Curso>();
		Docente docente1 = new Docente(100,"Pepe","Argento","pee_arg@gmail.com","3881587563");
		Docente docente2 = new Docente(101,"Abigail","Armella","abi_arme@gmail.com","3888123789");
		Docente docente3 = new Docente(102,"Lucio","Escobar","lucio_escobar@gmail.com","3888745213");
		
		cursos.add(new Curso(1,"algebra",LocalDate.of(2022, 03, 15),LocalDate.of(2022, 06, 17),3,"virtual",docente1,"ingenieria"));
		cursos.add(new Curso(2,"filosofia",LocalDate.of(2022, 03, 15),LocalDate.of(2022, 06, 17),3,"virtual",docente2,"ingenieria"));
		cursos.add(new Curso(3,"base de datos",LocalDate.of(2022, 03, 15),LocalDate.of(2022, 06, 17),3,"virtual",docente3,"ingenieria"));
		
	}
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	
	
	
}
