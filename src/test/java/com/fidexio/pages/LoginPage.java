package com.fidexio.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage{

    @FindBy(id = "login")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(partialLinkText = "Reset")
    public WebElement resetPasswordButton;

    @FindBy (xpath = "//*[contains(text(), 'Wrong login/password')]")
    public WebElement wrongLoginErrorMessage;

}
