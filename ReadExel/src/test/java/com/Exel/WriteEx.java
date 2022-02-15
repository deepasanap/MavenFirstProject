package com.Exel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WriteEx {
	WebDriver driver=null;
	FileOutputStream fos=null;
	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;
	Row row=null;
	Cell cell=null;
	@Test
	public void writeDataIntoCell(String filepath,String sheetName, int rownum, int cellnum, String data) throws Exception {
		
		FileInputStream fis=new FileInputStream(filepath);
		 wb=WorkbookFactory.create(fis);
		if(wb.getSheet(sheetName)==null) 
			wb.createSheet(sheetName);
			sh=wb.getSheet(sheetName);
		
		if(sh.getRow(rownum)==null) 
			row=sh.createRow(rownum);
			else
				row=sh.getRow(rownum);
		
		if(row.getCell(cellnum)==null)
			cell= row.createCell(cellnum);
		else
			cell=row.getCell(cellnum);
		cell.setCellValue(data);
		System.out.println(1111);
		fos=new FileOutputStream(filepath);
		wb.write(fos);
		wb.close();
		fos.close();
	}	
		
	
	@Test
	public void test01() throws Exception {
		writeDataIntoCell("Demo2.xls", "JAVA", 0, 2, "mangesh@gmail.com");
		writeDataIntoCell("Demo2.xls", "JAVA", 2, 2, "123456");
		
	}
	
}

