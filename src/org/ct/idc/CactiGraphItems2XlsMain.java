package org.ct.idc;

//import java.util.List;
import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CactiGraphItems2XlsMain {
	public static void main(String[] args) {
		
		// Login and get the cookies
		String cactiLoginURL = "http://10.2.0.50/index.php";
		String username = "szpeif";
		String password = "819131";
		CactiLogin cactiCookies = new CactiLogin();
		Map<String, String> cookies = cactiCookies.login(cactiLoginURL,
				username, password);
		cookies.remove("LoginResult");

		// URL of graph edit page
		String graphEditPageURL = "http://10.2.0.50/graphs.php?action=graph_edit&id=8387";
		
		// generate graph items list
		GraphItemsAssemble graphItemsAssemble = new GraphItemsAssemble(graphEditPageURL, cookies);
		graphItemsAssemble.load();
		List<Item> graphItemsList = graphItemsAssemble.getGraphItemsList();

		XlsGenerator xlsGenerator = new XlsGenerator(graphItemsList);
		xlsGenerator.creat();
		
	}

}
