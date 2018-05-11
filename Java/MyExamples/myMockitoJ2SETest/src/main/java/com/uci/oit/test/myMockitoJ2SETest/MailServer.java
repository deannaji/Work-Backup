package com.uci.oit.test.myMockitoJ2SETest;

public class MailServer implements MailServiceProvider{
    
	private String address;
	
	public MailServer(String address){
		this.address = address;
	}
	
	@Override
	public String getProviderAddress() {
		return address;
	}

	@Override
	public boolean send(String mail, String message) {
		return true;
	}

}
