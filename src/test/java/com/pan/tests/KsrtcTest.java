package com.pan.tests;

import com.pan.driver.Driver;
import com.pan.enums.PropertyType;
import com.pan.pages.ksrtcPages.BusDetailsPage;
import com.pan.pages.ksrtcPages.LoginPage;
import com.pan.utilities.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class KsrtcTest extends BaseTest {

    @Test(dataProvider="KsrtcData", dataProviderClass = DataProviderUtils.class)
    void getSeatCountTest(String from, String to, String travelDate) {
//    @Test(dataProvider="KsrtcData", dataProviderClass = DataProviderMapUtils.class)
//    void getSeatCountTest(Map<String, String> data) {

        Driver.driver.get(PropertyReaderUtils.getProperty(PropertyType.KSRTC_URL));

//        String fromPlace = "Mysore";
//        String toPlace = "Bangalore";
//        String dateOfJourney = "27 November 2023";

        String fromPlace = from;
        String toPlace = to;
        String dateOfJourney = travelDate;

//        String fromPlace = data.get("FromPlace");
//        String toPlace = data.get("ToPlace");
//        String dateOfJourney = data.get("TravelDate");

        LoginPage loginPage = new LoginPage();
        CommonUtilities.enterText(loginPage.getFromPlace(), fromPlace.substring(0,3));
        SpecialUtilities.enterCityName("fromPlaceName", fromPlace);

        CommonUtilities.enterText(loginPage.getToPlace(), toPlace.substring(0,3));
        WaitUtilities.unConditionalWait(2000);
        SpecialUtilities.enterCityName("toPlaceName", toPlace);
        CommonUtilities.click(loginPage.getJourneyDate());
        SpecialUtilities.selectDate(dateOfJourney);
        CommonUtilities.clickWithJs(loginPage.getSearchButton());

        BusDetailsPage busDetailsPage = new BusDetailsPage();

        WaitUtilities.waitForVisibilityOfElement(busDetailsPage.getHeaderDetails());

        List<WebElement> elements = busDetailsPage.getSeatCount();
        System.out.println("Total numbers of buses between " + fromPlace + " and " + toPlace + " are: " + elements.size());

        int totalSeats=0;
        for(WebElement ele:elements)
        {
            int NoOfSeats = Integer.parseInt(ele.getText().split(" ")[0]);
            totalSeats = totalSeats + NoOfSeats;
        }
        System.out.println("Total numbers of seats between " + fromPlace + " and " + toPlace + " are: " + totalSeats);
    }
}
