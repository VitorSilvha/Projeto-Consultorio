package com.consultorio.apiGw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.apiGw.comunicacao.AgendamentoRoteamento;
import com.consultorio.apiGw.comunicacao.PacienteRoteamento;


@CrossOrigin(origins = "http://localhost:9005")
@RestController

public class AgendamentoController {

	@Autowired
	private AgendamentoRoteamento agendamentoRotemento;
	
	@Autowired
	private PacienteRoteamento pacienteRoteamento;
	
	/*
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento);{
		
		return agendamentoRotemento.salvar();
	}
	*/

}
