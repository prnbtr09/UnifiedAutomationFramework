package stepDefs;

import driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObjects;

import java.util.List;
import java.util.Map;

public class LoginStepDef {
    WebDriver driver= CreateDriver.getInstance().getDriver();
    LoginPageObjects loginPageObjects;


    @Given("user has launched url {string}")
    public void launchApplication(String url){

        driver.get(url);
    }

    @Given("user has logged in to application using following credentials")
    public void loginToApp(DataTable table) {
        loginPageObjects = new LoginPageObjects(driver);
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        loginPageObjects.userName.sendKeys(credentials.get(0).get("UserName"));
        loginPageObjects.password.sendKeys(credentials.get(0).get("Password"));
        loginPageObjects.loginButton.click();


    }


}
