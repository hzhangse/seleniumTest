package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("http://pan.baidu.com/disk/home#list/path=%2F");
		
		// 鼠标右键点击指定的元素
		Actions action = new Actions(driver);
		By.linkText("photo");
		action.contextClick(driver.findElement(By.linkText("photo"))).perform();
	
		}
}
