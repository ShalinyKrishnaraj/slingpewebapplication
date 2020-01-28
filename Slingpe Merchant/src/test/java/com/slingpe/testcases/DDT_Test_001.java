package com.slingpe.testcases;
import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slingpe.pageobject.LoginPage;
import com.slingpe.utility.ExcelUtils;
public class DDT_Test_001 extends BaseClass { 
	@Test(dataProvider="multiSheetExcelRead")
	public void getdatas(String uname,String pwd){
	LoginPage login=new LoginPage(driver);
	login.setMobile(number);
	}
	@DataProvider(name="multiSheetExcelRead", parallel=true)
	public static Object[][] multiSheetExcelRead(Method method) throws Exception
	{
		File file = new File("./src/test/java/com/slingpe/testData/Login Test Data.xlsx");
		String SheetName = method.getName();
		System.out.println(SheetName);
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
		return testObjArray;
	}
	
	@DataProvider(name="excelSheetNameAsMethodName",parallel=true)
	public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
	{
		File file = new File("./src/test/resources/Excel Files/"+method.getName()+".xlsx");
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
		return testObjArray;
	}
}
