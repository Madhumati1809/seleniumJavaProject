package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;



public class LoginPageTest extends BaseTest {

	SoftAssert softAssert = new SoftAssert();



	@Test
	public void loginTest() throws InterruptedException {
		
		String username="";
		String password="";

		driver.findElement(By.xpath(loc.getProperty("LoginElement")));
		driver.findElement(By.xpath(loc.getProperty("LoginElement"))).click();
		driver.findElement(By.xpath(loc.getProperty("username"))).sendKeys(username);		
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
		
		if(username.isEmpty()) {
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
			Thread.sleep(5000);
			String error_color=driver.findElement(By.xpath(loc.getProperty("username"))).getCssValue("border-top-color");
			if(error_color.equals(loc.getProperty("error_color"))) {
				String error_msg=driver.findElement(By.xpath(loc.getProperty("username_err_ele"))).getText();
				softAssert.assertEquals(error_msg,loc.getProperty("user_err_msg"));
			}
		}else if(password.isEmpty()){
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
			Thread.sleep(5000);
			String error_msg=driver.findElement(By.xpath(loc.getProperty("pass_error_msg_ele"))).getText();
			softAssert.assertEquals(error_msg,loc.getProperty("pass_err_msg"));
		}else {
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
		}


	}

}
