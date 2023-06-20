package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class TimesheetCreationPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public TimesheetCreationPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("TimesheetCreationPage.properties");
		obj = new ObjectRepository("TimesheetCreationPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

//	public boolean verifyHiringAdminAbleToViewEmployeesHaveBeenAssignedPleaseSubmitTheirTimesheets() {
//		log.info("Verifying Hiring Admin Able To View Employees Have Been Assigned Please Submit Their Timesheets");
//		boolean display = element_Actions.waitAndFindElement(obj.getElement("msgEmployeesAssigned", 2000))
//				.isDisplayed();
//		log.info(
//				"Verify Hiring Admin Able To View Employees Have Been Assigned Please Submit Their Timesheets successfully ");
//		return display;
//	}

	public String verifyPleaseReviewTimesheetMessage() {
		log.info("Check for 'submit their timesheets' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("msgEmployeesAssigned"));
		String message = element_Actions.findElement(obj.getElement("msgEmployeesAssigned")).getText();
		log.info("Message displayed successfully");
		return message;
	} 
	public void ClickingOnTimesheet() throws InterruptedException {
		log.info("Verifying Add Edit Timesheet Button Visible On Clicking On Timesheet");
		element_Actions.waitAndFindElement(obj.getElement("timesheets"));
		element_Actions.click();
		Thread.sleep(3000);
	}
	
	public void clickaddEditButton() throws InterruptedException {
		log.info("Clicking on addEditButton ");
		element_Actions.waitAndFindElement(obj.getElement("addEditButton"));
		element_Actions.findElement(obj.getElement("addEditButton"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("AddEditButton Clicked Successfully ");
	}

	public boolean verifyNavigatedToAddTimesheetFormByClickingOnAddEditTimesheetButtonOnClickingOnTimesheet()
			throws InterruptedException {
		log.info(
				"Verifying Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet");
		Thread.sleep(3000);
		boolean display = element_Actions.waitAndFindElement(obj.getElement("addTimesheetForm")).isDisplayed();
		log.info(
				"Verify Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet successfully");
		Thread.sleep(3000);
		return display;
	}

	public boolean verifyTimesheetDetailShouldGetAutoFetched() throws InterruptedException {
		log.info("Verifying Timesheet Detail Should Get Auto-Fetched");
		Thread.sleep(3000);
		boolean display = element_Actions.waitAndFindElement(obj.getElement("timesheetDetail")).isDisplayed();
		log.info("Verify Timesheet Detail Should Get Auto-Fetched successfully");
		return display;
	}

	public boolean verifyHiringRoleShouldAbleToSelectDateAsCurrentDay() throws InterruptedException {
		log.info("Entering current date in Timesheet");
		Thread.sleep(3000);
		boolean display = element_Actions.waitAndFindElement(obj.getElement("dateField")).isDisplayed();
		element_Actions.click();
		Thread.sleep(2000);
		List<WebElement> todayDate = element_Actions.findElements(obj.getElement("todayDate"));
		System.out.println("size of the list before clicking on 1st confirm " + todayDate.size());
		todayDate.get(4).click();
		Thread.sleep(2000);
		log.info("Entered current date in Timesheet successfully");
		return display;
	}

	public void enterDate(String date) throws InterruptedException {
		log.info("Verify Future date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("dateField"));
		element_Actions.findElement(obj.getElement("dateField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(date);
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("startDateField"));
		element_Actions.click();
		log.info("Verify Future date successfully");
	}

	public String verifyHiringRoleShouldNotAbleToSelectFutureDateAndGetsPopup() {
		log.info("Verifying Hiring Role Should Not Able To Select Future Date And Gets Popup");
		element_Actions.waitAndFindElement(obj.getElement("futureDateError", 2000));
		String message = element_Actions.getElementText();
		log.info("Verify Hiring Role Should Not Able To Select Future Date And Gets Popup successfully ");
		return message;

	}

	public void closeBlankMandatoryFieldDialogBox() {
		log.info("closing Future Date DialogBox");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("closeFutureDateError"));
		element_Actions.findElement(obj.getElement("closeFutureDateError"));
		element_Actions.click();
		log.info("Future Date DialogBox close Successfully");
	}

	public boolean verifyEmployeesDetailsShouldGetFetchedAutomatically() throws InterruptedException {
		log.info("Verify Employees Details Should Get Fetched Automatically");

		boolean display = element_Actions.waitAndFindElement(obj.getElement("autoFetchEmployeeDetails")).isDisplayed();
		log.info("Verify Employees Details Should Get Fetched Automatically successfully");
		return display;
	}

	public boolean verifyUserShouldAbleToSelectFromTimeAndToTimeSuccessfullyAndTotalHoursShouldGetCalculate()
			throws InterruptedException {
		log.info(
				"Verify User Should Able To Select From Time And To Time Successfully And Total Hours Should Get Calculate");
		Thread.sleep(3000);
		boolean display = element_Actions.waitAndFindElement(obj.getElement("totalHours")).isDisplayed();
		log.info(
				"Verify User Should Able To Select From Time And To Time Successfully And Total Hours Should Get Calculate successfully");
		return display;
	}

	public void enterStartTime(String startTime) throws InterruptedException {
		log.info("Verify Start Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDateField"));
		element_Actions.findElement(obj.getElement("startDateField"));
		element_Actions.click();
		//Thread.sleep(3000);
		element_Actions.sendKeys(startTime);
		//Thread.sleep(4000);
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		log.info("Verify Start Time Field successfully");
	}

	public void enterEndTime(String endTime) throws InterruptedException {
		log.info("Verify End Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDateField"));
		element_Actions.findElement(obj.getElement("endDateField"));
		element_Actions.click();
		//Thread.sleep(3000);
		element_Actions.sendKeys(endTime);
	//	Thread.sleep(4000);
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		log.info("Verify End Time Field successfully");
	}

	public boolean verifyValuesInDropdownOfStatusColumn() throws InterruptedException {
		log.info("Verifying Values In Dropdown Of Status Column");
		Thread.sleep(2000);
		element_Actions.scrollToTheBottom();
		Thread.sleep(5000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("statusDropdown"));
		boolean display = element_Actions.waitAndFindElement(obj.getElement("statusDropdown")).isDisplayed();
		Thread.sleep(2000);
		element_Actions.click();
		Thread.sleep(1000);
		element_Actions.click();
		Thread.sleep(1000);
		element_Actions.scrollToTheBottom();
		Thread.sleep(5000);
		Select statusValues = new Select(element_Actions.findElement(obj.getElement("statusDropdown")));
		List<WebElement> options = statusValues.getOptions();
		System.out.println("Status values are :  " + options);
		log.info("Verifying Values In Dropdown Of Status Column successfull");
		return display;
	}

	public boolean verifyUserShouldAableViewPopupTimesheetAddedSuccessfully() throws InterruptedException {
		log.info("Submitting Timesheet ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("submitTimesheet"));
		boolean display = element_Actions.findElement(obj.getElement("submitTimesheet")).isDisplayed();
		element_Actions.click();
		Thread.sleep(2000);
		log.info(" Timesheet Submit successfully");
		log.info("Verify Pop-up for Timesheet Added Successfullysuccessfully ");
		return display;
	}

	public String verifyNotificationShouldBeSentToStaffingCompanyTimesheetIsCreated() {
		log.info("Verifying Notification Should Be Sent To Staffing Company Timesheet Is Created");
		element_Actions.waitAndFindElement(obj.getElement("approvalTimesheetMsgStaffing", 4000));
		String popupMsg = element_Actions.getElementText();
		log.info("Verify Notification Should Be Sent To Staffing Company Timesheet Is Created successfully ");
		return popupMsg;
	}

	public void clickAllOrder() throws InterruptedException {
		log.info("Clicking on All order Button");
		element_Actions.waitAndFindElement(obj.getElement("allOrderButton"));
		element_Actions.findElement(obj.getElement("allOrderButton"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("All Order Button clicked successfully");
	}

	public void clickFirstJobOrderLink() {
		log.info("Clicking on first job order Button");
		element_Actions.waitAndFindElement(obj.getElement("jobOrdersList"));
		List<WebElement> jobOrders = element_Actions.findElements(obj.getElement("jobOrdersList"));
		jobOrders.get(0).click();
		log.info("First job order button clicked successfully");
	}

	public void clickOrderOption() throws InterruptedException {
		log.info("Clicking on  order Button");
		element_Actions.waitAndFindElement(obj.getElement("ordersHiring"));
		element_Actions.findElement(obj.getElement("ordersHiring"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info(" Order Button clicked successfully");
	}

	public void clickJobOrder01587() {
		log.info("Clicking on Joborderno");
		element_Actions.waitAndFindElement(obj.getElement("jobOrderNo"));
		element_Actions.findElement(obj.getElement("jobOrderNo"));
		element_Actions.click();
		log.info("Job order no clicked successfully");
	}

	public void clickSubmitTimesheetButton() throws InterruptedException {
		log.info("Submitting Timesheet ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("submitTimesheet"));
		element_Actions.findElement(obj.getElement("submitTimesheet"));
		element_Actions.click();
		Thread.sleep(2000);
		log.info(" Timesheet Submit successfully");
	}
	
	public void clickEmployeeSelectChechbox() throws InterruptedException {
		log.info("Selecting Employees Checkbox");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("employeeSelectCheckbox"));
		element_Actions.findElement(obj.getElement("employeeSelectCheckbox"));
		element_Actions.click();
		Thread.sleep(2000);
		log.info(" Employees Checkbox selected successfully");
	}
}
