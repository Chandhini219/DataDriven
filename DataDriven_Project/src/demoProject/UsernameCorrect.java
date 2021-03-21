package demoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class UsernameCorrect {
	
	@Test
	@Parameters({"uname","pswrd"})
	public void passwordIswrong(String name,String upassword)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(name);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(upassword);
		WebElement submit=driver.findElement(By.id("btnLogin"));
		submit.click();
	}


}
