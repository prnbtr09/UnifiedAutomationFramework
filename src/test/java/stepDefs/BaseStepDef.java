package stepDefs;

import driverManager.Configurations;
import driverManager.ConfigureDriver;
import driverManager.CreateDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BaseStepDef {
    private Configurations configurations;
    private ConfigureDriver configDriver;

    @Before(order = 1)
    public void setConfigurations(Scenario scenario) {
        configurations=new Configurations();
        configurations.onPrepare();
        configDriver=new ConfigureDriver();
    }

    @Before(value ="@ui",order=2)
    public void setUpUIRunner() throws Exception {
        configDriver.setUpDriver();
    }










}
