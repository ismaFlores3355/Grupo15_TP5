package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.util.ListaBeca;

@Controller
@RequestMapping("/Becas")
public class BecasController {
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("/nuevo")
	public String getBecas(Model model) {
		model.addAttribute("beca", new Becas());
		return "nuevo_beneficiario";
	}

	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaBecasPage(@ModelAttribute("beca")Becas beca) {
		ModelAndView mav = new ModelAndView("lista_becas");
		//creo un objeto de la clase Lista Becas, donde esta el arrayList
		ListaBeca listaBecas = new ListaBeca();
		//recupero el arrayList y agrego un objeto becas a lista
		if(listaBecas.getBecas().add(beca)) {
			LOGGER.info("Se agrego un objeto al arrayList de Alumnos");
		}
		mav.addObject("beca",listaBecas.getBecas());
		return mav;
	}
}
