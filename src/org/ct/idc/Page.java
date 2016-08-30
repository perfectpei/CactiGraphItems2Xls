package org.ct.idc;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Page {
	private String pageURL = "";
	private Map<String, String> cookies = null;
	protected Document pageDoc = null;

	Page() {
		System.out
				.println("Error: Please use the constructor with parameters!");
	}

	Page(String inPageURL, Map<String, String> inCookies) {
		pageURL = inPageURL;
		cookies = inCookies;
		this.getDoc();
	}
	
	private void getDoc() {
		try {
			pageDoc = Jsoup
					.connect(pageURL)
					.header("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Language", "zh-cn")
					.header("X-Requested-With", "XMLHttpRequest")
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36")
					.cookies(cookies).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
