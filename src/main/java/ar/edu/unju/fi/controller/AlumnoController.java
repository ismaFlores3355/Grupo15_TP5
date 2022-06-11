package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;


@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
	//ListaAlumno listaAlumnos = new ListaAlumno();
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		model.addAttribute("alumnos", alumnoService.getAlumno());
		return "nuevo_alumno";
	}

	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("alumno")Alumno alumno,BindingResult bindingResult) {
		
		//corrige errores de ingreso
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_Alumno");
			mav.addObject("alumnos", alumno);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/Alumno/listaAlumno");

		//agrego un objeto alumno a la lista
		if(alumnoService.guardarAlumno(alumno)) {
			LOGGER.info("Se agrego un objeto al arrayList de Alumnos");
		}
		return mav;
	}
	
	@GetMapping("/listaAlumno")
	public ModelAndView getListAlumnoPage() {
		ModelAndView mav = new ModelAndView("lista_Alumnos");
		mav.addObject("alumnos", alumnoService.getListaAlumno().getAlumnos());
		return mav;
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.buscarAlumno(dni);
		mav.addObject("alumnos", alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView geteEditarDatosAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error " +alumno);
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumnos", alumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/Alumno/listaAlumno");
		alumnoService.modificarAlumno(alumno);
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumno(@PathVariable(value="dni")int dni) {
		alumnoService.eliminarAlumno(dni);
		ModelAndView mav= new ModelAndView("lista_Alumnos");
		mav.addObject("alumnos", alumnoService.getListaAlumno().getAlumnos());
		return mav;
	}
}
