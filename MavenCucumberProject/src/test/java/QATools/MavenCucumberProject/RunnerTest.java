package QATools.MavenCucumberProject;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource",
		glue= "QATools.MavenCucumberProject",
		monochrome = true,
		plugin = {"pretty" , "html:target/html/outpuit.html"}
		//tags = {} Running multiple feature file using tags @Annotation (tags needs to be in featrure file)
		// to run multiple runner test, run the suite as maven test. 
		)

public class RunnerTest {

}