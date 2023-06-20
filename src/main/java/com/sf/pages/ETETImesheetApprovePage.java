package com.sf.pages;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class ETETImesheetApprovePage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public ETETImesheetApprovePage(SelfHealingDriver driver, Logger log) throws IOException {
		super("TimesheetCreationPage.properties");
		obj = new ObjectRepository("TimesheetCreationPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void approveTimesheetFromStaffing() throws InterruptedException {
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
		log.info("Timesheet Submit successfully");
	}
}