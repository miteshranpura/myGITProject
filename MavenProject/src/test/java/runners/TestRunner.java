package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		plugin = {"pretty","html:target/htmlreports.html"},
//		monochrome = true,
		dryRun = false		
		)

public class TestRunner {
	
}