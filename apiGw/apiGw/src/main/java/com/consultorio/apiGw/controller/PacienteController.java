package com.consultorio.apiGw.controller;

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
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String>salvar(@RequestBody Paciente paciente) {
		System.out.println("Executando -salvar cliente-");
		System.out.println("Chamando o cliente service; endpoint salvar");
		ResponseEntity<String> resultado = pacienteRoteamento.salvar(paciente);
		return resultado;	
	}
	
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("executando deletar de cliente id " + id );
		ResponseEntity<Void> resultado = pacienteRoteamento.deletar(id);
		return resultado;
	}
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody  Paciente paciente) {
		ResponseEntity<String> resultado = pacienteRoteamento.atualizar(paciente);
		return resultado;
	}
	
}
