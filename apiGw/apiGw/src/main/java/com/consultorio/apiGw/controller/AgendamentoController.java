package com.consultorio.apiGw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.apiGw.comunicacao.AgendamentoRoteamento;
import com.consultorio.apiGw.comunicacao.PacienteRoteamento;
import com.consultorio.apiGw.entidades.Agendamento;



@RestController
public class AgendamentoController {

	@Autowired
	private AgendamentoRoteamento agendamentoRotemento;
	
	@Autowired
	private PacienteRoteamento pacienteRoteamento;
	
	
	@RequestMapping(value = "/v1/api-gw/agendamento",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento) {
		System.out.println("executando salvar");
		return agendamentoRotemento.salvar(agendamento);
		
	}
		
	@RequestMapping(value = "/v1/api-gw/processar-agendamento", method = RequestMethod.POST)
	public ResponseEntity<String> processarAgendamento(@RequestBody Agendamento agendamento) {
		System.out.println("Processando o agendamento");
		System.out.println("Verificando se o paciente existe");
		ResponseEntity<Boolean> existePaciente = pacienteRoteamento.existePaciente(agendamento.getIdPaciente());
		
		if(existePaciente.getBody().equals(Boolean.FALSE)) {
			System.out.println("Paciente não existe");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente não existe");
		}
		System.out.println("Paciente existe");
		System.out.println("Processando salvar agendamento");
		ResponseEntity<String> salvarAgendamento = agendamentoRotemento.salvar(agendamento);
		if(salvarAgendamento.getStatusCode() == HttpStatus.BAD_REQUEST) {
			System.out.println("Erro ao salvar a venda");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar venda");
		}
		
		System.out.println("Salvar vendas realizada com sucesso");
	
		return ResponseEntity.status(HttpStatus.OK).body("sucesso");
	}
	
	@RequestMapping(value = "/v1/api-gw/agendamento",method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar(@RequestBody Agendamento agendamento) {
		System.out.println("executando listar");
		return agendamentoRotemento.listar();
		}
}
