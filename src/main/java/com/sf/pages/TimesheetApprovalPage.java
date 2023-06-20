package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class TimesheetApprovalPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public TimesheetApprovalPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("TimesheetApprovalPage.properties");

		obj = new ObjectRepository("TimesheetApprovalPage.properties");

		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickOrder() throws InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		Thread.sleep(3000);
		element_Actions.click();
		Thread.sleep(3000);
		log.info("Order menu present on the staffing hompage clicked successfully.");
	}

	public void selectAllOption() throws InterruptedException {
		log.info("Clicking All orders menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		Thread.sleep(3000);
		element_Actions.click();
		Thread.sleep(3000);
		log.info("All orders menu present on the staffing hompage clicked successfully.");
	}

	public String verifyTimesheetAvailableForApprovalPopup() {
		log.info("Check for 'submit their timesheets' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("displayApprovalMessage"));
		String message = element_Actions.findElement(obj.getElement("displayApprovalMessage")).getText();
		log.info("Message displayed successfully");
		return message;
	} 
	public void ClickingOnTimesheet() throws InterruptedException {
		log.info(" Clicking On Timesheet");
		element_Actions.waitAndFindElement(obj.getElement("timesheets"));
		element_Actions.click();
		Thread.sleep(3000);
	}

	public void clickTimesheetGrid() {
		log.info("Clicking on Timesheet Grid on Job order form");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("timesheetGridButton"));
		element_Actions.findElement(obj.getElement("timesheetGridButton"));
		element_Actions.click();
		log.info("Timesheet Grid Clicked Successfully");
	}

	public boolean timesheetTitleDisplay() {
		log.info("Verify Timesheet Title");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("timesheetTitle"));
		boolean display = element_Actions.findElement(obj.getElement("timesheetTitle")).isDisplayed();
		element_Actions.click();
		log.info("Timesheet Title verified");
		return display;
	}

	public void clickApprovalRequestGrid() {
		log.info("Clicking on Approval Grid");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("timesheetDataApprovalGrid"));
		element_Actions.findElement(obj.getElement("timesheetDataApprovalGrid"));
		element_Actions.click();
		log.info("Timesheet Approval Grid Clicked Successfully");
	}
	public void clickCheckBox() throws InterruptedException {
		log.info("Clicking on checkbox");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("checkbox"));
	    element_Actions.findElement(obj.getElement("checkbox"));
		element_Actions.click();
		Thread.sleep(3000);
		log.info("checkbox Clicked Successfully");
	}

	public boolean verifyEmployeeDetails() {
		log.info("Verify Employee Details");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("timesheetTablegrid"));
		boolean display = element_Actions.findElement(obj.getElement("timesheetTablegrid")).isDisplayed();
		//element_Actions.click();
		log.info("Employee Details verified");
		return display;
	}

	public void clickActionsButton() {
		log.info("Clicking on Action Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("actionsButton"));
		element_Actions.findElement(obj.getElement("actionsButton"));
		element_Actions.click();
		log.info("Action Button Clicked Successfully");
	}

	public void clickApproveButton() {
		log.info("Clicking on approve Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("approveButton"));
		element_Actions.findElement(obj.getElement("approveButton"));
		element_Actions.click();
		log.info("approve Button Clicked Successfully");
	}

	public boolean verifyPopUpAfterClickApproveButton() {
       
        log.info("Clicking on approve Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("approveButton"));
		boolean display = element_Actions.findElement(obj.getElement("approveButton")).isDisplayed();
		//element_Actions.click();
		log.info("approve Button Clicked Successfully");
		log.info("verify Pop-up on Timesheet Approve successfully");
		return display;
	}

	public void closePopupApproveButton() {
		log.info("Clicking on close Popup approve Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("closePopupApproveButton"));
		element_Actions.findElement(obj.getElement("closePopupApproveButton"));
		element_Actions.click();
		log.info("Clicked on close Popup approve Button Successfully");
    }

	public Object verifyUserShouldAbleToSelectTimesheetFromCheckbox() {
        log.info("Clicking on checkbox");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("checkbox"));
		boolean display = element_Actions.findElement(obj.getElement("checkbox")).isDisplayed();
		element_Actions.click();
		log.info("checkbox Clicked Successfully");
		return display;
	}
	
	public String verifyTimesheetUpdatedMessage()
	{
		log.info("Check for 'Timesheet Updated' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("timesheetMsg"));
		String message = element_Actions.findElement(obj.getElement("timesheetMsg")).getText();
		log.info("Message displayed successfully");
		return message;
	}

	public boolean verifyNotificationShouldBeSentToHiringCompanyForApproveTimesheet() {
		log.info("Verifying company Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("notificationHiring"));
		boolean display = element_Actions.findElement(obj.getElement("notificationHiring")).isDisplayed();
		element_Actions.click();
		List<WebElement> notificationList = element_Actions.findElements(obj.getElement("recentNotification"));
		for (WebElement notification : notificationList) {
			String companyName = notification.getText();
			}
		return display;

	}
}
