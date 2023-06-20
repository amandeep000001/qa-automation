package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class StartDateTimeFieldPage  extends ObjectRepository{
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public StartDateTimeFieldPage(SelfHealingDriver driver, Logger log) throws IOException {
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
	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("Entering Start Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.waitAndFindElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(startDate);
		log.info("Start Date entered successfully");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("jobOrderFormTitle")).click();
	}
	public boolean verifyStartDateFieldVisibleAndNotAcceptPastDate() throws InterruptedException {
		log.info("Verifying Start Date Field should be Visible And Should Not Accept Past Date");
		Thread.sleep(5000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDateError"));
		element_Actions.findElement(obj.getElement("startDateError"));
		boolean value=false;
		String messageHeading = element_Actions.waitAndFindElement(obj.getElement("startDateError")).getText();
		if(messageHeading.contains("Start Date Cannot be Past Date"))
		{
			value= true;
		}
		log.info("Verifyied Start Date Field should be Visible And Should Not Accept Past Date");
		return value;
	}
	public void closeStartDateFieldDialogBox() throws InterruptedException {
		element_Actions.waitAndFindElement(obj.getElement("startDateErrorClose"));
		Thread.sleep(2000);
		element_Actions.click();
	}
	public void enterEndDate(String endDate) throws InterruptedException {
		log.info("Entering End Date ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.waitAndFindElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(endDate);
		log.info("End Date entered successfully");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("jobOrderFormTitle")).click();
	}
	public boolean verifyEndDateFieldVisibleAndNotAcceptPastDate() throws InterruptedException {
		log.info("Verifying End Date Field should be Visible And Should Not Accept Past Date");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endtDateError"));
		element_Actions.findElement(obj.getElement("endtDateError"));
		boolean value=false;
		String messageHeading = element_Actions.waitAndFindElement(obj.getElement("endtDateError")).getText();
		if(messageHeading.contains("End Date Cannot be Past Date"))
		{
			value= true;
		}
		log.info("Verifyied End Date Field  Visible And Should Not Accept Past Date");
		return value;
	}
	public void closeEndDateFieldDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("endtDateErrorClose"));
		element_Actions.click();
	}
	public boolean verifyStartTimeFieldShouldVisible() {
		log.info("Verifying Start Time Field should be Visible");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		boolean display=element_Actions.findElement(obj.getElement("jobStartTime")).isDisplayed();
		element_Actions.click();
		log.info("Verifying Start Time Field should be Visible");
		return display;
	}
	public boolean verifyJobSiteFieldShouldVisible() {
		log.info("Verifying Job Site Field should be Visible");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		boolean display=element_Actions.findElement(obj.getElement("jobSiteField")).isDisplayed();
		log.info("Verifying Job Site Field should be Visible");
		return display;
	}
	public void enterStartTime(String startTime) throws InterruptedException {
		log.info("Entering Start time ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("todayStartDate"));
		element_Actions.findElement(obj.getElement("todayStartDate"));
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		element_Actions.waitAndFindElement(obj.getElement("jobStartTime"));
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(startTime);
		Thread.sleep(1000);
		log.info("Start Date entered successfully");
		Thread.sleep(2000);
		element_Actions.waitAndFindElement(obj.getElement("endDate")).click();
	}
	public boolean verifyStartTimeFieldShouldNotAcceptPastTime() throws InterruptedException {
		log.info("verify Start time ");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startTimeError"));
		element_Actions.findElement(obj.getElement("startTimeError"));
		boolean value=false;
		String messageHeading = element_Actions.waitAndFindElement(obj.getElement("startTimeError")).getText();
		if(messageHeading.contains("Past Time Is Not Acceptable"))
		{
			value= true;
		}
		log.info("Verifyied Start Time Field should be Visible And Should Not Accept Past Date");
		return value;
	}
	public void closeStartTmeFieldDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("startTimeErrorClose"));
		element_Actions.click();		
	}
}