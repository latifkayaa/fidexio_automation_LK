package com.fidexio.step_definitions;


import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }

    @When("user enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.usernameField.sendKeys(username);
    }

    @And("user enters valid password {string}")
    public void user_enters_valid_password(String password) {
        loginPage.passwordField.sendKeys(password);
    }

    @When("user clicks the Log in button")
    public void user_clicks_the_log_in_button() {
        loginPage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
    }

    @Then("user should land on home page")
    public void user_should_land_on_home_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Odoo"));
    }

    @When("user enters invalid-valid username {string}")
    public void user_enters_invalid_valid_username(String username) {
        loginPage.usernameField.sendKeys(username);
    }

    @When("user enters invalid-valid password {string}")
    public void user_enters_invalid_valid_password(String password) {
        loginPage.passwordField.sendKeys(password);
    }

    @Then("Wrong login-password error message should be displayed.")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.wrongLoginErrorMessage.isDisplayed());
    }


    @Then("Please fill out this field error message should be displayed for password")
    public void field_error_message_should_be_displayed_for_password() {
        String expectedAlert = "Please fill out this field.";

        String actualAlertForPassword = Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage");

        Assert.assertEquals(expectedAlert, actualAlertForPassword);


    }

    @Then("Please fill out this field error message should be displayed for username")
    public void field_error_message_should_be_displayed_for_username() {
        String expectedAlert = "Please fill out this field.";
        String actualAlertForUsername = Driver.getDriver().findElement(By.name("login")).getAttribute("validationMessage");
        Assert.assertEquals(expectedAlert, actualAlertForUsername);
    }


    @When("user presses the ENTER key of the keyboard")
    public void user_presses_the_ENTER_key_of_the_keyboard() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @When("user clicks the Reset password button")
    public void user_clicks_the_reset_password_button() {
        loginPage.resetPasswordButton.click();
    }

    @Then("user should land on the ‘reset password’ page")
    public void user_should_land_on_the_reset_password_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Reset password"));
    }

    @Then("user sees the password as masked")
    public void user_sees_the_password_as_masked() {
        if (loginPage.passwordField.getAttribute("type").equals("password")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

}






