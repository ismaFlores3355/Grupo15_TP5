package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	ListaAlumno listaAlumnos = new ListaAlumno();
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}


	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno,BindingResult bindingResult) {
		
		//corrige errores de ingreso
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_Alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_Alumnos");
		//creo un objeto de la clase Lista Alumno, donde esta el arrayList

		//recupero el arrayList y agrego un objeto alumno a lista
		if(listaAlumnos.getAlumnos().add(alumno)) {
			LOGGER.info("Se agrego un objeto al arrayList de Alumnos");
		}
		//enviar el arrayList de alumnos a la pagina lista_Alumnos
		mav.addObject("alumnos",listaAlumnos.getAlumnos());
		return mav;
	}
	
	@GetMapping("/listaAlumno")
	public ModelAndView getListAlumnoPage() {
		ModelAndView mav = new ModelAndView("lista_Alumnos");
		mav.addObject("alumnos", listaAlumnos.getAlumnos());
		return mav;
	}
}
