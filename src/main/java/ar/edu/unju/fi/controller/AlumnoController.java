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
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}

	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaAlumnosPage(@ModelAttribute("alumno")Alumno alumno) {
		ModelAndView mav = new ModelAndView("lista_Alumnos");
		//creo un objeto de la clase Lista Alumno, donde esta el arrayList
		ListaAlumno listaAlumnos = new ListaAlumno();
		//recupero el arrayList y agrego un objeto alumno a lista
		if(listaAlumnos.getAlumnos().add(alumno)) {
			LOGGER.info("Se agrego un objeto al arrayList de Alumnos");
		}
		mav.addObject("alumnos",listaAlumnos.getAlumnos());
		return mav;
	}
}
