package test.gl.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/test/gl/features",glue="test/gl/main")
public class GLBlogRunnerTest {

}
