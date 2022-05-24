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
@RequestMapping("/Beca")
public class BecasController {
	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	ListaBeca listaBecas = new ListaBeca();
	
	@GetMapping("/nuevo")
	public String getBecas(Model model) {
		model.addAttribute("beca", new Becas());
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaBecasPage(@ModelAttribute("beca")Becas beca) {
		ModelAndView mav = new ModelAndView("lista_Beca");
		if(listaBecas.getBecas().add(beca)) {
			LOGGER.info("Se agrego un objeto al arrayList de Becas");
		}
		mav.addObject("becas",listaBecas.getBecas());
		return mav;
	}

	@GetMapping("/listaBeca")
	public ModelAndView getListaBecaPage() {
		ModelAndView mav = new ModelAndView("lista_Beca");
		mav.addObject("becas", listaBecas.getBecas());
		return mav;
	}
}
