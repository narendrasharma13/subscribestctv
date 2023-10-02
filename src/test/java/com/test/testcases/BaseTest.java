package com.test.testcases;

import org.testng.annotations.BeforeSuite;

import com.test.util.WebAction;

public class BaseTest {
	
	
	public WebAction webAction=null;
	
	@BeforeSuite
	public void beforeSuite()
	{
		webAction=new WebAction();
	}

}
