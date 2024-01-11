package com.myfirstproject.practices.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Q03_ClickWithJSExecutor extends TestBase {
    //    Go to https://testcenter.techproeducation.com/
//    Click on 'Back to top' at the bottom

    @Test
    public void clickWithJSExecutorTest(){
//        Go to https://testcenter.techproeducation.com/

        driver.get("https://testcenter.techproeducation.com/");

//    Click on 'Back to top' at the bottom
        WebElement backToTopButton = driver.findElement(By.linkText("Back to top"));
//        backToTopButton.click();  // error => element is not clickable

//        try{
//            backToTopButton.click();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        button is still not clicked => error => Element is not clickable at point (1120, 1674)

//        Lets try with JS Executor

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", backToTopButton);
//          Verify
        Assertions.assertTrue(driver.findElement(By.linkText("Back to TechProEducation.com")).isDisplayed());


    }

}
