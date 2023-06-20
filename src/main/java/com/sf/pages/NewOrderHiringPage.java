package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class NewOrderHiringPage extends ObjectRepository{
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public NewOrderHiringPage(SelfHealingDriver driver, Logger log) throws IOException {
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
	public void clickSave() {
		log.info("Clicking on Save Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		log.info("Save Button clicked successfully");
	}
	public String verifyMandatoryFieldIsBlank() {
		log.info("verifying Mandatory Field");
		element_Actions.waitAndFindElement(obj.getElement("msgprint", 2000));
		String mandatoryFields = element_Actions.getElementText();
		log.info("verify Mandatory Field successfully ");
		return mandatoryFields;
	}
	public void closeBlankMandatoryFieldDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeMandatoryFieldDialogBox"));
		element_Actions.click();
	}
	public boolean verifyPopupForMandatoryFieldIsBlank() {
		boolean value=false;
		element_Actions.waitUntilVisibilityLocated(obj.getElement("blankMandatoryFieldError"));
		String messageHeading = element_Actions.waitAndFindElement(obj.getElement("blankMandatoryFieldError")).getText();
		if(messageHeading.contains("Please Fill Mandatory Fields:")&& messageHeading.contains("Select Job"))
		{
			value= true;
		}
		return value;
	}
}