package com.consultorio.pacienteServer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.consultorio.pacienteServer.entidades.Paciente;

@Repository
public class PacienteRepository {
	
	private ArrayList<Paciente> lista = new ArrayList<Paciente>();
	private static Integer id = 1;

	public String salvar(Paciente paciente) throws Exception {
		System.out.println("Executando salvar paciente" + paciente);
		
		paciente.setId(id);
		id++;
		lista.add(paciente);
		return paciente.getId().toString();		
		
	}
	
	public List<Paciente> listar(){
		return lista;
	}
	public boolean atualizar(Paciente paciente) {
		
		for (Paciente p : lista) {
	        if (p.getId().equals(paciente.getId())) {	            
	            p.setNome(paciente.getNome());	            
	            p.setCpf(paciente.getCpf());
	            p.setTelefone(paciente.getTelefone());
	            p.setDataNascimento(paciente.getDataNascimento());
	            p.setGenero(paciente.getGenero());	            
	            return true;
	            
	        }
	    }
		return false;
	}
	
	public boolean deletar(Integer id) {		
		return lista.removeIf(obj -> obj.getId().equals(id));
	}
	
	public boolean existePaciente(Integer id) {
		for (Paciente p : lista) {
			if(p.getId().equals(id)) {
				return true;
			}
			
		}
		return false;
	}
	
	public Paciente buscarPaciente(Integer id) { 
		for(Paciente p : lista) {
			if(p.getId().equals(id)) {
				return p;	
			}
		}	
		return null;
	}
}
