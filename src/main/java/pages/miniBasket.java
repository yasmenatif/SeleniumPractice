package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class miniBasket extends Hooks {


    By miniBasketDrawerLocator = By.id("drawer-r2");
    By successMessageLocator = By.xpath("//div[@data-webid=\"add-to-basket-success\"]");
    By itemInCart = By.xpath("//h4[@class=\"_product-cart-item__info-info__text-title_130gm_71\"]");


    public void miniBasketDrawerOpened(){
        driver.findElement(miniBasketDrawerLocator).isDisplayed();
    }

    public void successMessageDisplayed(){
        driver.findElement(successMessageLocator).isDisplayed();

    }

    public String checkItemInCart(){
        return driver.findElement(itemInCart).getText().trim();


    }
}
