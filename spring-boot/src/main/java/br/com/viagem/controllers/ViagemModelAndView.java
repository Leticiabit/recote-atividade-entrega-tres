/*package br.com.viagem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.viagem.model.Viagem;

@Controller
@RequestMapping("/viagem")
public class ViagemModelAndView {

	@Autowired
	private Viagem viagem;
	
	@GetMapping
	public ModelAndView listar() {
	List&lt;Viagem&gt; lista = viagem.findAll();

		ModelAndView modelAndView = new ModelAndView("viagem");
		modelAndView.addObject("viagem", lista);
		
		return modelAndView
	}
	
}
*/