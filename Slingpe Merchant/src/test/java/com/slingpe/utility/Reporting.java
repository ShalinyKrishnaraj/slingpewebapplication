package com.slingpe.utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Reporting implements ITestListener {
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlreports;
	
	

	public void onTestStart(ITestResult result) {
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed Successfully");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\HP\\git\\repository3\\Slingpe Merchant\\Screenshots" + result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture("C:\\Users\\HP\\git\\repository3\\Slingpe Merchant\\Screenshots" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}
	public void onStart(ITestContext context) {
		System.out.println("on start");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		reports.addSystemInfo("User Name","Shaliny Krishnaraj");
		reports.addSystemInfo("Host Name", "localhost");
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		reports.endTest(test);
		reports.flush();
	}
}

