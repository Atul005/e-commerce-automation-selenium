package com.eCom.pages;

import com.eCom.utilities.BrowserFactory;
import com.eCom.utilities.DataConfigProvider;
import com.eCom.utilities.ExcelDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public DataConfigProvider dataConfigProvider = new DataConfigProvider();
    public WebDriver webDriver;

    public static final String FILE_NAME = System.getProperty("user.dir")+ "\\TestData\\CommerceProjectExcel.xlsx";
    public static final String SHEET_NAME = "Users";

    protected String userName = ExcelDataProvider.getCellValue(FILE_NAME, SHEET_NAME, 1 ,0);
    protected String password = ExcelDataProvider.getCellValue(FILE_NAME, SHEET_NAME, 1 ,1);

    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        webDriver = BrowserFactory.startApplication(webDriver, dataConfigProvider.getBrowser(), dataConfigProvider.getUrl());
    }

    @AfterClass
    public void quit(){
        webDriver.quit();
    }

    public void captureScreenshot(WebDriver webDriver, String testName) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) webDriver;

        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcPath = new File("."+"//Screenshots//"+testName+".png");

        System.out.println("Screenshot taken for failed testcases");

        FileUtils.copyFile(src, srcPath);
    }


}
