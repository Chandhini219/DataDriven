package demoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginValidate {
	
	
String[][] data={	{"Admin","wrong"},
	{"wrong","admin123"},
	{"Admin","admin123"},
	{"wrong","wrong"} };
	
@DataProvider(name="result")
	public String[][] validation()
	{
	return data;
	}
	
	@Test(dataProvider = "result")
	public void loginExample(String uname,String pswrd)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(pswrd);
		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
	}


}
