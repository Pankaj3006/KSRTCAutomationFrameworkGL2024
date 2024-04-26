package com.pan.utilities;

import com.pan.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CommonUtilities {

    public static void click(WebElement element) {
        WaitUtilities.waitForClickabilityOfElement(element);
        element.click();
    }

    public static void clickWithJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)Driver.driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }
}
