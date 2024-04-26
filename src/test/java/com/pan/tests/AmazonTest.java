package com.pan.tests;

import com.pan.driver.Driver;
import com.pan.enums.PropertyType;
import com.pan.pages.amazonPages.HomePage;
import com.pan.utilities.CommonUtilities;
import com.pan.utilities.PropertyReaderUtils;
import com.pan.utilities.SpecialUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTest extends BaseTest {

    @Test
    void test() {
        Driver.driver.get(PropertyReaderUtils.getProperty(PropertyType.AMAZON_URL));

        HomePage homePage = new HomePage();

        CommonUtilities.click(homePage.getHamburgerMenu());
        CommonUtilities.click(homePage.getMobileAndComputers());
        CommonUtilities.clickWithJs(homePage.getLaptops());
        CommonUtilities.click(homePage.getAppleLaptop());
        CommonUtilities.click(homePage.getSortBy());
        CommonUtilities.click(homePage.getLowToHigh());
        CommonUtilities.click(homePage.getFirstLaptop());
        SpecialUtilities.switchToChildWindow();

        List<WebElement> listOfTables = Driver.driver.findElements(By.xpath("//tbody"));
        //Assert.assertEquals(listOfTables.size(),7);
        Assert.assertTrue(listOfTables.size()>0);
    }
}
