package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.service.ConsumerService;

public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		ProviderService service=(ProviderService) applicationContext.getBean("providerService");
//		for(int i=0;i<10;i++){
//			service.sendMessage("message"+i);
//		}
		ConsumerService consumerService=(ConsumerService) applicationContext.getBean("consumerService");
		String result=consumerService.receiveMessage();
		System.out.println(result);
		System.out.println(123);
	}
	
}
