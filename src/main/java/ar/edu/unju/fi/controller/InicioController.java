package ar.edu.unju.fi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class InicioController {

	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		return "index";
	}
}
