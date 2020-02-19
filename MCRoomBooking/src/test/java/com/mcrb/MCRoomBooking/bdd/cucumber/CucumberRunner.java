package com.mcrb.MCRoomBooking.bdd.cucumber;



import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		overviewChartsReport = true,
		pdfPageSize = "A4 Landscape",
		toPDF = true,
		outputFolder = "target/81",
		retryCount = 3
		)
@CucumberOptions(
		features = "stories",
		glue = {"com.mcrb.MCRoomBooking.bdd.cucumber"},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","usage:target/cucumber-usage.json"}
		)
public class CucumberRunner {


}
