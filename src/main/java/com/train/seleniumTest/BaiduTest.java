package com.train.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaiduTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/firefox");
		//WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",
//			"/usr/bin/google-chrome-stable");
//		  WebDriver driver = new InternetExplorerDriver();  
		//WebDriver driver = new ChromeDriver();
	    WebDriver driver = new FirefoxDriver();  
	     
	    driver.manage().window().setSize(new Dimension(800, 600));
	        // 让浏览器访问 Baidu  
	        driver.get("http://www.baidu.com");  
	        // 用下面代码也可以实现  
	        // driver.navigate().to("http://www.baidu.com");  
	  
	        // 获取 网页的 title  
	        System.out.println("1 Page title is: " + driver.getTitle());  
	  
	        // 通过 id 找到 input 的 DOM  
	        WebElement element = driver.findElement(By.id("kw"));  
	  
	        // 输入关键字  
	        element.sendKeys("zTree");  
	  
	        // 提交 input 所在的  form  
	        element.submit();  
	          
	        // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒  
	        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {  
	            public Boolean apply(WebDriver d) {  
	                return d.getTitle().toLowerCase().startsWith("ztree");  
	            }  
	        });  
	  
	        // 显示搜索结果页面的 title  
	        System.out.println("2 Page title is: " + driver.getTitle());  
	          
	        //关闭浏览器  
	        driver.quit(); 
	}
}
