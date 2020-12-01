package com.niveus;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	/**
	 * This method is used to select the Option by Value from Select Dropdown
	 * 
	 * @param webElement
	 * @param value
	 */
	public void selectByValue(WebElement webElement, String value) {
		Select sel = new Select(webElement);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to switch the driver control to new window
	 * 
	 * @param driver
	 * @return String
	 */
	public String switchToNewWindow(WebDriver driver) {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		String pid = it.next();
		String cid = it.next();

		driver.switchTo().window(cid);
		return pid;
	}

	public void moveToElement(WebDriver driver, WebElement webelement) {
		Actions act = new Actions(driver);
		act.moveToElement(webelement).click().perform();
		;
	}

	public void hoverMouse(WebDriver driver, WebElement webelement) {
		Actions act = new Actions(driver);
		act.moveToElement(webelement).perform();
	}
	/*
	 * This method is used to generate random word
	 * 
	 */

	public String generateRandomWord(int wordLength) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder(wordLength);
		for (int i = 0; i < wordLength; i++) {
			char tmp = (char) ('a' + r.nextInt('z' - 'a'));
			sb.append(tmp);
		}
		return sb.toString();
	}
	public  Integer ranndomNumber()
	{
		Random rand=new Random();
		return rand.nextInt(100);
	}
}
