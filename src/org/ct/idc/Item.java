package org.ct.idc;

public class Item {
	// get values of attributes below from item content
	private String rowTaskItemId = "";
	private String rowColorId = "";
	private String rowAlpha = "";
	private String rowGraphTypeId = "";
	private String rowConsolidationFunctionId = "";
	private String rowCdefId = "";
	private String rowValue = "";
	private String rowGprintId = "";
	private String rowTextFormat = "";
	private String rowHardReturn = "";
	private String rowSequence = "";
	// get values of attributes below from item abstract 
	private String itemURL = "";
	private String itemNum = "";
	private String trafficDirection = "";

	// Initialize
	Item() {

	}

	// Set method
	public void setRowTaskItemId(String inRowTaskItemId) {
		rowTaskItemId = inRowTaskItemId;
	}

	public void setRowColorId(String inRowColorId) {
		rowColorId = inRowColorId;
	}

	public void setRowAlpha(String inRowAlpha) {
		rowAlpha = inRowAlpha;
	}

	public void setRowGraphTypeId(String inRowGraphTypeId) {
		rowGraphTypeId = inRowGraphTypeId;
	}

	public void setRowConsolidationFunctionId(
			String inRowConsolidationFunctionId) {
		rowConsolidationFunctionId = inRowConsolidationFunctionId;
	}

	public void setRowCdefId(String inRowCdefId) {
		rowCdefId = inRowCdefId;
	}

	public void setRowValue(String inRowValue) {
		rowValue = inRowValue;
	}

	public void setRowGprintId(String inRowGprintId) {
		rowGprintId = inRowGprintId;
	}

	public void setRowTextFormat(String inRowTextFormat) {
		rowTextFormat = inRowTextFormat;
	}

	public void setRowHardReturn(String inRowHardReturn) {
		rowHardReturn = inRowHardReturn;
	}

	public void setRowSequence(String inRowSequence) {
		rowSequence = inRowSequence;
	}

	public void setItemURL(String inItemURL) {
		itemURL = inItemURL;
	}

	public void setItemNum(String inItemNum) {
		itemNum = inItemNum;
	};

	public void setTrafficDirection(String inTrafficDirection) {
		trafficDirection = inTrafficDirection;
	}

	// Get method
	public String getRowTaskItemId() {

		return rowTaskItemId;
	}

	public String getRowColorId() {

		return rowColorId;
	}

	public String getRowAlpha() {

		return rowAlpha;
	}

	public String getRowGraphTypeId() {

		return rowGraphTypeId;
	}

	public String getRowConsolidationFunctionId() {

		return rowConsolidationFunctionId;
	}

	public String getRowCdefId() {

		return rowCdefId;
	}

	public String getRowValue() {

		return rowValue;
	}

	public String getRowGprintId() {

		return rowGprintId;
	}

	public String getRowTextFormat() {

		return rowTextFormat;
	}

	public String getRowHardReturn() {

		return rowHardReturn;
	}

	public String getRowSequence() {

		return rowSequence;
	}

	public String getItemURL() {

		return itemURL;
	}

	public String getItemNum() {

		return itemNum;
	}

	public String getTrafficDirection() {

		return trafficDirection;
	}

}
