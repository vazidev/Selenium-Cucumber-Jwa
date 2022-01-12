package com.vazidev.seleniumcucumberjwatest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearchSteps {
    public static String browser = "chrome";
    public static WebDriver driver;
    private static String searchTerm = "Razor Gaming laptop i7";


    @Given("user is on the Amazon landing page")
    public void userIsOnTheAmazonLandinPage() {
        System.out.println("###Browser is open");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        //https://example.testproject.io/web/
        System.out.println("###User is on the Amazon Landing Page");
        driver.navigate().to("https://www.amazon.com");
    }

    @When("user enters a text in the Amazon search box")
    public void user_enters_text_in_search_box() throws InterruptedException {
        System.out.println("###user enters a text in the search box");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm);
        //wait(3000);
    }


    @And("user clicks on the search button")
    public void userClicksOnTheSearchButton() {
        System.out.println("###user enters a text in the search box");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("nav-search-submit-text")).click();
    }

    @Then("user is directed to the results page")
    public void userIsDirectedToTheResultsPage() {
            System.out.println("### user is navigated to search results");
            //todo
            String checkResults = driver.findElement(By.xpath("//*[@id='search']")).getText();
            //assert
            Assert.assertTrue(checkResults.contains(searchTerm));;

    }

    @After
        public void freeResources(){
            System.out.println("Testing Complete, Closing Browser resources.");
            driver.close();
            driver.quit();
        }
}
