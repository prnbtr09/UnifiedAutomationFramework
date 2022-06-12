package driverManager;

import constants.ResourcesConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class CreateDriver {
    public static CreateDriver instance;
    public WebDriver driver;

    Map<String,String> environmentBrowserMap=new HashMap<>();

    private CreateDriver() {
    }

    public static CreateDriver createInstance() {
        if (null == instance) {
            instance = new CreateDriver();
        }

        return instance;
    }

    public final void setDriver(String browser, String environment) throws Exception {
        environmentBrowserMap.put(browser,environment);
        switch (browser.toLowerCase()){
            case "chrome":
                if(environment.equalsIgnoreCase("local")){
                    if (!Configurations.getConfigProp().getProperty("useWebDriverManager").equals("false")) {
                        System.setProperty("webdriver.chrome.driver", ResourcesConstants.CHROME_EXE);
                    } else {
                        WebDriverManager.chromedriver().setup();
                    }
                }else{

                }
                driver = new ChromeDriver();
                break;

            case "firefox":
                if(environment.equalsIgnoreCase("local")){

                }else{

                }
                break;

        }
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
