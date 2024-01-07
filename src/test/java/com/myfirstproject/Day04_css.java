package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Day04_css {

    WebDriver driver;

    @BeforeEach   // runs before each test method
    public void setup(){
        driver = new ChromeDriver(); // set up the driver
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

    }

    @AfterEach  // runs after each test method
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void cssTest() throws InterruptedException {

//        User goes to "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

        // Get a list of all programs on the homepage
        List<WebElement> homePageLinks = driver.findElements(By.cssSelector("#backmenu"));

        // Verify that the list contains 'Opportunities'
        for (WebElement w : homePageLinks) {
            System.out.println(w.getText());
            Assertions.assertTrue(w.getText().contains("Opportunities"));

        }

        // Click on the 'Programs' link
        WebElement programsLink = driver.findElement(By.cssSelector("a[href='/programs']"));
        programsLink.click();
        Thread.sleep(2000);


//        User clicks on search box
        driver.findElement(By.cssSelector("input#searchHeaderInput")).sendKeys("Automation");
        Thread.sleep(2000);

    }










    @Test
    public void loginTestWithCss() throws InterruptedException {
        //log in the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //locate username
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("Admin");
        //locate password
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("admin123");
        // click on submit
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement profile = driver.findElement(By.cssSelector("*[class='oxd-userdropdown']"));
        profile.click();
        Thread.sleep(2000);

        //Assert login is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }

}
