package stepDefs;

import driverManager.drivers.CreateDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObjects;

public class HomePageStepDef {
    WebDriver driver= CreateDriver.getInstance().getDriver();
    HomePageObjects homePageObjects;

    @Given("user click on {string}")
    public void clickElement(String option){
        homePageObjects=new HomePageObjects(driver);
        homePageObjects.addToCart.click();

    }
}
