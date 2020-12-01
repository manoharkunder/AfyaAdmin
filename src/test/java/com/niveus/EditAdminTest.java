package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EditAdminTest extends Base {

	public LoginPage log;
	public AdminPage adpage;
	Utility ut=new Utility();

	WebDriverWait wait;
	@Test
	public  void editAdminValidation()
	{
		test=extent.createTest("13.Edit Admin","This test case is to edit the admin");

		log=PageFactory.initElements(driver, LoginPage.class);

		adpage=PageFactory.initElements(driver, AdminPage.class);
		
		wait=new WebDriverWait(driver, 20);
		Reporter.log("Edit  admin  script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

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
		
       
       wait.until(ExpectedConditions.elementToBeClickable(adpage.getadminLink()));
		
       
	    adpage.getadminLink().click();
	    
	    wait.until(ExpectedConditions.visibilityOf(adpage.getEditAdmin()));
	    
	    adpage.getEditAdmin().click();
	    
	    wait.until(ExpectedConditions.visibilityOf(adpage.getaFname()));

	    
	    adpage.getaFname().sendKeys("aa");
	    adpage.getaLastName().sendKeys("v");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(adpage.getUpdateBtn()));
	    
	    adpage.getUpdateBtn().click();
	    
	   wait.until(ExpectedConditions.visibilityOf(adpage.getConfirmUpdate()));
	   
	   boolean result=adpage.getConfirmUpdate().getText().contains("updated");
	   
	   Assert.assertTrue(result);
	   
	   Reporter.log(adpage.getConfirmUpdate().getText(),true);
	   
	  Reporter.log("editAdminValidation is sucessfully  done##########################",true);
	    
	    
	    
	}
}
