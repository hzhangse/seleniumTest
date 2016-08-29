package com.train.seleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login1631 {
	public static void main(String[] args) {
		// System.setProperty("webdriver.gecko.driver",
		// "/home/ryan/work/tools/firefox/firefox");
		System.setProperty("webdriver.gecko.driver", "/usr/bin/firefox");
		System.out.println("163 mail login.");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://mail.163.com");

		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		By username = By
				.xpath(".//input[@data-type='email' and @name='email' ]");

		driver.findElement(username).sendKeys("rainbow954");
		By password = By
				.xpath("//input[@type='password' and  @autocomplete='new-password' and @data-required='true' and @name='password' and @data-placeholder='密码' ]");
		WebElement epassword = driver.findElement(password);
		epassword.clear();
		epassword.sendKeys("Q1w2E3r4");
		By login = By.xpath("//*[@id='dologin']");
		WebElement eloginButton = driver.findElement(login);
		driver.switchTo().defaultContent();
		WebElement we = driver.findElement(By.id("btnQiYu"));
		System.out.println(we.getTagName() + "***" + we.getAttribute("class"));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		eloginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				By recLink = By.xpath("//div[@id='_mail_component_65_65']");
				return d.findElement(recLink);

			}
		}).click();
		By recLink = By.xpath("//div[@id='_mail_component_65_65']");
		WebElement recLink1 = driver.findElement(recLink);
		Actions action = new Actions(driver);
		action.contextClick(recLink1).perform();
		List<WebElement> lst = driver.findElements(By
				.className("nui-menu-item-text"));
		for (WebElement ele : lst) {

		}
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				List<WebElement> lst = d.findElements(By
						.className("nui-menu-item-text"));
				WebElement ele = null;
				for (WebElement el : lst) {
					if (el.getText().equalsIgnoreCase("查看未读")) {
						ele = el;
					}
				}
				return ele;
			}
		}).click();;
		
		// action.clickAndHold(driver.findElement(By.xpath(""))).perform();
		// driver.quit();
	}
}
