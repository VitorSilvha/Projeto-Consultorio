package com.consultorio.agendamentoServer.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultorio.agendamentoServer.entidades.Agendamento;
import com.consultorio.agendamentoServer.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public Integer salvar(Agendamento agendamento) throws Exception {
		validacao(agendamento);
		agendamento.setData(new Date());
		return agendamentoRepository.salvar(agendamento);
	}

	private void validacao(Agendamento agendamento) throws Exception {
		if (agendamento.getIdPaciente() == null) {
			throw new Exception("Id do Paciente invalido");
		}
		if (agendamento.getStatus() == null || agendamento.getStatus().equals("")) {
			throw new Exception("Status do agendaemnto invalido");
		}
		if (agendamento.getCategoria() == null || agendamento.getCategoria().equals("")) {
			throw new Exception("Categoria do agendaemnto invalido");
		}
	}

	public List<Agendamento> listar() {
		return agendamentoRepository.listar();
	}

}
