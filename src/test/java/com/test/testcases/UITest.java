package com.test.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pageObject.ChoosePlan;
import com.test.pageObject.HomePage;

public class UITest extends BaseTest {

	public HomePage home=null;
	public ChoosePlan choosePlan=null;
	
	@BeforeTest
	public void before()
	{
		webAction.getDriver("chrome");
		home=new HomePage(webAction);
		choosePlan=new ChoosePlan(webAction);
		home.navigateSubscribeTv();
	}
	
	@Test
	public void BahrainTest() {
		
		String country="Bahrain";
		home.selectEnglishLocale();
		home.selectCountry(country);
		// Verify plan charges and currency
		choosePlan.verifyPlanChargesForPackage(country, "Lite");
		choosePlan.verifyPlanChargesForPackage(country, "Classic");
		choosePlan.verifyPlanChargesForPackage(country, "Premium");
	}
	
	@Test
	public void KuwaitTest() {
		
		String country="Kuwait";
		home.selectEnglishLocale();
		home.selectCountry(country);
		// Verify plan charges and currency
		choosePlan.verifyPlanChargesForPackage(country, "Lite");
		choosePlan.verifyPlanChargesForPackage(country, "Classic");
		choosePlan.verifyPlanChargesForPackage(country, "Premium");
	}
	
	@Test
	public void KSATest() {
		
		String country="KSA";
		home.selectEnglishLocale();
		home.selectCountry(country);
		// Verify plan charges and currency
		choosePlan.verifyPlanChargesForPackage(country, "Lite");
		choosePlan.verifyPlanChargesForPackage(country, "Classic");
		choosePlan.verifyPlanChargesForPackage(country, "Premium");
	}
	
	@AfterTest
	public void after()
	{
		webAction.close();
	}
}