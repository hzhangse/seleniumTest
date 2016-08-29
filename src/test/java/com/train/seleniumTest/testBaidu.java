package com.train.seleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testBaidu {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).sendKeys("testNG");
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "testNG_百度搜索");
	}
	
	@Test
	@Parameters("test1") //设置测试方法的入参
	public void testCase1(String test1) throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).sendKeys(test1);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, test1+"_百度搜索");
	}

	@AfterMethod
	
	public void tearDown() throws Exception {
		driver.quit();
	}
}
