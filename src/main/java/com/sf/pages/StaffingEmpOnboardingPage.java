package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class StaffingEmpOnboardingPage extends ObjectRepository {
	
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	
	public StaffingEmpOnboardingPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("StaffingEmpOnboardingPage.properties");
		obj = new ObjectRepository("StaffingEmpOnboardingPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public boolean verifyEmployeeOnboardingTitle() 
	{
		log.info("Verify EmployeeOnboardingTitle on the employee-onboarding page");
		element_Actions.waitAndFindElement(obj.getElement("employeeOnboardingTitle"));
		boolean Display = element_Actions.findElement(obj.getElement("employeeOnboardingTitle")).isDisplayed();
		log.info("EmployeeOnboardingTitle menu displayed successfully.");
		return Display;
	}
	public void clickAddEmployeeOnboarding() 
	{
		log.info("Clicking AddEmployeeOnboarding present on the  employee-onboarding page");
		element_Actions.waitAndFindElement(obj.getElement("addEmployeeOnboardingButton"));
		element_Actions.findElement(obj.getElement("addEmployeeOnboardingButton"));
		element_Actions.click();
		log.info("Add Employee Onboarding button clicked successfully.");
	}
	public void verifyNewEmployeeOnboardingTitle() 
	{
		log.info("Verify New Employee Onboarding Title while clicking add Employee Onboarding Button");
		element_Actions.waitAndFindElement(obj.getElement("newEmployeeOnboardingTitle"));
		element_Actions.findElement(obj.getElement("newEmployeeOnboardingTitle"));
		log.info("New Employee Onboarding Title displayed while clicking add Employee Onboarding Button successfully.");
	}
	public void clickSaveButton() throws InterruptedException 
	{
		log.info("Clicking save button on New Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		Thread.sleep(3000);
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save button clicked successfully");
	}
	public String verifyMissingFieldPopUp() 
	{
		log.info("Verify Missing field dialog while clicking save Button");
		element_Actions.waitAndFindElement(obj.getElement("missingFieldPopUp"));
		String message = element_Actions.findElement(obj.getElement("missingFieldPopUp")).getText();
		log.info("Missing field dialog displayed while clicking save Button successfully.");
		return message;
	}
	public boolean verifyFirstNameIsVisible() 
	{
		log.info("Checking first name feild is Visible");
		element_Actions.waitAndFindElement(obj.getElement("firstName"));
		boolean Display=element_Actions.findElement(obj.getElement("firstName")).isDisplayed();
		log.info("First name is displayed successfully");
		return Display;
	}
	public void enterFirstName(String firstname)
	{
		log.info("Entering new user's first name");
		element_Actions.waitAndFindElement(obj.getElement("firstNameField"));
		element_Actions.findElement(obj.getElement("firstNameField"));
		element_Actions.sendKeys(firstname);
		log.info("User's first name entered successfully");
	}
	public boolean verifyLastNameIsVisible() 
	{
		log.info("Checking last name feild is Visible");
		element_Actions.waitAndFindElement(obj.getElement("lastName"));
		boolean Display=element_Actions.findElement(obj.getElement("lastName")).isDisplayed();
		log.info("last name is displayed successfully");
		return Display;
	}
	public void enterLastName(String lastname)
	{
		log.info("Entering new user's Last name");
		element_Actions.waitAndFindElement(obj.getElement("lastNameField"));
		element_Actions.findElement(obj.getElement("lastNameField"));
		element_Actions.sendKeys(lastname);
		log.info("User's last name entered successfully");
	}
	public boolean verifyEmailVisible() 
	{
		log.info("Checking email is Visible");
		element_Actions.waitAndFindElement(obj.getElement("eMail"));
		boolean Display=element_Actions.findElement(obj.getElement("eMail")).isDisplayed();
		log.info("email is displayed successfully");
		return Display;
	}
    public void enterEmail(String email)
	{
		log.info("Entering new email");
		element_Actions.waitAndFindElement(obj.getElement("eMailField"));
		element_Actions.findElement(obj.getElement("eMailField"));
		element_Actions.sendKeys(email);
		log.info("email entered successfully");
	}
	public boolean verifyEmployeeOnboardingTemplateVisible() 
	{
		log.info("Checking Employee Onboarding Template is Visible");
		element_Actions.waitAndFindElement(obj.getElement("templateName"));
		boolean Display=element_Actions.findElement(obj.getElement("templateName")).isDisplayed();
		log.info("Employee Onboarding Template is displayed successfully");
		return Display;
	}
	public void enterEmployeeOnboardingTemplateValue(String employeeonboardingtemplate)
	{
		log.info("Entering ");
		element_Actions.waitAndFindElement(obj.getElement("templateNameFeild"));
		element_Actions.click();
		element_Actions.selectDropdownByValue("Automation Template");
//		element_Actions.waitAndFindElement(obj.getElement("templateName"));
//		element_Actions.selectDropdownByValue("templateName");
//		element_Actions.findElement(obj.getElement("templateName"));
//		element_Actions.sendKeys(employeeonboardingtemplate);
//		element_Actions.findElement(obj.getElement("empValue"));
//		element_Actions.click();
		log.info("entered successfully");
	}
	public void clickCloseButtonMissingFieldPopUp() throws InterruptedException 
	{
		log.info("Clicking close button on New Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("closeButtonMissingFieldPopUp"));
		element_Actions.findElement(obj.getElement("closeButtonMissingFieldPopUp"));
		Thread.sleep(3000);
		element_Actions.click();
		log.info("CLose button clicked successfully");
	}
	public void enterDateOfBirth(String dateOfBirth) throws InterruptedException
	{
		log.info("Entering DOb in  new EmployeeOnborading page");
		element_Actions.waitAndFindElement(obj.getElement("dateOfBirthFeild"));
		element_Actions.findElement(obj.getElement("dateOfBirthFeild"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(dateOfBirth);
		Thread.sleep(2000);
		element_Actions.findElement(obj.getElement("dateOfBirthFeild")).sendKeys(Keys.TAB);
		log.info("Entered DOb in  new EmployeeOnborading page successfully");
	}
	public boolean verifyDraftStatusOnForm() throws InterruptedException 
	{
		log.info("verify clicking Save button moved to Draft Status on form");
		element_Actions.waitAndFindElement(obj.getElement("draftStatus"));
		Thread.sleep(3000);
		boolean Display=element_Actions.findElement(obj.getElement("draftStatus")).isDisplayed();
		log.info("verified clicking Save button moved to Draft Status on form successfully");
		return Display;
	}
	public boolean verifySubmitButtonOnForm() 
	{
		log.info("verify clicking Submit button on Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("submitButton"));
		boolean Display=element_Actions.findElement(obj.getElement("submitButton")).isDisplayed();
		log.info("verified clicking on Submit button on Employee Onboarding form successfully");
		return Display;
	}
	public void clickSubmitButton() 
	{
		log.info("Clicking save button on New Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("submitButton"));
		element_Actions.findElement(obj.getElement("submitButton"));
		element_Actions.click();
		log.info("Save button clicked successfully");
	}
	public void clickModalConfirmYesButton() 
	{
		log.info("Clicking yes button on confirm modal Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("modalConfirmYes"));
		element_Actions.findElement(obj.getElement("modalConfirmYes"));
		element_Actions.click();
		log.info("Yes button on confirm modal clicked successfully");
	}
	public void clickModalConfirmCloseIcon() throws InterruptedException 
	{
		log.info("Clicking close Icon on confirm modal Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("modalConfirmCloseIcon"));
		Thread.sleep(3000);
		element_Actions.findElement(obj.getElement("modalConfirmCloseIcon"));
		element_Actions.click();
		log.info("Close Icon on confirm modal clicked successfully");
	}
	public void clickModalMessageCloseIcon() 
	{
		log.info("Clicking message close Icon on confirm modal Employee Onboarding form");
		element_Actions.waitAndFindElement(obj.getElement("modalMessageCloseIcon"));
		element_Actions.findElement(obj.getElement("modalMessageCloseIcon"));
		element_Actions.click();
		log.info("Message close Icon on confirm modal clicked successfully");
	}
	public boolean verifySubmittedStatusOnForm() throws InterruptedException 
	{
		log.info("verify clicking submit button moved to submitted Status on form");
		element_Actions.waitAndFindElement(obj.getElement("submittedStatus"));
		Thread.sleep(3000);
		boolean Display=element_Actions.findElement(obj.getElement("submittedStatus")).isDisplayed();
		log.info("verified clicking submit button moved to submitted Status on form successfully");
		return Display;
	}
	public void clickEmployeeOnboardingOnPendingForm() 
	{
		log.info("Clicking Employee Onboarding On Pending Form");
		element_Actions.waitAndFindElement(obj.getElement("employeeOnboarding"));
		element_Actions.findElement(obj.getElement("employeeOnboarding"));
		element_Actions.click();
		log.info(" Employee Onboarding On Pending Form clicked successfully.");
	}
	public boolean verifyFirstLastNameListing() 
	{
		log.info("Checking first last name is listing");
		element_Actions.waitAndFindElement(obj.getElement("onboardedEmployeeListingForm"));
		boolean Display=element_Actions.findElement(obj.getElement("onboardedEmployeeListingForm")).isDisplayed();
		log.info("first last name is displayed listing form successfully");
		return Display;
	}
	public void enterData1(String data1)
	{
		log.info("Entering Job Applicant List in the search box");
		element_Actions.waitAndFindElement(obj.getElement("seachBoxFeild"));
		element_Actions.findElement(obj.getElement("seachBoxFeild"));
		element_Actions.sendKeys(data1);
		log.info("Entered Job Applicant List in the search box successfully");
	}
	public void clickSearchBox() 
	{
		log.info("Searching Job Applicant List having the Status as Accepted");
		element_Actions.waitAndFindElement(obj.getElement("seachBoxFeild2"));
		element_Actions.findElement(obj.getElement("seachBoxFeild2"));
		element_Actions.click();
		log.info("Job Applicant List having the Status as Accepted listed successfully");
	}
	public boolean verifyJobApplicantList() 
	{
		log.info("Checking Job applicant list having the Status as Accepted");
		element_Actions.waitAndFindElement(obj.getElement("statusAccepted"));
		boolean Display=element_Actions.findElement(obj.getElement("statusAccepted")).isDisplayed();
		log.info("first last name is displayed listing form successfully");
		return Display;
	}
	public void enterData2(String data2)
	{
		log.info("Entering Job Offer List in the search box");
		element_Actions.waitAndFindElement(obj.getElement("seachBoxFeild"));
		element_Actions.findElement(obj.getElement("seachBoxFeild"));
		element_Actions.sendKeys(data2);
		log.info("Entered Job offer List in the search box successfully");
	}
	public boolean verifyJobOfferList() 
	{
		log.info("Checking Job offer list having the Status as Accepted");
		element_Actions.waitAndFindElement(obj.getElement("statusDraft"));
		boolean Display=element_Actions.findElement(obj.getElement("statusDraft")).isDisplayed();
		log.info("first last name is displayed listing form successfully");
		return Display;
	}
	public String verifyBirthYearErrorMessage() 
	{
		log.info("Verify birth year error message ");
		element_Actions.waitAndFindElement(obj.getElement("missingFieldPopUp"));
		String message = element_Actions.findElement(obj.getElement("missingFieldPopUp")).getText();
		log.info("Birth year error message verified successfully.");
		return message;
	}
	
}
