package com.myfirstproject.practices.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.myfirstproject.utilities.TestBase.waitFor;

public class Q02_DragAndDrop extends TestBase {
    /*
    Given
         Go to https://demo.guru99.com/test/drag_drop.html
    When
         Drag orange elements on proper boxes below
    Then
         Verify they are dropped.

     */

    @Test
    public void dragAndDropTest(){
//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");
//        Drag orange elements on proper boxes below
//        Locate the elements first that we need to drag

//        WebElement bank = driver.findElement(By.id("credit2"));
//        WebElement sales = driver.findElement(By.id("credit1"));

        WebElement bank = driver.findElement(By.linkText("BANK"));
        WebElement sales = driver.findElement(By.linkText("SALES"));

        WebElement firstAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement secondAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));

//        Locate the elements where we need to drop the above elements
//        WebElement debitAccount =  driver.findElement(By.xpath("//li[@class='placeholder']"));  // OR
        WebElement debitAccountTarget =  driver.findElement(By.id("bank"));
        WebElement debitAmountTarget = driver.findElement(By.id("amt7"));

        WebElement creditAccountTarget = driver.findElement(By.id("loan"));
        WebElement creditAmountTarget = driver.findElement(By.id("amt8"));

//        Now drag and drop these webElements at their target place
//        We need Actions class for that
        Actions actions = new Actions(driver);

        actions.dragAndDrop(bank, debitAccountTarget).perform();
        waitFor(2);
        actions.dragAndDrop(firstAmount, debitAmountTarget).perform();
        waitFor(2);
        actions.dragAndDrop(sales, creditAccountTarget).perform();
        waitFor(2);
        actions.dragAndDrop(secondAmount, creditAmountTarget).perform();

//        Or build a chain of actions  and remember to use build() method to build the chain
//        actions.
//                dragAndDrop(bank, debitAccountTarget).
//                dragAndDrop(firstAmount,debitAmountTarget).
//                dragAndDrop(sales, creditAccountTarget).
//                dragAndDrop(secondAmount, creditAmountTarget).
//                build().perform();


//        Verify they are dropped
        String successMessage =  driver.findElement(By.id("equal")).getText();
        System.out.println("successMessage = " + successMessage);
        Assertions.assertTrue(successMessage.contains("Perfect!"));


    }
}




