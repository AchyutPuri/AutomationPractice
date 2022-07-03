package com.jarvis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Ravi Sir-Testing\\chrome 101\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		HttpURLConnection huc=null;
		
		String url ="";
		int code=0;
		
		driver.get("https://www.amazon.in");

		Thread.sleep(5000);
		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		
		System.out.println("size is: "+list.size());
		
		Iterator<WebElement> itr=list.iterator();
		
		
		while (itr.hasNext())
		{
			 url=itr.next().getAttribute("href");
			 
			 System.out.println(url);
			 
			 if(url==null || url.isEmpty())
			 {
				System.out.println("link is empty"); 
			 }
			 
			 try
			 {
			 URL url1=new URL(url);
			
			 
			 huc=(HttpURLConnection)url1.openConnection();
			 
			 huc.setRequestMethod("HEAD");
			 
			 huc.connect();
			 
			 code=huc.getResponseCode();
			 
			 if(code>=400)
			 {
				 System.out.println(url+" its a broken link");
			 }
			 else
			 {
				 System.out.println(url+" its a valid link");
			 }
			 } 
			 catch (MalformedURLException e)
			 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (IOException e)
			 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
