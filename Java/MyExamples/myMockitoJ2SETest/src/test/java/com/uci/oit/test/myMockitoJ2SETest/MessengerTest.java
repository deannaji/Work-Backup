package com.uci.oit.test.myMockitoJ2SETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class MessengerTest extends TestCase {

	@Test
	public void testSendMessage() {
		//Dummy
		Template template = mock(Template.class);
		
		//Test stubs
		Client client = mock(Client.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		MailServer mailServer = mock(MailServer.class);
		
		//System under test
		Messenger sut = new Messenger(templateEngine, mailServer);
		
		when(templateEngine.prepareMessage(client, template)).thenReturn("test message..");
		when(client.getLocation()).thenReturn("testEmail@domain.com");
		
		//Execution of sut method 
		sut.sendMessage(client, template);
		
		//Verification
		verify(mailServer).send("testEmail@domain.com","test message..");
		
	}

}
