package org.ct.idc;

import java.util.Map;

import org.jsoup.nodes.Element;

public class ItemPage extends Page{
	private Element itemContent = null;
	ItemPage() {
		super();
	}

	ItemPage(String inGraphEditURL, Map<String, String> inCookies) {
		super(inGraphEditURL, inCookies);
	}
	
	public Element getItemContent() {
		itemContent = pageDoc.getElementById("row_task_item_id").parent();
		return itemContent;
	}
	
	
}
