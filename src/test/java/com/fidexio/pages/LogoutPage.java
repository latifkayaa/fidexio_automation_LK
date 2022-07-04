package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(className = "oe_topbar_name")
    public WebElement usernameButton;

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;

    @FindBy(className = "modal-title")
    public WebElement sessionExpiredAlertHeader;

    @FindBy(xpath = "//span[.='Ok']")
    public WebElement okButton;
}
