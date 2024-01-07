package com.myfirstproject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_Xpath_Css {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");


        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().window().implicitlyWait(Duration.ofSeconds(20));


        // amazon.com a gidip arama kutusunu locate edin
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusunun tagName`inin input oldugunu test edin
        String actaulTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";

        if(actaulTagName.equals(expectedTagName)) {
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        // arama kutusunun name attribute`nun degerinin field-keywords oldugunu test edin
        String actualAttributeName = aramaKutusu.getAttribute("name");
        System.out.println(actualAttributeName);

        String expectedAttributeName = "fields-keywords";

        if(actualAttributeName.equals(expectedAttributeName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // sayfayi kapatin
        driver.close();







    }
}
