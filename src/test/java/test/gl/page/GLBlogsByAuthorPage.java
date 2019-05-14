package test.gl.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GLBlogsByAuthorPage extends GLBasePage {
	private static final String AUTHOR_NAME_CSS_SELECTOR = ".author-data h2";
	
	public GLBlogsByAuthorPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAuthor() {
		return getDriver().findElement(By.cssSelector(AUTHOR_NAME_CSS_SELECTOR)).getText();
	}
}
