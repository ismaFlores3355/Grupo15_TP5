package ar.edu.unju.fi.service.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCurso;



@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService{
   
	@Autowired
	private ListaCurso listaCurso;
	
	
	
	
	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return listaCurso.getCursos().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		for(Curso can : listaCurso.getCursos()) {
			if(can.getCodigo() == curso.getCodigo()) {
				can.setTitulo(curso.getTitulo());
				can.setFechaInicio(curso.getFechaInicio());
				can.setFechaFin(curso.getFechaFin());
				can.setHoras(curso.getHoras());
				can.setModalidad(curso.getModalidad());
				can.setDocente(curso.getDocente());
				can.setCategoria(curso.getCategoria());
			       
			}
		}
		
	}

	@Override
	public ListaCurso getListaCurso() {
		return listaCurso;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso = listaCurso.getCursos().stream().filter(a -> a.getCodigo()== codigo).findFirst();
		return curso.get();
	}

	
	@Override
	public void eliminarCurso(int codigo) {
		Optional<Curso> curso = listaCurso.getCursos().stream().filter(a -> a.getCodigo()== codigo).findFirst();
		for(int i=0; i<listaCurso.getCursos().size();i++) {
			if(listaCurso.getCursos().get(i).getCodigo() == codigo) {
			    listaCurso.getCursos().remove(i);
			}
		}
		
	}


	
}
