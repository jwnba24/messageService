package com.demo.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.demo.service.ProviderService;

public class ProviderServiceImpl  implements ProviderService{

	Destination destination;
	
	public void setDestination(Destination destination) {
		this.destination = destination;
	}


	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	JmsTemplate jmsTemplate;
	
	
	public String sendMessage(final String message) {
		// TODO Auto-generated method stub
		jmsTemplate.send(destination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage textMessage=session.createTextMessage(message);
				System.out.println("发送消息："+message);
				return textMessage;
			}
		});
		return "这是远程调用";
	}
	
}
