package org.ct.idc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GraphItemsAssemble {
	private String graphEditPageURL;
	private Map<String, String> cookies;
	private Elements itemAbstracts;

	List<Item> graphItemsList;

	GraphItemsAssemble() {
		System.out
				.println("Error: Please use the constructor with parameters!");
	}

	GraphItemsAssemble(String inGraphEditPageURL, Map<String, String> inCookies) {
		graphEditPageURL = inGraphEditPageURL;
		cookies = inCookies;
		graphItemsList = new ArrayList<Item>();
	}

	// load graph edit pages and set itemAbstracts
	private void loadGraphEditPage() {
		GraphEditPage graphEditPage = new GraphEditPage(graphEditPageURL,
				cookies);
		itemAbstracts = graphEditPage.getItemsAbstracts();
	}

	// assemble items
	private void assemble() {
		int listSize = itemAbstracts.size();
		System.out.println("There are " + listSize
				+ " items in this Graph Edit Page.");
		for (int count = 0; count < listSize; count++) {
			Item item = new Item();
			Element singleItemAbstract = itemAbstracts.get(count);
			parseSingleItemAbstract(singleItemAbstract, item);

			String itemURL = "http://10.2.0.50/" + item.getItemURL();
			ItemPage itemPage = new ItemPage(itemURL, cookies);
			Element itemContent = itemPage.getItemContent();
			pareseSingleItemContent(itemContent, item);
			graphItemsList.add(count, item);
			System.out
					.println("--> " + item.getItemNum() + " has been parsed!");
		}
	}

	private void parseSingleItemAbstract(Element inSingleItemAbstract,
			Item inItem) {
		Elements tdTagElements = inSingleItemAbstract.getElementsByTag("td");
		inItem.setItemNum(tdTagElements.get(0).getElementsByTag("strong")
				.text());
		inItem.setItemURL(tdTagElements.get(0).getElementsByAttribute("href")
				.attr("href"));
		inItem.setTrafficDirection(tdTagElements.get(1).text());
	}

	private void pareseSingleItemContent(Element inItemContent, Item inItem) {
		inItem.setRowTaskItemId(inItemContent.getElementById("task_item_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowColorId(inItemContent.getElementById("color_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowAlpha(inItemContent.getElementById("alpha")
				.getElementsByAttribute("selected").text());

		inItem.setRowGraphTypeId(inItemContent.getElementById("graph_type_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowConsolidationFunctionId(inItemContent
				.getElementById("consolidation_function_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowCdefId(inItemContent.getElementById("cdef_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowValue(inItemContent.getElementById("row_value")
				.getElementsByTag("input").attr("value"));

		inItem.setRowGprintId(inItemContent.getElementById("gprint_id")
				.getElementsByAttribute("selected").text());

		inItem.setRowTextFormat(inItemContent.getElementById("row_text_format")
				.getElementsByTag("input").attr("value"));

		inItem.setRowHardReturn(inItemContent.getElementById("hard_return")
				.getElementsByTag("input").attr("checked"));

		inItem.setRowSequence(inItemContent.getElementById("row_sequence")
				.getElementsByTag("em").text());
	}

	public void load() {
		loadGraphEditPage();
		assemble();
		System.out.println("Graph Edit Page has been loaded!");
		System.out.println("================================");
		System.out.println("\n");
	}

	public List<Item> getGraphItemsList() {
		return graphItemsList;
	}

}
