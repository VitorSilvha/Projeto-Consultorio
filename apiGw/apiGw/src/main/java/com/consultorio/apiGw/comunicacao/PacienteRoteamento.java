package com.consultorio.apiGw.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.apiGw.configuration.RetreiveMessageErrorDecoder;
import com.consultorio.apiGw.entidades.Paciente;

@FeignClient(
        name = "ClienteRoteamento",
        url = "http://localhost:9000/",
        configuration = {RetreiveMessageErrorDecoder.class}
)
public interface PacienteRoteamento {

    @RequestMapping(value = "/v1/paciente", method = RequestMethod.POST)
    ResponseEntity<String> salvar(@RequestBody Paciente paciente);

    @RequestMapping(value = "/v1/paciente", method = RequestMethod.GET)
    ResponseEntity<List<Paciente>> listar();

    @RequestMapping(value = "/v1/paciente/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletar(@PathVariable Integer id);

    @RequestMapping(value = "/v1/paciente", method = RequestMethod.PUT)
    ResponseEntity<String> atualizar(@RequestBody Paciente paciente);
    
	@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Integer id);
	
	@RequestMapping(value = "/v1/cliente/buscar-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Paciente> buscarCliente(@PathVariable Integer id);

}