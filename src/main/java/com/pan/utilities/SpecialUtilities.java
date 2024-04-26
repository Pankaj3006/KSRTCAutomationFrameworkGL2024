package com.pan.utilities;

import com.pan.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Iterator;
import java.util.Set;

public class SpecialUtilities {
    public static void enterCityName(String textBoxId, String placeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        String script = "return document.getElementById(\""+textBoxId+"\").value;";
        String text = (String) js.executeScript(script);

        while (!text.equalsIgnoreCase(placeName)) {
            Driver.driver.findElement(By.id(textBoxId)).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
        }
        Driver.driver.findElement(By.id(textBoxId)).sendKeys(Keys.ENTER);
    }

    public static void selectDate(String date) {
        int count = 0;
        while (!Driver.driver.findElement(By.cssSelector(".ui-datepicker-header .ui-datepicker-title")).getText().contains(date.substring(3,date.length()))) {
           CommonUtilities.click(Driver.driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")));
        }
        int rowcount = Driver.driver.findElements(By.xpath("//table/tbody/tr")).size();
        int colcount = Driver.driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
        for (int i = 1; i <= rowcount; i++) {
            for (int j = 1; j <= colcount; j++) {
                if ((Driver.driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]"))).getText()
                        .contains(date.split(" ")[0])) {
                    count++;
                    CommonUtilities.click(Driver.driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]")));
                    break;
                }
            }
            if (count == 1) {
                break;
            }
        }
    }

    public static void switchToChildWindow() {
        String mainWindow = Driver.driver.getWindowHandle();

        Set<String> multipleWindow = Driver.driver.getWindowHandles();
        Iterator<String> itr = multipleWindow.iterator();

        while (itr.hasNext()) {
            String childWindow = itr.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)) {
                Driver.driver.switchTo().window(childWindow);
            }
        }
    }
}
