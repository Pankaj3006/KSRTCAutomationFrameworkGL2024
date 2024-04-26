package com.pan.pages.amazonPages;

import com.pan.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
    private final By mobilesAndComputers = By.xpath("//div[text()='Mobiles, Computers']/parent::a");
    private final By laptops = By.xpath("//a[text()='Laptops']");
    private final By apple = By.xpath("(//span[text()='Apple'])[2]");
    private final By sortBy = By.xpath("//span[text()='Sort by:']");
    private final By lowToHigh = By.xpath("//a[text()='Price: Low to High']");
    private final By firstLaptop = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]");

    public WebElement getHamburgerMenu() {
        return Driver.driver.findElement(hamburgerMenu);
    }
    public WebElement getMobileAndComputers() { return Driver.driver.findElement(mobilesAndComputers); }
    public WebElement getLaptops() {
        return Driver.driver.findElement(laptops);
    }
    public WebElement getAppleLaptop() {
        return Driver.driver.findElement(apple);
    }
    public WebElement getSortBy() {
        return Driver.driver.findElement(sortBy);
    }
    public WebElement getLowToHigh() {
        return Driver.driver.findElement(lowToHigh);
    }
    public WebElement getFirstLaptop() { return Driver.driver.findElement(firstLaptop); }
}
