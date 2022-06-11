package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private ListaAlumno listaAlumno ;
	
	@Override
	public Alumno getAlumno() {
		// retorna un objeto de la clase Alumno
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// guarda un objeto en la lista
		return listaAlumno.getAlumnos().add(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		
		for(Alumno alu: listaAlumno.getAlumnos()) {
			if(alu.getDni() == alumno.getDni()) {
				alu.setApellido(alumno.getApellido());
				alu.setNombre(alumno.getNombre());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliminarAlumno(int dni) {
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni()== dni).findFirst();
		for(int i=0; i<listaAlumno.getAlumnos().size();i++) {
			if(listaAlumno.getAlumnos().get(i).getDni() == dni) {
				listaAlumno.getAlumnos().remove(i);
			}
		}	
	}

	@Override
	public ListaAlumno getListaAlumno() {
		return listaAlumno;
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// busca un alumno por dni y devuelve el objeto asociado
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		return alumno.get();
	}

}
