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

public class GoogleSearchSteps {

    public static String browser = "chrome";
    public static WebDriver driver;


    @Given("browser is open")
    public void browser_is_open(){
        System.out.println("###browser is open");
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @And("user is on the google search page")
    public void user_is_on_google_home_page(){
        System.out.println(" ###User is on the Google home page");
        driver.navigate().to("https://www.google.com");
    }


    @When("^user enters a (.*) in the search box$")
    public void user_enters_text_in_search_box(String searchTerm){
        System.out.println("###user enters a text in the search box");
        driver.findElement(By.name("q")).sendKeys(searchTerm);
    }


    @And ("hits enter")
    public void user_hits_enter(){
        System.out.println("### User hits Enter");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user is navigated to the (.*) results")
    public void user_navigated_to_the_search_results(String searchTerm){
        System.out.println("### user is navigated to search results");
        //todo
        //String checkResults = driver.findElement(By.xpath("//*[@id=\"result-stats\"]")).getText();
        String checkResults = driver.findElement(By.id("fprs")).getText();
        //assert
        Assert.assertTrue(checkResults.contains(searchTerm));
    }

    @After
    public void freeResources(){
        System.out.println("Testing Complete, Closing Browser resources.");
        driver.close();
        driver.quit();
    }

}
