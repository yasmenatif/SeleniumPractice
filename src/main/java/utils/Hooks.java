package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Hooks {

    public WebDriver driver = new ChromeDriver();
//    String eluxUrl = "https://www.electrolux.fr/kitchen/dishwashing/dishwashers/built-in-compact-dishwasher/";
    String eluxUrl = "https://www.google.com";



    @BeforeMethod
    public void startDriver(){

        driver.get(eluxUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void quitDriver(){

        driver.quit();


    }
}
