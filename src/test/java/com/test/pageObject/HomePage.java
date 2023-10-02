package com.test.pageObject;

import org.testng.Assert;

import com.test.util.ChoosePlanConstant;
import com.test.util.WebAction;

public class HomePage {

	WebAction wb = null;
	String subscribeTvUrl = "https://subscribe.stctv.com/";

	// locators
	String engLocale = "//*[@href='/sa-en' and @id='translation-btn']";
	String currentCountry = "//*[@class='country-current']";
	String selectCountryPopup = "//*[@id='country-selct']";
	String selectCountryCode = "//*[@id='##replaceString##']";

	public HomePage(WebAction webAction) {
		wb = webAction;
	}

	public void navigateSubscribeTv() {
		wb.get(subscribeTvUrl);
		wb.wait(2);
	}

	public void selectEnglishLocale() {
		if (wb.isElementPresent(engLocale)) {
			wb.click(engLocale);
			wb.wait(2);
		}
	}

	public void selectCountry(String country) {
		wb.click(currentCountry);
		String countryCode = ChoosePlanConstant.getCountryCode(country);
		Assert.assertTrue(wb.isElementPresent(selectCountryCode, countryCode), "Select Country popup could not open");
		wb.click(selectCountryCode, countryCode);
		wb.wait(5);
	}

}
