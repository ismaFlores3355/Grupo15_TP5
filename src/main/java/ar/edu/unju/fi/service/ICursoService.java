package ar.edu.unju.fi.service;


import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.util.ListaCurso;

public interface ICursoService {
    
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public ListaCurso getListaCurso();
	public Curso buscarCurso(int codigo);	
	public void eliminarCurso(int codigo); 
	
	
	
}
