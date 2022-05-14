package ar.edu.unju.fi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.util.ListaBeca;

public class BeneficioController {

	@GetMapping("/beneficio/becas")
	public String getBeneficioPage(Model model) {
		ListaBeca listaBecas = new ListaBeca();
		model.addAttribute("becas",listaBecas.getBecas());
		return "beneficios";
	}

}
