package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class StaffingHomePage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public StaffingHomePage(SelfHealingDriver driver, Logger log) throws IOException {
		super("StaffingHomePage.properties");
		obj = new ObjectRepository("StaffingHomePage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void clickOrdersMenuOnStaffingHomePage() throws InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("Order menu present on the staffing hompage clicked successfully.");
	}
	public void clickAllOrdersOnStaffingHomePage() throws InterruptedException {
		log.info("Clicking All orders menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		Thread.sleep(2000);
		element_Actions.click();
		log.info("All orders menu present on the staffing hompage clicked successfully.");
	}
	public void clickJobOrderHomePage() throws InterruptedException {
		log.info("Clicking Job orders menu present on the staffing homepage navigates to joborder listing form ");
		element_Actions.waitAndFindElement(obj.getElement("jobOrders"));
		element_Actions.findElement(obj.getElement("jobOrders"));
		element_Actions.scrollElementIntoView();
		Thread.sleep(2000);
		element_Actions.click();
		log.info("All job orders menu present on the staffing hompage clicked successfully and navigates to joborder listing form  .");
	}

public void clickATSMenuOnStaffingHomePage() 
	{
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("atsMenu"));
		element_Actions.findElement(obj.getElement("atsMenu"));
		element_Actions.click();
		log.info("ATS menu present on the staffing hompage clicked successfully.");
	}
	public boolean verifyOnboardingMenuOnStaffingHomePage() 
	{
		log.info("Verify Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("onboardingMenu"));
		Boolean Display=element_Actions.findElement(obj.getElement("onboardingMenu")).isDisplayed();
		log.info("onboardingMenu displayed successfully.");
		return Display;
	}
	public boolean verifySetUpMenuOnStaffingHomePage() 
	{
		log.info("Verify setup menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("setUpMenu"));
		Boolean Display=element_Actions.findElement(obj.getElement("setUpMenu")).isDisplayed();
		log.info("Setup menu displayed successfully.");
		return Display;
	}
	public void clickOnboardingMenuOnStaffingHomePage() 
	{
		log.info("Clicking Onboarding menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("onboardingMenu"));
		element_Actions.findElement(obj.getElement("onboardingMenu"));
		element_Actions.click();
		log.info("Onboarding menu present on the staffing hompage clicked successfully.");
	}

	public void clickSetUpOptionUnderTheATS() 
	{
		log.info("Clicking on the set up menu under the ATS option");
		element_Actions.waitAndFindElement(obj.getElement("setUpMenu"));
		element_Actions.findElement(obj.getElement("setUpMenu"));
		element_Actions.click();
		log.info("clicked set up menu under the ATS option present on the staffing homepage successfully.");
	}



	public String verifyPleaseAssignEmployeeMessage()
	{
		log.info("Check for 'Please Assign Employee' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("msgApproveAssignEmployee"));
		String message = element_Actions.findElement(obj.getElement("msgApproveAssignEmployee")).getText();
		log.info("Message displayed successfully");
		return message;
	}
	
}

