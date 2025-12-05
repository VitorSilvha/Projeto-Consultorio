package com.consultorio.apiGw.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.agendamentoServer.entidades.Agendamento;
import com.consultorio.agendamentoServer.service.AgendamentoService;
import com.consultorio.apiGw.configuration.RetreiveMessageErrorDecoder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@FeignClient(
        name = "ClienteRoteamento",
        url = "http://localhost:9002/",
        configuration = {RetreiveMessageErrorDecoder.class}
)

public class AgendamentoRoteamento {
	
	
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento);
		
	
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar() ;
	
}