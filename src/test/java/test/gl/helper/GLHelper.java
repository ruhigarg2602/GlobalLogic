package test.gl.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GLHelper {	
	public static WebDriver loadDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	public static void timeWait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch(Exception e) { }
	}
	
	public static void scrollTo(WebDriver driver, WebElement element) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
		
		timeWait(1);
	}
}
