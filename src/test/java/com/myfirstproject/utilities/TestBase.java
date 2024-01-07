package com.myfirstproject.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {

    /*
    - We keep TestBase class abstract because we don't want to create object from this class
    - TestBase class is used to store repetitive methods which are used as pre-conditions or post-conditions
    - We make WebDriver protected because we want it to be available for all classes within this project

    -TestBase will be extended to classes where test steps are and this class will provide before and after methods automatically

     */

    protected static WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver(); // instantiating chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // allows time to the page to load
        driver.manage().window().maximize();
    }

     @AfterEach
     public void tearDown() throws InterruptedException {
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait if needed
      Thread.sleep(3000);
        driver.quit();
      }
    // DROPDOWN
    // create a reusable method that select dropdown option by index

    public static void dropdownSelectByIndex(WebElement element, int index){
        Select select= new Select(element);
        select.selectByIndex(index);
    }

    public static void dropdownSelectByIndex(By locator, int index){
       WebElement element = driver.findElement(locator);
        Select select = new Select(element);
       select.selectByIndex(index);
    }

    public static void dropdownSelectByIndex(String xpath, int index){
        WebElement element = driver.findElement(By.xpath(xpath));
        Select select = new Select(element);
        select.selectByIndex(index);
    }





}
