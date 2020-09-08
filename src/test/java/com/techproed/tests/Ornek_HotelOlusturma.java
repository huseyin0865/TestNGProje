package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void hotelCreate(){
        driver.findElement(By.id("Code")).sendKeys("122");
        driver.findElement(By.id("Name")).sendKeys("Muhsin");
        driver.findElement(By.id("Address")).sendKeys("Zeytinlik sok no:123 Erdemli");
        driver.findElement(By.id("Phone")).sendKeys("0343000000");
        driver.findElement(By.id("Email")).sendKeys("mhsnl@gmail.com");
        WebElement dropDown = driver.findElement(By.id("IDGroup"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Hotel Type1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        /*
          WebElement codeKutusu = driver.findElement(By.id("Code"));
          WebElement nameKutusu = driver.findElement(By.id("Name"));
          WebElement adresKutusu= driver.findElement(By.id("Address"));
          WebElement phoneKutusu= driver.findElement(By.id("Phone"));
          WebElement emailKutusu= driver.findElement(By.id("Email"));
          WebElement idGrup     = driver.findElement(By.id("IDGroup"));
          WebElement saveButonu = driver.findElement(By.id("btnSubmit"));
          codeKutusu.sendKeys("1234");
          nameKutusu.sendKeys("Hamza Yılmaz");
          adresKutusu.sendKeys("Çıkmaz Sk. 34/20");
          phoneKutusu.sendKeys("022222222222");
           emailKutusu.sendKeys("merhaba@dunya.com");
           Select select = new Select(idGrup);
           select.selectByIndex(2);
           saveButonu.click();
         */

        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());



    }
}
