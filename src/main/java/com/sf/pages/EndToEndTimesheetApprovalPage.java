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
public class EndToEndTimesheetApprovalPage  extends ObjectRepository {
	private static final String Admin = null;
	private static final String category = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public EndToEndTimesheetApprovalPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("EndToEndTimesheetApprovalPage.java");


		obj = new ObjectRepository("EndToEndTimesheetApprovalPage.java");



		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public String newOrderHiring(String estDailyHours,String startDate,String enddate,String startTime,String availability,String jobSite ,String jobTitle, String category, String noOfWorker,String eSignature ) throws InterruptedException {
		log.info("Clicking on New Order Button");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("newOrder"));
		element_Actions.findElement(obj.getElement("newOrder"));
		element_Actions.click();
		log.info("New Order Button clicked successfully");
		log.info("Entering EstDailyHours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHoursField"));
		element_Actions.findElement(obj.getElement("estDailyHoursField"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		Thread.sleep(5000);
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(estDailyHours);
		log.info("EstDailyHours entered successfully");
		log.info("Entering StartDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(3000);
		List<WebElement> todayDate = element_Actions.findElements(obj.getElement("todayStartDate"));
		System.out.println("size of the list before clicking on 1st confirm " +todayDate.size());
		todayDate.get(0).click();
		Thread.sleep(2000);
		log.info("StartDate entered successfully");
		log.info("Entering EndDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.findElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(enddate);
		Thread.sleep(2000);
		log.info("EndDate entered successfully");
		log.info("Entering StartTime");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		element_Actions.findElement(obj.getElement("jobStartTime"));
		element_Actions.sendKeys(startTime);
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("hourStartTime"));
		element_Actions.findElement(obj.getElement("hourStartTime"));
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("minStartTime"));
		element_Actions.findElement(obj.getElement("minStartTime"));
		element_Actions.click();
		log.info("StartTime entered successfully");
		log.info("Entering Availability");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		element_Actions.sendKeys(availability);
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Availabilit entered successfully");
		log.info("Entering JobSite");
		Thread.sleep(5000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField"));
		element_Actions.sendKeys(jobSite);
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectHiringJobSiteField"));
		for(WebElement jobSites:jobSiteOptions) {
			String value = jobSites.getText();
			if(value.equalsIgnoreCase("New York, NY 10020, USA")){
				jobSites.click();
				break;
			}
		}
		log.info("JobSite entered successfully");
		log.info("Entering JobTitle");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField"));
		element_Actions.sendKeys(jobTitle);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("selectJobTitle"));
		element_Actions.findElement(obj.getElement("selectJobTitle"));
		element_Actions.click();
		List<WebElement> jobTitleOption= element_Actions.findElements(obj.getElement("selectJobTitle"));
		for(WebElement jobTitles:jobTitleOption) {
			String jobName = jobTitles.getText();
			if(jobName.equalsIgnoreCase("Administrative Service")){
				jobTitles.click();
				break;
			}
		}
		Thread.sleep(3000);
		log.info("JobTitle entered successfully");
		log.info("Entering No Of Workers");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		element_Actions.findElement(obj.getElement("noOfWorkers"));
		element_Actions.sendKeys(noOfWorker);
		log.info("NoOfWorkers entered successfully");
		log.info("Entering ESignature");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignatureJobOrder"));
		element_Actions.findElement(obj.getElement("esignatureJobOrder"));
		element_Actions.sendKeys(eSignature);
		log.info("ESignature entered successfully");
		log.info("clickAgreeContract");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		element_Actions.click();
		log.info("clickAgreeContract successfully");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		List<WebElement> confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 1st confirm " +confirmButton.size());
		confirmButton.get(0).click();
		Thread.sleep(2000);
		confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 2nd confirm " +confirmButton.size());
		confirmButton.get(1).click();
		Thread.sleep(3000);
		log.info("Job order link present on the home page clicked");
		Thread.sleep(3000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderConfirmID"));
		String hiringJobId=element_Actions.findElement(obj.getElement("jobOrderConfirmID")).getText();
		System.out.println("Hiring Job order Id Is : " +hiringJobId);
		Thread.sleep(5000);
		driver.navigate().refresh();
		log.info("Verify Job Order Id and Email Successfully");
		return hiringJobId;
	}
	public void selectParticularJobOrderFromListing(String hiringJobId) throws InterruptedException
	 {
		log.info("Selecting Particular Joborder on the listing");
		Thread.sleep(10000);
		System.out.println("JobOrderId= ****** "+ hiringJobId );
		List<WebElement> listOrder=element_Actions.findElements(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
		listOrder.get(1).click();
		log.info("Particular Joborder on the listing selected successfully");
	}
	public void ClaimOrderForStaffing(String noOfEmployeesClaim, String employeePayRate, String eSignature,
			String alphabetValue, String specialCharacterValue, String jobOrderId) throws InterruptedException {
		log.info("Clicking Job orders menu present on the staffing homepage navigates to joborder listing form ");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("jobOrders"));
		element_Actions.findElement(obj.getElement("jobOrders"));
		element_Actions.scrollElementIntoView();
		Thread.sleep(5000);
		element_Actions.click();
		log.info(
				"All job orders menu present on the staffing hompage clicked successfully and navigates to joborder listing form  .");
		Thread.sleep(3000);
		List<WebElement> elements = element_Actions.findElements(obj.getElement("availableOrderButtonClaim"));
		Thread.sleep(3000);
		elements.get(0).click();
		log.info("Available Order Button clicked successfully");
		Thread.sleep(5000);
		selectParticularJobOrderFromListing(jobOrderId);
		log.info("Clicking on Claim order Button");
		element_Actions.waitAndFindElement(obj.getElement("claimOrderButton"));
		element_Actions.findElement(obj.getElement("claimOrderButton"));
		element_Actions.click();
		log.info("Claim order button clicked successfully");
		log.info("Entering the No. of Employees Claim");
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("noOfEmployeesClaim"));
		element_Actions.findElement(obj.getElement("noOfEmployeesClaim")).sendKeys(noOfEmployeesClaim);
		log.info("No. of Employees Claim entered successfully");
		Thread.sleep(3000);
		log.info("Entering the E-Signature");
		element_Actions.waitAndFindElement(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(eSignature);
		log.info("E-Signature entered successfully");
		log.info("Clicking on Agree to Contract Button");
		element_Actions.waitAndFindElement(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		element_Actions.click();
		log.info("Agree to Contract Button clicked successfully");
		log.info("Clicking on Submit Claim Button");
		element_Actions.waitAndFindElement(obj.getElement("submitClaimButton"));
		element_Actions.findElement(obj.getElement("submitClaimButton"));
		element_Actions.click();
		log.info("Submit Claim Button clicked successfully");
		Thread.sleep(5000);
	}
	public void ApproveClaimFromHiring(String approveCount,String jobOrderId) throws InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Order menu present on the staffing hompage clicked successfully.");
		log.info("Clicking All orders menu present on the staffing homepage");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("All orders menu present on the staffing hompage clicked successfully.");
		selectParticularJobOrderFromListing(jobOrderId);
		log.info("Clicking on the claim button navigates to claim order form ");
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("claimsButton"));
		element_Actions.findElement(obj.getElement("claimsButton"));
		element_Actions.click();
		log.info("Clicking on the claim button navigates to claim order form successfully");
		log.info("Clicking the select head count button on the claim order form");
		element_Actions.waitAndFindElement(obj.getElement("selectHeadCountButton"));
		element_Actions.findElement(obj.getElement("selectHeadCountButton"));
		element_Actions.click();
		log.info("Clicked the select head count button on the claim order form successfully");
		log.info("Entering Approve count should not be greater than Workerscount");
		element_Actions.waitAndFindElement(obj.getElement("modalApproveCount"));
		element_Actions.findElement(obj.getElement("modalApproveCount")).sendKeys(approveCount);
		Thread.sleep(3000);
		log.info("Approve count is not more than the workers count");
		log.info("Clicking on modal submit Button");
		element_Actions.waitAndFindElement(obj.getElement("modalSubmitButton"));
		element_Actions.findElement(obj.getElement("modalSubmitButton"));
		element_Actions.click();
		log.info("Modal submit button clicked successfully");
	}
	public void AssignEmployee(String miles, String employeeId,String jobOrderId) throws IOException, InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		element_Actions.click();
		log.info("Order menu present on the staffing hompage clicked successfully.");
		log.info("Clicking All orders menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.click();
		log.info("All orders menu present on the staffing hompage clicked successfully.");
		selectParticularJobOrderFromListing(jobOrderId);
		log.info("Clicking Assign employees under the related section");
		element_Actions.waitAndFindElement(obj.getElement("buttonAssignEmployees"));
		element_Actions.findElement(obj.getElement("buttonAssignEmployees"));
		element_Actions.click();
		log.info("Clicked assign employees on job order form successfully");
		log.info("Entering Distance radius in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("distanceRadiusValue"));
		element_Actions.findElement(obj.getElement("distanceRadiusValue"));
		element_Actions.selectDropdownByValue(miles);
		log.info("Distance radius in new Assign Employee form entered successfully");
		log.info("Clicking CheckBox ShowAllEmployees");
		element_Actions.waitAndFindElement(obj.getElement("checkBoxShowAllEmployees"));
		element_Actions.findElement(obj.getElement("checkBoxShowAllEmployees"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info(" ShowAllEmployees CheckBox clicked successfully");
		log.info("Clicking AddRow in new Assign Employee form ");
		element_Actions.scrollToTheBottom();
		Thread.sleep(5000);
		element_Actions.waitAndFindElement(obj.getElement("addRowButton"));
		element_Actions.findElement(obj.getElement("addRowButton"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("AddRow button in new Assign Employee form clicked successfully");
		log.info("Entering employeeId in new Assign Employee form ");
		element_Actions.waitAndFindElement(obj.getElement("employeeIDValue"));
		element_Actions.findElement(obj.getElement("employeeIDValue"));
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("enterEmployeeIDValue"));
		Thread.sleep(5000);
		element_Actions.sendKeys(employeeId);
		element_Actions.findElement(obj.getElement("employeeNameValue"));
		element_Actions.click();
		log.info("employeeId in new Assign Employee form entered successfully");
		log.info("Clicking save new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("save button in new Assign Employee form clicked successfully");
		log.info("Clicking on Close Icon");
		element_Actions.waitAndFindElement(obj.getElement("modalCloseIcon"));
		element_Actions.findElement(obj.getElement("modalCloseIcon"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Close Icon clicked successfully");
		log.info("Clicking save new Assign Employee form");
		element_Actions.waitAndFindElement(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("save button in new Assign Employee form clicked successfully");
		log.info("Clicking yes on warning modal ");
		element_Actions.waitAndFindElement(obj.getElement("yesButtonWarningModal"));
		element_Actions.findElement(obj.getElement("yesButtonWarningModal"));
		element_Actions.click();
		log.info("yes Button on warning modal clicked successfully");
	}
	public void createTimesheetHiring(String dateTimeSheet,String startTimeTimeSheet,String endTimeTimeSheet,String jobOrderId) throws InterruptedException{
		log.info("Clicking on order Button");
		element_Actions.waitAndFindElement(obj.getElement("order"));
		element_Actions.findElement(obj.getElement("order"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info(" Order Button clicked successfully");
		log.info("Clicking on All order Button");
		element_Actions.waitAndFindElement(obj.getElement("allOrderButton"));
		element_Actions.findElement(obj.getElement("allOrderButton"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("All Order Button clicked successfully");
		Thread.sleep(2000);
		selectParticularJobOrderFromListing(jobOrderId);
		Thread.sleep(2000);
		log.info(" Clicking On Timesheet Button");
		element_Actions.waitAndFindElement(obj.getElement("timesheets"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Clicked On Timesheet Button successfully");
		log.info(" Clicking On add Edit Timesheet Button");
		element_Actions.waitAndFindElement(obj.getElement("addEditButton"));
		element_Actions.click();
		Thread.sleep(5000);
		log.info("Clicked On add Edit Timesheet Button successfully");
		log.info("Entering current date in Timesheet");
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		Thread.sleep(2000);
		List<WebElement> todayDate = element_Actions.findElements(obj.getElement("todayDate"));
		System.out.println("size of the list before clicking on 1st confirm " +todayDate.size());
		todayDate.get(4).click();
		Thread.sleep(2000);
		log.info("Entered current date in Timesheet successfully");
		log.info("Verify Start Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDateField"));
		element_Actions.findElement(obj.getElement("startDateField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startTimeTimeSheet);
		Thread.sleep(4000);
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		log.info("Verify Start Time Field successfully");
		log.info("Verify End Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDateField"));
		element_Actions.findElement(obj.getElement("endDateField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(endTimeTimeSheet);
		Thread.sleep(4000);
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		log.info("Verify End Time Field successfully");	
		log.info("Submitting Timesheet ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("submitTimesheet"));
		element_Actions.findElement(obj.getElement("submitTimesheet"));
		element_Actions.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		log.info(" Timesheet Submit successfully");	
	}
	public void approveTimesheetFromStaffing(String jobOrderId) throws InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		element_Actions.click();
		log.info("Order menu present on the staffing hompage clicked successfully.");
		log.info("Clicking All orders menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.click();
		log.info("All orders menu present on the staffing hompage clicked successfully.");
		selectParticularJobOrderFromListing(jobOrderId);
		log.info("Clicking On Timesheet");
		element_Actions.waitAndFindElement(obj.getElement("timesheets"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Click On Timesheet successfully");
		log.info("Clicking On Actions");
		element_Actions.waitAndFindElement(obj.getElement("actionsBotton"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Click On Actions successfully");
		log.info("Selecting Approve Timesheet Option");
		element_Actions.waitAndFindElement(obj.getElement("approveTimesheet"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Select Approve Timesheet Option successfully");
		log.info("Confirm Timesheet Submit");
		element_Actions.waitAndFindElement(obj.getElement("yesButton"));
		element_Actions.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		log.info("Timesheet Submit successfully");
	}
}