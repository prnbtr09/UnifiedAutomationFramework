package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects extends BasePageObjects{
    public HomePageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement addToCart=elementByXpath("(//*[text()='Add to cart'])[1]");
}
