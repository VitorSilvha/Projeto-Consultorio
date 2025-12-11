package com.consultorio.apiGw.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consultorio.apiGw.entidades.Paciente;

@FeignClient(
        value = "PacienteRoteamento",
        url = "http://localhost:9003/"
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
    
	@RequestMapping(value = "/v1/paciente/existe-paciente/{id}",method = RequestMethod.GET)
	ResponseEntity<Boolean> existePaciente(@PathVariable Integer id);
	
	@RequestMapping(value = "/v1/paciente/buscar-paciente/{id}",method = RequestMethod.GET)
	ResponseEntity<Paciente> buscarPaciente(@PathVariable Integer id);

}