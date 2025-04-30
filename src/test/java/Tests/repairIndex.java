package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pdpPage;
import utils.Hooks;


import java.time.Duration;

public class repairIndex{

//    WebDriver driver = new ChromeDriver();
    protected pdpPage pdp;

//    String eluxUrl = "https://www.electrolux.fr/kitchen/dishwashing/dishwashers/built-in-compact-dishwasher/esl2500ro2/";
    String expectedUrl = ".pdf";


//    @BeforeClass
//    public void startDriver(){
////        pdp = new pdpPage(driver);
//        driver.get(eluxUrl);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }

    @Test(priority = 1)
    public void pdfOpened() throws InterruptedException {

        pdp = new pdpPage();
        pdp.handleCookiesPopUp("accept");
        pdp.clickOnRepairIndex();
        pdp.switchToSecondWindow();
        pdp.verifyRightURL(expectedUrl);

        Thread.sleep(3000);

    }

    @Test
    public void testCase02(){


    }
//    @AfterClass
//    public void quitDriver(){
//
//        driver.quit();
//
//
//    }
}

