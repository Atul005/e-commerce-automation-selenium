package com.eCom.testCases;

import com.eCom.pages.BaseClass;
import com.eCom.pages.LoginPage;
import com.eCom.pages.SearchPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(SearchProductTest.class);

    @Test
    public void searchProductTest(){
        SearchPage searchPage = new SearchPage(webDriver);
        loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(userName, password);
        searchPage.searchPage("Android TV");
    }

    @Test
    public void dataDrivenSearchProductTest(){

    }


}
