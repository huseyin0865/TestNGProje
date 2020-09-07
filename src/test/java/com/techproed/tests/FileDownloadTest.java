package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarmi (){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        //C:\Users\CEM BULUT\IdeaProjects\TestNGProje\pom.xml
        String pomXmlDosyaYolu =kullaniciDosyaYolu+ "/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
    }
    @Test
    public void dosyaUpload(){//bilgisayardan veb sayfasina dosya yuklame
        //C:\Users\CEM BULUT\Desktop\selenium 15. ders\logo.png
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaYukle = driver.findElement(By.id("file-upload"));
        dosyaYukle.sendKeys("C:/Users/CEM BULUT/Desktop/selenium 15. ders/logo.png");
        WebElement yukle =driver.findElement(By.id("file-submit"));
        yukle.click();
        WebElement fileUploadYazisi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazisi.isDisplayed());
    }
    @Test
    public void dosyaDownload(){
        driver.get("http://the-internet.herokuapp.com/download");
        //C:\Users\CEM BULUT\Downloads\Amsterdam.jpg

        WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi =Files.exists((Paths.get("C:\\Users\\CEM BULUT\\Downloads\\Amsterdam.jpg")));
        Assert.assertTrue(varMi);
        }


}












