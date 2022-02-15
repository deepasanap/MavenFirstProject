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

public class ReadEx2Register {
	
	WebDriver driver;
	DataFormatter df=new DataFormatter();
	FileInputStream fis;
	Workbook wb;
	@Test
	public void Read() throws Exception {
		
		 fis=new FileInputStream("register.xlsx");
		 wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("register");
		int rows=sh.getLastRowNum();
		
		for(int i=0;i<=rows;i++) {
			int cols=sh.getRow(i).getLastCellNum();//last col which having a data
			for(int j=0;j<cols;j++) {
				Cell cell=sh.getRow(i).getCell(j);
				String data=df.formatCellValue(cell);
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		
		}
	
	public String getCelldata(int rownum, int cellnum) throws Exception {
		 fis=new FileInputStream("register.xlsx");
		 wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("register");
		return df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		
		
	}
	
	@Test
	public void LoginTest()throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///F:/OJT/sel%20software/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		driver.findElement(By.id("name")).sendKeys(getCelldata(1,0));
		driver.findElement(By.id("mobile")).sendKeys(getCelldata(1,1));	
		driver.findElement(By.id("email")).sendKeys(getCelldata(1,2));	
		driver.findElement(By.id("password")).sendKeys(getCelldata(1,3));	
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();
		
		driver.switchTo().alert().accept();
}
}
