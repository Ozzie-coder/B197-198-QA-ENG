package com.myfirstproject;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

//        Set up and create chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        Maximise the window
        driver.manage().window().maximize();

//        go to a Google home page
        driver.get("https://www.google.com");
        Thread.sleep(2000);  // Hard Java wait
//        Staying in the same class, navigate to techproeducation homepage
        driver.get("https://www.techproeducation.com");
        Thread.sleep(2000);
//        Navigate back to google
        driver.navigate().back();
        Thread.sleep(2000);
//        Navigate forward to techproeducation
        driver.navigate().forward();
        Thread.sleep(2000);
//        Refresh the page
        driver.navigate().refresh();
        Thread.sleep(2000);
//        Close/Quit the browser
        driver.quit();

        /*
        NOTES:
        1. How do you go to a page in Selenium?
        - I use get() or navigate() method. get() is more commonly used.
        2. What is the difference between get() and navigate() method?
        - both are used to go to a page
        - get is shorter than navigate method
        - navigate() allows you to go forward,back and refresh the page
        - get method accepts String only as parameter, navigate() accepts string and url
        3. What's the difference between quit() and close()?
        close() method closes the current active window, whereas quit() method closes all opened windows
        4. What is Thread.slepp()?
        - it is JAVA wait. we call it HARD WAIT as well.

         */





    }
}
