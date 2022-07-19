package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileReader reader;
	public static Properties prop = new Properties();
	
	@BeforeMethod
	public void setup() throws IOException {
		if(driver==null) {
			 reader= new FileReader("user.dir"+"\\src\\test\\resources\\testdata\\base.properties");
			prop.load(reader);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(prop.getProperty("baseurl"));
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get(prop.getProperty("baseurl"));
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
