package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class B_OrganizationPage extends BaseClass{
    public static WebDriver weBdriver;

    public B_OrganizationPage(WebDriver ldriver){
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver,this);
    }

    public void clickOrganizationsMenu() throws Throwable{
        WebElement element=weBdriver.findElement(By.id("organizationSearchMenuOption"));
        element.click();
    }

    public void enterCTEPID() throws Throwable{
        WebElement element=weBdriver.findElement(By.id("ctepID"));
        element.click();
        element.sendKeys("WQ456");
    }

    public void selectResearchOrganization() throws Throwable{
        weBdriver.findElement(By.id("functionalRole")).click();
        {
            WebElement dropdown = weBdriver.findElement(By.id("functionalRole"));
            dropdown.findElement(By.xpath("//option[. = 'Lead Organization']")).click();
        }
    }

    public void clickSearch() throws Throwable{
        WebElement element=weBdriver.findElement(By.cssSelector(".search"));
        element.click();
    }

    public void assertNovartis() throws Throwable{
        String assertText="Novartis Pharmaceuticals";
        Assert.assertTrue(assertText.equals(weBdriver.findElement(By.cssSelector(".odd > td:nth-child(3)")).getText()));
    }

    public void clickLogout() throws Throwable{
        WebElement element=weBdriver.findElement(By.linkText("Logout"));
        element.click();
    }
}
