package com.uci.oit.pts.site.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceInterface{

	@Inject
	private HttpSession session; //getting a handle on HttpSession by simply only injecting it.
	
	
	@Override
	public String authenticateUciWebAuth(String ucinetid_auth) throws IOException {
		String url="https://login.uci.edu/ucinetid/webauth_check?ucinetid_auth="+ucinetid_auth;
		URL urlObj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();	
		
		//Parsing the response using buffered reader:
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer responseBuffer = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responseBuffer.append(inputLine+" ");
		}
		in.close();	
		
		String responseStr = responseBuffer.toString();
		//Now using Apache Commons String Utils lib (maven dependency) to parse the response string and get UCINetId.
		String ucinetid= StringUtils.substringBetween(responseStr, "ucinetid=","auth");
		
		return ucinetid;
	}
	
	@Override
	public boolean checkLoginStatus(){
		if(session.getAttribute("username") != null){
			return true;	
		}else{
			return false;
		}
	}

	@Override
	public void logUserIn(String username) {
		if(checkLoginStatus()){
			logUserOut();
		}
		session.setAttribute("username", username);
	}

	@Override
	public void logUserOut() {
		session.invalidate();
	}

}
