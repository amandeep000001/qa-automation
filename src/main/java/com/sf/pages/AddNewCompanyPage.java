package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class AddNewCompanyPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	Functions fun ;

	public AddNewCompanyPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("AddNewCompanyPage.properties");
		obj = new ObjectRepository("AddNewCompanyPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
		fun = new Functions();
	}


	public void enterCompanytype(String companyType) {
		log.info("Entering Company Type");
		
		element_Actions.findElement(obj.getElement("companyTypeField"));
		element_Actions.clearField();
		element_Actions.sendKeys(companyType);
		log.info("Company type entered successfully");

	}

	public void enterTagCharges(String tagCharges) throws InterruptedException {
		log.info("Entering Tag Charges");
		element_Actions.findElement(obj.getElement("tagChargesField"));
		element_Actions.clearField();
		Thread.sleep(1000);
		element_Actions.sendKeys(tagCharges);
		log.info("Tag charges entered successfully");

	}

	public  void enterCompanyName(String companyName) throws InterruptedException {
		log.info("Entering Comapany Name");
		element_Actions.findElement(obj.getElement("companyNameField"));
		element_Actions.click();
		element_Actions.clearField();
		element_Actions.sendKeys(companyName);
		log.info("Company Name entered successfully");

	}

	public void enterContactName(String contactName) {
		log.info("Entering Contact Name");
		element_Actions.findElement(obj.getElement("contactNameField"));
		element_Actions.clearField();
		element_Actions.sendKeys(contactName);
		log.info("Contact Name entered successfully");

	}

	public void enterContactPhone(String phone) {
		log.info("Entering Contact Phone Number");
		element_Actions.findElement(obj.getElement("contactPhoneNumberField"));
		element_Actions.clearField();
		element_Actions.sendKeys(phone);
		log.info("Contact Phone Number entered successfully");

	}

	public void enterContactEmail(String contactEmail) {
		log.info("Entering Contact Email");
		element_Actions.findElement(obj.getElement("contactEmailField"));
		element_Actions.clearField();
		element_Actions.sendKeys(contactEmail);
		log.info("Contact Email entered successfully");

	}

	public void selectSerchOnMapsRadioButton() {
		log.info("Slecting Search On Maps radio button");
		element_Actions.findElement(obj.getElement("addressSearchOnMapsRadioButton"));
		element_Actions.click();
		log.info("Search On Maps radio button selected successfully");
	}

	public void selectEnterManuallyRadioButton() {
		log.info("Selecting radio button");
		element_Actions.findElement(obj.getElement("addressEnterManuallyRadioButton"));
		element_Actions.click();
		log.info("Enter Manually radio button selected successfully");
	}

	public void enterCompleteAddres(String completeAddress) {
		log.info("Entering Complete Address");
		element_Actions.findElement(obj.getElement("addressField"));
		element_Actions.clearField();
		element_Actions.sendKeys(completeAddress);
		log.info("Complete Address entered successfully");

	}

	public void enterSuiteORApartmentNumber(String suiteOrApartmentNumber) {
		log.info("Entering Suite or Apartment Number");
		element_Actions.findElement(obj.getElement("addressApartmentNoField"));
		element_Actions.clearField();
		element_Actions.sendKeys(suiteOrApartmentNumber);
		log.info("Suite or Apartment Number entered successfully");
	}

	public void clickSaveButton() throws InterruptedException {
		log.info("Clicking Save new company button");
		try {
			Thread.sleep(5000);
			element_Actions.waitAndFindElement(obj.getElement("savebutton"));
			element_Actions.click();
		} 
		catch (Exception e) {
			log.info("Exception encountered");
			Thread.sleep(5000);
			element_Actions.waitAndFindElement(obj.getElement("savebutton"));
			element_Actions.click();
			log.info("Exception handled successfully");
		}
		log.info("Save buttton clicked successfully");

	}
	
	public void waitAfterSaveButtonIsClicked(String companyName)
	{
		element_Actions.waitUntilVisibilityLocated(obj.getElement("verifyNewCompanyCreated",companyName));
	}
	
	public void clickCancelButton() {
		log.info("Clicking Cancel new company button");
		element_Actions.findElement(obj.getElement("cancelButton"));
		element_Actions.click();
		log.info("Cancel buttton clicked successfully");
	}

	public boolean verifyNewCompanyCreatedSuccessfully(String companyName) throws InterruptedException {

		log.info("Checking new company was created successfully or not");
		Thread.sleep(2000);
		boolean result = element_Actions
				.checkElementPresence(obj.getElement("verifyNewCompanyCreated", companyName));
		return result;	
	}
	
	public boolean verifyMandatoryFieldIsBlank()
	{
		boolean value=false;
		String messageHeading = element_Actions.waitAndFindElement(obj.getElement("emptyMandatoryFieldDialogBoxHeading")).getText();
		if(messageHeading.equalsIgnoreCase("Missing Fields"))
		{
			value= true;
		}
		return value;
	}
	
	public void closeBlankMandatoryFieldDialogBox()
	{
		element_Actions.waitAndFindElement(obj.getElement("closeEmptyMandatoryFieldDialogBox"));
		element_Actions.click();
	}
	
	public void clickonSearchField()
	{
		element_Actions.waitAndFindElement(obj.getElement("searchBox"));
		element_Actions.click();
	}
	
	public  void goTOCompanyListingPage()
	{
		element_Actions.waitAndFindElement(obj.getElement("companyListingLinkOnDetialspage"));
		element_Actions.click();
	}
	
	
		
	
	

}