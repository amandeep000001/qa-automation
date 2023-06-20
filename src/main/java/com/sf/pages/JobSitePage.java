package com.sf.pages;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class JobSitePage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public JobSitePage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobSitePage.properties");
		obj = new ObjectRepository("JobSitePage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	
	public void clickJobSiteOnHomepage() {
		log.info("Clicking on Job Site on Homepage");
		element_Actions.waitAndFindElement(obj.getElement("jobSiteHomepage"));
		element_Actions.click();
		log.info("Job Site Listing opened successfully");
	}
	
	public void clickAddJobSiteButton() {
		log.info("Clicking Add Job Site Button");
		element_Actions.waitAndFindElement(obj.getElement("addJobSiteButton"));
		element_Actions.click();
		log.info("Add Job Site clicked successfully");
	}
	
	public void clickCreateNewUserOption() {
		log.info("Clicking New User Option in Job site Contact");
		element_Actions.waitAndFindElement(obj.getElement("createNewUser"));
		element_Actions.click();
		log.info("New User Option in Job site Contactclicked successfully");
	}
	
	public void clickClosePopUp() {
		log.info("Clicking on close icon in pop up");
		element_Actions.waitAndFindElement(obj.getElement("closeEmailSentDialogBox"));
		element_Actions.click();
		log.info("pop up closed successfully");
	}
	
	public void enterJobTitleInTable() {
		log.info("Entering Job Title List in the Table");
		
		element_Actions.waitAndFindElement(obj.getElement("jobTitleinTable"));
		element_Actions.scrollElementIntoView();
		element_Actions.click();
		log.info("Clicked Job Title in the Table successfully");
		
		
	}
	
	public void enterTitle(String title) throws InterruptedException {
		log.info("Enter Title");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleInputField"));
		element_Actions.findElement(obj.getElement("jobTitleInputField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(title);
		log.info("Entered Job Title in the Table successfully");
	}
	
	public void clickSaveButton() {
		log.info("Clicking Save Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save Button clicked successfully");
	}
	public String verifyCreatedSite() {
		log.info("Verify Job Site created Successfully");
		element_Actions.waitAndFindElement(obj.getElement("createConfirmation"));
		String message = element_Actions.findElement(obj.getElement("createConfirmation")).getText();
		log.info("Job Site Created successfully.");
		return message;
	}
		
		public void enterMobile(String contactName) {
			log.info("Entering Mobile Number");
			element_Actions.waitAndFindElement(obj.getElement("mobileNo")).sendKeys(contactName);
			log.info("Mobile Number Entered Successfully");
		}
		public void clickSavebuttonInAddUser() {
			log.info("Clicking Save Button");
			element_Actions.waitAndFindElement(obj.getElement("saveButtoninAddUser"));
			element_Actions.click();
			log.info("Save Button clicked successfully");
		
	}
}