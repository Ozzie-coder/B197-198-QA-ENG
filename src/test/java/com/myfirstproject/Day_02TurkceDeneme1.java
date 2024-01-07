package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day_02TurkceDeneme1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Amazon sayfasina gidelim
        // Sayfa basliginin Amazon icerdigini test edelim
        // URL`in https://www.amazon.com oldugunu test edelim
        // Sayfayi kapatalim

        driver.get("https://www.amazon.com/"); //GENELDE get() KULLANILIR ama forward() ve backward() kullanildiginda navigate() lazim get() yerine !
        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");

        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com/";
        if(expectedURL.equals(actualURL)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.close();// birden fazla sayfa varsa quit ==> driver.quit();






    }
}
