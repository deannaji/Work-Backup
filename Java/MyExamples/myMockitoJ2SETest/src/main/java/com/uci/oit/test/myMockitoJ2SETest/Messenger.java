package com.uci.oit.test.myMockitoJ2SETest;

public class Messenger {
	private TemplateEngine templateEngine;
	private MailServer mailServer;
	
	public Messenger(TemplateEngine tempEng, MailServer server){
		this.templateEngine = tempEng;
		this.mailServer = server;
	}
	
	public void sendMessage(Client client, Template template){
		String msg = templateEngine.prepareMessage(client, template);
		mailServer.send(client.getLocation(), msg);
		
		//logging:
		String log="Message sent! \n Details:\n" +
		           "- Client name: "+client.getName()+" @ "+client.getLocation()+"\n"+
		           "- Server:"+mailServer.getProviderAddress()+"\n"+
		           "- Message content: \n"+msg;
		System.out.println(log);
	}
}
