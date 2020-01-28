package com.slingpe.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	File file=new File("./Configuration\\config.properties");
	public ReadConfig(){

		try {
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	public String getWebApplicationURL() 
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getApplicationUserName() {
		String uname=pro.getProperty("username");
		return uname;

	}
	public String getApplicationPassword() {
		String pwd1=pro.getProperty("password");
		return pwd1;		
	}
	public String getApplicationDriver1() {
		String driver1=pro.getProperty("chromepath");
		return driver1;
	}
	public String getApplicationDriver2() {
		String driver2=pro.getProperty("firefoxpath");
		return driver2;
	}
	public String getApplicationDriver3() {
		String driver3=pro.getProperty("iepath");
		return driver3;
	}
	

}

