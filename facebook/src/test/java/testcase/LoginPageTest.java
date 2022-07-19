package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;



public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginTest() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("LoginElement")));
		driver.findElement(By.xpath(loc.getProperty("LoginElement"))).click();
		driver.findElement(By.xpath(loc.getProperty("username"))).sendKeys("");
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys("Tatu@12345");
		driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();

		
	}

}
