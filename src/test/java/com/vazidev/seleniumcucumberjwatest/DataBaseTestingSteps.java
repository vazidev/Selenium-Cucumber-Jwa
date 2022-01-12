package com.vazidev.seleniumcucumberjwatest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DataBaseTestingSteps {
    Connection connection;
    Statement statement;
    ResultSet res;
    String QUERY;
    String string = "(.*)$";



        @When("connection is established using (.*) (.*) (.*) and (.*)$")
        public void etablish_connection(String url, String driver, String userName, String password) throws ClassNotFoundException, SQLException{
            System.out.println("Connecting to the DataBase");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);

            }

        @And("I run a select query to get (.*) containing (.*) the data from the (.*) where (.*) equals (.*)$")
        public void run_selected_query(String columnName, String queryColumnName, String tableName, Integer queryColumn) throws SQLException{
            QUERY = "SELECT" + columnName + " FROM " + tableName + " WHERE " + queryColumnName + " = " + queryColumn;
            statement = connection.createStatement();

            }


        @Then("^I should see the result as (.*)$")
        public void iShouldSeeTheResultAsColumnValue(String columnValue) throws SQLException {
            res.next();
            String expected = columnValue;
            String actual = res.getString(1);
            assertEquals(expected, actual);

            }

}
