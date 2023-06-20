package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class ContactCreation extends ObjectRepository {
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public ContactCreation(SelfHealingDriver driver, Logger log) throws IOException {
		super("ContactCreation.properties");
		obj = new ObjectRepository("ContactCreation.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public String verifyCRMTextOnHomepage() {
		log.info("Check for CRM Icon on Homepage");
		element_Actions.waitAndFindElement(obj.getElement("CRMIcon"));
		String message = element_Actions.findElement(obj.getElement("CRMIcon")).getText();
		log.info("CRM Icon displayed successfully");
		return message;
	}
	
	public String verifyCRMTextOnStaffingHomepage() {
		log.info("Check for CRM Icon on Homepage");
		element_Actions.waitAndFindElement(obj.getElement("CRMIconHomepage"));
		String message = element_Actions.findElement(obj.getElement("CRMIconHomepage")).getText();
		log.info("CRM Icon displayed successfully");
		return message;
	}
	

	public void clickCRMIcon() {
		log.info("Clicking on CRM Button");
		element_Actions.waitAndFindElement(obj.getElement("CRMIcon"));
		element_Actions.findElement(obj.getElement("CRMIcon"));
		element_Actions.click();
		log.info("CRM Button clicked successfully");
	}

	public void clickCRMIcoOnHomepage() {
		log.info("Clicking on CRM Button");
		element_Actions.waitAndFindElement(obj.getElement("CRMIconHomepage"));
		element_Actions.findElement(obj.getElement("CRMIconHomepage"));
		element_Actions.click();
		log.info("CRM Button clicked successfully");
	}
	
	public void clickContactIcon() {
		log.info("Clicking on Contact Button");
		element_Actions.waitAndFindElement(obj.getElement("contactIcon"));
		element_Actions.findElement(obj.getElement("contactIcon"));
		element_Actions.click();
		log.info("Contact Button clicked successfully");
	}

	public String verifyContactListingForm() {
		log.info("Check for Contact Title");
		element_Actions.waitAndFindElement(obj.getElement("contactListingFormTitle"));
		String message = element_Actions.findElement(obj.getElement("contactListingFormTitle")).getText();
		log.info("Contact Title displayed successfully");
		return message;
	}

	public void clickAddContactButton() {
		log.info("Clicking on Contact Button");
		element_Actions.waitAndFindElement(obj.getElement("addContactButton"));
		element_Actions.findElement(obj.getElement("addContactButton"));
		element_Actions.click();
		log.info("Add Contact Button clicked successfully");
	}

	public void clickSaveButton() {
		log.info("Clicking on Contact Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton")).click();
		log.info("Add Contact Button clicked successfully");
	}

	public String verifyContactForm() {
		log.info("Check for New Contact Form");
		element_Actions.waitAndFindElement(obj.getElement("newContactForm"));
		String message = element_Actions.findElement(obj.getElement("newContactForm")).getText();
		log.info("New Contact Form displayed successfully");
		return message;
	}

	public boolean verifyMandatoryFieldIsBlank() {
		log.info("Verifying the Mandatory Field Pop-Up Title");
		boolean value = false;
		String messageHeading = element_Actions
				.waitAndFindElement(obj.getElement("emptyMandatoryFieldDialogBoxHeading")).getText();
		if (messageHeading.equalsIgnoreCase("Missing Fields")) {
			value = true;
		}
		log.info("Mandatory Field Pop-Up Title displayed Successfully");
		return value;
		
		
	}

	public void closeBlankMandatoryFieldDialogBox() {
		log.info("Clicking on Close Pop-Up Icon");
		element_Actions.waitAndFindElement(obj.getElement("closeEmptyMandatoryFieldDialogBox"));
		element_Actions.click();
		log.info("Close Pop-Up Icon Clicked Successfully");
	}

	public void enterContactName(String contactName) {
		log.info("Entering Contact Name");
		element_Actions.waitAndFindElement(obj.getElement("contactInputField")).sendKeys(contactName);
		log.info("Contact Name Entered Successfully");
	}

	public void enterEmail(String email) {
		log.info("Entering Email");
		element_Actions.waitAndFindElement(obj.getElement("emailInputField")).sendKeys(email);
		log.info("Email Entered Successfully");
	}

	public void enterPhoneNumber(String phoneNumber) {
		log.info("Entering Phone Number");
		element_Actions.waitAndFindElement(obj.getElement("phInputField")).sendKeys(phoneNumber);
		log.info("Phone Number Entered Successfully");
	}

	public void enterLead(String lead) {
		log.info("Entering Lead");
		element_Actions.waitAndFindElement(obj.getElement("leadInputField")).sendKeys(lead);
		log.info("Lead Entered Successfully");
	}

	public void clickContactLinkforListingForm() {
		log.info("Click on Contact for Listing form");
		element_Actions.waitAndFindElement(obj.getElement("contactLink"));
		element_Actions.click();
		log.info("Contact for Listing form clicked Successfully");
	}
	
	public boolean verifyContactCreatedOnListingPage(String newContact)
	{
		log.info("Check for Created Contact");
		boolean result=  element_Actions
				.checkElementPresence(obj.getElement("findUserOnListingPage", newContact));
		log.info("Created Contact displayed successfully");
		return result;
	}
	
	public void enterCompanyType(String companyType) {
		log.info("Entering Lead");
		element_Actions.waitAndFindElement(obj.getElement("companyType")).sendKeys(companyType);
		log.info("Lead Entered Successfully");
	}
	
}
