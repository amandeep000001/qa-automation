package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class LeadCreation extends ObjectRepository {
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	String drop = null;

	public LeadCreation(SelfHealingDriver driver, Logger log) throws IOException {
		super("LeadCreation.properties");
		obj = new ObjectRepository("LeadCreation.properties");
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

	public void clickCRMIcon() {
		log.info("Clicking on CRM Button");
		element_Actions.waitAndFindElement(obj.getElement("CRMIcon"));
		element_Actions.findElement(obj.getElement("CRMIcon"));
		element_Actions.click();
		log.info("CRM Button clicked successfully");
	}

	public void clickLeadIcon() {
		log.info("Clicking on Lead Button");
		element_Actions.waitAndFindElement(obj.getElement("leadIcon"));
		element_Actions.findElement(obj.getElement("leadIcon"));
		element_Actions.click();
		log.info("Lead Button clicked successfully");
	}

	public String verifyLeadListingForm() {
		log.info("Check for Lead Title");
		element_Actions.waitAndFindElement(obj.getElement("leadListingFormTitle"));
		String message = element_Actions.findElement(obj.getElement("leadListingFormTitle")).getText();
		log.info("Lead Title displayed successfully");
		return message;
	}

	public void clickAddLeadButton() {
		log.info("Clicking on Lead Button");
		element_Actions.waitAndFindElement(obj.getElement("addLeadButton"));
		element_Actions.findElement(obj.getElement("addLeadButton"));
		element_Actions.click();
		log.info("Add Lead Button clicked successfully");
	}

	public void clickSaveButton() {
		log.info("Clicking on Save Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton")).click();
		log.info("Save Button clicked successfully");
	}

	public void clickSaveButtonInContract() {
		log.info("Clicking on Save Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButtonInContract")).click();
		log.info("Save Button clicked successfully");
	}

	public String verifyLeadForm() {
		log.info("Check for New Lead Form");
		element_Actions.waitAndFindElement(obj.getElement("newLeadForm"));
		String message = element_Actions.findElement(obj.getElement("newLeadForm")).getText();
		log.info("New Lead Form displayed successfully");
		return message;
	}

	public void enterFirstName(String firstName) {
		log.info("Entering First Name");
		element_Actions.waitAndFindElement(obj.getElement("firstNameInputField")).sendKeys(firstName);
		log.info("First Name Entered Successfully");
	}

	public void enterLastName(String lastName) {
		log.info("Entering Last Name");
		element_Actions.waitAndFindElement(obj.getElement("lastNameInputField")).sendKeys(lastName);
		log.info("Last Name Entered Successfully");
	}

	public void enterCompanyName(String companyName) {
		log.info("Entering Company Name");
		element_Actions.waitAndFindElement(obj.getElement("companyNameInputField")).sendKeys(companyName);
		log.info("Company Name Entered Successfully");
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

	public void clickLeadLinkforListingForm() {
		log.info("Click on Lead for Listing form");
		element_Actions.waitAndFindElement(obj.getElement("leadLink"));
		element_Actions.click();
		log.info("Lead for Listing form clicked Successfully");
	}

	public String verifyLeadStatus() {
		log.info("Check for Status as Lead");
		element_Actions.waitAndFindElement(obj.getElement("leadStatus"));
		String message = element_Actions.findElement(obj.getElement("leadStatus")).getText();
		log.info("Status verified as Lead successfully");
		return message;
	}

	public String verifyCreatedLead() {
		log.info("Check for Created Lead");
		String message = element_Actions.waitAndFindElement(obj.getElement("createdLead")).getText();
		log.info("Created Lead displayed successfully");
		return message;
	}
	
	public boolean verifyLeadCreatedOnListingPage(String newCompany)
	{
		log.info("Check for Created Contact");
		boolean result=  element_Actions
				.checkElementPresence(obj.getElement("findUserOnListingPage", newCompany));
		log.info("Created Contact displayed successfully");
		element_Actions.click();
		return result;
		
	}
	
	public String clickCreatedLead(String createdLead) {
		log.info("Clicking on Created Lead");
		element_Actions.waitAndFindElement(obj.getElement("createdLead"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		element_Actions.click();
		log.info("Created Lead clicked successfully");
		return createdLead;
	}

	public void clickLeadStatusOpen() {
		log.info("Clicking on Status dropdown");
		Select select = new Select(element_Actions.findElement(obj.getElement("leadStatus1")));
		select.selectByVisibleText("Open");
		log.info("Open Status entered successfully");

	}

	public void clickNotesTab() {
		log.info("Clicking on Notes Tab");
		element_Actions.waitAndFindElement(obj.getElement("notesTab"));
		element_Actions.click();
		log.info("Notes Tab clicked successfully");
	}

	public void enterNotes(String notes) {
		log.info("Entering Note");
		element_Actions.waitAndFindElement(obj.getElement("notesInputField"));
		element_Actions.scrollElementIntoView();
		element_Actions.sendKeys(notes);
		log.info("Note Entered Successfully");
	}
	
	public void clickOverviewTab() {
		log.info("Clicking on Notes Tab");
		element_Actions.waitAndFindElement(obj.getElement("overviewTab"));
		element_Actions.click();
		log.info("Notes Tab clicked successfully");
	}

	public void clickLeadStatusContractNegotiation() {
		log.info("Clicking on Status dropdown");
		Select select = new Select(element_Actions.findElement(obj.getElement("leadStatus1")));
		select.selectByVisibleText("Contract Negotiation");
		log.info("Contract Negotiation Status entered successfully");

	}

	public boolean verifyPrepareContractButton() {
		log.info("Verify Prepare Contract Button");
		Boolean display = element_Actions.findElement(obj.getElement("prepareContractButton")).isDisplayed();
		log.info("Prepare Contract Button displayed successfully");
		return display;
	}

	public void clickPrepareContractButton() {
		log.info("Clicking on Prepare Contract Button");
		element_Actions.waitAndFindElement(obj.getElement("prepareContractButton"));
		element_Actions.click();
		log.info("Prepare Contract Button clicked successfully");
	}

	public String verifyContractForm() {
		log.info("Check for New Contract Form");
		element_Actions.waitAndFindElement(obj.getElement("newContractForm"));
		String message = element_Actions.findElement(obj.getElement("newContractForm")).getText();
		log.info("New Contract Form displayed successfully");
		return message;
	}

	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("Entering the Start Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startDate);
		Thread.sleep(2000);
		log.info("Start Date Entered Successfully");
	}

	public void enterEndDate(String endDate) throws InterruptedException {
		log.info("Entering the End Date");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.findElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(endDate);
		Thread.sleep(2000);
		log.info("End Date Entered Successfully");
	}

	public void clickAddRowButton() {
		log.info("Clicking on Add Row Button");
		element_Actions.waitAndFindElement(obj.getElement("addRowButton"));
		element_Actions.click();
		log.info("Add Row Button clicked successfully");
	}

	public void clickAddRowButton1() {
		log.info("Clicking on Add Row Button");
		element_Actions.waitAndFindElement(obj.getElement("addRowButton1"));
		element_Actions.click();
		log.info("Add Row Button clicked successfully");
	}
	
	public void clickJobTitleInTable() {
		log.info("Entering Job Title List in the Table");
		element_Actions.waitAndFindElement(obj.getElement("jobTitleinTable"));
		element_Actions.click();
		log.info("Clicked Job Title in the Table successfully");
	}
	
	public void clickJobIndustryInTable() {
		log.info("Entering Job Industry List in the Table");
		element_Actions.waitAndFindElement(obj.getElement("jobIndustryinTable"));
		element_Actions.click();
		log.info("Clicked Job Industry in the Table successfully");
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
	
	public void enterIndustry(String industry) throws InterruptedException {
		log.info("Enter Title");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobIndustryInputField"));
		element_Actions.findElement(obj.getElement("jobIndustryInputField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(industry);
		log.info("Entered Job Title in the Table successfully");
	}

	public void enterSign(String sign) {
		log.info("Entering Sign");
		element_Actions.waitAndFindElement(obj.getElement("signInputField"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheBottom();
		element_Actions.sendKeys(sign);
		log.info("Sign Entered Successfully");
	}

	public boolean verifyFinalizeButton() {
		log.info("Verify Finalize Button");
		Boolean display = element_Actions.findElement(obj.getElement("finalizeButton")).isDisplayed();
		log.info("Finalize Button displayed successfully");
		return display;
	}

	public void clickFinalizeButton() {
		log.info("Clicking Finalize button");
		element_Actions.waitAndFindElement(obj.getElement("finalizeButton"));
		element_Actions.click();
		log.info("Finalize button clicked successfully");
	}

	public String verifyPopUpSuccessMsg() {
		log.info("Verifying pop up msg");
		element_Actions.waitAndFindElement(obj.getElement("popUpSuccessMsg"));
		String message = element_Actions.findElement(obj.getElement("popUpSuccessMsg")).getText();
		log.info("pop up msg displayed successfully");
		return message;
	}

	public void clickContractLinkforListingForm() {
		log.info("Click on Contract for Listing form");
		element_Actions.waitAndFindElement(obj.getElement("contractLink"));
		element_Actions.click();
		log.info("Contract for Listing form clicked Successfully");
	}

	public String verifyCreatedContract() {
		log.info("Check for Created Contract");
		String message = element_Actions.waitAndFindElement(obj.getElement("createdContract")).getText();
		log.info("Created Contract displayed successfully");
		return message;
	}
	
	public boolean verifyContractCreatedOnListingPage(String newContract)
	{
		log.info("Check for Created Contract");
		boolean result=  element_Actions
				.checkElementPresence(obj.getElement("createdContract", newContract));
		log.info("Created Contract displayed successfully");
		return result;
		
	}

	public void clickContactIcon() {
		log.info("Clicking on Contact Button");
		element_Actions.waitAndFindElement(obj.getElement("contactIcon"));
		element_Actions.findElement(obj.getElement("contactIcon"));
		element_Actions.click();
		log.info("Contact Button clicked successfully");
	}

	public String verifyCreatedContact() {
		log.info("Check for Created Contact");
		String message = element_Actions.waitAndFindElement(obj.getElement("createdContact")).getText();
		log.info("Created Contact displayed successfully");
		return message;
	}
}
