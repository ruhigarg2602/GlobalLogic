package test.gl.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class GLBasePage {
	private WebDriver driver;
	
	public GLBasePage(WebDriver driver){
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void timeWait(int time) {
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
}
