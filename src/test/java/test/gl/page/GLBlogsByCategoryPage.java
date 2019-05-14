package test.gl.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GLBlogsByCategoryPage extends GLBasePage{
	private static final String CATEGORY_NAME_CSS_SELECTOR = ".hero-title";
	
	public GLBlogsByCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCategory() {
		String categoryName = getDriver().findElement(By.cssSelector(CATEGORY_NAME_CSS_SELECTOR)).getText();
		return categoryName.trim();
	}
}
