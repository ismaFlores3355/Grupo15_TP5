package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Service("AlumnoServiceImpMysql")
public class AlumnoServiceImpMysql implements IAlumnoService {

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaAlumno getListaAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
