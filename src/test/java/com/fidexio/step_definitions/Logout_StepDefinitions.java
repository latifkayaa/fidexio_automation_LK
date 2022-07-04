package com.fidexio.step_definitions;

import com.fidexio.pages.LogoutPage;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDefinitions {

    LogoutPage logoutPage = new LogoutPage();

    @Then("User clicks on their username which is on the up right side of the page")
    public void user_clicks_on_their_username_which_is_on_the_up_right_side_of_the_page() {
        logoutPage.usernameButton.click();
    }
    @Then("User clicks Log out text button")
    public void user_clicks_log_out_text_button() {
        logoutPage.logoutButton.click();
    }
    @Then("User should land on login page")
    public void user_should_land_on_login_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Login"));
    }

    @When("User clicks the go back button which is on the up left corner of the browser page")
    public void user_clicks_the_go_back_button_which_is_on_the_up_left_corner_of_the_browser_page() {
       Driver.getDriver().navigate().back();
    }
    @And("User sees the Odoo Session Expired text")
    public void user_sees_the_odoo_session_expired_text() {
        Assert.assertTrue(logoutPage.sessionExpiredAlertHeader.getText().equals("Odoo Session Expired"));
    }

    @And("User clicks the Ok button")
    public void user_clicks_the_ok_button() {
     logoutPage.okButton.click();
    }
    @Then("User should not be able to go to the home page again and sees the title as Odoo")
    public void user_should_not_be_able_to_go_to_the_home_page_again_and_sees_the_title_as_odoo() {

        String expiredSessionTitle = "Odoo";
        if (Driver.getDriver().getTitle().equals(expiredSessionTitle)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }


}
