package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class ClaimOrderPage extends ObjectRepository {
	
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public ClaimOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("ClaimOrderPage.properties");
		obj = new ObjectRepository("ClaimOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
    public void enterNoOfEmployeesClaim(String noOfEmployeesClaim) {
		log.info("Entering the No. of Employees Claim");
		element_Actions.waitAndFindElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.findElement(obj.getElement("noOfEmployeesClaim")).sendKeys(noOfEmployeesClaim);
		log.info("No. of Employees Claim entered successfully");
	}
    public void enterEmployeePayRate(String employeePayRate) {
		log.info("Entering the Employee Pay Rate");
		element_Actions.waitAndFindElement(obj.getElement("employeePayRate"));
		element_Actions.findElement(obj.getElement("employeePayRate"));
		element_Actions.sendKeys(employeePayRate);
		log.info("Employee Pay Rate entered successfully");
	}
	public void enterESignature(String eSignature) {
		log.info("Entering the E-Signature");
		element_Actions.waitAndFindElement(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(eSignature);
		log.info("E-Signature entered successfully");
	}
	public void clickAgreeContract() {
		log.info("Clicking on Agree to Contract Button");
		element_Actions.waitAndFindElement(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		element_Actions.click();
		log.info("Agree to Contract Button clicked successfully");
	}
	public void clickSubmitClaim() {
		log.info("Clicking on Submit Claim Button");
		element_Actions.waitAndFindElement(obj.getElement("submitClaimButton"));
		element_Actions.findElement(obj.getElement("submitClaimButton"));
		element_Actions.click();
		log.info("Submit Claim Button clicked successfully");
	}
	public String verifyEmailSuccessMessage() {
		log.info("Check for submission of Claim Order");
		element_Actions.waitAndFindElement(obj.getElement("msgprint"));
		String emailSuccessMessage = element_Actions.findElement(obj.getElement("msgprint")).getText();
		log.info("Claim Order Submitted Successfully");
		return emailSuccessMessage;
	}
	public String verifyMandatoryFieldErrorMessage() {
		log.info("Check for all mandatory fiels entered");
		element_Actions.waitAndFindElement(obj.getElement("msgprint"));
		String message = element_Actions.findElement(obj.getElement("msgprint")).getText();
		log.info("Error message displayed successfully");
		return message;
	}
	public void clearField()
	{
		log.info("Entering the No. of Employees Claim");
		element_Actions.waitAndFindElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.findElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.clearField();
		
	}
	
	public void clickCancel() {
		log.info("Clicking on cancel Button");
		element_Actions.waitAndFindElement(obj.getElement("cancelButton"));
		element_Actions.findElement(obj.getElement("cancelButton"));
		element_Actions.click();
		log.info("Cancel Button clicked successfully");
	}
	public void clickCloseIcon() throws InterruptedException {
		log.info("Clicking on Close Icon");
		element_Actions.waitAndFindElement(obj.getElement("modalCloseIcon"));
		Thread.sleep(3000);
		element_Actions.click();
		log.info("Close Icon clicked successfully");
	}
	public void verifyAndRemoveEmployeePayRate() {
		log.info("Verfied employee pay rate field and removed");
		element_Actions.waitAndFindElement(obj.getElement("employeePayRate"));
		log.info("Employee pay rate is visible");
		element_Actions.findElement(obj.getElement("employeePayRate"));
		element_Actions.clearField();
		log.info("Verfied and removed the employee pay rate");
	}
	public boolean verifySubmitButtonIsVisible() {
		log.info("Check SubmitClaim Button is Visible");
		element_Actions.waitAndFindElement(obj.getElement("submitClaimButton"));
		boolean submit = element_Actions.findElement(obj.getElement("submitClaimButton")).isDisplayed();
		log.info("Submit claim button  is displayed successfully");
		return submit;
	}
	public boolean verifyCancelButtonIsVisible() {
		log.info("Check cnacel button is visible");
		element_Actions.waitAndFindElement(obj.getElement("cancelButton"));
		boolean cancel = element_Actions.findElement(obj.getElement("cancelButton")).isDisplayed();
		log.info("Cancel claim button displayed successfully");
		return cancel;
	}
	public boolean verifyNewClaimOrderPage() {
		log.info("While clicking claim order it should navigate to New order");
		element_Actions.waitAndFindElement(obj.getElement("newClaimOrderPage"));
		boolean verify = element_Actions.findElement(obj.getElement("newClaimOrderPage")).isDisplayed();
		log.info("While clicking claim order successfully navigates to New order");
		return verify;
	}
    public String getRemainingEmployeeValue() {
		log.info("Entering No of Employees greater than Remaining Employees");
		element_Actions.waitAndFindElement(obj.getElement("employeesRemainingValue"));
		element_Actions.findElement(obj.getElement("employeesRemainingValue"));
		String remainingEmployees = element_Actions.getElementText();
		log.info("Entered No of Employees greater than Remaining Employees successfully");
        return remainingEmployees;
    }
	public void verifyAndEnterEmployeePayRate(String employeePayRate) {
		log.info("Check for Employee Payrate is empty or not");
		element_Actions.waitAndFindElement(obj.getElement("employeePayRateSection"));
		element_Actions.findElement(obj.getElement("employeePayRate"));
		element_Actions.click();
		element_Actions.findElement(obj.getElement("employeePayRateSection"));
		element_Actions.click();
		
		if(element_Actions.findElement(obj.getElement("employeesPayRateValue")).getAttribute("textContent").isEmpty() ||
				element_Actions.findElement(obj.getElement("employeesPayRateValue")).getAttribute("textContent")==null){
			log.info("Employee Payrate is empty");
			element_Actions.findElement(obj.getElement("employeePayRate"));
			element_Actions.click();
			element_Actions.sendKeys(employeePayRate);
			log.info("Entered the employee pay rate value greater than 0 successfully");
		}
		else {
			log.info("Employee pay rate value is already existing hence skipping this field");
		}	
	}
	public void verifyNoOfEmployeesClaimNotAcceptAlphabet(String alphabetValue) {
		log.info("Check for'No.of.Employees to claim' by entering alphabet");
		element_Actions.waitAndFindElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.findElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.click();
		element_Actions.sendKeys(alphabetValue);
		log.info("Alphabets entered in No. of Employees to Claim successfully");
	}
	public void verifyNoOfEmployeesClaimNotAcceptSpecialCharacters(String specialCharacter) {
		log.info("Check for'No.of.Employees to claim' by entering alphabet");
		element_Actions.waitAndFindElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.findElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.click();
		element_Actions.sendKeys(specialCharacter);
		log.info("Special Characters entered in No. of Employees to Claim successfully");
	}
	public boolean verifyApproveFieldIsVisible() {
		log.info("Check for Approvefield is visible");
		element_Actions.waitAndFindElement(obj.getElement("titleApprove"));
		boolean approveField = element_Actions.findElement(obj.getElement("titleApprove")).isDisplayed();
		log.info("Approvefield is visible successfully");
		return approveField;
	}
	 public void enterApproveCount(String approveCount) {
		log.info("Entering Approve count should not be greater than Workerscount");
	    element_Actions.waitAndFindElement(obj.getElement("modalApproveCount"));
		element_Actions.findElement(obj.getElement("modalApproveCount")).sendKeys(approveCount);
		log.info("Approve count is not more than the workers count");
	}
	 public void enterApproveCountGreater(String approveCount1) {
			log.info("Entering Approve count should not be greater than Workerscount");
		    element_Actions.waitAndFindElement(obj.getElement("modalApproveCount"));
			element_Actions.findElement(obj.getElement("modalApproveCount")).sendKeys(approveCount1);
			log.info("Approve count is not more than the workers count");
		}
	 public void clickModalSubmitButton() {
		log.info("Clicking on modal submit Button");
		element_Actions.waitAndFindElement(obj.getElement("modalSubmitButton"));
		element_Actions.findElement(obj.getElement("modalSubmitButton"));
		element_Actions.click();
		log.info("Modal submit button clicked successfully");
	}
	 public String verifyErrorMessage() {
		log.info("Popup shows as Claims approved cannot be greater than the no. of workers");
		element_Actions.waitAndFindElement(obj.getElement("msgprint"));
		String errorMessage = element_Actions.findElement(obj.getElement("msgprint")).getText();
		log.info("Error Message displayed successfully");
		return errorMessage;
	}
	 public String getWorkersCount() {
		log.info("Entering Approve count should not be greater than Workerscount");
		element_Actions.waitAndFindElement(obj.getElement("modalWorkersCount"));
		element_Actions.findElement(obj.getElement("modalWorkersCount"));
		String workersCount = element_Actions.getElementText();
		log.info("Approve count is not more than the workers count");
		return workersCount;
	}
	 public void clickYesButton()
	{
		log.info("Clicking yes on warning modal ");
		element_Actions.waitAndFindElement(obj.getElement("yesButtonWarningModal"));
		element_Actions.findElement(obj.getElement("yesButtonWarningModal"));
		element_Actions.click();
		log.info("yes Button on warning modal clicked successfully");
	}
}
