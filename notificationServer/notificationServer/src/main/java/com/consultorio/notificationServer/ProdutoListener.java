package com.consultorio.notificationServer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.consultorio.notificationServer.entidades.EventoEmail;
import com.google.gson.Gson;

@Component
public class ProdutoListener {

	@Value("${queue}")
	String queue;
	
	private Gson gson = new Gson();
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RabbitListener (queues = {"${queue}"})
    public void receive(@Payload String fileBody) {
		System.out.println("Mensagem recebida da fila " + queue + ": " +  fileBody);
		EventoEmail evento = gson.fromJson(fileBody, EventoEmail.class);
		
		System.out.println("email do cliente: " +  evento.getPaciente().getEmail());
		
		// NÃO ESTÁ ENVIANDO EMAIL, POIS NÃO CONSEGUIMOS ENVIAR.
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("contasecundariapadrao@gmail.com");
        message.setTo(evento.getPaciente().getEmail()); 
        message.setSubject(evento.getTituloEmail()); 
        message.setText(evento.getTextoEmail());
        //javaMailSender.send(message);
		
		
    }
}