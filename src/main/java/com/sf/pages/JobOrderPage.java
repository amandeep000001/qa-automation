package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class JobOrderPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public JobOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderPage.properties");
		obj = new ObjectRepository("JobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void clickNewOrder() {
		log.info("Clicking on New Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("neworder"));
		element_Actions.findElement(obj.getElement("neworder"));
		element_Actions.click();
		log.info("New Order Button clicked successfully");
	}
	public void enterCategory(String category) {
		log.info("Entering the category");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("category"));
		element_Actions.findElement(obj.getElement("category"));
		element_Actions.sendKeys(category);
		log.info("Category entered successfully");
	}
	public void enterJobTitle(String job_title) {
		log.info("Entering the Job Title");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobtitle"));
		element_Actions.findElement(obj.getElement("jobtitle"));
		element_Actions.sendKeys(job_title);
		log.info("Job Title entered successfully");
	}
   public void enterStartDate(String startdate) {
		log.info("Entering the Start Date");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startdate"));
		element_Actions.findElement(obj.getElement("startdate"));
		element_Actions.sendKeys(startdate);
		element_Actions.click();
		element_Actions.findElement(obj.getElement("date1")).click();
		log.info("Start Date entered successfully");
	}
	public void enterEndDate(String end_date) {
		log.info("Entering the End Date");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("enddate"));
		element_Actions.findElement(obj.getElement("enddate"));
		element_Actions.click();
		element_Actions.findElement(obj.getElement("date2")).click();
		log.info("End Date entered successfully");
	}
   public void enterStartTime(String start_time) {
		log.info("Entering the Start Time");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobstarttime"));
		element_Actions.findElement(obj.getElement("jobstarttime"));
		element_Actions.click();
		element_Actions.findElement(obj.getElement("timer")).click();
		log.info("Start Time entered successfully");
	}
	public void enterJobOrderStartTime(String start_time) {
		log.info("Entering the Start Time");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobstarttime"));
		element_Actions.findElement(obj.getElement("jobstarttime")).sendKeys(start_time);;
		element_Actions.findElement(obj.getElement("jobstarttime")).sendKeys(Keys.RETURN);
		log.info("Start Time entered successfully");
	}
	public void enterEstDailyHours(String daily_hours) {
		log.info("Entering the Estimated Daily Hours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estdailyhours"));
		element_Actions.findElement(obj.getElement("estdailyhours"));
		element_Actions.sendKeys(daily_hours);
		log.info("Estimated Daily Hours entered successfully");
	}
    public void enterAvailability() {
	    log.info("Entering Availability");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		element_Actions.selectDropdownByIndex(1);
		log.info("Availability entered successfully");
    }
	public void enterAvailabilityByValue(String availability) {
		log.info("Entering Availability");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		element_Actions.selectDropdownByValue(availability);
		log.info("Availability entered successfully");
	}
	public void enterJobSite(String job_site) {
		log.info("Entering the Job Site");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobsite"));
		element_Actions.findElement(obj.getElement("jobsite"));
		element_Actions.sendKeys(job_site);
		element_Actions.findElement(obj.getElement("jobSiteDropdown")).click();
		log.info("Job Site entered successfully");
	}
	public void enterNoOfWorkers(String no_of_workers) {
		log.info("Entering the No. of Workers");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noofworkers"));
		element_Actions.findElement(obj.getElement("noofworkers"));
		element_Actions.sendKeys(no_of_workers);
		log.info("No. of Workers entered successfully");
	}
	public void enterDrivingRecordPrice() {
		log.info("Entering the Driving Record Price");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("drivingrecord"));
		element_Actions.findElement(obj.getElement("drivingrecord"));
		element_Actions.selectDropdownByIndex(1);
		log.info("Driving Record Price entered successfully");
	}
	public void enterExtraPrice(String extra_price) {
		log.info("Entering the Extra Pricing");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("extraprice"));
		element_Actions.findElement(obj.getElement("extraprice"));
		element_Actions.sendKeys(extra_price);
		log.info("Extra Pricing entered successfully");
	}
	public void enterESignature(String signature) {
		log.info("Entering the E-Signature");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(signature);
		log.info("E-Signature entered successfully");
	}
	public void clickAgreeContract() {
		log.info("Clicking on Agree to Contract Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreetocontract"));
		element_Actions.findElement(obj.getElement("agreetocontract"));
		element_Actions.click();
		log.info("Agree to Contract Button clicked successfully");
	}
	public void clickSave() {
		log.info("Clicking on Save Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("savebutton"));
		element_Actions.findElement(obj.getElement("savebutton"));
		element_Actions.click();
		log.info("Save Button clicked successfully");
	}
	public void clickConfirm() {
		log.info("Clicking on Confirm Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("confirm"));
		element_Actions.findElement(obj.getElement("confirm"));
		element_Actions.click();
		log.info("Confirm Button clicked successfully");
	}
	public void clickConfirm2() {
		log.info("Clicking on Confirm Button Again");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("confirm2"));
		element_Actions.findElement(obj.getElement("confirm2"));
		element_Actions.click();
		log.info("Confirm Button clicked Again successfully");
	}
	public boolean checkJobOrderCreation() {
		log.info("Check for creation of Job Order");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("msgprint"));
		element_Actions.findElement(obj.getElement("msgprint"));
		boolean jobOrderCreation= element_Actions.checkElementPresence(obj.getElement("msgprint"));
		log.info("Job Order Created Successfully");
		return jobOrderCreation;
	}
	 public void clickFirstSubmittedClaim() {
		log.info("Clicking on the first submitted claim");
		element_Actions.waitAndFindElement(obj.getElement("jobOrdersList"));
		List<WebElement> jobOrders = element_Actions.findElements(obj.getElement("jobOrdersList"));
		jobOrders.get(0).click();
		log.info("Opens the staffing first new claim successfully.");
	 }
	 public void clickClaimsButton() {
		log.info("Clicking on the claim button navigates to claim order form ");
		element_Actions.waitAndFindElement(obj.getElement("claimsButton"));
		element_Actions.findElement(obj.getElement("claimsButton"));
		element_Actions.click();
		log.info("Clicking on the claim button navigates to claim order form successfully");
	}
	 public void clickSelectHeadCountButton() {
		log.info("Clicking the select head count button on the claim order form");
		element_Actions.waitAndFindElement(obj.getElement("selectHeadCountButton"));
		element_Actions.findElement(obj.getElement("selectHeadCountButton"));
		element_Actions.click();
		log.info("Clicked the select head count button on the claim order form successfully");
	}
	 public void titleSelectHeadCountModal() {
		log.info("Clicking Select Head Count button, a modal should open having a title as 'Select Head Count'");
		element_Actions.waitAndFindElement(obj.getElement("titleHeadcount"));
		element_Actions.findElement(obj.getElement("titleHeadcount"));
		element_Actions.click();
		log.info("clicked Select Head Count button, a modal title as 'Select Head Count'opened successfully");
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
	 public void selectParticularJobOrderFromListingHiring(String hiringJobId) throws InterruptedException 
		{
			Thread.sleep(10000);
			System.out.println("JobOrderId= ****** "+ hiringJobId );
			element_Actions.waitAndFindElement(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
			Thread.sleep(2000);
			element_Actions.click();
		}
	 public void clickCompletedOrdersTab() {
			log.info("Clicking on the Completed Orders Tab ");
			element_Actions.waitAndFindElement(obj.getElement("completedOrderButton"));
			element_Actions.findElement(obj.getElement("completedOrderButton"));
			element_Actions.click();
			log.info("Completed Tab Clicked Successfully");
		}
		public void enterOrderId(String orderId) {
			log.info("Entering the Order ID");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("orderIdInputField"));
			element_Actions.findElement(obj.getElement("orderIdInputField"));
			element_Actions.sendKeys(orderId);
			log.info("Order ID Hours entered successfully");
		}
		public void clickCompletedOrder() throws InterruptedException    {
			log.info("Clicking on the Completed Order ");
			Thread.sleep(2000);
			element_Actions.waitAndFindElement(obj.getElement("completedOrder"));
			element_Actions.click();
			log.info("Completed Order Clicked Successfully");
		}
		public void clickRepeatOrderButton() {
			log.info("Clicking on the Repeat Order Button");
			element_Actions.waitAndFindElement(obj.getElement("repeatOrderButton"));
			element_Actions.findElement(obj.getElement("repeatOrderButton"));
			element_Actions.click();
			log.info("Repeat Order Button Clicked Successfully");
		}
		public void clickOpenOrderCheckbox() {
			log.info("Clicking on the Open Order Checkbox");
			element_Actions.waitAndFindElement(obj.getElement("openOrderCheckbox"));
			element_Actions.findElement(obj.getElement("openOrderCheckbox"));
			element_Actions.click();
			log.info("Open Order Checkbox Clicked Successfully");
		}
		public void clickDirectOrderCheckbox() {
			log.info("Clicking on the Direct Order Checkbox");
			element_Actions.waitAndFindElement(obj.getElement("directOrderCheckbox"));
			element_Actions.findElement(obj.getElement("directOrderCheckbox"));
			element_Actions.click();
			log.info("Direct Order Checkbox Clicked Successfully");
		}
		public void clickProceedButton() {
			log.info("Clicking on the Proceed Button");
			element_Actions.waitAndFindElement(obj.getElement("proceedButton"));
			element_Actions.findElement(obj.getElement("proceedButton"));
			element_Actions.click();
			log.info("Proceed Button Clicked Successfully");
		}
		public void clickSaveAndVerifyPopUp() throws InterruptedException {
			element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
			element_Actions.findElement(obj.getElement("saveButton"));
			element_Actions.click();
			List<WebElement> confirmButton = element_Actions.findElements(obj.getElement("jobOrderConfirmButton"));
			System.out.println("size of the list before clicking on 1st confirm " + confirmButton.size());
			confirmButton.get(0).click();
			Thread.sleep(2000);
			confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
			System.out.println("size of the list before clicking on 2nd confirm " + confirmButton.size());
			confirmButton.get(2).click();
			Thread.sleep(13000);
			element_Actions.refreshWebpage();
		}
		public String getJobSiteText() throws InterruptedException {
			log.info("Getting Job site text");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteValue"));
			String jobSiteValue = element_Actions.findElement(obj.getElement("jobSiteValue")).getText();
			log.info("Got the text successfully");
			return jobSiteValue;
		}
		
		public boolean verifyJobSiteTextIsPresent(String jobSiteValue)
		{
			log.info("Verifying same Job Site present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("jobSiteValue", jobSiteValue));
			log.info("Same job site is present");
			return result;
		}
		
		public String getJobTitleText() throws InterruptedException {
			log.info("Getting Job Title text");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleValue"));
			String jobTitleValue = element_Actions.findElement(obj.getElement("jobTitleValue")).getText();
			log.info("Got the text successfully");
			return jobTitleValue;
		}
		
		public boolean verifyJobTitleTextIsPresent(String jobTitleValue)
		{
			log.info("Verifying same Job Title present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("jobSiteValue", jobTitleValue));
			log.info("Same job Title is present");
			return result;
		}
		
		public String getJobIndustryText() throws InterruptedException {
			log.info("Getting Job Industry text");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("jobIndustryValue"));
			String jobIndustryValue = element_Actions.findElement(obj.getElement("jobIndustryValue")).getText();
			log.info("Got the text successfully");
			return jobIndustryValue;
		}
		
		public boolean verifyJobIndustryTextIsPresent(String jobIndustryValue)
		{
			log.info("Verifying same Job Industry present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("jobIndustryValue", jobIndustryValue));
			log.info("Same job Industry is present");
			return result;
		}

		public String getEstHoursText() throws InterruptedException {
			log.info("Getting getEstHoursText");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("estHoursValue"));
			String getEstHoursText = element_Actions.findElement(obj.getElement("estHoursValue")).getText();
			log.info("Got the text successfully");
			return getEstHoursText;
		}
		
		public boolean verifyEstHoursTextIsPresent(String getEstHoursText)
		{
			log.info("Verifying same Estimated Hours present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("estHoursInputValue", getEstHoursText));
			log.info("Same Estimated Hours is present");
			return result;
		}
		
		public String getNoOfWorkers() throws InterruptedException {
			log.info("Getting Number of Workers");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkersValue"));
			String noOfWorkersValue = element_Actions.findElement(obj.getElement("noOfWorkersValue")).getText();
			log.info("Got the text successfully");
			return noOfWorkersValue;
		}
		
		public boolean verifynoOfWorkersTextIsPresent(String noOfWorkersValue)
		{
			log.info("Verifying same Number of Workers present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("noOfWorkersInputValue", noOfWorkersValue));
			log.info("Same Number of Workers is present");
			return result;
		}
		
		public String getESignature() throws InterruptedException {
			log.info("Getting ESignature Value");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("eSignatureValue"));
			String eSignatureValue = element_Actions.findElement(obj.getElement("eSignatureValue")).getText();
			log.info("Got the text successfully");
			return eSignatureValue;
		}
		
		public boolean verifyESignatureTextIsPresent(String eSignatureValue)
		{
			log.info("Verifying same Esignature present");
			boolean result=  element_Actions
					.checkElementPresence(obj.getElement("esignature", eSignatureValue));
			log.info("Same Esignature is present");
			return result;
		}
		
		public void selectStaffingCompany(String staffCompany) {
			log.info("Entering Staffing Company");
			element_Actions.waitUntilVisibilityLocated(obj.getElement("selectStaffingCompany"));
			element_Actions.findElement(obj.getElement("selectStaffingCompany"));
			element_Actions.sendKeys(staffCompany);
			log.info("Staffing Company entered successfully");
		}
}
