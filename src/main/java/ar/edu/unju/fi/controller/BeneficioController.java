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

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.util.ListaAlumno;
import ar.edu.unju.fi.util.ListaBeca;

@Controller
public class BeneficioController {
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);

	@GetMapping("/beneficio/becas")
	public String getBeneficioPage(Model model) {
		ListaBeca listaBecas = new ListaBeca();
		model.addAttribute("becas",listaBecas.getBecas());
		return "beneficios";
	}
	
}
