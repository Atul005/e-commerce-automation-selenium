package com.eCom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver webDriver;
    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id="frm_search")
    WebElement searchBar;

    @FindBy(id="btn_search")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[2]/div/div/p/a")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[3]/a")
    WebElement cartIcon;

    @FindBy(xpath="//*[@id=\"cart\"]/div[2]/div/a")
    WebElement checkOut;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/nav/ol/li[1]/a")
    WebElement home;


    public void searchPage(String productName){
        home.click();
        searchBar.sendKeys(productName);
        searchButton.click();
        addToCart.click();
        cartIcon.click();
        checkOut.click();
    }


}
