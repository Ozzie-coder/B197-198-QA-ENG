package com.myfirstproject;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day01_WebDriverManager {

    public static void main(String[] args) {

        /*
        1. Add WebDriverManager repository from https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
        and get the latest version, paste it INSIDE dependencies tag
        2. Reload the project
        3. Use WebDriverManager class to set up (2nd way)
         */

//        1. Set up
       // WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();

//        2. Create the driver
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new EdgeDriver();

//        3. Now that driver is ready, automate the function that we want to perform
        driver.get("https://www.google.com");


    }
}
