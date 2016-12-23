package com.caysever.jms;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {

	JmsTemplate jmsTemplate;
	Destination destination;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public void receiveMessage() {
		try {
			Message message = null;
			if (destination == null) {
				message  = jmsTemplate.receive();
			} else {
				message = jmsTemplate.receive(destination);
			}

			if(message != null){
				System.out.println("Received message : " + ((TextMessage) message).getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
