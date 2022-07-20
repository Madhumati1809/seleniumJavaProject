package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;



public class LoginPageTest extends BaseTest {

	SoftAssert softAssert = new SoftAssert();



	@Test
	public void loginTest() throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("LoginElement")));
		driver.findElement(By.xpath(loc.getProperty("LoginElement"))).click();
		driver.findElement(By.xpath(loc.getProperty("username"))).sendKeys("swamimadhumati@gmail.com");
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys("Tatu@12345");
		String windowHandle=driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();

		Thread.sleep(10000);

		String username_error_color=driver.findElement(By.xpath(loc.getProperty("username"))).getCssValue("border-top-color");
		if(username_error_color.equals(loc.getProperty("error_color"))) {
			System.out.println(username_error_color);
			softAssert.assertEquals(username_error_color,loc.getProperty("error_color"));
			softAssert.assertAll();
		}


	}

}
