package com.niveus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddUserTest extends Base {

	public LoginPage log;
	public Doctor doc;
	WebDriverWait tt;
	Utility ut=new Utility();


	@Test
	public void addUserValidation() throws Exception {

		test = extent.createTest("12.Add USer", "This test case is to add the User");

		log = PageFactory.initElements(driver, LoginPage.class);

		doc = PageFactory.initElements(driver, Doctor.class);
		
		tt = new WebDriverWait(driver, 30);

		Reporter.log(" addUserValidation script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login script is  done#####", true);

		tt.until(ExpectedConditions.visibilityOf(doc.getUser()));

		doc.getUser().click();
		tt.until(ExpectedConditions.visibilityOf(doc.getAddUSerLink()));

		doc.getAddUSerLink().click();

		tt.until(ExpectedConditions.visibilityOf(doc.getNpi()));

		
		doc.getNpi().sendKeys("36728217"+ut.ranndomNumber());

		doc.getFirstname().sendKeys("all");
		doc.getLastName().sendKeys("dddd");
		doc.getDOB().sendKeys("11-11-1998");
		doc.getEmailId().sendKeys("add"+ut.generateRandomWord(2)+"@gmail.com");
		doc.getPassword().sendKeys("Aa123456@");
		doc.getMobileNO().sendKeys("9087654563");
		doc.getExperiance().sendKeys("3");
		doc.getHsptlname().sendKeys("KMC");
		doc.getSpecialty().sendKeys("Anesthesiology", Keys.ENTER);

		Thread.sleep(5000);

		doc.getAbout().sendKeys("good");
		doc.getOrganization().sendKeys("Testyantra", Keys.ENTER);
		
		Thread.sleep(5000);

		doc.getSelectRole().sendKeys("Submitter Provider", Keys.ENTER);
	

		tt.until(ExpectedConditions.elementToBeClickable(doc.getSaveBtn()));
		
		doc.getSaveBtn().click();
			
		
		boolean res= doc.getSaveBtn().isEnabled();
		
		Assert.assertTrue(res);
		
		/*
		 * Reporter.log(doc.getConfirmUsr().getText(),true);
		 */		
		Reporter.log("add UserValidation testCase is sucessfully pass##########################",true);
	}
}
