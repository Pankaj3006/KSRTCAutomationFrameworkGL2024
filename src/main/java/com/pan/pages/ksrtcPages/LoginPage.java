package com.pan.pages.ksrtcPages;

import com.pan.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By fromPlace = By.id("fromPlaceName");
    private final By toPlace = By.id("toPlaceName");
    private final By journeyDate = By.id("txtJourneyDate");
    private final By searchButton = By.xpath("//*[@id='bookingsForm']/div[1]/div/div[2]/div[3]/button");

    public WebElement getFromPlace() {
        return Driver.driver.findElement(fromPlace);
    }

    public WebElement getToPlace() {
        return Driver.driver.findElement(toPlace);
    }

    public WebElement getJourneyDate() {
        return Driver.driver.findElement(journeyDate);
    }

    public WebElement getSearchButton() {
        return Driver.driver.findElement(searchButton);
    }
}
