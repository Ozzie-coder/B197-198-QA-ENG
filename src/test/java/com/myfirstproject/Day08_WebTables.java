package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day08_WebTables extends TestBase {

    @Test
    public void webTablesTest(){

//          https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("******* Task 1 *******");
//        Task 1 : Print the entire table and Assert if the last element in the table 1 is "edit delete"
//        String entireTableData = driver.findElement(By.id("table1")).getText();
//        String entireTableData = driver.findElement(By.xpath("//table[@id='table1']")).getText(); // This returns the entire table data as a SINGLE WebElement
        String entireTableData = driver.findElement(By.xpath("//table//tbody")).getText(); // This returns the entire table data as a SINGLE WebElement
        System.out.println("entireTableData = " + entireTableData);

        System.out.println("==================================");

//        ALTERNATIVELY
        List< WebElement> elementList = driver.findElements(By.xpath("//table[@id='table1']//td"));  // This xpath returns the data from cell level as individual data
        int dataNum = 1;
        for (WebElement eachElement:elementList){
            System.out.println("Data "+dataNum+ " => "+eachElement.getText());
            dataNum++;
        }

//          Assert if the last element in the table 1 is "edit delete"
        Assertions.assertTrue(elementList.get(elementList.size()-1).getText().contains("edit delete"));  // This asserts the last element
        Assertions.assertTrue(elementList.get(1).getText().contains("John"));
        Assertions.assertTrue(elementList.get(14).getText().contains("jdoe@hotmail.com"));
        Assertions.assertTrue(elementList.get(9).getText().contains("$51.00"));

        System.out.println("******* Task 2 *******");
//        Task 2 : Print All Rows

//        Task 3 : Print Last row data only
//        Task 4 : Print column 5 data in the table body
//
//        Task 5 : Write a method that accepts 2 parameters
//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);   => prints data in 2nd row 3rd column


    }
}
