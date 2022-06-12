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

import ar.edu.unju.fi.model.Becas;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.service.IBecaService;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaBeca;
import ar.edu.unju.fi.util.ListaCurso;

@Controller
@RequestMapping("/beca")
public class BecasController {
	
	@Autowired
	@Qualifier("BecaServiceImpList")
	
	private IBecaService becaService;
	
	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
ListaBeca listaBecas = new ListaBeca();
	
	@GetMapping("/nuevo")
	public String getFormNuevoBecaPage(Model model) {
		model.addAttribute("beca", becaService.getBeca());
	    return "nuevo_beca";
	}
	
	@PostMapping("/guardar") //se guarda la info
	public ModelAndView getListaBecasPage(@Validated @ModelAttribute
			("curso")Becas beca,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca",beca);
		   return mav;
		   }
		
		
		
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		
		if(becaService.guardarBeca(beca)) {
			LOGGER.info("Se agrego un objeto al arrayList de Becas");
		}
		
		return mav;
		
	}
	
	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecasPage() {
		ModelAndView mav = new ModelAndView("lista_Beca");
		mav.addObject("becas",becaService.getListaBeca().getBecas());
		return mav;
	}
	
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarBecaPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_beca");
		Becas beca = becaService.buscarBeca(codigo);
		mav.addObject("beca", beca);
		return mav;
		
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca") Becas beca, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+beca);
			ModelAndView mav = new ModelAndView("edicion_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		LOGGER.info("se modifico "+beca);
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		becaService.modificarBeca(beca);
		return mav;
		
	}
	
	
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarBecaPage(@PathVariable(value="codigo")int codigo) {
		
		becaService.eliminarBecas(codigo);
		ModelAndView mav = new ModelAndView("lista_Beca");
		LOGGER.info("se elimino la beca con el codigo:  "+codigo);
		mav.addObject("becas", becaService.getListaBeca().getBecas());
		return mav;
		
	}
}
