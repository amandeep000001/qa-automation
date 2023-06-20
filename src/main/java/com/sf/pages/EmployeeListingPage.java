package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class EmployeeListingPage extends ObjectRepository {

	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public EmployeeListingPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("EmployeeListing.properties");
		obj = new ObjectRepository("EmployeeListing.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void waitForEmployeeListingPageToLoad() {
		element_Actions.waitAndFindElement(obj.getElement("AddNewButton"), 20000);
	}
	
	public void clickAddNewEployeeButton() {
		log.info("Clicking on Add New Employee Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("addNewEmployeeButton"));
		element_Actions.waitAndFindElement(obj.getElement("addNewEmployeeButton",20000));
		element_Actions.click();
		log.info("Employee button clicked successfully");
	}

}
