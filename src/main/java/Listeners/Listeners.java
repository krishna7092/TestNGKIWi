package Listeners;

import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {


    ExtentReports report=GenerateExtentreports.generatereport();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = report.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        test.fail(result.getThrowable());
        String path;
        try {
            driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.
                    getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            path= takescreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" +path,"failed");


    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        report.flush();
    }
}
