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

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoDocentePage(Model model) {
		model.addAttribute("docentes", docenteService.getDocente());
	    return "nuevo_docente";
	}
	
	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaDocentesPage(@Validated @ModelAttribute("docente")Docente docente,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docentes",docente);
		   return mav;
		   }
		
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		if(docenteService.guardarDocente(docente)) {
			LOGGER.info("Se agrego un objeto al arrayList de Docente");
		}
		return mav;		
	}
	
	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		ModelAndView mav = new ModelAndView("lista_Docente");
		mav.addObject("docentes", docenteService.getListaDocente().getDocentes());
		return mav;
	}
	
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="legajo")int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(legajo);
		mav.addObject("docentes", docente);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView getEditarDatosDocentePage(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error" + docente);
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docentes", docente);
			return mav;
		}
	ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
	docenteService.modificarDocente(docente);
	return mav;
	
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView getEliminarDocente(@PathVariable(value="legajo")int legajo) {
		docenteService.eliminarDocente(legajo);
		ModelAndView mav = new ModelAndView("lista_Docente");
		mav.addObject("docentes", docenteService.getListaDocente().getDocentes());
		return mav;
		}
		
}
