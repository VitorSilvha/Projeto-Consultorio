package com.consultorio.apiGw.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.apiGw.entidades.Agendamento;




@FeignClient(
        value = "AgendamentoRoteamento",
        url = "http://localhost:9002/"
)
public interface AgendamentoRoteamento {
	
	
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.POST)
	public ResponseEntity<String>salvar(@RequestBody Agendamento agendamento);
		
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar() ;

	
		
}