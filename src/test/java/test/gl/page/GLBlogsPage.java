package test.gl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.gl.helper.GLHelper;

public class GLBlogsPage extends GLBasePage{
	private static final String CATEGORIES_CSS_SELECTOR = ".top-cat";
	private static final String AUTHORS_CSS_SELECTOR = ".top-cat";
	private static final String CATEGORY_LINK_CSS_SELECTOR = ".cat.cat-desc ul li a";
	private static final String AUTHOR_LINK_CSS_SELECTOR = ".aut.cat-desc ul li .auth-list-txt a";

	private GLBlogsByCategoryPage blogsByCategoryPage;
	private GLBlogsByAuthorPage blogsByAuthorPage;
	
	private String selectedCategory;
	private String selectedAuthor;

	public GLBlogsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public String getSelectedAuthor() {
		return selectedAuthor;
	}

	public void setSelectedAuthor(String selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}

	public GLBlogsByCategoryPage gotoBlogsByCategoryPage() throws Exception {
		clickOnRandomCategory();
		this.blogsByCategoryPage = new GLBlogsByCategoryPage(getDriver());
		return this.blogsByCategoryPage;
	}
	
	public GLBlogsByAuthorPage gotoBlogsByAuthorPage() throws Exception {
		clickOnRandomAuthor();
		this.blogsByAuthorPage = new GLBlogsByAuthorPage(getDriver());
		return this.blogsByAuthorPage;
	}
	
	private void clickOnRandomCategory() throws Exception{
		scrollDownToCategory();
		WebElement catLink = getRandomCategoryElement();
		selectedCategory = catLink.getText();
		catLink.click();
		timeWait(10);
	}
	
	private void clickOnRandomAuthor() throws Exception {
		scrollDownToAuthor();
		WebElement authorLink = getRandomAuthorElement();
		selectedAuthor = authorLink.getText();
		authorLink.click();
		timeWait(10);
	}
	
	private void scrollDownToCategory() throws Exception {
		WebElement categoryContainer = getCategoryContainer();
		GLHelper.scrollTo(getDriver(), categoryContainer);
	}

	private void scrollDownToAuthor() throws Exception {
		WebElement authorContainer = getAuthorContainer();
		GLHelper.scrollTo(getDriver(), authorContainer);
	}
	
	private WebElement getCategoryContainer() {
		List<WebElement> sidebarContainers = getDriver().findElements(By.cssSelector(CATEGORIES_CSS_SELECTOR));
		return sidebarContainers.get(0);
	}
	
	private WebElement getAuthorContainer() {
		List<WebElement> sidebarContainers = getDriver().findElements(By.cssSelector(AUTHORS_CSS_SELECTOR));
		return sidebarContainers.get(1);
	}
	
	private WebElement getRandomCategoryElement() {
		List<WebElement> allCatLinks = getCategoryContainer().findElements(By.cssSelector(CATEGORY_LINK_CSS_SELECTOR));
		int randomIndex = new Double(Math.floor(allCatLinks.size() * Math.random())).intValue();
		return allCatLinks.get(randomIndex);
	}
	
	private WebElement getRandomAuthorElement() {
		List<WebElement> allAuthorLinks = getAuthorContainer().findElements(By.cssSelector(AUTHOR_LINK_CSS_SELECTOR));
		int randomIndex = new Double(Math.floor(allAuthorLinks.size() * Math.random())).intValue();
		return allAuthorLinks.get(randomIndex);
	}
}
