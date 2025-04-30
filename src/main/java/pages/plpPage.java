package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class plpPage extends Hooks {




    By product1x1 = By.xpath("//*[@data-pnc=\"911026022\"]");

    public void goToPDPPage(){
        driver.findElement(product1x1).click();
    }
}
