package test.gl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GLHomePage extends GLBasePage {
	public static final String HOME_PAGE_URL = "https://www.globallogic.com/";
	public static final String INSIGHTS_LINK_TEXT = "INSIGHTS";
	public static final String PRIMARY_MENU_LINK_SELECTOR = "#primary-menu li a";
	
	private GLInsightsPage insightsPage;
	
	public GLHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void load() {
		getDriver().get(HOME_PAGE_URL);
		timeWait(1000);
	}
	
	public GLInsightsPage gotoInsights(){
		clickOnInsights();
		this.insightsPage = new GLInsightsPage(getDriver());
		return this.insightsPage;
	}

	private void clickOnInsights() {
		List<WebElement> allMenuLinks = getDriver().findElements(By.cssSelector(PRIMARY_MENU_LINK_SELECTOR));
		WebElement insightsLink = null;
		for (WebElement elem : allMenuLinks) {
			if (INSIGHTS_LINK_TEXT.equals(elem.getText())) {
				insightsLink = elem;
			}
		}

		insightsLink.click();
	}
}
