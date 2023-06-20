package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class JobTitlePage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public JobTitlePage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobTitlePage.properties");
		obj = new ObjectRepository("JobTitlePage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void enterJobTitleInSearchBar(String jobTitleList) {
		log.info("Entering Job Title List in the search box");
		element_Actions.waitAndFindElement(obj.getElement("seachBoxFeild"));
		element_Actions.sendKeys(jobTitleList);
		log.info("Entered Job Title List in the search box successfully");
	}

	public void clickSearchBox() {
		log.info("Searching Job Title Listing for should open");
		element_Actions.waitAndFindElement(obj.getElement("seachBoxFeild2"));
		element_Actions.click();
		log.info("Job Title Listing opened successfully");
	}

	public boolean verifyJobTitleListingPage() {
		log.info("Verify Job Title Listing Page is displayed");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("listingPageTitle"));
		Boolean display = element_Actions.findElement(obj.getElement("listingPageTitle")).isDisplayed();
		log.info("Job Title Listing Page displayed successfully");
		return display;
	}

	public void clickAddJobTitleButton() {
		log.info("Clicking Add Job Title Button");
		element_Actions.waitAndFindElement(obj.getElement("addJobTitleButton"));
		element_Actions.click();
		log.info("Add Job Title Button clicked successfully");
	}

	public void clickSaveButton() {
		log.info("Clicking on Save Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.click();
		element_Actions.click();
		log.info("Save button clicked successfully");
	}
	public void clickSaveButton1() {
		log.info("Clicking on Save Button");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save button clicked successfully");
	}

	public void clickCloseButtonMissingFieldPopUp() throws InterruptedException {
		log.info("Clicking close button on Job Title Form");
		element_Actions.waitAndFindElement(obj.getElement("closeButtonMissingFieldPopUp"));
		Thread.sleep(3000);
		element_Actions.click();
		log.info("Close button clicked successfully");
	}

	public String verifyMissingFieldPopUp() {
		log.info("Verify Missing field dialog while clicking save Button");
		element_Actions.waitAndFindElement(obj.getElement("mandatoryFieldsPopUp"));
		String message = element_Actions.findElement(obj.getElement("mandatoryFieldsPopUp")).getText();
		log.info("Missing field dialog displayed while clicking save Button successfully.");
		return message;
	}

	public void enterIndustry(String industry) {
		log.info("Entering Job Industry");
		element_Actions.waitAndFindElement(obj.getElement("industryInputField"));
		element_Actions.sendKeys(industry);
		log.info("Job Industry entered successfully");
	}

	public void enterRate(String rate) {
		log.info("Entering rate");
		element_Actions.waitAndFindElement(obj.getElement("rateInputField"));
		element_Actions.sendKeys(rate);
		log.info("Rate entered successfully");
	}

	public void enterJobTitle(String title) {
		log.info("Entering Job Title");
		element_Actions.waitAndFindElement(obj.getElement("titleInputField"));
		element_Actions.sendKeys(title);
		log.info("Job Title entered successfully");
	}

	public void enterDescription(String description) {
		log.info("Entering Description");
		element_Actions.waitAndFindElement(obj.getElement("descriptionInputField"));
		element_Actions.sendKeys(description);
		log.info("Description entered successfully");
	}

	public String verifyEnabledTitle() {
		log.info("Verify Job Title created Successfully");
		element_Actions.waitAndFindElement(obj.getElement("enabledTitle"));
		String message = element_Actions.findElement(obj.getElement("enabledTitle")).getText();
		log.info("Job Title Created successfully.");
		return message;
	}

}
