package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.miniBasket;
import pages.pdpPage;
import pages.plpPage;

public class addToCart {

    protected pdpPage pdp= new pdpPage();
    protected plpPage plp= new plpPage();
    protected miniBasket miniBasket= new miniBasket();





    @Test(priority = 1)
    public void addToCart() throws InterruptedException {


        pdp.handleCookiesPopUp("accept");
        plp.goToPDPPage();
        String itemName = pdp.storeModelName();
        pdp.clickAddToCart();
        miniBasket.miniBasketDrawerOpened();
        miniBasket.successMessageDisplayed();
        String inCartItemName = miniBasket.checkItemInCart();
        Assert.assertEquals(itemName, inCartItemName);


        Thread.sleep(3000);

    }

}
