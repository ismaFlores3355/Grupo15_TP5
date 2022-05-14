package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Alumno;

public class ListaAlumno {

	private ArrayList<Alumno> alumnos;
	
	public ListaAlumno() {
		alumnos = new ArrayList<Alumno>();
		
		alumnos.add(new Alumno(15879612,"Evelin Rosario","Chavez","eve_212@gmail.com","3887894561"));
		alumnos.add(new Alumno(11415125,"Carlos","Flores","car21@gmail.com","3887512353"));
		alumnos.add(new Alumno(15672652,"Karen","Santos","kare_212@gmail.com","3881234891"));
		alumnos.add(new Alumno(79798413,"David","Lopez","dadiv_1231@gmail.com","3882511717"));
	}
	
	//metodos
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
