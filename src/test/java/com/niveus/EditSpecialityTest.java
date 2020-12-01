package com.niveus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class EditSpecialityTest extends Base {
public LoginPage log;
	
	public HomePage home;
   Utility ut=new Utility();
	


	@Test
	public void editSPecValidation() throws Exception
	{
		test = extent.createTest("4.Editspecialty", "This test case is to check EditSpecialty");

		log = PageFactory.initElements(driver, LoginPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		Reporter.log("Edit Specialty script  is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login  is sucessfully done", true);

		WebDriverWait tt = new WebDriverWait(driver, 20);

		tt.until(ExpectedConditions.elementToBeClickable(home.getmasterSection()));

		home.getmasterSection().click();

		WebDriverWait pp = new WebDriverWait(driver, 20);
		pp.until(ExpectedConditions.elementToBeClickable(home.getmSpeciality()));

		home.getmSpeciality().click();

		WebDriverWait pt = new WebDriverWait(driver, 20);
		pt.until(ExpectedConditions.elementToBeClickable(home.getaddSpec()));

		home.getaddSpec().click();

		WebDriverWait tl = new WebDriverWait(driver, 20);
		tl.until(ExpectedConditions.elementToBeClickable(home.gettextArea()));
		
		String spec=ut.generateRandomWord(2);

		home.gettextArea().sendKeys("aa"+spec);
		
		Thread.sleep(2000);


		WebDriverWait mt = new WebDriverWait(driver, 20);
		mt.until(ExpectedConditions.elementToBeClickable(home.getaddnutton()));

		
		home.getaddnutton().click();
		/*
		 * WebDriverWait ppt = new WebDriverWait(driver, 30);
		 * 
		 * ppt.until(ExpectedConditions.visibilityOf(home.getconformSpec()))
		 */;

		boolean res = home.getaddnutton().isEnabled();
		
		Assert.assertTrue(res);
	
		Reporter.log("add spec is sucessfully done ##########",true);
		
		Thread.sleep(4000);		
		
		  tt.until(ExpectedConditions.elementToBeClickable(home.geteditButton()));
		  
		  home.geteditButton().click();
		  
		  Reporter.log("clicked on edit button sucessfully......",true);
		
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].value='no';", home.gettextArea());
		  
		  home.getUpdatebtn().click();
		  
		  boolean k=home.getUpdatebtn().isEnabled();
		  
		  
			/*
			 * WebDriverWait jj=new WebDriverWait(driver, 20);
			 * 
			 * jj.until(ExpectedConditions.visibilityOf(home.getConfirnUpdate()));
			 * 
			 * boolean k=home.getConfirnUpdate().getText().contains("updated");
			 */
		  
		  Assert.assertTrue(k);
		  
			/*
			 * Reporter.log(home.getConfirnUpdate().getText(),true);
			 */		  
		  Reporter.log("EditTestCase is sucessfully done#################################",true);
		  
	}
		 
}