package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrgSpecialtySearchTest extends Base
{
	WebDriverWait tt;
	Organization org;
	public LoginPage log;
	public Doctor doc;


	@Test
public void OrgSpecSearchValidation() throws Exception
{
		test = extent.createTest("15.SpecOrgSearch", "This test case is used to search the specialty based on Org");

		log = PageFactory.initElements(driver, LoginPage.class);
	
		doc = PageFactory.initElements(driver, Doctor.class);


		Reporter.log(" OrgSpecSearchValidation is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login script is sucessfully done#####", true);		

		tt = new WebDriverWait(driver, 30);

		tt.until(ExpectedConditions.elementToBeClickable(doc.getUser()));
  
		doc.getUser().click();

		
		Thread.sleep(4000);
		
		tt.until(ExpectedConditions.visibilityOf(doc.getOrgSearchSpec()));
		
		doc.getOrgSearchSpec().sendKeys("Obstetrics");
		
		Thread.sleep(8000);
		
		boolean res=doc.getSpecialtySearch().getText().contains("Obstetrics");
		
		Assert.assertTrue(res);
		
		Reporter.log("OrgSpecSearchValidation is sucessfully done####################",true);
		
		
}
}
