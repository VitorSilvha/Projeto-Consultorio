package com.consultorio.pacienteServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultorio.pacienteServer.entidades.Paciente;
import com.consultorio.pacienteServer.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public String salvar(Paciente paciente) throws Exception{
		System.out.println("Salvando paciente na Service" + paciente);
		
		//  Validacao		
		if(paciente.getNome() == null || paciente.getNome().length() <= 2) {
			throw new Exception("Nome do paciente deve ter no minimo 3 caracter");
		}
		
		return pacienteRepository.salvar(paciente);
	}
	
	public List<Paciente> listar() {
		return pacienteRepository.listar();
	}	
	
	public boolean deletar(Integer id) {
		return pacienteRepository.deletar(id);
	}
	
	public boolean atualizar(Paciente paciente) {
		return pacienteRepository.atualizar(paciente);
	}
	
	public boolean existePaciente(Integer id) {
		return pacienteRepository.existePaciente(id);
	}
	
	public Paciente buscarPaciente(Integer id) { 
		return pacienteRepository.buscarPaciente(id);			
	}

	
}
