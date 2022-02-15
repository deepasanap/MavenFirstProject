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



public class ReadExelEx {
	DataFormatter df=null;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;
	Cell cell;
	
	@Test
public void getExeldata() throws Exception {
	 fis=new FileInputStream("Demo3.xlsx");
	 wb=WorkbookFactory.create(fis);
	 sh=wb.getSheet("login");
	int rows=sh.getLastRowNum();
	for(int i=0;i<=rows;i++) {
			int cols=sh.getRow(i).getLastCellNum();
			for(int j=0;j<cols;j++) {
				 cell=sh.getRow(i).getCell(j);
				 df=new DataFormatter();
				String data=df.formatCellValue(cell);
				System.out.print(data+"      ");
			}
			System.out.println("    ");
	}
	
}
		public String getCellData(int rownum, int cellnum) throws Exception {
		 fis=new FileInputStream("Demo3.xlsx");
		wb=WorkbookFactory.create(fis);
		 sh=wb.getSheet("login");
		 String data =df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		 return data; 
			}
	@Test
	public void LoginTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///F:/OJT/sel%20software/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(getCellData(1,0));	
		driver.findElement(By.id("password")).sendKeys(getCellData(1,1));	
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
}