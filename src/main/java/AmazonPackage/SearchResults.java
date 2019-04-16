package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResults extends Settings {
    By listOfElements = By.cssSelector(".a-size-medium.a-color-base.a-text-normal");
    By addToCard = By.id("add-to-cart-button");
    By viewCard = By.xpath("//div[@role='dialog']//a[@href='/gp/cart/view.html/ref=uss_cart']");
    String text;

    public void chooseElement (){
        waitForElementClickable(listOfElements);
        List<WebElement> results = driver.findElements(listOfElements);
        results.get(0).click();
    }
    public String elementName(){
        List<WebElement> results = driver.findElements(listOfElements);
        results.get(0).getText();
        return text;
    }
    public void addToCard(){
        waitForElementClickable(addToCard);
        driver.findElement(addToCard).click();
    }
    public void viewCard(){
        waitForElementClickable(viewCard);
        String openLinkNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(viewCard).sendKeys(openLinkNewTab);
    }
}
