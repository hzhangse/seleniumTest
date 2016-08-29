package com.train.seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserGo {

	public static void main(String[] args){
//		System.setProperty("webdriver.chrome.driver",
//				"/usr/bin/google-chrome-stable");
//	
		WebDriver driver = new ChromeDriver();
		System.out.println("broser back and forward.");
		
		String firstUrl = "http://www.baidu.com";
	
		System.out.printf("now accesss %s \n", firstUrl);
		driver.get(firstUrl);
		String secondUrl = "http://news.baidu.com";
		System.out.printf("now accesss %s \n", secondUrl);
		driver.get(secondUrl);
		System.out.printf("now back to %s \n", firstUrl);
		driver.navigate().back();
		System.out.printf("forward to %s \n", secondUrl);
		driver.navigate().forward();
		driver.navigate().refresh();
	//	driver.quit();
		}
}
