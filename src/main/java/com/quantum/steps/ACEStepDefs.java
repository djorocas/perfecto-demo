package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@QAFTestStepProvider
public class ACEStepDefs {

	private QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	private static final Logger LOGGER = Logger.getLogger(ACEStepDefs.class.getName());
    private Map<String, Object> restprms = new HashMap<>();

	private static void switchToContext(RemoteWebDriver driver, String context) {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
		Map<String, String> params = new HashMap<>();
		params.put(Constants.NAME, context);
		executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
	}

	@When("^I start device logging$")
	public void iStartDeviceLogging() {
		driver.executeScript(Constants.MOBILELOGSSTART, restprms);
	}

	@Then("^I stop device logging$")
	public void iStopDeviceLogging() {
		driver.executeScript(Constants.MOBILELOGSSTOP, restprms);
	}

    @When("^I start device vitals$")
    public void iStartDeviceVitals() {
        List<String> vitals = new ArrayList<>();
        vitals.add(Constants.ALL);
        restprms.put(Constants.VITALS, vitals);
        driver.executeScript(Constants.MOBILEMONITORSTART, restprms);
        restprms.remove(Constants.VITALS);
    }

    @Then("^I stop device vital$")
    public void iStopDeviceVitals() {
        driver.executeScript(Constants.MOBILEMONITORSTOP, restprms);
    }

    @When("^I start the device Map application$")
    public void iStartTheDeviceMapApplication() {
        restprms.put(Constants.PROPERTY, Constants.OS);
        String deviceOS = (String) driver.executeScript(Constants.MOBILEHANDSETINFO, restprms);
        restprms.remove(Constants.PROPERTY);
        if (deviceOS.equals(Constants.IOS)) {
            restprms.put(Constants.NAME, Constants.GOOGLEMAPS);
        } else {
            restprms.put(Constants.NAME, Constants.MAPS);
        }
        driver.executeScript(Constants.MOBILEAPPLICATIONOPEN, restprms);
        restprms.remove(Constants.NAME);
    }

    @Then("^I close the device Map application$")
    public void iCloseTheDeviceMapApplication() {
        restprms.put(Constants.PROPERTY, Constants.OS);
        String deviceOS = (String) driver.executeScript(Constants.MOBILEHANDSETINFO, restprms);
        restprms.remove(Constants.PROPERTY);
        if (deviceOS.equals(Constants.IOS)) {
            restprms.put(Constants.NAME, Constants.GOOGLEMAPS);
        } else {
            restprms.put(Constants.NAME, Constants.MAPS);
        }
        driver.executeScript(Constants.MOBILEAPPLICATIONCLOSE, restprms);
        restprms.remove(Constants.NAME);
    }

    @When("^I set the device packet loss to \"(.*?)\" Percent$")
    public void iSetTheDevicePacketLossPercentage(String packetLoss) {
        restprms.put(Constants.PACKETLOSS, packetLoss);
        driver.executeScript(Constants.MOBILEVNETWORKSTART, restprms);
        restprms.remove(Constants.PACKETLOSS);
    }

    @When("^I update the virtual network to \"(.*?)\"$")
    public void iUpdateTheVirtualNetworkTo(String profile) {
        restprms.put(Constants.PROFILE, profile);
        driver.executeScript(Constants.MOBILEVNETWORKUPDATE, restprms);
        restprms.remove(Constants.PROFILE);
    }

    @When("^I receive a phone call$")
    public void iReceiveAPhoneCall() {
        restprms.put(Constants.PROPERTY, Constants.DEVICEID);
        String deviceId = (String) driver.executeScript(Constants.MOBILEHANDSETINFO, restprms);
        restprms.remove(Constants.PROPERTY);
        restprms.put(Constants.TOHANDSET, deviceId);
        driver.executeScript(Constants.MOBILEGATEWAYCALL, restprms);
        restprms.remove(Constants.TOHANDSET);
    }

    @When("^I receive an SMS with the text: \"(.*?)\"$")
    public void iReceiveAnSMSWithTheText(String message) {
        restprms.put(Constants.PROPERTY, Constants.DEVICEID);
        String deviceId = (String) driver.executeScript(Constants.MOBILEHANDSETINFO, restprms);
        restprms.remove(Constants.PROPERTY);
        restprms.put(Constants.TOHANDSET, deviceId);
        restprms.put(Constants.BODY, message);
        driver.executeScript(Constants.MOBILEGATEWAYSMS, restprms);
        restprms.remove(Constants.TOHANDSET);
        restprms.remove(Constants.BODY);
    }

    @Then("^I take a device screenshot$")
    public void iTakeADeviceScreenshot() {
	    driver.getScreenshotAs(OutputType.BYTES);
    }

    @Given("^I start the device image capture application$")
    public void iStartTheDeviceImageCaptureApplication() {
        restprms.put(Constants.PROPERTY, Constants.OS);
        String deviceOS = (String) driver.executeScript(Constants.MOBILEHANDSETINFO, restprms);
        restprms.remove(Constants.PROPERTY);
        if (deviceOS.equals(Constants.IOS)) {
            restprms.put(Constants.NAME, Constants.GOOGLEMAPS);
        } else {
            restprms.put(Constants.NAME, Constants.MAPS);
        }
        driver.executeScript(Constants.MOBILEAPPLICATIONOPEN, restprms);
        restprms.remove(Constants.NAME);
    }


    private void testSleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e){
			LOGGER.log(Level.WARNING, "Interrupted!", e);
			// Restore interrupted state...
			Thread.currentThread().interrupt();}
	}
}