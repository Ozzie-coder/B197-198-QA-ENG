package com.myfirstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_TurkceDeneme3 {
    public static void main(String[] args) {

   System.setProperty("web-driver.chrome.driver","drivers/chromedriver");
   WebDriver driver =  new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

   driver.get("https://www.techproeducation.com");


        driver.getTitle();
        String curntUrl =driver.getCurrentUrl();
      //  System.out.println("curntUrl " + curntUrl);

        if (curntUrl.contains("www.techproeducation.com")){
            System.out.println("Test Passed");

        }else System.out.println("Test Failed");

        driver.navigate().to("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));



        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bike",Keys.ENTER);

        driver.findElement(By.xpath("(//div[@class ='rush-component'])[1]")).click();



    }
}
