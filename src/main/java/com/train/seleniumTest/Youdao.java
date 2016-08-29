package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youdao {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.youdao.com");
		driver.findElement(By.id("translateContent")).sendKeys("submit");
		// 提交输入的内容
		driver.findElement(By.id("translateContent")).submit();
	driver.quit();
	}
}