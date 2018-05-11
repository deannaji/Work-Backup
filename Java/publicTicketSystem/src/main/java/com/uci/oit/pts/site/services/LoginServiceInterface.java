package com.uci.oit.pts.site.services;

import java.io.IOException;

public interface LoginServiceInterface {
	public String authenticateUciWebAuth(String ucinetid_auth) throws IOException;
	
	boolean checkLoginStatus();
	
	void logUserIn(String username);
	
	void logUserOut();
}
