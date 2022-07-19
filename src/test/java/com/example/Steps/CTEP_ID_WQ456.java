package com.example.Steps;

import com.example.Base.BaseClass;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_OrganizationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CTEP_ID_WQ456 extends BaseClass{
    static WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver","c:/users/hildebrandrr/IdeaProjects/CTRP-2586/chromedriver 4.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }

    @When("^I enter Username and password")
    public void i_enterusername_and_password() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable{
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

    }

    @Given("^I click on organizations menu option$")
    public void i_click_on_organizations_menu_option() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickOrganizationsMenu();
    }

    @When("^I type WQ456 in CTEP ID$")
    public void i_type_wq456_in_ctep_id() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.enterCTEPID();
    }

    @Then("^I select Research organization into Organization Type$")
    public void i_select_research_organization_into_organization_type() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.selectResearchOrganization();
    }

    @Then("^I click on Search$")
    public void i_click_on_search() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickSearch();
    }

    @Then("^I assert Novartis Pharmaceuticals matches Novartis Pharmaceuticals$")
    public void i_assert_novartis_pharmaceuticals_matches_novartis_pharmaceuticals() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.assertNovartis();
    }

    @Then("^I click logout$")
    public void i_click_logout() throws Throwable{
        B_OrganizationPage organizationPage=new B_OrganizationPage(driver);
        organizationPage.clickLogout();
    }
}
