package com.test.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UITest extends BaseTest {

	String searchBar="//input[@type='text']";
	String searchSuggestion="//*[contains(@class,'suggestion-ell')]";
	
	@BeforeTest
	public void before()
	{
		webAction.getDriver("chrome");
		webAction.get("https://www.amazon.in/");
		webAction.wait(2);
	}
	
	@Test
	public void SearchAmazon() {
		
		webAction.sendKeys("amazon", searchBar);
		webAction.printTextFromAll(searchSuggestion);
		
		
	}
	
	@AfterTest
	public void after()
	{
		webAction.close();
	}
}