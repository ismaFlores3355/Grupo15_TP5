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
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCurso;


@Controller
@RequestMapping("/curso")
public class CursosController {
  
	
	@Autowired
	@Qualifier("CursoServiceImpList")
	
	private ICursoService cursoService;
	
	
	private static final Log LOGGER = LogFactory.getLog(CursosController.class);
	
ListaCurso listaCursos = new ListaCurso();
	
	@GetMapping("/nuevo")
	public String getFormNuevoCursoPage(Model model) {
		model.addAttribute("curso", cursoService.getCurso());
	    return "nuevo_curso";
	}
	
	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaCursosPage(@Validated @ModelAttribute
			("curso")Curso curso,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso",curso);
		   return mav;
		   }
		
		
		
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		
		if(cursoService.guardarCurso(curso)) {
			LOGGER.info("Se agrego un objeto al arrayList de Cursos");
		}
		
		return mav;
		
	}
	
	@GetMapping("/listaCursos")
	public ModelAndView getListadoCursosPage() {
		ModelAndView mav = new ModelAndView("lista_Curso");
		mav.addObject("cursos",cursoService.getListaCurso().getCursos());
		return mav;
	}
	
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCursoPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_curso");
		Curso curso = cursoService.buscarCurso(codigo);
		mav.addObject("curso", curso);
		return mav;
		
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+curso);
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		cursoService.modificarCurso(curso);
		return mav;
		
	}
	
	
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCursoPage(@PathVariable(value="codigo")int codigo) {
		
		cursoService.eliminarCurso(codigo);
		ModelAndView mav = new ModelAndView("lista_Curso");
		mav.addObject("cursos", cursoService.getListaCurso().getCursos());
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
}