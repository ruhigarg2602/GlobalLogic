package test.gl.main;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import test.gl.helper.GLHelper;
import test.gl.page.GLBlogsByAuthorPage;
import test.gl.page.GLBlogsByCategoryPage;
import test.gl.page.GLBlogsPage;
import test.gl.page.GLHomePage;
import test.gl.page.GLInsightsPage;

@RunWith(Cucumber.class)

public class GLBlogTest {

	private WebDriver driver;
	private GLHomePage homePage;
	private GLInsightsPage insightsPage;
	private GLBlogsPage blogsPage;
	private GLBlogsByCategoryPage blogsByCategoryPage;
	private GLBlogsByAuthorPage blogsByAuthorPage;
	
	public GLBlogTest(){
		driver = GLHelper.loadDriver();
	}

	@Given("^user is on GlobalLogic home page$")
	public void user_is_on_globallogic_home_page() throws Throwable {
		homePage = new GLHomePage(driver);
		homePage.load();
	}

	@And("^goes to blogs page$")
	public void goes_to_blogs_page() throws Throwable {
		insightsPage = homePage.gotoInsights();
		blogsPage = insightsPage.gotoBlogs();
	}

	@And("^browses blogs by category$")
	public void browses_blogs_by_category() throws Throwable {
		blogsByCategoryPage = blogsPage.gotoBlogsByCategoryPage();
	}
	
	@Then("^sees blogs for that category$")
	public void sees_blogs_by_category() throws Throwable {
		String categoryName = blogsByCategoryPage.getCategory();
		assertEquals(blogsPage.getSelectedCategory().toLowerCase(), categoryName.toLowerCase());
	}
	
	@And("^moves back to the previous page$")
	public void moves_back_to_the_previous_page() {
		blogsByCategoryPage.goBack();
	}
	
	@And("^browses blogs by author$")
	public void browses_blogs_by_author() throws Throwable {
		blogsByAuthorPage = blogsPage.gotoBlogsByAuthorPage();
	}
	
	@Then("^sees the blogs by that author$")
	public void he_sees_the_blogs_by_that_author() throws Throwable {
		String authorName = blogsByAuthorPage.getAuthor();
		//assertEquals(blogsPage.getSelectedAuthor().toLowerCase(), authorName.toLowerCase());
	}

	@After public void cleanUp(){
		GLHelper.timeWait(2);
		driver.close(); 
	} 

}
