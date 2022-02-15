package com.Exel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WriteEx2 {
	Workbook wb=null;
	Sheet sh=null;
	Row row=null;
	Cell cell=null;
	FileOutputStream fos=null;
	public void writeDataIntoCell(String filePath,String sheetname, int rownum, int cellnum, String data) throws Exception {
		FileInputStream fis=new FileInputStream(filePath);
		    wb=new WorkbookFactory().create(fis);
		if(wb.getSheet(sheetname)==null)
			sh=wb.createSheet(sheetname);
			sh=wb.getSheet(sheetname);
			 
		if(sh.getRow(rownum)==null)
			 row=sh.createRow(rownum);
		 else
			row=sh.getRow(rownum);
		if(row.getCell(cellnum)==null)
			cell=row.createCell(cellnum);
		else
			cell=row.getCell(cellnum);
		cell.setCellValue(data);
			
		fos=new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
				
	}
	@Test
	public void test01() throws Exception {
		
		System.setProperty("webdriver,chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("1111111111");
		driver.get("file:///F:/OJT/sel%20software/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/pages/examples/users.html");
					List <WebElement> headers=driver.findElements(By.tagName("th"));
				for(WebElement header:headers) {
					writeDataIntoCell("Demo1.xlsx", "WebData", 0, headers.indexOf(header), header.getText());
			
				}
					List <WebElement> rows=driver.findElements(By.xpath("//tr"));
		        for(int i=2;i<=rows.size();i++) {
		        	List <WebElement> cols=driver.findElements(By.xpath("//tr["+i+"]/td"));      	
		        	for(WebElement col:cols) {
		        		writeDataIntoCell("Demo1.xlsx", "WebData", i-1, cols.indexOf(col), col.getText());
		          System.out.println(cols+"  ");
		        	}
		        
		        }
		        System.out.println("11111");
					
		
				}

		
		
	
}