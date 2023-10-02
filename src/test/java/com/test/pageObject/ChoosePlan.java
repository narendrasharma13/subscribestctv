package com.test.pageObject;

import org.testng.Assert;

import com.test.util.ChoosePlanConstant;
import com.test.util.WebAction;

public class ChoosePlan {
	
	WebAction wb=null;
	
	
	
	//locators
	String price="(//*[@class='price'])[count(//*[text()='##replaceString##']/../preceding-sibling::*)+1]";
	
	
	public ChoosePlan(WebAction webAction)
	{
		wb=webAction;
		ChoosePlanConstant.setPlanChargesCountryWise();
	}

	public void verifyPlanChargesForPackage(String country,String packageName)
	{
		try {
		String charge=wb.getText(price,packageName);
		Double actualCharge=Double.parseDouble(charge.split(" ")[0]);//Double.parseDouble(charge.replaceAll("\\D", ""));
		Double expectedCharge=ChoosePlanConstant.getCountryWiseCharges(country, packageName);
		String expectedCurrency=ChoosePlanConstant.getCountryCurreny(country);
		boolean flagCurrency=charge.contains(expectedCurrency);
		Assert.assertEquals(actualCharge,expectedCharge,"Plan charges are incorrect(Expected:"+expectedCharge+" actual:"+charge+")");
		Assert.assertTrue(flagCurrency,"Country currency is incorrect(Expected:"+expectedCurrency+" actual:"+charge+")");
		System.out.println(country+" Plan Charges for "+packageName+" Package verified : "+charge);
		}catch(Exception e) {}
	}
	
	
	
}
