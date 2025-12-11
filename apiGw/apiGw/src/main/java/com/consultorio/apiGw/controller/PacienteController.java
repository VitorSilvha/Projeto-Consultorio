package com.consultorio.apiGw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.apiGw.comunicacao.PacienteRoteamento;
import com.consultorio.apiGw.entidades.Paciente;

public class PacienteController {

	@Autowired
	private PacienteRoteamento pacienteRoteamento;
	
	@RequestMapping(value = "/v1/paciente",method = RequestMethod.POST)
	public ResponseEntity<String>salvar(@RequestBody Paciente paciente) {
		System.out.println("Executando -salvar paciente-");
		ResponseEntity<String> resultado = pacienteRoteamento.salvar(paciente);
		return resultado;	
	}
	

    @RequestMapping(value = "/v1/paciente", method = RequestMethod.GET)
    ResponseEntity<List<Paciente>> listar() {
		System.out.println("Executando -listar paciente-");
		ResponseEntity<List<Paciente>> resultado = pacienteRoteamento.listar();
		return resultado;	
	}

	
	@RequestMapping(value = "/v1/paciente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("executando deletar de paciente id " + id );
		ResponseEntity<Void> resultado = pacienteRoteamento.deletar(id);
		return resultado;
	}
	
	@RequestMapping(value = "/v1/paciente",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Paciente paciente) {
		System.out.println("executando atualizar de paciente");
		ResponseEntity<String> resultado = pacienteRoteamento.atualizar(paciente);
		return resultado;
	}
	
    
	@RequestMapping(value = "/v1/paciente/existe-paciente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existePaciente(@PathVariable Integer id) {
		System.out.println("executando existePaciente de paciente");
		ResponseEntity<Boolean> resultado = pacienteRoteamento.existePaciente(id);
		return resultado;
	}
	
	@RequestMapping(value = "/v1/paciente/buscar-paciente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Paciente> buscarPaciente(@PathVariable Integer id) {
		System.out.println("executando existePaciente de paciente");
		ResponseEntity<Paciente> resultado = pacienteRoteamento.buscarPaciente(id);
		return resultado;
	}

	
}
