package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void launchUrl(String url) {
		
		driver.get(url);
	}
	public static void maxWindow() {
		driver.manage().window().maximize();

	}
	public static void fillTextbox(WebElement element, String value) {
		element.sendKeys(value);

	}
	public static void btnClick(WebElement ref) {
		ref.click();		
	}
	public static void pageTitle() {
		String name = driver.getTitle();
		System.out.println(name);
	}
	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	public static String readExecel(int rowNo, int cellNo) throws IOException {
		
		File f = new File("C:\\Users\\Loghesh\\eclipse-workspace\\CucumberTask\\Excel\\register.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet("Sheet1");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name = "";
		if (type==1) {
			name = c.getStringCellValue();
			}else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat form = new SimpleDateFormat("dd-mm-yyy");
				name = form.format(d);
			}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			name = String.valueOf(l);			
		}
		return name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
