package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.util.ListaBeca;
import ar.edu.unju.fi.util.ListaCurso;

public interface IBecaService {
	public Becas getBeca();
	public boolean guardarBeca(Becas beca);
	public void modificarBeca(Becas beca);
	public ListaBeca getListaBeca();
	public Becas buscarBeca(int codigo);	
	public void eliminarBecas(int codigo); 
}
