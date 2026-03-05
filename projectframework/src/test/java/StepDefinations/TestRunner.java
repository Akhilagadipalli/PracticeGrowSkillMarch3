package StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features="src/test/java/FeatureFiles/",
			glue= {"StepDefinations"},
			tags="@smoke",
			dryRun =false,
			monochrome=false,
		plugin = {"pretty","html:target/HtmlReports/index.html",

		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	}
		)
public class TestRunner {
	

}
