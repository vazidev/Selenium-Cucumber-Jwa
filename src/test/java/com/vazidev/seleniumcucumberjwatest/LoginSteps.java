package com.vazidev.seleniumcucumberjwatest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

        public static String browser = "chrome";
        public static WebDriver driver;
        private String userName="Leonard";
        private String passKey = "12345";

        @Given("user is on the login page")
        public void user_is_on_login_page() {
            System.out.println("###User is on the login page");
            System.out.println("###Browser is open");
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.navigate().to("https://example.testproject.io/web/");
            //https://example.testproject.io/web/
        }

        @When("^user enters (.*) and (.*)$")
        public void user_enters_username_and_password(String username, String password) {
            System.out.println("###user enters username and password");
            driver.findElement(By.id("name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
        }

        @When("clicks on the login button")
        public void clicks_on_login_button() {
            System.out.println("###clicks6+4 on login button");
            driver.findElement(By.id("login")).click();
        }

        @Then("^user is navigated to the Home page that should contain (.*)$")
        public void user_is_navigated_to_the_home_page(String message) {
            System.out.println("###user is navigated to the home page");
            //to do
            //assert
            String check= driver.findElement(By.xpath("//*[@id=\"greetings\"]")).toString();
            assertTrue(check.contains("Hello" + message + " let's complete the test form"));
        }

        @After
        public void freeResources(){
            System.out.println("Testing Complete, Closing Browser resources.");
            driver.close();
            driver.quit();
        }


    }

