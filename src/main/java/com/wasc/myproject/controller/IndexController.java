package com.wasc.myproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wasc.myproject.model.Ganhos;
import com.wasc.myproject.model.SeletorMotorista;
import com.wasc.myproject.repository.Ganho;

@Controller
@RequestMapping("/projeto")
public class IndexController {
	
	private static final String CADASTRO_VIEW = "CadastroGanhos";
	
	@Autowired
	private Ganho ganho;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastro(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Ganhos());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Ganhos ganhos, Errors errors, RedirectAttributes attributes){
		if(errors.hasErrors()){
			return CADASTRO_VIEW;
		}
		
		try{
		ganho.save(ganhos);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso");
		return "redirect:/projeto/cadastro";
		} catch (DataIntegrityViolationException e){
			errors.rejectValue("dtCorrida", null, "Formato de data inválido");
			return CADASTRO_VIEW;
		}
	}	
	
	@RequestMapping("/pesquisa")
	public ModelAndView pesquisar() {
		List<Ganhos> todosGanhos = ganho.findAll();
		ModelAndView mv = new ModelAndView("Pesquisa");
		mv.addObject("ganhos", todosGanhos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo){
		Ganhos ganhos = ganho.findOne(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(ganhos);
		return mv;
	}
	
	@ModelAttribute("todosSeletorMotorista")
	public List<SeletorMotorista> todosSeletorMotorista(){
		return Arrays.asList(SeletorMotorista.values());
	}
}
