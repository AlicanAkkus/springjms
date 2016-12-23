package com.caysever.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {

	JmsTemplate jmsTemplate;
	Destination destination;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void sendMessage(final String message) {
		try {
			MessageCreator creator = new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			};
			
			System.out.println("Sender message : " + message);
			jmsTemplate.send(destination, creator);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
