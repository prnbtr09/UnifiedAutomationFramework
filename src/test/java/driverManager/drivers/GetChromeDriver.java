package driverManager.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GetChromeDriver extends Driver {
    @Override
    WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = CreateDriver.getInstance().getDriver();
        this.driver = new ChromeDriver();
        return driver;

    }



}
