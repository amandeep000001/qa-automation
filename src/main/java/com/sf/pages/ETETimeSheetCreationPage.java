package com.sf.pages;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class ETETimeSheetCreationPage extends ObjectRepository{
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public ETETimeSheetCreationPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("TimesheetCreationPage.properties");
		obj = new ObjectRepository("TimesheetCreationPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void createTimesheetHiring(String date,String startTime,String endTime) throws InterruptedException{
		log.info("Verifying Add Edit Timesheet Button Visible On Clicking On Timesheet");
		element_Actions.waitAndFindElement(obj.getElement("timesheets"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Verifying Add Edit Timesheet Button Visible On Clicking On Timesheet successfully");
		log.info("Verifying Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet");
		element_Actions.waitAndFindElement(obj.getElement("addEditButton"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Verify Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet successfully");
		log.info("Verifying Timesheet Detail Should Get Auto-Fetched");
		Thread.sleep(4000);
		element_Actions.waitAndFindElement(obj.getElement("timesheetDetail"));
		log.info("Verify Timesheet Detail Should Get Auto-Fetched successfully");
		log.info("Entering Date");
		element_Actions.waitAndFindElement(obj.getElement("dateField"));
		element_Actions.click();
		Thread.sleep(3000);
		List<WebElement> todayDate = element_Actions.findElements(obj.getElement("todayDate"));
		System.out.println("size of the list before clicking on 1st confirm " +todayDate.size());
		todayDate.get(4).click();
		Thread.sleep(2000);
		log.info("Enter Date successfully ");
		log.info("Verify Start Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDateField"));
		element_Actions.findElement(obj.getElement("startDateField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startTime);
		Thread.sleep(2000);
		log.info("Verify Start Time Field successfully");	
		log.info("Verify End Time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDateField"));
		element_Actions.findElement(obj.getElement("endDateField"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(endTime);
		Thread.sleep(2000);
		log.info("Verify End Time Field successfully");	
		log.info("Enter Date successfully ");
		log.info("Submitting Timesheet ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("submitTimesheet"));
		element_Actions.findElement(obj.getElement("submitTimesheet"));
		element_Actions.click();
		Thread.sleep(2000);
		log.info(" Timesheet Submit successfully");	
	}
}