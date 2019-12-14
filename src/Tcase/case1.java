package Tcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataRead.ReadExldata;

public class case1 {
	WebDriver driver;
	ReadExldata obj=new ReadExldata();
	@BeforeClass
	public void A()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Desktop\\Java\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
//	@DataProvider
//	public String[][] methoddata() throws IOException
//	{
//		String testdata[][]=ReadExldata.Exlread();
//		return testdata;
//		
//	}
	@Test()
	public void B() throws IOException
	{
		String data[][] = ReadExldata.Exlread();
		for(int i=1;i<data.length;i++)
		{
			driver.get("http://demo.automationtesting.in");
			driver.findElement(By.id("btn2")).click();
			String Fname=data[i][2];
			String Lastname=data[i][3];
			String Address=data[i][4];
			String Emailid=data[i][5];
			String Phone=data[i][6];
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Fname);
			driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys(Lastname);
			driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys(Address);
			driver.findElement(By.xpath("//*[@id='eid']/input")).sendKeys(Emailid);
			driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[4]/div/input")).sendKeys(Phone);
		
						
		}

		
	}

}
