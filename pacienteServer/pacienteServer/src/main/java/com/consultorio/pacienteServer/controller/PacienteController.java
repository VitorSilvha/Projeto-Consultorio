package com.consultorio.pacienteServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.pacienteServer.entidades.Paciente;
import com.consultorio.pacienteServer.service.PacienteService;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(origins = "http://localhost:9005")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	
	//TODO FAZER A DOCUMENTAÇÃO SWAGGER
	@RequestMapping(value = "/v1/paciente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Paciente paciente) {
		
		try {
			String id = pacienteService.salvar(paciente);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/v1/paciente",method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> resultado = pacienteService.listar();
		return ResponseEntity.ok(resultado);
	}

	@RequestMapping(value = "/v1/paciente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		
		boolean resultado = pacienteService.deletar(id);
			if(resultado == true) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@RequestMapping(value = "/v1/paciente",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Paciente paciente){
		boolean resultado = pacienteService.atualizar(paciente);
		if(resultado == true) {
			return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso.");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado.");
		}
	}
	
	@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Integer id) { 
		System.out.println("executando existeCliente");
		boolean resultado = pacienteService.existePaciente(id);
		return ResponseEntity.ok(resultado);
	}
	
	@RequestMapping(value = "/v1/cliente/buscar-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Paciente> buscarCliente(@PathVariable Integer id) { 
		
		Paciente resultado = pacienteService.buscarCliente(id);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}else {		
			return ResponseEntity.noContent().build();
		}
	}
	
}
