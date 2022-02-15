package com.Exel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadEx2forDPEx {
	
	WebDriver driver;
	DataFormatter df=new DataFormatter();
	FileInputStream fis;
	Workbook wb;
	
	public String[][] Read(String filepath,String sheetname) throws Exception {
		
		 fis=new FileInputStream(filepath);
		 wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rows=sh.getLastRowNum();
		int columns=sh.getRow(rows).getLastCellNum();
		String data[][]=new String[rows][columns];
		for(int i=1;i<=rows;i++) {
			int cols=sh.getRow(i).getLastCellNum();//last col which having a data
			for(int j=0;j<cols;j++) {
				Cell cell=sh.getRow(i).getCell(j);
				data[i-1][j]=df.formatCellValue(cell);
                }
			
     }
		return data;
		
}
	
	public String getCelldata(int rownum, int cellnum) throws Exception {
		 fis=new FileInputStream("Demo1.xlsx");
		 wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("login");
		return df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		
		
	}
	
	
}
