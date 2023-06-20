package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class AddNewUserPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public AddNewUserPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("AddNewUserPage.properties");
		obj = new ObjectRepository("AddNewUserPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	
	
	public void waitAfterClickingSaveNewUserForm()
	{
		element_Actions.waitAndFindElement(obj.getElement(Admin), 20000);
	}

	public void enterCompanyType(String companyType) {
		log.info("Entering Company Type");
		element_Actions.waitAndFindElement(obj.getElement("companyTypeField"));
		element_Actions.clearField();
		element_Actions.sendKeys(companyType);
		log.info("Company Type Entered Successfully");
	}

	public void clearCompanyTypeField() {
		log.info("Clearing company type field");
		element_Actions.waitAndFindElement(obj.getElement("companyTypeField"));
		element_Actions.clearField();
		log.info("Company Type field cleared Successfully");
	}

	public void enterFirstNameField(String userFirstName) {
		log.info("Entering First Name field");
		element_Actions.waitAndFindElement(obj.getElement("userFirstName"));
		element_Actions.clearField();
		element_Actions.sendKeys(userFirstName);
		log.info("First Name  entered successfully");

	}

	public void clickLastNameField() {
		log.info("Clicking Last Name field");
		element_Actions.waitAndFindElement(obj.getElement("userLastName"));
		element_Actions.click();
		log.info("Last Name  field clicked successfully");
	}

	public void enterLastNameField(String userLastName) throws InterruptedException {
		log.info("Entering Last Name field");
		element_Actions.waitAndFindElement(obj.getElement("userLastName"));
		element_Actions.click();
		element_Actions.clearField();
		element_Actions.sendKeys(userLastName);
		log.info("Last Name entered successfully");
	}

	public void clickSavebutton() {
		log.info("Clicking save button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save button clicked successfully");
		element_Actions.waitAndFindElement(obj.getElement("closeEmailSentDialogBox"));
	}

	public void clickLocation() {
		log.info("Clicking Location Field");
		element_Actions.waitAndFindElement(obj.getElement("location"));
		element_Actions.click();
		log.info("Location Field clicked successfully");
	}
	public void selectCompanyRole(String companyRole) {
		element_Actions.waitAndFindElement(obj.getElement("selectCompanyRole", companyRole));
		element_Actions.selectValueFromDropdown(companyRole);

	}

	public void enterUserEmail(String email) throws InterruptedException {
		log.info("Entering user email address");
		element_Actions.waitAndFindElement(obj.getElement("userEmail"));
		element_Actions.click();
		element_Actions.clearField();
		element_Actions.sendKeys(email);
		log.info("Email entered successfully");
	}

	public void selectUserRoleType(String userRole) {
		element_Actions.waitAndFindElement(obj.getElement("userRole"));
		element_Actions.selectValueFromDropdown(userRole);

	}

	public void cickOnMoreInformationheader() {
		element_Actions.waitAndFindElement(obj.getElement("companyInfoTab"));
		element_Actions.click();
	}

	public void enterCompanyName(String companyName) throws InterruptedException {
		element_Actions.waitAndFindElement(obj.getElement("userCompanyName"));
		Thread.sleep(3000);
		element_Actions.click();
		element_Actions.clearField();
		element_Actions.sendKeys(companyName);
	}

	public void navigateToUserlisting() {
		element_Actions.waitAndFindElement(obj.getElement("userListingPageLink"));
		element_Actions.click();
	}

	public void closeMandatoryFieldsDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeMessageDialogBox"));
		element_Actions.click();
	}

	public boolean verifyMessageBoxContent() {
		boolean result = false;
		element_Actions.waitAndFindElement(obj.getElement("messageBox"));
		String messageReceived = element_Actions.getElementText();
		if (messageReceived.contains("Company Type") && messageReceived.contains("First Name")
				&& messageReceived.contains("Email") && messageReceived.contains("Last Name")
				&& messageReceived.contains("Company")) {
			result = true;
		}
		return result;
	}

	public boolean verifyUserCreatedOrNot() {
		boolean result = false;
		log.info("Verifying Pop Up Text");
		element_Actions.waitAndFindElement(obj.getElement("emailSentDialogBox"));
		String text = element_Actions.getElementText();
		if (text.contains("Welcome email sent")) {
			result = true;
		}
		log.info("Getting the Pop Up text");
		return result;
	}

	public void clickCloseEmailSentDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeEmailSentDialogBox"));
		element_Actions.click();
	}

	public void waitForAddNewUserPageToLoad() throws InterruptedException {

		element_Actions.waitAndFindElement(obj.getElement("companyTypeField"));
	}
	
	public void clearField() throws InterruptedException
	{
		element_Actions.waitAndFindElement(obj.getElement("userNameOnListingForm"));
		element_Actions.click();
		element_Actions.clearField();
	}
}
