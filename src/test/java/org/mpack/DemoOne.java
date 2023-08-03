package org.mpack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoOne {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("APjFqb")).sendKeys("Automation testing tools");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//span[text()='20 more']")).click();
		List<WebElement> allTitle = driver.findElements(By.xpath("//div[@class='FZPZX q8U8x PZPZlf']"));
		List<WebElement> link = driver.findElements(By.xpath("//a[contains(text(),'Wikipedia')]"));
		
		if(allTitle.size()>0 && link.size()>0)
		{
			for(int i=0;i<allTitle.size() && i<link.size();i++) {
				WebElement titleElement = allTitle.get(i);
				String title = titleElement.getText();
				WebElement linkElement = link.get(i);
				
				String href = linkElement.getAttribute("href");
				System.out.println("Title :" +title);
				System.out.println("Link :" +href);
				System.out.println();
			}}
			else {
				System.out.println("No result found");
			}
			if(driver !=null)
			{driver.quit();
			
			}
		}
		
	}


