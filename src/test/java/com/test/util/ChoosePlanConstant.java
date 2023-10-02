package com.test.util;

import java.util.HashMap;
import java.util.Map;

public class ChoosePlanConstant {
	
	static Map<String, Double> planCharges=null;
	static Map<String,Map<String,Double>> countryWisePlan= new HashMap<String,Map<String,Double>>();
	@SuppressWarnings("serial")
	static Map<String,String> countryCode=new HashMap<String, String>() {{
	    put("Kuwait", "kw");
	    put("Bahrain", "bh");
	    put("KSA","sa");
	}};
	@SuppressWarnings("serial")
	static Map<String,String> countryCurrency=new HashMap<String, String>() {{
	    put("Kuwait", "KWD");
	    put("Bahrain", "BHD");
	    put("KSA","SAR");
	}};
	
	public static String getCountryCurreny(String country)
	{
		return countryCurrency.get(country);
	}
	
	public static void setPlanChargesCountryWise()
	{
		//Kuwait Plan
		planCharges=new HashMap<String, Double>();
		planCharges.put("LITE", 1.2);
		planCharges.put("CLASSIC", 2.5);
		planCharges.put("PREMIUM", 4.8);
		countryWisePlan.put("Kuwait", planCharges);
		
		//KSA Plan
		planCharges=new HashMap<String, Double>();
		planCharges.put("LITE", (double) 15);
		planCharges.put("CLASSIC", (double) 25);
		planCharges.put("PREMIUM", (double) 60);
		countryWisePlan.put("KSA", planCharges);
		
		//Bahrain Plan
		planCharges=new HashMap<String, Double>();
		planCharges.put("LITE", (double) 2);
		planCharges.put("CLASSIC", (double) 3);
		planCharges.put("PREMIUM", (double) 6);
		countryWisePlan.put("Bahrain", planCharges);
	}
	
	public static Double getCountryWiseCharges(String country,String packageName)
	{
		Double charge=countryWisePlan.get(country).get(packageName.toUpperCase());
		return charge;
	}
	
	public static String getCountryCode(String country)
	{
		return countryCode.get(country);
	}

}
