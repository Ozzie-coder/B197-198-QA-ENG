package com.myfirstproject.practices.practice01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QO5_GoogleSearch {
    //    NOTE: Don't extend to TestBase
//    Create driver and go to http://www.google.com in the BeforeEach method
//    With 3 different test methods:
//      -Type "Desktop" in the search box and search it
//      -Type "Smartphone" in the search box and search it
//      -Type "Laptop" in the search box and search it
//    NOTE: Print the result numbers in AfterEach method
//    Close driver with AfterEach method

    WebDriver driver;
    @BeforeEach
    public void beforeMethod(){
        driver = new ChromeDriver();  // Initiate the Selenium Web Driver
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void test1(){
        driver.findElement(By.name("q")).sendKeys("Desktop", Keys.ENTER);
    }

    @Test
    public void test2(){
        driver.findElement(By.name("q")).sendKeys("Smartphone", Keys.ENTER);
    }

    @Test
    public void test3(){
        driver.findElement(By.name("q")).sendKeys("Laptop", Keys.ENTER);
    }

    @AfterEach
    public void afterMethod() throws InterruptedException {
        String searchResult =  driver.findElement(By.id("result-stats")).getText();
        System.out.println("searchResult = " + searchResult);
        String numOfResults =  searchResult.split(" ")[1];
        System.out.println("numOfResults = " + numOfResults);
        Thread.sleep(3000);
        driver.quit();
    }
}
