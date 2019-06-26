package com.cbt.tests;

import org.openqa.selenium.WebDriver;
import com.cbt.utilities.BrowserFactory;

import java.util.ArrayList;

public class NavigationTests {

    public static void main(String[] args) {

        ArrayList<WebDriver> drivers = new ArrayList<>();

        drivers.add(BrowserFactory.getDriver("chrome"));
        drivers.add(BrowserFactory.getDriver("firefox"));
        drivers.add(BrowserFactory.getDriver("edge"));

        for (WebDriver driver:drivers) {
            driver.manage().window().maximize();
            driver.get("http://google.com/");
            try{
                Thread.sleep(5000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            String actualTitle1 = driver.getTitle();
            driver.navigate().to("http://etsy.com/");
            try{
                Thread.sleep(4000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            String actualTitle2 = driver.getTitle();
            driver.navigate().back();
            try{
                Thread.sleep(4000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            String backedTitle1 = driver.getTitle();
            if(actualTitle1.equals(backedTitle1)){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
                System.out.println("First title: " + actualTitle1);
                System.out.println("Back title: " + backedTitle1);
            }
            driver.navigate().forward();
            try{
                Thread.sleep(4000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            String forwardTitle1 = driver.getTitle();
            if(actualTitle2.equals(forwardTitle1)){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
                System.out.println("Second title: " + actualTitle2);
                System.out.println("Forward title: " + forwardTitle1);
            }
            //this command will stop execution for 5 seconds
            driver.close();
        }
    }
}
