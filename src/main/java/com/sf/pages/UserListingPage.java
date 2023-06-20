package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class UserListingPage extends ObjectRepository{

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public UserListingPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("UserListingPage.properties");
		obj = new ObjectRepository("UserListingPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	
	
	public void clickAddNewUserButton() throws InterruptedException
	{
		try
		{
		
		element_Actions.waitAndFindElement(obj.getElement("addNewUserButton"));
		element_Actions.click();
		}
		catch(Exception e)
		{
			element_Actions.refreshWebpage();
			Thread.sleep(20000);
			element_Actions.waitAndFindElement(obj.getElement("addNewUserButton"));
			element_Actions.click();
	
		}
	
	}
	
	public boolean verifyUserCreatedOnListingPage(String userEmail)
	{
		boolean result=  element_Actions
				.checkElementPresence(obj.getElement("findUserOnListingPage", userEmail));
		return result;
	}
	
	public void clickFilterIcon() {
		log.info("clicking filter icon present on the listing page");
		element_Actions.waitAndFindElement(obj.getElement("filterIcon"));
		element_Actions.click();
		log.info("Filter icon clicked successfully");
	}
	
	public void clickClearFilterIcon() {
		log.info("clicking Clear Filter icon present on the listing page");
		element_Actions.waitAndFindElement(obj.getElement("clearFilterIcon"));
		element_Actions.click();
		log.info("Clear Filter icon clicked successfully");
	}
	
	
	
	
		
}
