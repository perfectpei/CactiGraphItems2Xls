/**
 *  This CactiCookies Class submit Username and Password to Login.
 *  Return Cookies and login result, FAILED or SUCCESS.
 */
package org.ct.idc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CactiLogin {

	public Map<String, String> login(String inCactiLoginURL,
			String inUsername, String inPassword) {
		
		// Login form data include action, Username and Password
		Map<String, String> loginFormData = new HashMap<String, String>();
		loginFormData.put("action", "login");
		loginFormData.put("login_username", inUsername);
		loginFormData.put("login_password", inPassword);
		
		// cookies to be returned
		Map<String, String> cookies = null;
		
		// POST a login request and collect the response.
		Connection.Response responseLogin = null;

		try {
			// Visit the Cacti login page, and get the cookies
			Connection.Response responseOpen = Jsoup
					.connect(inCactiLoginURL)
					.header("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Language", "zh-cn")
					.header("X-Requested-With", "XMLHttpRequest")
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36")
					.method(Method.POST).execute();
			
			// get cookies
			cookies = responseOpen.cookies();
			
			// Use cookies, username and password to login
			responseLogin = Jsoup
					.connect(inCactiLoginURL)
					.header("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Language", "zh-cn")
					.header("X-Requested-With", "XMLHttpRequest")
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36")
					.data(loginFormData)
					.method(Method.POST)
					.cookies(cookies)
					.execute();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Determin the login result from Response Body.
		Document responseDoc = Jsoup.parse(responseLogin.body());
		String responseTitle = responseDoc.title();
		
		if (responseTitle.equals("Login to Cacti")) {
			cookies.put("LoginResult", "FAILED");
			System.out.println("User " + inUsername +" Login failed! Something wrong! Please check!");
		} else if (responseTitle.equals("Cacti")){
			cookies.put("LoginResult", "SUCCESS");
			System.out.println("User " + inUsername +" Login successfully!");
		} else {
			cookies.put("LoginResult", "ERROR");
		}
		
		return cookies;

	}

}
