package com.pan.utilities;

import com.pan.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtilities {

    public static void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickabilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void unConditionalWait(long duration)
    {
        try{
            Thread.sleep(duration);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}