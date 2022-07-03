package com.jarvis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException, MalformedURLException,IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Ravi Sir-Testing\\chrome 101\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		HttpURLConnection huc=null;
		
		String url="";
		driver.get("https://www.ebay.com");
		
		Thread.sleep(5000);
		
		List<WebElement> urlList=driver.findElements(By.tagName("a"));
		
		for(int i=1;i<urlList.size();i++)
		{
			url=urlList.get(i).getAttribute("href");
			
			System.out.println(" url is: "+url);
			
			URL url1=new URL(url);
			
			huc=(HttpURLConnection) url1.openConnection();
			
			huc.setRequestMethod("HEAD");
			
			huc.connect();
			
			int resCode=huc.getResponseCode();
			
			if(resCode>=400)
			{
				System.out.println(url+ " this link is broken");
				System.out.println("    ");
			}
			
			
		}
		
		
		
		
		
		
	}

}
