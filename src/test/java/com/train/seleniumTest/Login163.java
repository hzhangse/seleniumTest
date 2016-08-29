package com.train.seleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login163 {

	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod

	public void setUp() throws Exception {
		 driver = new FirefoxDriver();
		baseUrl = "http://mail.163.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// 定义对象数组
	@DataProvider(name = "user")
	public Object[][] Users() {
		return new Object[][] { { "rainbow954", "Q1w2E3r4" }, };
	}

	// 登录方法
	public  void login(WebDriver driver, String username, String password) {
		driver.get(baseUrl + "/");
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		By usernameBy = By
				.xpath(".//input[@data-type='email' and @name='email' ]");

		driver.findElement(usernameBy).sendKeys(username);
		By passwordBy = By
				.xpath("//input[@type='password' and  @autocomplete='new-password' and @data-required='true' and @name='password' and @data-placeholder='密码' ]");
		WebElement epassword = driver.findElement(passwordBy);
		epassword.clear();
		epassword.sendKeys(password);
		By login = By.xpath("//*[@id='dologin']");
		WebElement eloginButton = driver.findElement(login);
		driver.switchTo().defaultContent();
		WebElement we = driver.findElement(By.id("btnQiYu"));
		System.out.println(we.getTagName() + "***" + we.getAttribute("class"));
		driver.switchTo().frame(driver.findElement(By.id("x-URS-iframe")));
		eloginButton.click();
	//	Assert.fail();
	}

	// 调用 user 数组的值
	@Test(dataProvider = "user")
	public void testlogin(String username, String password1) throws Exception {
		login(driver,username,password1);
		driver.quit();
	}

	@Test(dependsOnMethods = { "testlogin" },dataProvider = "user")
	public void ClickRecLink(String name, String password1) {
   
		login(driver,name,password1);
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
		}).click();
		this.driver.close();
	}
}
