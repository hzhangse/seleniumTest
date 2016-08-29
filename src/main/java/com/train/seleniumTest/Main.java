package com.train.seleniumTest;

public class Main {
	public String sayHello() {
		return "Hallo Welt!";
	}

	public static void main(String[] args) {
		Main objOfMain = new Main();
		System.out.println(objOfMain.sayHello());
	}
}