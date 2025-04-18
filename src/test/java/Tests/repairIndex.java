package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pdpPage;


import java.time.Duration;

public class repairIndex {

    WebDriver driver = new ChromeDriver();
    protected pdpPage pdp;

    String eluxUrl = "https://t1-electrolux-qa-a.eluxmkt.com/fr-fr/laundry/laundry/washing-machines/top-loader-washing-machine/ew6t3465ed/";
    String expectedUrl = "ACGBWM22RDE0001K.pdf";


    @BeforeClass
    public void startDriver(){
        pdp = new pdpPage(driver);
        driver.get(eluxUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(priority = 1)
    public void pdfOpened() {

        pdp = new pdpPage(driver);
        pdp.handleCookiesPopUpSwitch("accept");
        pdp.clickOnRepairIndex();
        pdp.switchToSecondWindow();
        pdp.verifyRightURL(expectedUrl);


    }

    @Test
    public void testCase02(){


    }
    @AfterClass
    public void quitDriver(){

        driver.quit();


    }
}

