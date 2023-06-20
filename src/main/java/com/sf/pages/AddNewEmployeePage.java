package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class AddNewEmployeePage extends ObjectRepository {

	private static final String Admin = null;

	Logger log;

	SelfHealingDriver driver;

	ElementActions element_Actions;

	Functions functions;

	ObjectRepository obj;

	HomePage homePage;

	EmployeeListingPage empList;

	public AddNewEmployeePage(SelfHealingDriver driver, Logger log) throws IOException {

		super("AddNewEmployee.properties");

		obj = new ObjectRepository("AddNewEmployee.properties");

		this.log = log;

		this.driver = driver;

		functions = new Functions();

		homePage = new HomePage(driver, log);

		element_Actions = new ElementActions(driver);

		empList = new EmployeeListingPage(driver, log);

	}

	public void waitForAddNewEmployeePageToLoad() {

		element_Actions.waitAndFindElement(obj.getElement("saveButton"), 20000);

		element_Actions.waitAndFindElement(obj.getElement("companyField"), 20000);

	}

	public void enterCompanyName(String companyName) {

		log.info("Entering Company Name");

		element_Actions.waitAndFindElement(obj.getElement("companyField"));

		element_Actions.clearField();

		element_Actions.sendKeys(companyName);

		log.info("Company Name entered successfully");

	}
	public void clearCompanyFeild() {
		element_Actions.waitAndFindElement(obj.getElement("companyField"));
		element_Actions.clearField();
	}
	
	

	public void enterFirstName(String firstName) {

		log.info("Entering First Name");

		element_Actions.waitAndFindElement(obj.getElement("firstNameField"));

		element_Actions.sendKeys(firstName);

		log.info("First Name entered successfully");

	}

	public void enterLastName(String lastName) {

		log.info("Entering Last Name");

		element_Actions.waitAndFindElement(obj.getElement("lastNameField"));

		element_Actions.sendKeys(lastName);

		log.info("Last Name entered successfully");

	}

	public void enterEmail(String email) {

		log.info("Entering email");

		element_Actions.waitAndFindElement(obj.getElement("emailField"));

		element_Actions.sendKeys(email);

		log.info("Email entered successfully");

	}

	public void enterDateOfBirthField(String dateOfBirth) throws InterruptedException {

		log.info("Entering date of birth");

		element_Actions.waitAndFindElement(obj.getElement("dateOfBirthField"));
		element_Actions.click();
		Thread.sleep(1000);

		element_Actions.sendKeys(dateOfBirth);

		log.info("Date of birth entered successfully");

	}

	public void clickSaveButton() {

		log.info("Clicking Save button");

		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));

		element_Actions.waitAndFindElement(obj.getElement("saveButton"));

		element_Actions.click();

		log.info("Save button clicked successfully");

	}

	public void clickCancelbutton() {

		log.info("Clicking Cancel button");

		element_Actions.waitAndFindElement(obj.getElement("cancelButton"));

		element_Actions.click();

		log.info("Cancel button clicked successfully");

	}
	
	public String verifyListingPage() {

		element_Actions.waitAndFindElement(obj.getElement("listingPageTitleEmployee", 2000));

		String employeeFormTitle = element_Actions.getElementText();

		return employeeFormTitle;

	}
	
	

	public boolean verifyNewEmployeeCreation(String empName) {

		boolean result = false;

		element_Actions

				.waitUntilVisibilityLocated(obj.getElement("verifyEmployeeCreation", empName));

		result = element_Actions

				.checkElementPresence(obj.getElement("verifyEmployeeCreation", empName));

		return result;

	}

	public void selectMilitaryVetranCheckbox() {

		log.info("Selecting millitary checkbox");

		WebElement checkbox = element_Actions.findElement(obj.getElement("millitaryVetranCheckbox"));

		if (checkbox.isSelected() == false)

			checkbox.click();

		log.info("Millitary checkbox selected");

	}

	public boolean verifyDiscardAddNewEmployee() {

		boolean result = false;

		String currentURL = driver.getCurrentUrl();

		if (currentURL.equalsIgnoreCase("https://qa-new.tempguru.co/app/employee"))

			result = true;

		return result;

	}

	public String verifyMandatoryFields() {

		element_Actions.waitAndFindElement(obj.getElement("mandatoryFieldDialogBox", 2000));

		String mandatoryFields = element_Actions.getElementText();

		return mandatoryFields;

	}

	public void selectSearchOnMapsCheckbox() throws InterruptedException {

		log.info("Selecting search on Maps checkbox");

		WebElement checkbox = element_Actions.findElement(obj.getElement("searchOnMapsCheckBox"));

		// element_Actions.scrollElementIntoView();

		Thread.sleep(2000);

		checkbox.click();

		log.info("Search on maps checkbox selected");

	}
	
	public void selectAddressTab() throws InterruptedException {

		log.info("Clicking Address Tab");

		WebElement checkbox = element_Actions.findElement(obj.getElement("addressTab"));

		// element_Actions.scrollElementIntoView();

		Thread.sleep(2000);

		checkbox.click();

		log.info("Address Tab clicked successfully");

	}

	public void enterEmployeeAddressOnMaps(String address) {

		log.info("Etering employee address on maps");

		try {

			element_Actions.waitAndFindElement(obj.getElement("serachAddressFieldOnMaps"));

			element_Actions.sendKeys(address);

			Thread.sleep(1000);

			element_Actions.pressDownArrow();

			Thread.sleep(0);

			element_Actions.presEnterKey();

		} catch (Exception e) {

		}

		log.info("Employee entered successfully");

	}

	public String getEmployeeIdFromEmaployeeDetailsPage() {

		log.info("Fetching employee id");

		element_Actions.waitAndFindElement(obj.getElement("employeeId"));

		String empId = element_Actions.getElementText();

		log.info("Employee id fetched successfully");

		return empId;

	}
	
	public String getEmployeeNameFromEmaployeeDetailsPage() {

		log.info("Fetching employee Name");

		element_Actions.waitAndFindElement(obj.getElement("employeeName"));

		String empName = element_Actions.getElementText();

		log.info("Employee Name fetched successfully");

		return empName;

	}

	public String addEmployeeFlow(String companyName, String firstName, String lastName, String DOB, String empEmail,

			String address) throws InterruptedException {

		Thread.sleep(7000);

		homePage.clickHomePageLink();

		homePage.clickOnAddEmployeeOnLeftMenu();

		Thread.sleep(20000);

		empList.clickAddNewEployeeButton();
		Thread.sleep(5000);

		enterCompanyName(companyName);
		Thread.sleep(2000);

		enterFirstName(firstName);
		Thread.sleep(2000);
		String newEmployeeLastName = lastName + functions.randomStringGenerator(4);
		enterLastName(newEmployeeLastName);
		
		
		Thread.sleep(2000);
		enterDateOfBirthField(DOB);
		Thread.sleep(2000);
		String newEmployeeEmail = empEmail + functions.randomNumberGenerator(5) + "@yopmail.com";

		enterEmail(newEmployeeEmail);
		Thread.sleep(2000);
		//selectSearchOnMapsCheckbox();
		selectAddressTab();
		Thread.sleep(2000);
		enterEmployeeAddressOnMaps(address);
		Thread.sleep(2000);
		clickSaveButton();

		Thread.sleep(40000);

//		String employeeId = getEmployeeIdFromEmaployeeDetailsPage();
//
//		return employeeId;
		
		String employeeName = getEmployeeNameFromEmaployeeDetailsPage();
		
		return employeeName;

	}

}
