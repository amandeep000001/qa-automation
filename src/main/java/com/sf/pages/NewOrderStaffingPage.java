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
public class NewOrderStaffingPage extends ObjectRepository{
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	Functions fun ;
	public NewOrderStaffingPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderPage.properties");
		obj = new ObjectRepository("JobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
		fun = new Functions();
	}
	public void clickOrder() {
		log.info("Clicking on  Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("clickOrder"));
		element_Actions.findElement(obj.getElement("clickOrder"));
		element_Actions.click();
		log.info(" Order Button clicked successfully");
	}
	public void selectAllOption() {
		log.info("Clicking on All Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("selectAllFromOrder"));
		element_Actions.findElement(obj.getElement("selectAllFromOrder"));
		element_Actions.click();
		log.info("All Button clicked successfully");
	}
	public void clickAddJobOrder() {
		log.info("Clicking on Add Job Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("addJobOrder"));
		element_Actions.findElement(obj.getElement("addJobOrder"));
		element_Actions.click();
		log.info(" Add Job Order clicked successfully");
	}
	public void clickSaveButton() {
		log.info("Clicking on Save Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save Button clicked successfully");		
	}
	public String verifyPopupMandatoryFieldsBlank() {
		log.info("Verifying Pop-up If click On Save Without Entering Mandatory Fields");
		element_Actions.waitAndFindElement(obj.getElement("msgprint", 2000));
		String mandatoryFields = element_Actions.getElementText();
		log.info("Verify Pop-up If click On Save Without Entering Mandatory Fields successfully ");
		return mandatoryFields;
	}
	public void closeBlankMandatoryFieldDialogBox() {
		element_Actions.waitUntilVisibilityLocated(obj.getElement("closeEmptyMandatoryFieldDialogBox"));
		element_Actions.findElement(obj.getElement("closeEmptyMandatoryFieldDialogBox"));		
		element_Actions.click();
	}
	public boolean verifyCompanyFieldShouldVisible() {
		log.info("Verifying Company Field Should Visible on Job order creation form");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("companyField"));
		Boolean display=element_Actions.findElement(obj.getElement("companyField")).isDisplayed();
		element_Actions.click();
		log.info("Company Field is Visible on Job order creation form");	
		return display;
	}
	public boolean verifycategoryFieldStaffingShouldVisible() throws InterruptedException {
		log.info("Verifying Category Field");
		log.info("Verifying company Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("companyField"));
		element_Actions.findElement(obj.getElement("companyField")).click();
		List<WebElement> companyList= element_Actions.findElements(obj.getElement("selectCompany"));
		for(WebElement company:companyList) {
			String companyName = company.getText();
			if(companyName.equalsIgnoreCase("Exclusive maruti suzuki")){
				company.click();
				break;
			}
		}
		log.info("Verifying Job Site Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField")).click();
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectJobSiteField"));
		for(WebElement jobSite:jobSiteOptions) {
			String value = jobSite.getText();
			if(value.equalsIgnoreCase("New York, NY 10011, USA-13")){
				jobSite.click();
				break;
			}
		}
		log.info("Verifying Job Title Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField")).click();
		List<WebElement> jobTitleOption= element_Actions.findElements(obj.getElement("selectJobTitleArc"));
		for(WebElement jobTitle:jobTitleOption) {
			String name = jobTitle.getText();
			if(name.equalsIgnoreCase("Architect")){
				jobTitle.click();
				break;
			}
		}
		log.info("Verify Category Field");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryFieldStaffing"));
		element_Actions.scrollElementIntoView();
		Thread.sleep(2000);
		Boolean display = element_Actions.findElement(obj.getElement("categoryFieldStaffing")).isDisplayed();
		log.info("Verifyied Category Field and Job Title");
		return  display;
	}
	public boolean verifyAvailabilityFieldShouldDropdownField() {
		log.info("Verify Availability Field Should have Dropdown");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		Boolean display = element_Actions.findElement(obj.getElement("availability")).isDisplayed();
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Verifyied Availability Field Should have Dropdown");
		return  display;
	}
	public boolean verifyRateFieldShouldAutomaticallyFetched() throws InterruptedException {
		log.info("Verifying Rate Field Should be Automatically Fetched And Editable");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField")).click();
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectJobSiteField"));
		for(WebElement jobSite:jobSiteOptions) {
			String value = jobSite.getText();
			if(value.equalsIgnoreCase("New York, NY 10011, USA-13")){
				jobSite.click();
				break;
			}
		}
		log.info("Verifying Job Title Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField")).click();
		List<WebElement> jobTitleOptions= element_Actions.findElements(obj.getElement("selectJobTitleArc"));
		for(WebElement jobTitle:jobTitleOptions) {
			String name = jobTitle.getText();
			if(name.equalsIgnoreCase("Architect")){
				jobTitle.click();
				break;
			}
		}
		log.info("Verifying Category Field");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryFieldStaffing"));
		element_Actions.findElement(obj.getElement("categoryFieldStaffing"));
		log.info("Verifyied Category Field and Job Title");
		log.info("Verifying rate Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("rateField"));
		Boolean display=element_Actions.findElement(obj.getElement("rateField")).isDisplayed();
		String rate = element_Actions.findElement(obj.getElement("rateField")).getAttribute("value");
		System.out.println("The rate is : " +rate);
		log.info("Verifyied Rate Field Should be Automatically Fetched And Editable");
		return  display;
	}
	public boolean verifyStartDateField() throws InterruptedException {
		log.info("Verify Start Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		Boolean display=element_Actions.findElement(obj.getElement("startDate")).isDisplayed();
		log.info("Verify Start Date Field successfully");
		return  display;
	}
	public boolean verifyEndDateField() {
		log.info("Verify End Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		Boolean display=element_Actions.findElement(obj.getElement("endDate")).isDisplayed();
		log.info("Verify End Date Field successfully");
		return  display;
	}
	public boolean verifyStartTimeField() {
		log.info("Verify Start Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		Boolean display=element_Actions.findElement(obj.getElement("jobStartTime")).isDisplayed();
		log.info("Verify Start Time Field successfully");
		return  display;
	}
	public boolean verifyJobSiteField() {
		log.info("Verify Job Site Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		Boolean display=element_Actions.findElement(obj.getElement("jobSiteField")).isDisplayed();
		log.info("Verify Job Site Field successfully");
		return  display;
	}
	public boolean verifyEstimatedDailyHoursField() {
		log.info("Verify Estimated Daily HoursTime ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHours"));
		Boolean display=element_Actions.findElement(obj.getElement("estDailyHours")).isDisplayed();
		log.info("Verify Estimated Daily Hours Field successfully");
		return  display;
	}
	public void enterEstHours(String estimatedHours) throws InterruptedException {
		log.info("Entering the Estimated Daily Hours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHours"));
		element_Actions.waitAndFindElement(obj.getElement("estDailyHours"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		Thread.sleep(5000);
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(estimatedHours);
		log.info("Estimated Daily Hours entered successfully");
	}
	public String verifyEstimatedDailyHoursFieldNotAcceptHoursMoreThan24() {
		log.info("Entering the Estimated Daily Hours More Than 24 ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton")).click();
		element_Actions.waitAndFindElement(obj.getElement("msgprint", 2000));
		String mandatoryFields = element_Actions.getElementText();
		log.info("verifyed Estimated Daily Hours Field Not Accept Hours More Than 24");
		return mandatoryFields;
	}
	public void closeEstimatedDailyhoursDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeEstimatedFieldDialogBox"));
		element_Actions.click();
	}
	public boolean verifyNoOfWorkersFieldShouldVisible() {
		log.info("Verifying Rate Field Should be Automatically Fetched And Editable");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField")).click();
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectJobSiteField"));
		for(WebElement jobSite:jobSiteOptions) {
			String value = jobSite.getText();
			if(value.equalsIgnoreCase("New York, NY 10011, USA-13")){
				jobSite.click();
				break;
			}
		}
		log.info("Verifying Job Title Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField")).click();
		List<WebElement> jobTitleOptions= element_Actions.findElements(obj.getElement("selectJobTitleArc"));
		for(WebElement jobTitle:jobTitleOptions) {
			String name = jobTitle.getText();
			if(name.equalsIgnoreCase("Architect")){
				jobTitle.click();
				break;
			}
		}
		log.info("Verifying Category Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryFieldStaffing"));
		element_Actions.findElement(obj.getElement("categoryFieldStaffing"));
		log.info("Verifyied Category Field and Job Title");
		log.info("Verifying No of Worker Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		Boolean display=element_Actions.findElement(obj.getElement("noOfWorkers")).isDisplayed();
		log.info("Verifyied No of Worker Should be No of Worker Visible");
		return  display;
	}
	public boolean verifyAgreeToContractFieldShouldBeCheckbox() {
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		Boolean display =element_Actions.findElement(obj.getElement("agreeToContract")).isDisplayed();
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		return display;
	}
	public boolean verifyPopupForConfirmJobOrderDetails() throws InterruptedException{
		log.info("Verify Availability Field Should have Dropdown");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		Boolean display =element_Actions.findElement(obj.getElement("availability")).isDisplayed();
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Verifyied Availability Field Should have Dropdown");
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract")).click();
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		log.info("Clicking on Save Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Verifying Pop-up If click On Save for Confirm job order");
		return display;
	}
	public void enterHours(String estHours) throws InterruptedException {
		log.info("Entering the Estimated Daily Hours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHours"));
		element_Actions.findElement(obj.getElement("estDailyHours"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		Thread.sleep(5000);
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(estHours);
		log.info("Estimated Daily Hours entered successfully");
	}
	public void enterTime(String time) throws InterruptedException {
		log.info("Verify Start Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		element_Actions.findElement(obj.getElement("jobStartTime"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(time);
		Thread.sleep(2000);
		log.info("Verify Start Time Field successfully");	
	}
	public boolean verifyConfirmationPopupShouldHaveConfirmAndButton() throws InterruptedException {
		log.info("Verify Confirmation Popup Should Have Confirm  Buttons");
		Thread.sleep(1000);
		Boolean display=element_Actions.findElement(obj.getElement("confirmButtonConfirmJoborder")).isDisplayed();
		log.info("Verify Confirmation Popup Should Have Confirm  Buttons successfully");
		return  display;
	}
	public boolean verifyConfirmationPopupShouldHaveCancelButton() throws InterruptedException {
		log.info("Verify Confirmation Popup Should Have Cancel Buttons");
		Thread.sleep(1000);
		Boolean display=element_Actions.findElement(obj.getElement("modalCancelButtonConfirmJoborder")).isDisplayed();
		log.info("Verify Confirmation Popup Should Have Cancel Buttons");
		return  display;
	}
	public boolean verifyClickingCancelNothingShouldSave() {
		log.info("Verify Clicking Cancel Nothing Should Save");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("modalCancelButtonConfirmJoborder"));
		element_Actions.findElement(obj.getElement("modalCancelButtonConfirmJoborder")).click();
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderFormTitle"));
		Boolean display=element_Actions.findElement(obj.getElement("jobOrderFormTitle")).isDisplayed();
		log.info("Verify successfully Clicking Cancel Nothing Should Save");
		driver.navigate().refresh();
		return display;
	}
	public boolean verifyJobOrderCreateSuccessfullyAndJobOrderIdShouldCreated() throws InterruptedException {
		log.info("Verifying Job Order Create Successfully");
		log.info("Verifying Category Field");
		log.info("Verifying company Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("companyField"));
		element_Actions.findElement(obj.getElement("companyField")).click();
		List<WebElement> companyOptions= element_Actions.findElements(obj.getElement("selectCompany"));
		for(WebElement company:companyOptions) {
			String companyName = company.getText();
			if(companyName.equalsIgnoreCase("Exclusive maruti suzuki")){
				company.click();
				break;
			}
		}
		log.info("Verifying Job Site Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField")).click();
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectJobSiteField"));
		for(WebElement jobSite:jobSiteOptions) {
			String value = jobSite.getText();
			if(value.equalsIgnoreCase("New York, NY 10011, USA-13")){
				jobSite.click();
				break;
			}
		}
		log.info("Verifying Job Title Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField")).click();
		List<WebElement> jobTitleOptions= element_Actions.findElements(obj.getElement("selectJobTitleArc"));
		for(WebElement jobSite:jobTitleOptions) {
			String name = jobSite.getText();
			if(name.equalsIgnoreCase("Architect")){
				jobSite.click();
				break;
			}
		}
		log.info("Verify Availability Field Should have Dropdown");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Verifyied Availability Field Should have Dropdown");
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		Thread.sleep(3000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		Thread.sleep(2000);
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		log.info("Clicking on Save Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		List<WebElement> confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 1st confirm " +confirmButton.size());
		confirmButton.get(0).click();
		Thread.sleep(2000);
		confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 2nd confirm " +confirmButton.size());
		confirmButton.get(1).click();
		log.info("Job order link present on the home page clicked");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderConfirmID"));
		Boolean display=element_Actions.findElement(obj.getElement("jobOrderConfirmID")).isDisplayed();
		Thread.sleep(1000);
		log.info("Verify Job Order Create Successfully");
		return display;
	}
	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("enter Start date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startDate);
		Thread.sleep(2000);
		log.info("Verify enter Start date");
	}
	public void enterEndDate(String endDate) throws InterruptedException {
		log.info("Verify End Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.findElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(endDate);
		Thread.sleep(2000);
		log.info("Verify enter End date");
	}
	public boolean verifyJobOrdersFieldShouldVisibleUnderShortcuts() throws InterruptedException {
		log.info("Verifying Job Order Visible Under Shortcuts");
		Thread.sleep(3000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("shortcutJobOrder"));
		Boolean display=element_Actions.findElement(obj.getElement("shortcutJobOrder")).isDisplayed();
		element_Actions.click();
		Thread.sleep(2000);
		log.info("Verify Job Order Visible Under Shortcuts");
		return display;
	}
	public boolean verifyPopupEmailSentSucessfully() {
		log.info("Verifying Popup Email Sent Sucessfully");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("emailSendSuccessfully"));
		Boolean display=element_Actions.findElement(obj.getElement("emailSendSuccessfully")).isDisplayed();
		log.info("Verify Popup Email Sent Sucessfully");
		return display;
	}
	public boolean verifyClaimHasBeenApprovedPleaseAssignEmployees() {
		log.info("Verify Claim Has Been Approved Please Assign Employees");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("claimJoborderAssignEmployeepopup"));
		Boolean display=element_Actions.findElement(obj.getElement("claimJoborderAssignEmployeepopup")).isDisplayed();
		log.info("Verify Claim Has Been Approved Please Assign Employees");
		return display;
	}
	public boolean verifyAddOrderButtonShouldVisibleOnHomepage() {
		log.info("Verifying Job Order Visible Under Shortcuts");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("addJobOrderButton"));
		Boolean display=element_Actions.findElement(obj.getElement("addJobOrderButton")).isDisplayed();
		log.info("Verify Job Order Visible Under Shortcuts");
		return display;
	}
}