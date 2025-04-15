package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();


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


        String repairDocument = driver.getTitle();

        System.out.println(repairDocument);

        if (repairDocument.equals("ACGBWM22RDE0001K.pdf")) {
            System.out.println("Repair Document is opened");
        }


        driver.quit();

    }


}

