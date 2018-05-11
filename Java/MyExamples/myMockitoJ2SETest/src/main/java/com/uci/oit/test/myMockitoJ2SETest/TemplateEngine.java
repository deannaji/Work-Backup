package com.uci.oit.test.myMockitoJ2SETest;

public class TemplateEngine {
	public String prepareMessage(Client client, Template template){
		String msgContent= "From: "+ client.getName() + "\n" + template.getTemplate();
		return msgContent;
	}
}
