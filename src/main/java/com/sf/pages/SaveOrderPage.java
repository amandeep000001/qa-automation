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

public class SaveOrderPage  extends ObjectRepository{
	private static final String Admin = null;
	private static final String category = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public SaveOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderPage.properties");
		obj = new ObjectRepository("JobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void newOrder() {
		log.info("Clicking on New Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("newOrder"));
		element_Actions.findElement(obj.getElement("newOrder"));
		element_Actions.click();
		log.info("New Order Button clicked successfully");
	}
	public void enterCategory(String category) {
		log.info("Entering category ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryField"));
		element_Actions.findElement(obj.getElement("categoryField"));
		element_Actions.sendKeys(category);
		log.info("category entered successfully");
	}
	public void enterJobTitle(String jobTitle) throws InterruptedException {
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
		log.info("JobTitle entered successfully");
	}
	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("Entering StartDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startDate);
		Thread.sleep(2000);
		log.info("StartDate entered successfully");
	}
	public void enterEndDate(String enddate) throws InterruptedException {
		log.info("Entering EndDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.findElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(enddate);
		Thread.sleep(2000);
		log.info("EndDate entered successfully");
	}
	public void enterStartTime(String startTime) {
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
	}
	public void enterEstDailyHours(String estDailyHours) throws InterruptedException {
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
	}
	public void enterAvailability(String availability) {
		log.info("Entering Availability");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		element_Actions.sendKeys(availability);
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Availabilit entered successfully");
	}
	public void enterJobSite(String jobSite) throws InterruptedException {
		log.info("Entering JobSite");
		Thread.sleep(3000);
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
	}
	public void enterNoOfWorkers() {
		log.info("Entering No Of Workers");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		element_Actions.findElement(obj.getElement("noOfWorkers"));
		element_Actions.click();
		log.info("NoOfWorkers entered successfully");
	}
	public void enterDrivingRecordPrice() {
		log.info("Entering DrivingRecordPrice");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("drivingRecord"));
		element_Actions.findElement(obj.getElement("drivingRecord"));
		element_Actions.click();
		log.info("DrivingRecordPrice entered successfully");
	}
	public void enterExtraPrice(String extraPrice) {
		log.info("Entering ExtraPrice");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("extraprice"));
		element_Actions.findElement(obj.getElement("extraprice"));
		element_Actions.sendKeys(extraPrice);
		log.info("ExtraPrice entered successfully");
	}
	public void enterESignature(String eSignature) {
		log.info("Entering ESignature");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(eSignature);
		log.info("ESignature entered successfully");
	}
	public void clickSave() {
		log.info("click on save button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("clicked on save button successfully");
	}
	public void clickAgreeContract() {
		log.info("clickAgreeContract");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		element_Actions.click();
		log.info("clickAgreeContract successfully");
	}
	public boolean verifyConfirmJobOrderDetails() {
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("confirmOrderPopup"));
		boolean display =element_Actions.findElement(obj.getElement("confirmOrderPopup")).isDisplayed();
		return display;
	}
	public boolean verifyConfirmationPopupShouldHaveConfirmAndButton() throws InterruptedException {
		log.info("Verify Confirmation Popup Should Have Confirm  Buttons");
		Thread.sleep(1000);
		boolean display=element_Actions.findElement(obj.getElement("confirmButtonConfirmJoborder")).isDisplayed();
		log.info("Verify Confirmation Popup Should Have Confirm  Buttons successfully");
		return  display;
	}
	public boolean verifyConfirmationPopupShouldHaveCancelButton() throws InterruptedException {
		log.info("Verify Confirmation Popup Should Have Cancel Buttons");
		Thread.sleep(1000);
		boolean display=element_Actions.findElement(obj.getElement("modalCancelButtonConfirmJoborder")).isDisplayed();
		log.info("Verify Confirmation Popup Should Have Cancel Buttons");
		return  display;
	}
	
//	public boolean verifyClickingCancelNothingSave() throws InterruptedException {
//		log.info("Verify Clicking Cancel Nothing Should Save");
//		element_Actions.waitUntilVisibilityLocated(obj.getElement("cancelButtonConfirmJoborder"));
//		element_Actions.findElement(obj.getElement("cancelButtonConfirmJoborder")).click();
//		element_Actions.click();
//		Thread.sleep(3000);
//		element_Actions.waitUntilVisibilityLocated(obj.getElement("notSaved"));
//		boolean display=element_Actions.findElement(obj.getElement("notSaved")).isDisplayed();
//		log.info("Verify successfully Clicking Cancel Nothing Should Save");
//		driver.navigate().refresh();
//		return display;
//	}
	public void clickingCancelButton() throws InterruptedException {
		log.info("Clicking on cancel button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("modalCancelButtonConfirmJoborder"));
		element_Actions.findElement(obj.getElement("modalCancelButtonConfirmJoborder"));
		element_Actions.click();
		log.info("Cancelled button clicked successfully");
		driver.navigate().refresh();
	}
	
	public String verifyClickingCancelNothingSave() throws InterruptedException
	{
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("jobOrderFormTitle", 2000));

		String notSaved = element_Actions.getElementText();

		return notSaved;
	}
	
	public boolean verifyJobOrderIdAndPopupEmailSentSuccessfully() throws InterruptedException {
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
		Thread.sleep(2000);
		
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderConfirmID"));
		Thread.sleep(2000);
		boolean display=element_Actions.findElement(obj.getElement("jobOrderConfirmID")).isDisplayed();
		String hiringJobId=element_Actions.findElement(obj.getElement("jobOrderConfirmID")).getText();
		System.out.println("Hiring Job order Id Is : " +hiringJobId);
		log.info("Verify Job Order Id and Email Successfully");
		return display;
	}
	public void enterNoOfWorker(String noOfWorker) {
		log.info("Entering No Of Workers");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		element_Actions.findElement(obj.getElement("noOfWorkers"));
		element_Actions.sendKeys(noOfWorker);
		log.info("NoOfWorkers entered successfully");
	}
}