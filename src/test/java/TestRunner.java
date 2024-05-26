import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "src/test/java/Features/Search.feature",
		glue = {"StepDefinitions", "BaseHooks"},
		plugin = {"pretty", "html:target/cucumber.html"},
		dryRun = false
		)

public class TestRunner {
	
}
