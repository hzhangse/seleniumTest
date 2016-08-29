package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alert {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		// 鼠标悬停相“设置”链接
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("设置"))).perform();
		// 打开搜索设置
		driver.findElement(By.className("setpref")).click();
		Thread.sleep(2000);
		// 保存设置
		driver.findElement(By.className("prefpanelgo")).click();
		Thread.sleep(2000);
		// 接收弹窗
		driver.switchTo().alert().accept();
	//	driver.quit();
	}
}
