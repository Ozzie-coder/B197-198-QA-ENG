package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class Day07_NewWindows extends TestBase {

    @Test
    public void newTabTest() throws InterruptedException {
//        Open the pages in 2 new windows and verify their  TITLES -> LinkedIn , Ebay
//        Open 2 new tabs and verify their TITLES   -> LinkedIn , Ebay

//        LinkedIn
        driver.get("https://www.linkedin.com");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
        Thread.sleep(2000);
//        Get the window handle
        String linkedinHandle = driver.getWindowHandle();

//        Ebay
//        I (as a QA) want to open a new tab for the second web page
        driver.switchTo().newWindow(WindowType.TAB); // THIS MAKES THE DRIVER OPEN A NEW TAB
        driver.get("https://www.ebay.com/");
        Assertions.assertTrue(driver.getTitle().contains("eBay"));

//        Get the window handle
        String ebayHandle = driver.getWindowHandle();
//        Go back to linked page
        driver.switchTo().window(linkedinHandle);
        String linkedinURL = driver.getCurrentUrl();
        System.out.println("linkedinURL = " + linkedinURL);

//        Go to EBay page
        driver.switchTo().window(ebayHandle);
        String ebayURL = driver.getCurrentUrl();
        System.out.println("ebayURL = " + ebayURL);


    }

    @Test
    public void newWindowsTest() throws InterruptedException {
//        Open the pages in 2 new windows and verify their  TITLES -> LinkedIn , Ebay
//        Open 2 new tabs and verify their TITLES   -> LinkedIn , Ebay

//        LinkedIn
        driver.get("https://www.linkedin.com");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
        Thread.sleep(2000);
//        Get the window handle
        String linkedinHandle = driver.getWindowHandle();

//        Ebay
//        I (as a QA) want to open a new tab for the second web page
        driver.switchTo().newWindow(WindowType.WINDOW); // THIS MAKES THE DRIVER OPEN A NEW WINDOW
        driver.get("https://www.ebay.com/");
        Assertions.assertTrue(driver.getTitle().contains("eBay"));

//        Get the window handle
        String ebayHandle = driver.getWindowHandle();
//        Go back to linked page
        driver.switchTo().window(linkedinHandle);
        String linkedinURL = driver.getCurrentUrl();
        System.out.println("linkedinURL = " + linkedinURL);

//        Go to EBay page
        driver.switchTo().window(ebayHandle);
        String ebayURL = driver.getCurrentUrl();
        System.out.println("ebayURL = " + ebayURL);


    }



}
