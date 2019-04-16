package AmazonPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyCard extends Settings {
    By listOfItems = By.cssSelector(".a-size-medium.sc-product-title.a-text-bold");
    String text;

    public String checkItem(){
        List<WebElement> results = driver.findElements(listOfItems);
        results.get(0).getText();
        return text;
    }
}

