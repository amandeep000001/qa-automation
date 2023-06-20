package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class CompanyListingPage extends ObjectRepository{
	
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public CompanyListingPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("CompanyListingPage.properties");
		obj = new ObjectRepository("CompanyListingPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	
	public void clickAddNewCompanyButton() throws InterruptedException
	{
		log.info("Clicking Add New Company button");
		try
		{	Thread.sleep(3000);
			element_Actions.waitUntilVisibilityLocated(obj.getElement("addCompanyButton"));
			element_Actions.waitAndFindElement(obj.getElement("addCompanyButton"), 7000);
			element_Actions.click();
			log.info("Add New Company button clicked successfully");
		}
		catch (Exception e)
		{
			log.info("Exception encountered");
			element_Actions.refreshWebpage();
			Thread.sleep(3000);
			element_Actions.waitAndFindElement(obj.getElement("addCompanyButton"));
			element_Actions.click();
			log.info("Exception handled successfully");
		}
		log.info("Add New Company button clicked successfully");
	}
	
	public boolean findCompanyNameOnListingPage(String companyName)
	{
		
		boolean result=  element_Actions
				.checkElementPresence(obj.getElement("companyListedOnListingpage", companyName));
		return result;
	}
	
	public void clearField() throws InterruptedException
	{
		element_Actions.waitAndFindElement(obj.getElement("companyNameOnListingForm"));
		element_Actions.click();
		element_Actions.clearField();
	}
	public void clickFiveHundredFilter() {
		log.info("Clicking on 500 filter");
		element_Actions.waitAndFindElement(obj.getElement("fiveHundredFilter"));
		element_Actions.findElement(obj.getElement("fiveHundredFilter"));
		element_Actions.click();
		log.info("500 filter clicked successfully");
	}

}
