package com.consultorio.pacienteServer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.consultorio.pacienteServer.entidades.Paciente;
import com.consultorio.pacienteServer.service.PacienteService;

public class PacienteController {

	private PacienteService pacienteService;
	
	
	//TODO FAZER A DOCUMENTAÇÃO SWAGGER
	public ResponseEntity<String> salvar(@RequestBody Paciente paciente) {
		
		try {
			String id = pacienteService.salvar(paciente);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> resultado = pacienteService.listar();
		return ResponseEntity.ok(resultado);
	}

	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		
		boolean resultado = pacienteService.deletar(id);
			if(resultado == true) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//TODO TERMINAR O ATUALIZAR PACIENTE
	public ResponseEntity<String> atualizar(@RequestBody Paciente paciente){
		boolean resultado = pacienteService.atualizar(paciente);
		if(resultado == true) {
			return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso.");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado.");
		}
	}
}
