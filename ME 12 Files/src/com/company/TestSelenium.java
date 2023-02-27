package com.company;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestSelenium {

    @Test
    public void main(){

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Russ\\Desktop\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abcgmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        Assert.assertTrue(driver.findElement(By.xpath("//label[@id='message9']")).isDisplayed());

        FirefoxDriver driver2 = new FirefoxDriver();
        //driver2.switchTo().newWindow(WindowType.WINDOW);

        driver2.get("http://demo.guru99.com/");
        WebElement element2 =driver2.findElement(By.xpath("//input[@name='emailid']"));
        element2.sendKeys("abc@gmail.com");

        WebElement button2 =driver2.findElement(By.xpath("//input[@name='btnLogin']"));
        button2.click();
        Assert.assertTrue(driver2.findElement(By.tagName("h3")).findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).isDisplayed());
        Assert.assertTrue(driver2.findElement(By.className("accpage")).findElement(By.xpath("//*[text()='User ID :']")).isDisplayed());
        Assert.assertTrue(driver2.findElement(By.className("accpage")).findElement(By.xpath("//*[text()='Password :']")).isDisplayed());

    }
}