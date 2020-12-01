package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Configuration {
@FindBy(xpath = "//span[text()='Configuration']")
private WebElement config;

public WebElement getConfiguration()
{
	return config;
}
@FindBy(xpath = "//span[text()='Consultation Complete']/preceding-sibling::span//input")
private WebElement conscomplete;

public WebElement getConsultComplete()
{
	return conscomplete;
}

@FindBy(xpath = "//span[text()='In-Person Visit']/preceding-sibling::span//input")
private WebElement inperson;

public WebElement getInPersonVisit()
{
	return inperson;
}
@FindBy(xpath = "//span[text()='Video Visit']/preceding-sibling::span//input")
private WebElement videovisit;

public WebElement getVideoVisit()
{
	return videovisit;
}
@FindBy(xpath = "//span[text()='Return']/../following-sibling::button")

private WebElement sub;

public WebElement getSubmitBtn() 
{
   return sub;	
}
}
