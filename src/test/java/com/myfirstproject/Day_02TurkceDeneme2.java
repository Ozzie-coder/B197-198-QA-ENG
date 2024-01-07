package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day_02TurkceDeneme2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasina gidelim
        driver.navigate().to("https://techproeducation.com/"); // get() methodu ile ayni
        Thread.sleep(3000);

        //Sonra Amazon sayfasina gidelim
        driver.navigate().to("https://Amazon.com/");
        Thread.sleep(3000);

        //Amazon sayfasinin basligini yazdiralim
        System.out.println("Amazon sayfa basligi : " + driver.getTitle());
        Thread.sleep(3000);

        //Techproeducation sayfasina geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdiralim
        System.out.println("techpro Sayfa Basligi : " + driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasina tekrar gidip URL`I yazdiralim
        driver.navigate().forward();
        System.out.println("Amazon sayfasi ve URL`i : " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasindayken sayfayi refresh edelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.quit();


    }
}
