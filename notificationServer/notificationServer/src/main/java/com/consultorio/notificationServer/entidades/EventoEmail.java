package com.consultorio.notificationServer.entidades;

public class EventoEmail {

	private Agendamento agendamento;
	private Paciente paciente;
	private String tituloEmail;
	private String textoEmail;
	
	
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getTituloEmail() {
		return tituloEmail;
	}
	public void setTituloEmail(String tituloEmail) {
		this.tituloEmail = tituloEmail;
	}
	public String getTextoEmail() {
		return textoEmail;
	}
	public void setTextoEmail(String textoEmail) {
		this.textoEmail = textoEmail;
	}
	
	
}