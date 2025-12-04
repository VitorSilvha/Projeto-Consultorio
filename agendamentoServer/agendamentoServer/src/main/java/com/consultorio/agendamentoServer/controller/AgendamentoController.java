package com.consultorio.agendamentoServer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.consultorio.agendamentoServer.entidades.Agendamento;
import com.consultorio.agendamentoServer.service.AgendamentoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;

	@Operation(summary = "salvar um agendamento")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "salvo com sucesso"),
			@ApiResponse(responseCode = "400", description = "erro de validação no agendamento") })
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento) {
		System.out.println("executando salvar " + agendamento);

		try {
			Integer id = agendamentoService.salvar(agendamento);
			return ResponseEntity.ok(id.toString());
		} catch (Exception e) {
			ResponseEntity<String> retorno = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			return retorno;
		}
	}

	@Operation(summary = "listar agendamento")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "retorna uma lista de agendamentos") })
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar() {
		return ResponseEntity.ok(agendamentoService.listar());
	}

	// TODO Implementar atualizar() e Deletar()

	
}
