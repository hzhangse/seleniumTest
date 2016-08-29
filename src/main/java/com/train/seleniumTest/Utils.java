package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utils {
	/** 这是智能等待元素加载的方法 */
	public void intelligentWait(WebDriver driver, int timeOut, final By by) {
		try {
			(new WebDriverWait(driver, timeOut))
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver driver) {
							WebElement element = driver.findElement(by);
							return element.isDisplayed();
						}
					});

		} catch (TimeoutException e) {
			Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
		}
	}

}
