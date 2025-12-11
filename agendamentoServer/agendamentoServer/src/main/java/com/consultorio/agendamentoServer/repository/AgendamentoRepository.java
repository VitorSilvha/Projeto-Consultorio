package com.consultorio.agendamentoServer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.consultorio.agendamentoServer.entidades.Agendamento;

@Repository
public class AgendamentoRepository {

	private HashMap<Integer, Agendamento> mapaAgendamento = new HashMap<Integer, Agendamento>();
	private static Integer id = 1;

	public Integer salvar(Agendamento agendamento) throws Exception {
		System.out.println("Executando salvara agendamento: " + agendamento);

		Integer idNovo = id + 1;
		agendamento.setIdAgendamento(idNovo);
		mapaAgendamento.put(idNovo, agendamento);
		id = idNovo;
		return idNovo;

	}

	public List<Agendamento> listar() {
		return new ArrayList<Agendamento>(mapaAgendamento.values());
	}

}
