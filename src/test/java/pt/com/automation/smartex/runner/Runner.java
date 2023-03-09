package pt.com.automation.smartex.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "pt.com.automation.smartex.steps" }, features = {
		"src/test/resources" },tags =  "@general")
public class Runner {
	
	

}
