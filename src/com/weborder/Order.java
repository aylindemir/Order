package com.weborder;

import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class Order {

	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/aylin/Documents/Selenium Dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		WebElement webelement = driver.findElement(By.linkText("Order"));
		Actions action = new Actions(driver).contextClick(webelement);
		Thread.sleep(2000);
		action.build().perform();
		Actions action2= new Actions(driver);
		action2.contextClick(webelement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		int Rquantity = (int) (Math.random() * (100 - 1)) + 1;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Integer.toString(Rquantity));
		Thread.sleep(2000);
		
		String CustomerName = "John " + RandomString() + " Smith";
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(CustomerName);
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia"); 
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(RandomZip());
		Thread.sleep(2000);
		int r2 = (int) (Math.random() * (2 - 0)) + 0;
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_"+r2+"\"]")).click();
		Thread.sleep(2000);
		String type="";
		int len=0;
		if(r2==0)
			{type="visa"; len=15;}
		else if(r2==1)
			{type="master"; len=15;}
		else if(r2==2)
			{type="americanExpress"; len=14;} 
		String cardnumber=randomCreditCard(len,type);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys(cardnumber);
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("11/23");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		Thread.sleep(2000);
		
		
	}
	public static String randomCreditCard(int len,String type) {
		StringBuilder std=new StringBuilder();
		int rdigit;
	   for (int i = 0; i < len; i++) {
		   rdigit = (int) (Math.random() * (9 - 0)) + 0;
		   std.append(rdigit);
		
	}
	   return std.toString();
}
	public static String RandomZip() {
	    Random r = new Random( System.currentTimeMillis() );
	    int zip = 10000 + r.nextInt(20000);
	    return String.valueOf(zip);
	}
	public static String RandomString() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int Length = 5;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(Length);
	    for (int i = 0; i < Length; i++) {
	        int limit = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) limit);
	    }
	    return buffer.toString(); 
	}
	

	
}
