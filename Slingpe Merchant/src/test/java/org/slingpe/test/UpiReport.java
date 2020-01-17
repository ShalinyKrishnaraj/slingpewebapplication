package org.slingpe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpiReport {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse\\Slingpe Merchant\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://upi.slingpe.com/");
		driver.manage().window().maximize();

	}

}
