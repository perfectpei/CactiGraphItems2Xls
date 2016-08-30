package org.ct.idc;

import java.util.ArrayList;
import java.util.List;

public class ItemsListExample {
	private List<Item> itemsListExample;
	
	public List<Item> create() {
		itemsListExample = new ArrayList<Item>();
		for(int count = 0; count < 10; count ++){
			Item item = new Item();
			this.createItem(count, item);
			itemsListExample.add(count, item);
		}
		return itemsListExample;
	}
	
	private Item createItem(int inItemNum, Item inItem){
		Item itemExample = inItem;
		itemExample.setItemNum("Item # " + inItemNum);
		itemExample.setTrafficDirection("traffic_out");
		itemExample.setRowTaskItemId("福永XXXXXXXXXXXXXXX");
		itemExample.setRowGraphTypeId("rowGraphTypeId");
		itemExample.setRowConsolidationFunctionId("rowConsolidationFunctionId");
		itemExample.setRowGprintId("rowGprintId");
		itemExample.setRowCdefId("rowCdefID");
		itemExample.setRowSequence("rowSequence");
		itemExample.setRowTextFormat("rowTextFormat");
		itemExample.setRowHardReturn("rowHardReturn");
		itemExample.setRowValue("rowValue");
		itemExample.setRowAlpha("rowAlpha");
		itemExample.setRowColorId("#FFFFFF");
		itemExample.setItemURL("http://10.2.0.50/XXXXXXXXXXXX");

		return itemExample;
	}
}
