package org.ct.idc;

import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GraphEditPage extends Page{
	private Elements itemsList = null;
	private Elements itemAbstracts = null;

	GraphEditPage() {
		super();
	}

	GraphEditPage(String inGraphEditURL, Map<String, String> inCookies) {
		super(inGraphEditURL, inCookies);
		itemAbstracts = new Elements();
		this.getItemsList();
	}

	private void getItemsList() {
		itemsList = pageDoc.getElementsMatchingOwnText("Item #");
	}

	public Elements getItemsAbstracts() {
		int itemsNum = itemsList.size();
		for(int counter = 0; counter < itemsNum; counter++){
			Element singleItemAbstract = this.itemsList.get(counter).parent().parent().parent();
			itemAbstracts.add(counter, singleItemAbstract);
		}
		return itemAbstracts;
	}

}
