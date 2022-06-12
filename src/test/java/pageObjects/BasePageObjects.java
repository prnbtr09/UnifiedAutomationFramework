package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObjects {


public WebDriver driver;

    public BasePageObjects(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement elementByXpath(String xPath){

        return driver.findElement(By.xpath(xPath));
    }

    public WebElement elementByID(String id){

        return driver.findElement(By.id(id));
    }

    public WebElement elementByClassName(String className){

        return driver.findElement(By.className(className));

    }



}
