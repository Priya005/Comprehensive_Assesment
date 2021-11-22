package runnerBDD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ={"features"},
		glue = {"com.mindtree.stepdefinations"},
		dryRun = false,
		monochrome = true)

public class BigSmallRunner extends AbstractTestNGCucumberTests
{

}