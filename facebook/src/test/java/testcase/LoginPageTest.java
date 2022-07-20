package testcase;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;



public class LoginPageTest extends BaseTest {

	SoftAssert softAssert = new SoftAssert();



	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		String username="swamimadhumati@gmail.com";
		
		String password="Tatu@12345";
		
		Date currentdate= new Date();
		String screenshotname =currentdate.toString().replace(" ", "-").replace(":", "-");

		driver.findElement(By.xpath(loc.getProperty("LoginElement")));
		driver.findElement(By.xpath(loc.getProperty("LoginElement"))).click();
		driver.findElement(By.xpath(loc.getProperty("username"))).sendKeys(username);		
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
		
		if(username.isEmpty()) {
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
			Thread.sleep(5000);
			String error_color=driver.findElement(By.xpath(loc.getProperty("username"))).getCssValue("border-top-color");
			
			File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File(".//screenshots//"+screenshotname+".png"));
			
			if(error_color.equals(loc.getProperty("error_color"))) {
				String error_msg=driver.findElement(By.xpath(loc.getProperty("username_err_ele"))).getText();
				softAssert.assertEquals(error_msg,loc.getProperty("user_err_msg"));
			}
		}else if(password.isEmpty()){
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
			File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File(".//screenshots//"+screenshotname+".png"));
			Thread.sleep(5000);
			String error_msg=driver.findElement(By.xpath(loc.getProperty("pass_error_msg_ele"))).getText();
			softAssert.assertEquals(error_msg,loc.getProperty("pass_err_msg"));
		}else {
			driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
			Thread.sleep(10000);
			File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File(".//screenshots//"+screenshotname+".png"));
			

			
		}


	}

}
