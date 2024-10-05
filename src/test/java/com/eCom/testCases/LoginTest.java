package com.eCom.testCases;

import com.eCom.pages.BaseClass;
import com.eCom.pages.LoginPage;
import com.eCom.utilities.ExcelDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    public static final String FILE_NAME = System.getProperty("user.dir")+ "\\TestData\\CommerceProjectExcel.xlsx";
    public static final String SHEET_NAME = "Users";



    @Test
    public void verify() throws IOException {
        String uName = "ravi@dhiyotech.in";
        String pass = "Dem";
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(uName,pass);
        if(uName.equals("ravi@dhiyotech.in") && pass.equals("Demo")){
            Assert.assertTrue(true);
        } else {
            captureScreenshot(webDriver, "verifyUsers");
            Assert.fail();
        }
//        loginPage.logOut();
    }


    @Test(dataProvider = "loginDataProvider")
    public void verifyUsers(String userName, String password) throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(userName, password);

        if(userName.equals("ravi@dhiyotech.in") && password.equals("Dem")){
            Assert.assertTrue(true);
        } else {
            captureScreenshot(webDriver, "verifyUsers");
            Assert.fail();
        }
    }

    @DataProvider
    public String[][] loginDataProvider(){
        int row = ExcelDataProvider.getRowCount(FILE_NAME, SHEET_NAME);
        int col = ExcelDataProvider.getColumnCount(FILE_NAME, SHEET_NAME);

        String[][] userPassMatrix = new String[row-1][col];

        for(int i=1;i<userPassMatrix.length;i++){
            for(int j=0;j<userPassMatrix.length;j++){
                userPassMatrix[i-1][j]= ExcelDataProvider.getCellValue(FILE_NAME, SHEET_NAME, i, j);
            }
        }

        return userPassMatrix;
    }

}
