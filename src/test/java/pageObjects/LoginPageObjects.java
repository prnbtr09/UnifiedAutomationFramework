package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects extends BasePageObjects {

    public LoginPageObjects(WebDriver driver) {
        super(driver);
    }


    public WebElement userName=elementByXpath("//input[@id='user-name']");

    public WebElement password=elementByXpath("//input[@id='password']");

    public WebElement loginButton=elementByXpath("//input[@id='login-button']");


}
