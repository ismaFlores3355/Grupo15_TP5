package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Service("DocenteServiceImpList")
public class DocenteServiceImp  implements IDocenteService{

	@Autowired
	private ListaDocente listaDocente;
	
	@Override
	public Docente getDocente() {
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		return listaDocente.getDocentes().add(docente);
	}

	@Override
	public void modificarDocente(Docente docente) {
		for(Docente doc: listaDocente.getDocentes()) {
			if(doc.getLegajo() == docente.getLegajo()) {
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setNombre(docente.getNombre());
				doc.setTelefono(docente.getTelefono());
			}
		}
		
	}

	@Override
	public void eliminarDocente(int legajo) {
		for(int i=0;i<listaDocente.getDocentes().size();i++) {
			if(listaDocente.getDocentes().get(i).getLegajo() == legajo) {
				listaDocente.getDocentes().remove(i);
			}
		}		
	}

	@Override
	public ListaDocente getListaDocente() {
		return listaDocente;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(a -> a.getLegajo()==legajo).findFirst();
		return docente.get();
	}

}
