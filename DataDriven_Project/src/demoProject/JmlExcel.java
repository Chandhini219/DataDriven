package demoProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JmlExcel {
	WebDriver driver;
	
	
	
	@BeforeTest	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider = "value")
	public void LoginValidate(String uname,String pswrd) {


		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(pswrd);
		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
	}

	@DataProvider(name="value")
	public String[][] datavalueset() throws BiffException, IOException
	{
		String data[][]=null;
		data=excelDatabase();
		return data;
	}

	public String[][] excelDatabase() throws BiffException, IOException
	{
		FileInputStream file=new FileInputStream("//C:\\Users\\vijayakumar\\Desktop\\OrangeDemo.xls");
		Workbook wb=Workbook.getWorkbook(file);
		Sheet sheet=wb.getSheet("Sheet1");
		int rows=sheet.getRows();
		int column=sheet.getColumns();
		String value[][]=new String[rows-1][column];
		for(int i=1;i<rows;i++) {
		for(int j=0;j<column;j++) {
		value[i-1][j]=	sheet.getCell(j, i).getContents();
		}
		}
		return value;
			}

	

	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
}