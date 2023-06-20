package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class StaffingJobOrderPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public StaffingJobOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("StaffingJobOrderPage.properties");
		obj = new ObjectRepository("StaffingJobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickAvailableOrder() throws InterruptedException {
		log.info("Clicking on Available order Button");
		List<WebElement> elements = element_Actions.findElements(obj.getElement("availableOrderButtonClaim"));
     	Thread.sleep(3000);
		elements.get(0).click();
		log.info("Available Order Button clicked successfully");
	}

	public void clickFirstJobOrderLink() {
		log.info("Clicking on first job order Button");
		element_Actions.waitAndFindElement(obj.getElement("jobOrdersList"));
		List<WebElement> jobOrders = element_Actions.findElements(obj.getElement("jobOrdersList"));
		jobOrders.get(0).click();
		log.info("First job order button clicked successfully");
	}
	public void selectParticularJobOrderFromListing(String hiringJobId) throws InterruptedException
	 {
		log.info("Selecting Particular Joborder on the listing");
		Thread.sleep(10000);
		System.out.println("JobOrderId= ****** "+ hiringJobId );
		List<WebElement> listOrder=element_Actions.findElements(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
		listOrder.get(0).click();
		log.info("Particular Joborder on the listing selected successfully");
	}
	
	public void clickClaimOrderButton() {
		log.info("Clicking on Claim order Button");
		element_Actions.waitAndFindElement(obj.getElement("claimOrderButton"));
		element_Actions.findElement(obj.getElement("claimOrderButton"));
		element_Actions.click();
		log.info("Claim order button clicked successfully");
	}
	
	public String autoApproveText() throws InterruptedException {
		log.info("Verify Auto Approve Text");
		element_Actions.waitAndFindElement(obj.getElement("autoApproveVerify"));
		Thread.sleep(10000);
		String autoApprveText = element_Actions.findElement(obj.getElement("autoApproveVerify")).getText();
		log.info("Auto Approve Text displayed successfully");
		return autoApprveText;
	}

	public boolean verifyJobOrderPage() {
		log.info("Job order form is displayed");
		element_Actions.waitAndFindElement(obj.getElement("jobOrderPageTitle"));
		boolean title = element_Actions.findElement(obj.getElement("jobOrderPageTitle")).isDisplayed();
		log.info("Job orderform is displayed successfully");
		return title;
	}

	public String verifySubmissionOfClaimOrder() {
		log.info("Job order form should display submission of claim order");
		element_Actions.waitAndFindElement(obj.getElement("claimOrderSubmission"));
		;
		String message = element_Actions.findElement(obj.getElement("claimOrderSubmission")).getText();
		log.info("Message displayed successfully");
		return message;
	}

	public boolean verifyHeadCountAvaialblecolumnIsAvailableInJobOrderForm() {
		log.info("Check for column headcount available is present");
		element_Actions.waitAndFindElement(obj.getElement("headCountColumn"));
		boolean headcount = element_Actions.findElement(obj.getElement("headCountColumn")).isDisplayed();
		log.info("Job order form displayed headcount column successfully");
		return headcount;
	}

	public boolean verifyJobOrderIdPage() {
		log.info("Job order form is displayed");
		element_Actions.waitAndFindElement(obj.getElement("jobIdPageTitle"));
		boolean JoborderId = element_Actions.findElement(obj.getElement("jobIdPageTitle")).isDisplayed();
		log.info("Job orderform is displayed successfully");
		return JoborderId;
	}

	public boolean VerifyResumeRequiredBoxIsUnchecked() {
		log.info("Checking Resume required Box is Unchecked");
		element_Actions.waitAndFindElement(obj.getElement("resumesRequiredSection"));
		boolean resumesRequiredCheckBox = element_Actions.findElement(obj.getElement("resumesRequired")).isSelected();
		log.info("Resume required Box is Unchecked successfully");
		return resumesRequiredCheckBox;
	}

	public boolean VerifyClaimOrderVisible() {
		log.info("Checking Claim order Button is Visible");
		element_Actions.waitAndFindElement(obj.getElement("claimOrderButton"));
		boolean claimOrderButton = element_Actions.findElement(obj.getElement("resumesRequired")).isDisplayed();
		log.info("Claim order Button is displayed successfully");
		return claimOrderButton;
	}

	public void clickAssignEmployeesButton() {
		log.info("Clicking Assign employees under the related section");
		element_Actions.waitAndFindElement(obj.getElement("buttonAssignEmployees"));
		element_Actions.findElement(obj.getElement("buttonAssignEmployees"));
		element_Actions.click();
		log.info("Clicked assign employees on job order form successfully");
	}

	public boolean verifyNewAssignEmployeeFormVisible() {
		log.info("Check new assign employee form is visible");
		element_Actions.waitAndFindElement(obj.getElement("formNewAssignEmployee"));
		boolean newAssignEmployee = element_Actions.findElement(obj.getElement("formNewAssignEmployee")).isDisplayed();
		log.info("New assign employee form displayed successfully");
		return newAssignEmployee;
	}

	public String verifyMandatoryFieldErrorMessage() {
		log.info("Check for all mandatory fiels entered");
		element_Actions.waitAndFindElement(obj.getElement("msgprint"));
		String message = element_Actions.findElement(obj.getElement("msgprint")).getText();
		log.info("Error message displayed successfully");
		return message;
	}

	public boolean verifyCompanyFeildAutoPopulated() {
		log.info("Verify Company Feild auto populated in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("companyFeildAutoPopulate"));
		boolean display = element_Actions.findElement(obj.getElement("companyFeildAutoPopulate")).isDisplayed();
		log.info("Company Feild auto populated in new Assign Employee form successfully.");
		return display;
	}

	public boolean verifyEmployeePayRate() {
		log.info("Verfied employee pay rate field in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("employeePayRate"));
		boolean display = element_Actions.findElement(obj.getElement("employeePayRate")).isDisplayed();
		log.info("Verfied and removed the employee pay rate");
		return display;
	}

	public boolean verifyEmpPayRatePopulated() {
		log.info("Verify employee pay rate value auto populated in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("employeePayRateValue"));
		boolean display = element_Actions.findElement(obj.getElement("employeePayRateValue")).isDisplayed();
		log.info("Employee pay rate value auto populated in new Assign Employee form successfully.");
		return display;
	}

	public boolean verifyDistanceRadiusFeild() {
		log.info("Verify Distance Radius Feild is visible in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("distanceRadius"));
		boolean display = element_Actions.findElement(obj.getElement("distanceRadius")).isDisplayed();
		log.info(" Distance Radius Feild is displayed in new Assign Employee form successfully.");
		return display;
	}

	public void enterMiles(String miles) {
		log.info("Entering Distance radius in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("distanceRadiusValue"));
		element_Actions.findElement(obj.getElement("distanceRadiusValue"));
		element_Actions.selectDropdownByValue(miles);
		log.info("Distance radius in new Assign Employee form entered successfully");
	}

	public void enterEmployeeOnboardingTemplateValue(String employeeonboardingtemplate) {
		log.info("Entering ");
		element_Actions.waitAndFindElement(obj.getElement("employeeOnboardingTemplate"));
		element_Actions.findElement(obj.getElement("employeeOnboardingTemplate"));
		element_Actions.sendKeys(employeeonboardingtemplate);
		element_Actions.findElement(obj.getElement("empValue"));
		element_Actions.click();
		log.info("entered successfully");
	}

	public boolean verifyShowAllEmployeesVisible() {
		log.info("Verify ShowAllEmployees Feild is visible in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("showAllEmployees"));
		boolean display = element_Actions.findElement(obj.getElement("showAllEmployees")).isDisplayed();
		log.info(" ShowAllEmployees Feild is displayed in new Assign Employee form successfully.");
		return display;
	}

	public void clickCheckBoxShowAllEmployess() throws InterruptedException {
		log.info("Clicking CheckBox ShowAllEmployees");
		element_Actions.waitAndFindElement(obj.getElement("checkBoxShowAllEmployees"));
		element_Actions.findElement(obj.getElement("checkBoxShowAllEmployees"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info(" ShowAllEmployees CheckBox clicked successfully");
	}

	public void clickAddRowButton() throws InterruptedException {
		log.info("Clicking AddRow in new Assign Employee form ");
		element_Actions.scrollToTheBottom();
		Thread.sleep(5000);
		element_Actions.waitAndFindElement(obj.getElement("addRowButton"));
		element_Actions.findElement(obj.getElement("addRowButton"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("AddRow button in new Assign Employee form clicked successfully");
	}

	public boolean verifyEmployeeIDVisible() {
		log.info("Verify employeeID is visible in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("employeeID"));
		boolean display = element_Actions.findElement(obj.getElement("employeeID")).isDisplayed();
		log.info("EmployeeID is displayed in new Assign Employee form successfully.");
		return display;
	}
	public void clickEditButton(){
		log.info("Clicking edit button on the form under the EmployeeDetails");
		element_Actions.waitAndFindElement(obj.getElement("editButton"));
		element_Actions.findElement(obj.getElement("editButton"));
		element_Actions.click();
		log.info("Clicked edit button on the form under the EmployeeDetails successfully");
	}

	public void enterEmployeeId(String createdEmployeeId) throws InterruptedException {
		log.info("Entering employeeId in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("enterEmployeeIDValue"));
		element_Actions.findElement(obj.getElement("enterEmployeeIDValue"));
		element_Actions.click();
	    element_Actions.sendKeys(createdEmployeeId);
		log.info("employeeId in new Assign Employee form entered successfully");
	}

	public void enterEmployeeName(String createdEmployeeName) throws InterruptedException {
		log.info("Entering employeeName in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("enterEmployeeIDValue"));
		element_Actions.findElement(obj.getElement("enterEmployeeIDValue"));
		element_Actions.click();
	    element_Actions.sendKeys(createdEmployeeName);
		log.info("employeeName in new Assign Employee form entered successfully");
	}
	
	public void clickSearchedEmployee(){
		log.info("Clicking Searched Employee");
		element_Actions.waitAndFindElement(obj.getElement("clickSearchedEmployee"));
		element_Actions.findElement(obj.getElement("clickSearchedEmployee"));
		element_Actions.click();
		log.info("Searched Employee clicked Successfully");
	}
	
	public void clickDropModalClose(){
		log.info("Clicking Dropdown arrow in the modal");
		element_Actions.waitAndFindElement(obj.getElement("dropDownModal"));
		element_Actions.findElement(obj.getElement("dropDownModal"));
		element_Actions.click();
		log.info("Clicked Dropdown arrow in the modal successfully");
	}
	
	public void clickYesButton() throws InterruptedException {
		log.info("Clicking yes on warning modal ");
		element_Actions.waitAndFindElement(obj.getElement("yesButtonWarningModal"));
		element_Actions.findElement(obj.getElement("yesButtonWarningModal"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("yes Button on warning modal clicked successfully");
	}

	public void clickSaveButton() throws InterruptedException {
		log.info("Clicking save new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		Thread.sleep(2000);
		element_Actions.findElement(obj.getElement("saveButton"));
		Thread.sleep(2000);
		element_Actions.click_JS();
		log.info("save button in new Assign Employee form clicked successfully");
	}

	public boolean verifySaveButtonVisible() {
		log.info("Verify savebutton is visible in new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		boolean display = element_Actions.findElement(obj.getElement("saveButton")).isDisplayed();
		log.info("save button is displayed in new Assign Employee form successfully.");
		return display;
	}

	public void clickCloseIcon() throws InterruptedException {
		log.info("Clicking on Close Icon");
		element_Actions.waitAndFindElement(obj.getElement("modalCloseIcon"));
		element_Actions.findElement(obj.getElement("modalCloseIcon"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Close Icon clicked successfully");
	}

	public String verifyEmailSuccessMessage() {
		log.info("Check for submission of Claim Order");
		element_Actions.waitAndFindElement(obj.getElement("msgprint"));
		String emailSuccessMessage = element_Actions.findElement(obj.getElement("msgprint")).getText();
		log.info("Claim Order Submitted Successfully");
		return emailSuccessMessage;
	}

	public void clickErrorClose() throws InterruptedException {
		log.info("Clicking on Close Icon");
		element_Actions.waitAndFindElement(obj.getElement("errorClose"));
		element_Actions.findElement(obj.getElement("errorClose"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Close Icon clicked successfully");
	}

	public void clickRadius() {
		log.info("Clicking on first job order Button");
		element_Actions.waitAndFindElement(obj.getElement("distanceRadiusValue"));
		List<WebElement> jobOrders = element_Actions.findElements(obj.getElement("distanceRadiusValue"));
		jobOrders.get(1).click();
		log.info("First job order button clicked successfully");
	}

	public String verifyPleaseSubmitInvoiceMessage() {
		log.info("Check for 'Please submit an invoice to complete the order.' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("messageSubmitInvoice"));
		String message = element_Actions.findElement(obj.getElement("messageSubmitInvoice")).getText();
		log.info("Message displayed successfully");
		return message;
	}

	public void clickCreateInvoice() {
		log.info("Clicking on create invoice button ");
		element_Actions.waitAndFindElement(obj.getElement("buttonCreateInvoice"));
		element_Actions.findElement(obj.getElement("buttonCreateInvoice"));
		element_Actions.click();
		log.info("Create Invoice button clicked successfully");
	}

	public boolean VerifyNewInvoice() {
		log.info("Verify New invoice is visible");
		element_Actions.waitAndFindElement(obj.getElement("titleNewInvoice"));
		boolean display = element_Actions.findElement(obj.getElement("titleNewInvoice")).isDisplayed();
		log.info("Title New Invoice is displayed in form successfully.");
		return display;
	}

	public boolean VerifyCancelButton() {
		log.info("Verify cancel button is visible");
		element_Actions.waitAndFindElement(obj.getElement("cancelButton"));
		boolean display = element_Actions.findElement(obj.getElement("cancelButton")).isDisplayed();
		log.info("Cancel Button is displayed in form successfully.");
		return display;
	}

	public boolean VerifySaveButton() {
		log.info("Verifysave button is visible");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		boolean display = element_Actions.findElement(obj.getElement("saveButton")).isDisplayed();
		log.info("Svae button is displayed in form successfully.");
		return display;
	}

	public boolean VerifyDraftText() {
		log.info("Verify Draft text is visible");
		element_Actions.waitAndFindElement(obj.getElement("draftText"));
		boolean display = element_Actions.findElement(obj.getElement("draftText")).isDisplayed();
		log.info("Draft text is displayed in form successfully.");
		return display;
	}

	public String verifySubmitThisDocumentMessage() {
		log.info("Check for 'Submit this document to confirm”' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("confirmationText"));
		String message = element_Actions.findElement(obj.getElement("confirmationText")).getText();
		log.info("Message displayed successfully");
		return message;
	}

	public void clickSubmitButton() {
		log.info("Clicking on submit button ");
		element_Actions.waitAndFindElement(obj.getElement("submitButton"));
		element_Actions.findElement(obj.getElement("submitButton"));
		element_Actions.click();
		log.info("Submit button clicked successfully");
	}

	public boolean VerifyYesButtonConfirmModal() {
		log.info("Verify yes button is visible in confirm modal");
		element_Actions.waitAndFindElement(obj.getElement("yesButtonConfirmModal"));
		boolean display = element_Actions.findElement(obj.getElement("yesButtonConfirmModal")).isDisplayed();
		log.info("Yes Button is displayed in confirm modal");
		return display;
	}

	public boolean VerifyNoButtonConfirmModal() {
		log.info("Verify No button is visible in confirm modal");
		element_Actions.waitAndFindElement(obj.getElement("noButtonConfirmModal"));
		boolean display = element_Actions.findElement(obj.getElement("noButtonConfirmModal")).isDisplayed();
		log.info("No Button is displayed in confirm modal");
		return display;
	}

	public void clickYesButtonConfirmModal() throws InterruptedException {
		log.info("Clicking yes button  in confirm modal");
		element_Actions.waitAndFindElement(obj.getElement("yesButtonConfirmModal"));
		element_Actions.findElement(obj.getElement("yesButtonConfirmModal"));
		Thread.sleep(3000);
		element_Actions.click();
		Thread.sleep(3000);
		log.info("yes button  in confirm modal clicked successfully");
	}
	
	public boolean VerifyAssignedEmployeesButton() {
		log.info("Verify Assigned Employees Button visible ");
		element_Actions.waitAndFindElement(obj.getElement("assignedEmployeesButton"));
		boolean display = element_Actions.findElement(obj.getElement("assignedEmployeesButton")).isDisplayed();
		log.info("Assigned Employees Button displayed in form successfully.");
		return display;
	}
	
	public void clickConfirmButtonInModal() {
		log.info("Clicking on confirm button ");
		element_Actions.waitAndFindElement(obj.getElement("buttonConfirmModal"));
		element_Actions.findElement(obj.getElement("buttonConfirmModal"));
		element_Actions.click();
		log.info("Confirm button clicked successfully");
	}
	
	public void selectParticularJobOrderFromListingStaffing(String hiringJobId) throws InterruptedException
	 {
		log.info("Selecting Particular Joborder on the listing");
		Thread.sleep(10000);
		System.out.println("JobOrderId= ****** "+ hiringJobId );
		List<WebElement> listOrder=element_Actions.findElements(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
		listOrder.get(1).click();
		log.info("Particular Joborder on the listing selected successfully");
	}

}
