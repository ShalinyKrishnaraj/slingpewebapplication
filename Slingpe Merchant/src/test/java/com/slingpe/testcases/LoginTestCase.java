package com.slingpe.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.slingpe.pageobject.LoginPage;


public class LoginTestCase extends BaseClass
{

	@Test
	public void tc_001(){

		LoginPage login=new LoginPage(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);
		Log.info("website launch");
		login.setMobile(username);
		Log.info("valid username is entered successfully");
		login.setPwd(password);
		Log.info("valid password entered successfully");
		Log.info("TestCase Completed Successfully");
	}
	

}