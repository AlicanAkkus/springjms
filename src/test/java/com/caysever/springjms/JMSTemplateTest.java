package com.caysever.springjms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.caysever.jms.MessageReceiver;
import com.caysever.jms.MessageSender;

/**
 * Unit test for simple App.
 */
public class JMSTemplateTest {

	ApplicationContext ctx;
	MessageSender messageSender;
	MessageReceiver messageReceiver;

	@Before
	public void initialize() {
		ctx = new FileSystemXmlApplicationContext("conf/appContext.xml");

		messageSender = (MessageSender) ctx.getBean("jmsSender");
		messageReceiver = (MessageReceiver) ctx.getBean("jmsReceiver");

	}

	@Test
	public void jmsSenderReceiver() throws InterruptedException {
		
		while (true) {
			messageSender.sendMessage("Test DATA");
			messageReceiver.receiveMessage();
			
			Thread.currentThread().sleep(1000);
		}

	}

}
