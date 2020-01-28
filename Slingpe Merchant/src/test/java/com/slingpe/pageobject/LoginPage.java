package com.slingpe.pageobject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver1){
		driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	@FindBy(id="name")
	WebElement txtusername;

	@FindBy(id="mobile")
	WebElement txtmobilenumber;

	@FindBy(id="email")
	WebElement txtemail;

	@FindBy(id="password")
	WebElement txtpassword;

	@FindBy(id="password_confirmation")
	WebElement txtconfirmpassword;

	@FindBy(xpath="//button[@class='btn btn-lg login-btn-sec btn-block text-white mb-4']")
	WebElement btnregisternow;

	@FindBy(id="mobile")
	WebElement txtmobile;

	@FindBy(id="password")
	WebElement txtpass;

	@FindBy(xpath="//label[contains(text(),'Remember me')]//input")
	WebElement clkrememberme;

	@FindBy(xpath="//button[@class='btn btn-lg login-btn-sec btn-block text-white mb-4']")
	WebElement clksignin;

	public void setName(String name){
		txtusername.sendKeys(name);
	}

	public void setMobile(String number) {
		txtmobilenumber.sendKeys(number);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setPwd(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void setConfirmpwd(String confirmpwd)
	{
		txtconfirmpassword.sendKeys(confirmpwd);
	}

	public void btnsRegisternow() {
		btnregisternow.click();
	}

	public void setMobileno(String mobileno) {
		txtmobile.sendKeys(mobileno);
	}

	public void setPassword(String password) {
		txtpass.sendKeys(password);
	}

	public void btnSignin() {
		clksignin.click();
	}

	public void btnRememberme() {
		clkrememberme.click();
	}

}




	