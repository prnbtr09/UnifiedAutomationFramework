package runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmokeRunner {

    @Test(groups = {"smoke"})
    public void smoke(){
        System.out.println("In smoke");
    }

    @Test(groups = {"regression"})
    public void regression(){
        System.out.println("In Regression");
    }

}
