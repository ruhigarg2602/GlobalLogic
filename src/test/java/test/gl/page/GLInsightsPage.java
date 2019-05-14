package test.gl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GLInsightsPage extends GLBasePage {
	public static final String BLOGS_PAGE_LINK_TEXT = "BLOGS";
	public static final String MENU_LINK_CSS_SELECTOR = "#menu-news-insights li a";
	
	private GLBlogsPage blogsPage;
	
	public GLInsightsPage(WebDriver driver) {
		super(driver);
	}
	
	public GLBlogsPage gotoBlogs() {
		clickOnBlogs();
		this.blogsPage = new GLBlogsPage(getDriver());
		return this.blogsPage;
	}
	
	private void clickOnBlogs() {
		List<WebElement> allInsights = getDriver().findElements(By.cssSelector(MENU_LINK_CSS_SELECTOR));
		WebElement allInsightsLinks = null;
		for (WebElement elem : allInsights) {
			if (BLOGS_PAGE_LINK_TEXT.equals(elem.getText())) {
				allInsightsLinks = elem;
			}
		}

		allInsightsLinks.click();
		timeWait(2000);
	}
}
