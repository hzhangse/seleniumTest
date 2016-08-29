package com.train.seleniumTest;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieOpe {
	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.youdao.com");
		//获得 cookie
		Set<Cookie> coo = driver.manage().getCookies();
		//打印 cookie
		System.out.println(coo);
		driver.quit();
		}
}
