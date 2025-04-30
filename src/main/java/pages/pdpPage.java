package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Hooks;

import java.util.Set;

public class pdpPage extends Hooks{




    // variables
//    String eluxUrl = "https://www.electrolux.fr/kitchen/dishwashing/dishwashers/built-in-compact-dishwasher/esl2500ro2/";
//    String expectedUrl = "ACGBWM22RDE0001K.pdf";
    String wrongDoc = "URL does not end with .pdf";

    // Locators
    By acceptCookiesLocator= By.id("onetrust-accept-btn-handler");
    By cookiesPopUpLocator= By.xpath("//div[@class=\"ot-sdk-container\"]//div[@class=\"ot-sdk-row\"]");
    By repairIndexLocator = By.xpath("//div[contains(@class, \"energy-information\")][2]//img[@class=\"picture-img\"]");
    By rejectCookiesLocator = By.xpath("");

    By addToCartLocator = By.xpath("//div[@class=\"product-landing__add-to-cart\"]//button[@data-webid=\"add-to-cart\"]");

    By itemNameLocator = By.xpath("//h1[@class=\"product-landing__model-name\"]");

    // Actions
    public void acceptCookies(){
        if(driver.findElement(cookiesPopUpLocator).isDisplayed()){
            driver.findElement(acceptCookiesLocator).click();
        }
    }

    public void handleCookiesPopUp(String action) {

        if (driver.findElement(cookiesPopUpLocator).isDisplayed()) {
            if (action.toLowerCase() == "accept") {
                driver.findElement(acceptCookiesLocator).click();

            } else if (action.toLowerCase() == "decline") {
                driver.findElement(rejectCookiesLocator).click();

            }
            else {
                System.out.println("Please enter accept/decline");
            }
        }
        else {
            System.out.println("Pop up didn't appear");
        }
    }

    public void handleCookiesPopUpSwitch(String action) {


        if(driver.findElement(cookiesPopUpLocator).isDisplayed()){
            switch (action){
                case "accept":
                    driver.findElement(acceptCookiesLocator).click();
                    break;
                case "decline":
                    driver.findElement(rejectCookiesLocator).click();
                    break;
                default:
                    System.out.println("Pop up didn't appear");

            }
        }


    }


    public void clickOnRepairIndex(){

        driver.findElement(repairIndexLocator).click();
    }

    public void verifyRightURL(String expectedUrl) {

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Title " + currentUrl);
        Assert.assertTrue(currentUrl.contains(expectedUrl), wrongDoc);

    }

    public void switchToSecondWindow(){

//          Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//          wait.until(d -> driver.getWindowHandles().size() > 1);

        String originalWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);

        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void clickAddToCart(){
        driver.findElement(addToCartLocator).click();
    }

    public String storeModelName(){

        return driver.findElement(itemNameLocator).getText().trim();



    }
}
