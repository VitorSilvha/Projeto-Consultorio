package com.consultorio.apiGw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.agendamentoServer.entidades.Agendamento;
import com.consultorio.apiGw.comunicacao.AgendamentoRoteamento;
import com.consultorio.apiGw.comunicacao.PacienteRoteamento;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@CrossOrigin(origins = "http://localhost:9005")
@RestController

public class AgendamentoController {

	@Autowired
	private AgendamentoRoteamento agendamentoRotemento;
	
	@Autowired
	private PacienteRoteamento pacienteRoteamento;
	
	
	@RequestMapping(value = "/v1/api-gw/agendamento",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento) {
		System.out.println("executando salvar");
		System.out.println("Verificando se paciente existe");
		
		ResponseEntity<Boolean> existePaciente = 
				pacienteRoteamento.existePaciente(agendamento.getIdPaciente());
		
		if(existePaciente.getBody().equals(Boolean.FALSE)) {
			System.out.println("Paciente não existe");
			return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body("Paciente não existe");
		}
		
		System.out.println("paciente existe");
		System.out.println("processando salvar agendamento");		
		ResponseEntity<String> salvarAgendamento = agendamentoRotemento.salvar(agendamento);
		
		if(salvarAgendamento.getStatusCode() == HttpStatus.BAD_REQUEST) {
			System.out.println("Erro ao salvar o agendamento");
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Erro ao salvar o agendamento.");
		}
		
		System.out.println("salvar agendamento realizado com sucesso");
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("sucesso");
	}
	
	
}
