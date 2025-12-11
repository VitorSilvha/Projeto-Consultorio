package com.consultorio.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

	@GetMapping("/paciente")
	public String paciente(Model model) {
		return "paciente";
	}

	@GetMapping("/agendamentos")
	public String agendamentos(Model model) {
		return "agendamentos";
	}

}