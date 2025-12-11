package com.consultorio.agendamentoServer.entidades;

import java.util.Date;

public class Agendamento {

	private Integer idAgendamento;
	private Integer idPaciente;
	private Date data;
	private String status; // ex: cancelado,  realizado, confirmado
	private String categoria; // ex: exame, consulta, cirurgia
	private String observacoes;

	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "---------------------------------------------" + "\nAgendamento" + "\nid do agendamento: "
				+ idAgendamento + "\nid do paciente: " + idPaciente + "\nData: " + data + "\nStatus: " + status
				+ "\nCategoria: " + categoria + "\nObservacoes: " + observacoes + "\n";
	}

}
