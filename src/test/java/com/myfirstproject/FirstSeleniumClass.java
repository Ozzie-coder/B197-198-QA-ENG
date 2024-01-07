package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {

//        1. Set the path of the driver
//        System.setProperty("What is it", "where is it");
       System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");  // MAC
//        System.setProperty("webdriver.chrome.driver", "./drivers/gechodriver");  // MAC
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); // WINDOWS

//        2. Create the driver
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new EdgeDriver();

//        3. Now that driver is ready, automate the function that we want to perform
        driver.get("https://www.google.com");


    }

}
