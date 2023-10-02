package com.test.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAction {

	WebDriver driver=null;
	WebDriverWait wait = null;
	public WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 10);
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 10);
		}
		return driver;
	}
	
	public WebElement find(String...xpath)
	{
		String xp=xpath[0];
		if(xpath.length==2)
			xp=xp.replaceAll("##replaceString##", xpath[1]);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
		return element;
	}
	
	public List<WebElement> findAll(String...xpath)
	{
		String xp=xpath[0];
		if(xpath.length==2)
			xp=xp.replaceAll("##replaceString##", xpath[1]);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xp)));
		return elements;
	}
	
	public void click(String... xpath)
	{
		WebElement element=find(xpath);
		element.click();
	}
	
	public void sendKeys(String text,String ...xpath)
	{
		WebElement element=find(xpath);
		element.sendKeys(text);
	}
	
	public void get(String url)
	{
		driver.get(url);
	}
	
	public void wait(int i)
	{
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printTextFromAll(String ...xpath)
	{
		List<WebElement> list=findAll(xpath);
		for(WebElement e:list)
			System.out.println(e.getText());
	}
	
	public void close()
	{
		driver.close();
	}
}
