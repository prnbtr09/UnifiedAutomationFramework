package driverManager.drivers;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class CreateDriver {
    public static CreateDriver instance;
    public WebDriver driver;
   Map<String,String> environmentBrowserMap=new HashMap<>();

    private CreateDriver() {
    }

    public final void setDriver(String browser, String environment) throws Exception {
        environmentBrowserMap.put(browser,environment);
        driver=new GetDriver().getDriver(browser).getDriver();
        this.setDriver(driver);
    }

    public static CreateDriver createInstance() {
        if (null == instance) {
            instance = new CreateDriver();
        }

        return instance;
    }

    public static CreateDriver getInstance(){
        return createInstance();
    }


    public static void setInstance(CreateDriver instance) {
        CreateDriver.instance = instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
