package com.eCom.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ITestListenerClass implements ITestListener {

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void configureReport(){
        extentSparkReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Machine", "E-Commerce Automation Project");
        extentReports.setSystemInfo("OS", "Windows 11");

        extentSparkReporter.config().setDocumentTitle("Test Execution Report");
        extentSparkReporter.config().setReportName("E-Commerce Automation Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("E-Commerce Suite Completed");
        extentReports.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("E-Commerce Suite Started");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case FAILED "+result.getMethod().getMethodName()+" "+result.getTestClass());
        extentTest = extentReports.createTest(result.getMethod().getMethodName());

        extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getMethod().getMethodName()+".png";
        File screenShotFile = new File(screenShotPath);
        if(screenShotFile.exists()){
            extentTest.fail("Screenshot added"+ extentTest.addScreenCaptureFromPath(screenShotPath));
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case SKIPPED "+result.getMethod().getMethodName()+" "+result.getTestClass());
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Case started "+result.getMethod().getMethodName()+ " "+result.getTestClass());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case PASSED "+result.getMethod().getMethodName()+" "+result.getTestClass());
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
    }
}
