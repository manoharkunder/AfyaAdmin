package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchAdminTest extends Base
{

	public LoginPage log;
	public AdminPage adpage;
	
	@Test
	public void adminSearchValidation() throws Exception
	{
		test=extent.createTest("8.Search Admin","This test case is to Search the admin");

		log=PageFactory.initElements(driver, LoginPage.class);

		adpage=PageFactory.initElements(driver, AdminPage.class);
		
		Reporter.log("Search admin  script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("superadmin@afya.net");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		
		
		Reporter.log("Admin login script is sucessfully done###",true);
		
		
		  WebDriverWait jj=new WebDriverWait(driver, 10);
		  jj.until(ExpectedConditions.elementToBeClickable(adpage.getadminLink()));
		 
		
		
	    adpage.getadminLink().click();
	    
		
		/*
		 * WebDriverWait wait2=new WebDriverWait(driver, 10);
		 * wait2.until(ExpectedConditions.visibilityOf(adpage.getadminResult()));
		 * 
		 */
	    
	    Thread.sleep(3000);
	    adpage.getadminSearch().sendKeys("sathish");
	    

           Thread.sleep(6000);	
           
	    WebDriverWait wait1=new  WebDriverWait(driver, 10);
	    
	    wait1.until(ExpectedConditions.visibilityOf(adpage.getadminResult()));
	    
		   System.out.println(adpage.getadminResult().getText());

	   boolean res=adpage.getadminResult().getText().contains("Sathish");
	   
	   
	   Assert.assertTrue(res);
	   
	   Reporter.log("Admin Search Testcase  is sucessfully done .........######################",true);
	   
	    
	}
}
