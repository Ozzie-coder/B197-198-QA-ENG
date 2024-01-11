package com.myfirstproject.practices.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q01_AddRemoveButton extends TestBase {
     /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
         */

    @Test
    public void addRemoveButtonTest(){

//      Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            addButton.click();
        }

//        Click on the "Delete" button 20 times

        List<WebElement> deleteButton  = driver.findElements(By.className("added-manually"));
//         List<WebElement> deleteButton = driver.findElements(By.xpath("//*[.='Delete']"));  // other possible xpaths combinations: //button[.='Delete'] , //*[text()='Delete']
        for (int i = 0; i < 20; i++) {
            deleteButton.get(i).click();
        }
//        Assert that 20 buttons were deleted
        List<WebElement> deleteButtonAfterDeleting = driver.findElements(By.xpath("//*[.='Delete']"));  // After deleting 20 buttons
        System.out.println("Number of Delete Buttons left: " + deleteButtonAfterDeleting.size());

        Assertions.assertEquals(deleteButton.size()-20, deleteButtonAfterDeleting.size());


    }
}
