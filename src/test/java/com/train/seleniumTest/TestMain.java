package com.train.seleniumTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMain {
	private Main m;

	@BeforeMethod
	public void init() {
		m = new Main();
	}

	@Test
	public void testSayHello() {
		AssertJUnit.assertEquals(m.sayHello(), "Hallo Welt!");
	}
}
