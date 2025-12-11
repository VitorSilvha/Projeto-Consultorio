package com.consultorio.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

   @GetMapping("/agendamento")
	public String agendamento( Model model) {		
		return "agendamento";
	}
   
   @GetMapping("/cadastro")
	public String cadastro( Model model) {		
		return "cadastro";
	}
   
   @GetMapping("/home")
	public String index( Model model) {		
		return "index";
	}
   
   @GetMapping("/paciente")
	public String paciente( Model model) {		
		return "paciente";
	}
   
}