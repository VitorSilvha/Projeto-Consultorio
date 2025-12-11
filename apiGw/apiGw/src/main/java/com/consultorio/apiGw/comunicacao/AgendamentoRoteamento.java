package com.consultorio.apiGw.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.agendamentoServer.entidades.Agendamento;
import com.consultorio.apiGw.configuration.RetreiveMessageErrorDecoder;




@FeignClient(
        name = "ClienteRoteamento",
        url = "http://localhost:9002/",
        configuration = {RetreiveMessageErrorDecoder.class}
)

public interface AgendamentoRoteamento {
	
	
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Agendamento agendamento);
		
	@RequestMapping(value = "/v1/agendamento/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id);
	
	@RequestMapping(value = "/v1/agendamento", method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar() ;
	
	@RequestMapping(value = "/v1/agendamento",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Agendamento agendamento);
	
		
}