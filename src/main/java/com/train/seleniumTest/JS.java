package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(700, 600));
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("webdriver api");
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		// 将页面滚动条拖到底部
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(100,450);");
		Thread.sleep(3000);
		System.out.println("end");
	//	driver.quit();
	}
}
