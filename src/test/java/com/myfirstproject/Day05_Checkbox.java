package com.myfirstproject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_Checkbox {

    WebDriver driver;

    @BeforeEach   // runs before each test method
    public void setup(){
        driver = new ChromeDriver(); // set up the driver
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

    }

    @AfterEach  // runs after each test method
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void checkboxTest(){

//        Go to https://testcenter.techproeducation.com/index.php?page=checkboxes
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
//        Locate the elements of checkboxes
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

//        Then click on checkbox1 if box is not selected
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
//        Then click on checkbox2 if box is not selected
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

//        Then verify that checkbox1 is checked
        Assertions.assertTrue(checkbox1.isSelected());
        Assertions.assertTrue(checkbox2.isSelected());

    }
}
