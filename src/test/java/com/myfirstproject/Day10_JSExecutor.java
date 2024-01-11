package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day10_JSExecutor extends TestBase {

    @Test
    public void jsExecutorTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.navigate().refresh(); // This will resolve the captcha issue (hopefully)

//        When user click on "Account" link
//        We can't see the "Account" link unless we hover over "Account & List" option
//        So we need to create actions object
//        Step 1:
        Actions actions = new Actions(driver);
//        Step 2: Find the element first and then use moveToElement() from actions class
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListTab).perform();  // moveToElement() makes the driver hover over the given element
        Thread.sleep(2000);
//        Now we can see "Account" link on the dropdown
        WebElement accountOption =  driver.findElement(By.linkText("Account"));
//        accountOption.click(); // Normal way
//        actions.click(accountOption).perform();  // Alternative if normal click() doesn't work
//        If both of above click() don't work (happens rarely), we can use JSExecutor method to click
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", accountOption, accountListTab);  // arguments[0] has index 0, which means click on the first webElemet

//        Then verify the page title contains "Your account"
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().contains("Account"));

//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
//        actions.moveToElement(amazonMusic).perform();  // moveToElement() will find the element where ever it is on the page
        js.executeScript("arguments[0].scrollIntoView(true);", amazonMusic);  // scrolling to that webElement

        Thread.sleep(3000);
//        Click on it
//        amazonMusic.click();  /// Normal way
//        actions.click(amazonMusic).perform();
        js.executeScript("arguments[0].click();", amazonMusic);

//        Then verify Amazon Music page is displayed
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        js.executeScript("window.scrollTo(0, 250);" );  // Scroll Down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -250);" );  // Scroll Up
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);" );  // Scroll Down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);" );  // Scroll Up

//      Locate the search input at music page using JSExecutor method
        waitFor(2); // Using REUSABLE METHOD

        WebElement searchInput = locateElementByJS("navbarSearchInput");  // Using REUSABLE METHOD for JS EXECUTOR

//        Send the text 'POP' to search input
//        searchInput.sendKeys("POP");// normal way

        setValueByJS(searchInput, "POP");  // Using REUSABLE METHOD for JS EXECUTOR
//       Get the value from the search input using JS EXECUTOR
        String inputValue = getValueByJS("navbarSearchInput");
//       Assert the value sent is the same
        Assertions.assertTrue(inputValue.contains("POP"));



    }
}
