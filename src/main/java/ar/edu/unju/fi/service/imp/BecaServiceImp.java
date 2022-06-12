package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.util.ListaBeca;



@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {
   
	@Autowired
	
	private ListaBeca listaBeca;
	
	@Override
	public Becas getBeca() {
		// TODO Auto-generated method stub
		return new Becas();
	}

	@Override
	public boolean guardarBeca(Becas beca) {
		// TODO Auto-generated method stub
		return listaBeca.getBecas().add(beca);
	}

	@Override
	public void modificarBeca(Becas beca) {
		for(Becas can : listaBeca.getBecas()) {
			if(can.getCodigo() == beca.getCodigo()) {
				can.setFechaApertura(beca.getFechaApertura());
				can.setFechaCierre(beca.getFechaCierre());
				can.setCurso(beca.getCurso());
			       
			}
		}
		
		
		
		
	}

	@Override
	public ListaBeca getListaBeca() {
		return listaBeca;
	}

	@Override
	public Becas buscarBeca(int codigo) {
		Optional<Becas> beca = listaBeca.getBecas().stream().filter(a -> a.getCodigo()== codigo).findFirst();
		return beca.get();
	}

	@Override
	public void eliminarBecas(int codigo) {
		for(int i=0; i<listaBeca.getBecas().size();i++) {
			if(listaBeca.getBecas().get(i).getCodigo() == codigo) {
			    listaBeca.getBecas().remove(i);
			}
		}
		
	}

	
	
}
