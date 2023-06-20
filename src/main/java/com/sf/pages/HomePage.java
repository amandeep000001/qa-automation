package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class HomePage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public HomePage(SelfHealingDriver driver, Logger log) throws IOException {
		super("HomePage.properties");
		obj = new ObjectRepository("HomePage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickCompanyLinkOnHomePage() throws InterruptedException {
		log.info("Clicking Company link present on the homepage");
		element_Actions.waitAndFindElement(obj.getElement("companyLink"));
		element_Actions.findElement(obj.getElement("companyLink"));
		element_Actions.click();
		log.info("Company link present on the hompage clicked successfully.");
	}

	public void clickUsersLinkOnHomePage() {
		log.info("Clicking Users link present on the homepage");
		element_Actions.waitAndFindElement(obj.getElement("userLink"));
		element_Actions.findElement(obj.getElement("userLink"));
		element_Actions.click();
		log.info("Users link present on the hompage clicked successfully.");
	}

	public void clickOrdersMenuOnStaffingHomePage() throws InterruptedException {
		log.info("Clicking Order menu present on the staffing homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersMenu"));
		element_Actions.findElement(obj.getElement("ordersMenu"));
		element_Actions.click();
		log.info("Order menu present on the staffing hompage clicked successfully.");
	}
	
	public void clickOrdersMenuOnHiringHomePage() throws InterruptedException {
		log.info("Clicking Order menu present on the Hiring homepage");
		element_Actions.waitAndFindElement(obj.getElement("ordersHiring"));
		element_Actions.findElement(obj.getElement("ordersHiring"));
		element_Actions.click();
		log.info("Order menu present on the Hiring hompage clicked successfully.");
	}

	public void clickAllOrdersOnStaffingHomePage() {
		log.info("Clicking All orders menu present on the homepage");
		element_Actions.waitAndFindElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.findElement(obj.getElement("allOrdersSubMenu"));
		element_Actions.click();
		log.info("All orders menu present on the  hompage clicked successfully.");
	}

	public String verifyPleaseReviewSubmittedClaimsMessage() {
		log.info("Check for 'Please review submitted claims' message Displayed");
		element_Actions.waitAndFindElement(obj.getElement("message"));
		String message = element_Actions.findElement(obj.getElement("message")).getText();
		log.info("Message displayed successfully");
		return message;
	}

	public void clickOnProfileIcon() {
		element_Actions.waitAndFindElement(obj.getElement("profileIcon"));
		element_Actions.click();
	}

	public void logout() throws InterruptedException {
		clickOnProfileIcon();
		Thread.sleep(3000);
		element_Actions.waitAndFindElement(obj.getElement("logoutButton"));
		Thread.sleep(3000);
		element_Actions.click();
	}

	public void clickOnAddEmployeeOnLeftMenu() throws InterruptedException {
		element_Actions.waitAndFindElement(obj.getElement("employeesLinkOnSideMenu"));
		Thread.sleep(2000);
		element_Actions.click();
	}

	public void clickHomePageLink() {
		element_Actions.waitAndFindElement(obj.getElement("clickHomePageButton"));
		element_Actions.click();
	}
}