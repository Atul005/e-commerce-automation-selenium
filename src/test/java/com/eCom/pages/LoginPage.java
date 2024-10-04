package com.eCom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/a")
    WebElement loginIcon;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement pass;

    @FindBy(xpath = "//*[@id=\"customerloginForm\"]")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/div/div/a[2]")
    WebElement logOutIcon;

    @FindBy(name = "//*[@id=\"dropdownMenuButton\"]")
    WebElement logoutImage;

    public void loginPortal(String userName, String password){
        loginIcon.click();
        email.sendKeys(userName);
        pass.sendKeys(password);
        submit.click();
    }

    public void logOut(){
        logoutImage.click();
        logOutIcon.click();

    }

}
