package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;



public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginTest() {
		
		driver.findElement(By.xpath(loc.getProperty("LoginElement")));
		driver.findElement(By.xpath(loc.getProperty("LoginElement"))).click();

	}

}
