package com.myfirstproject;


//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Day02_FirefoxTest {
    public static void main(String[] args) throws InterruptedException {

//        1. Set up
//        WebDriverManager.firefoxdriver().setup();
//        2. Create the driver
        WebDriver driver = new FirefoxDriver();
//        3. Now that driver is ready, automate the function that we want to perform

//        But in our live session, FirefoxDriver wasn't intsantiating
//        (most probably because of version mismatch), so the following is another option to go about it
//        FirefoxOptions options = new FirefoxOptions();
//        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.amazon.com");
//        4. Maximise the window
        driver.manage().window().maximize();
        Thread.sleep(2000);
//        5. Close the browser
        driver.quit();


    }
}

