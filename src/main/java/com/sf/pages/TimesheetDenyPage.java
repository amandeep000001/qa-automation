package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class TimesheetDenyPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public TimesheetDenyPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("TimesheetDenyPage.properties");

		obj = new ObjectRepository("TimesheetDenyPage.properties");

		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickDenyButton() {
		log.info("Clicking on Deny Button");
		element_Actions.findElement(obj.getElement("denyButton"));
		element_Actions.click();
		log.info("Deny Button Clicked Successfully");
	}

	public void clickmodalDenyButton() {
		log.info("Clicking on Modal Deny Button");
		element_Actions.findElement(obj.getElement("modalDenyButton"));
		element_Actions.click();
		log.info("Modal Deny Button Clicked Successfully");
	}

	public void closeMessagePopup() {
		log.info("Clicking on close message Popup approve Button");

		element_Actions.findElement(obj.getElement("closeMessagePopUp"));
		element_Actions.click();
		log.info("Clicked on close message Popup Successfully");
	}

	public String verifyDeniedStatus() {
		log.info("Check for denied status");
		element_Actions.waitAndFindElement(obj.getElement("statusDenied"));
		String message = element_Actions.findElement(obj.getElement("statusDenied")).getText();
		log.info("denied status displayed successfully");
		return message;
	}

}
