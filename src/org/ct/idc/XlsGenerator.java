package org.ct.idc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class XlsGenerator {
	private List<Item> graphItemList;
	private Workbook workbook;
	private Sheet sheet;

	XlsGenerator() {
		System.out
				.println("Error: Please use the constructor with parameters!");
	}

	XlsGenerator(List<Item> inGraphItemsList) {
		graphItemList = inGraphItemsList;
	}

	public void creat() {
		try {
			// create workbook and sheet
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("graph items detail");
			// initialize the first line with titles
			this.initSheet();

			System.out.println("Write graph items to Excel file.");
			
			// write items list content to xls sheet
			for (int count = 0; count < graphItemList.size(); count++) {
				this.setRowValue(count, graphItemList.get(count));
				
			}

			// Write the output to a file
			FileOutputStream fileOut = new FileOutputStream(
					"cactiGraphItems.xls");
			workbook.write(fileOut);

			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initSheet() {
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("rowNum");
		titleRow.createCell(1).setCellValue("itemNum");
		titleRow.createCell(2).setCellValue("trafficDirection");
		titleRow.createCell(3).setCellValue("rowTaskItemId");
		titleRow.createCell(4).setCellValue("rowGraphTypeId");
		titleRow.createCell(5).setCellValue("rowConsolidationFunctionId");
		titleRow.createCell(6).setCellValue("rowGprintId");
		titleRow.createCell(7).setCellValue("rowCdefId");
		titleRow.createCell(8).setCellValue("rowSequence");
		titleRow.createCell(9).setCellValue("rowTextFormat");
		titleRow.createCell(10).setCellValue("rowHardReturn");
		titleRow.createCell(11).setCellValue("rowValue");
		titleRow.createCell(12).setCellValue("rowAlpha");
		titleRow.createCell(13).setCellValue("rowColorId");
		titleRow.createCell(14).setCellValue("itemURL");
		
		System.out.println("Excel File " + " has been initiallized!");

	}

	private void setRowValue(int inRowNum, Item inItem) {
		int rowNum = inRowNum + 1;
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue(rowNum);
		row.createCell(1).setCellValue(inItem.getItemNum());
		row.createCell(2).setCellValue(inItem.getTrafficDirection());
		row.createCell(3).setCellValue(inItem.getRowTaskItemId());
		row.createCell(4).setCellValue(inItem.getRowGraphTypeId());
		row.createCell(5).setCellValue(inItem.getRowConsolidationFunctionId());
		row.createCell(6).setCellValue(inItem.getRowGprintId());
		row.createCell(7).setCellValue(inItem.getRowCdefId());
		row.createCell(8).setCellValue(inItem.getRowSequence());
		row.createCell(9).setCellValue(inItem.getRowTextFormat());
		row.createCell(10).setCellValue(inItem.getRowHardReturn());
		row.createCell(11).setCellValue(inItem.getRowValue());
		row.createCell(12).setCellValue(inItem.getRowAlpha());
		row.createCell(13).setCellValue(inItem.getRowColorId());
		row.createCell(14).setCellValue(inItem.getItemURL());
		System.out.println("--> Write " + rowNum + " Item content to the xls file.");
	}

}
