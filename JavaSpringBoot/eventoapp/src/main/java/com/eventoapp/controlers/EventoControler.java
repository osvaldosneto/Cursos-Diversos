package com.eventoapp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller
public class EventoControler {
	
	@Autowired //toda vez cria esta interface
	private EventoRepository er;
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String formulario() {
		return "evento/formEvento"; //caminho da página a renderizar
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String formulario(Evento evento) {
		er.save(evento);
		return "redirect:/cadastrarEvento"; //caminho da página a renderizar
	}
	
	//metodo para retornar lista eventos
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index.html");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos); //eventos esta na pagina html
		return mv;
	}

}
