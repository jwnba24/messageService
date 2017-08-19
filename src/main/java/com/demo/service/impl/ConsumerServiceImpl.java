package com.demo.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

import com.demo.service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {

	
	private Destination destination;
	
	private JmsTemplate jmsTemplate;
	
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String receiveMessage() {
		// TODO Auto-generated method stub
		TextMessage message=(TextMessage) jmsTemplate.receive(destination);
		try {
			return message.getText();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
