package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import java.util.Set;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class repairIndex {

    WebDriver driver = new ChromeDriver();


    @Test
    public void pdfOpened(){


        driver.get("https://t1-electrolux-qa-a.eluxmkt.com/fr-fr/laundry/laundry/washing-machines/top-loader-washing-machine/ew6t3465ed/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Thread.sleep(3000);
        String originalWindow = driver.getWindowHandle();

        WebElement cookiesPopUp = driver.findElement(By.xpath("//div[@class=\"ot-sdk-container\"]//div[@class=\"ot-sdk-row\"]"));
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));

//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(cookiesPopUp.isDisplayed());
        acceptCookies.click();

        WebElement repairIndex = driver.findElement(By.xpath("//div[contains(@class, \"energy-information\")][2]//img[@class=\"picture-img\"]"));
        repairIndex.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(d -> driver.getWindowHandles().size() > 1);

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("ACGBWM22RDE0001K.pdf"), "URL does not end with .pdf");

        driver.quit();

    }
}
