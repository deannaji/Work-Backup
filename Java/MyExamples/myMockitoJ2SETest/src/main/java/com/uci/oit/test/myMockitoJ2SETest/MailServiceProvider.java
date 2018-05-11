package com.uci.oit.test.myMockitoJ2SETest;

public interface MailServiceProvider {
	String getProviderAddress();
	boolean send(String mail, String message);
}
