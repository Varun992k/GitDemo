package com.pageees;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.baseeees.BaseMain;

//import Pages.OrangeHrm;

public class PagesMain extends BaseMain {
	
	//Opening the URL using respective browser
	public void OpenUrl() throws InterruptedException{
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Thread.sleep(2000);
		}
   //  @FindBy(css="a[for='AutomationTester']")
    // public WebElement AutomationTester;
	//To enter into the OrangeHRM using valid credentials
	public void search() throws InterruptedException{
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);

	}

	//To check whether the dashboard URL is matched or not
	public void dashboardUrl() {
		if(driver.getCurrentUrl().contains("dashboard")) 
			System.out.println("Valid URL");
		else
			System.out.println("Invalid URL");

	}

	// Navigating to the Admin tab
	public void searchingJobs() throws InterruptedException {
		
		Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"))).perform();
		action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b"))).perform();
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("menu_admin_Job"))).perform();
		Thread.sleep(2000);
	}

	//To check whether the jobTitle is present or not
	public void checkingJobTitle() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//*[@id='menu_admin_viewJobTitleList']"));
			System.out.println("Job Title Exists");
			
			Actions action2 = new Actions(driver);
			//driver.findElement(By.xpath("//*[@id='menu_admin_viewJobTitleLists']"));	
			driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
			Thread.sleep(2000);
			
			List<WebElement> jobs = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a"));
			//Displaying the list of available jobs
			
			System.out.println("-----Lits of Jobs available-----");
			for(int i=0;i<jobs.size();i++){
				
				System.out.println(jobs.get(i).getText());
			}
			if(driver.getPageSource().contains("Automation Tester")){
				driver.findElement(By.id("btnAdd")).click();
				driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
				//driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				System.out.println("-----Automation Tester exists-----");
				Thread.sleep(2000);
				driver.findElement(By.name("btnCancel")).click();
			} 
			else {
				System.out.println("-----Automation Tester doesn't exist so we are adding a AUOTAMATION TESTER into the list-----");
				driver.findElement(By.id("btnAdd")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
				Thread.sleep(2000);
				driver.findElement(By.name("jobTitle[jobDescription]")).sendKeys("Automate the web applications");
				Thread.sleep(2000);
				driver.findElement(By.name("jobTitle[note]")).sendKeys("Need to be expertise");
				driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				System.out.println("-----Automation Tester added successfully-----");
				
			}
			//Cancelling the adding automation tester if it exists
			/*	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/form/div[4]/table/tbody/tr[1]/td[2]/a"));
				
				driver.findElement(By.id("btnAdd")).click();
				driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
				//driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				System.out.println("-----Automation Tester exists-----");
				Thread.sleep(2000);
				driver.findElement(By.name("btnCancel")).click();
			   
				//Adding automation tester if it doesn't exist
				
				driver.findElement(By.id("btnAdd")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
				Thread.sleep(2000);
				driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				System.out.println("-----Automation Tester doesn't exist so we are adding a AUOTAMATION TESTER into the list-----");
				*/
		
		} 
		
		catch(Exception e) {
			System.out.println("Job Title doesn't exist");
			
		}   
	
	
	
	
	
	} 


	/*To check whether automation tester is avalaible or not and displays all available jobs
		public void viewingJobTitleList() throws InterruptedException {
	  //  Actions action2 = new Actions(driver);
		//action2.moveToElement(driver.findElement(By.id("menu_admin_Job"))).perform();
		driver.findElement(By.xpath("//*[@id='menu_admin_viewJobTitleLists']"));	
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		Thread.sleep(2000);
		
		List<WebElement> jobs = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a"));
		//Displaying the list of available jobs
		System.out.println("-----Lits of Jobs available-----");
		for(int i=0;i<jobs.size();i++){
			
			System.out.println(jobs.get(i).getText());
		}
		//Cancelling the adding automation tester if it exists
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/form/div[4]/table/tbody/tr[1]/td[2]/a"));
			
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
			//driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
			System.out.println("-----Automation Tester exists-----");
			Thread.sleep(2000);
			driver.findElement(By.name("btnCancel")).click();
		} //Adding automation tester if it doesn't exist
		catch(NoSuchElementException e) {
			
			driver.findElement(By.id("btnAdd")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys("Automation Tester");
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
			System.out.println("-----Automation Tester doesn't exist so we are adding a AUOTAMATION TESTER into the list-----");
		}
	} */
		//Logging-out fromt the OrangeHRM website
		public void logOut() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[9]/ul/li[3]/a")).click();
			Thread.sleep(2000);
			System.out.println("-----Successfully logged-Out from the OrangeHRM-----");
		}
		public static void main(String[] args) throws InterruptedException{
		PagesMain  hrm= new PagesMain();
		hrm.driverSetup();
		hrm.OpenUrl();
		hrm.search();
		hrm.dashboardUrl();
		hrm.searchingJobs();
		hrm.checkingJobTitle();
	//	hrm.viewingJobTitleList();
		hrm.logOut();

		}
	}



