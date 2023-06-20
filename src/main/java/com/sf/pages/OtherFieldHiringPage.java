package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class OtherFieldHiringPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public  OtherFieldHiringPage (SelfHealingDriver driver, Logger log) throws IOException {
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
	public boolean verifyNoOfWorkersField() {
		log.info("Verify No Of Workers Field Visible");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		boolean display =element_Actions.findElement(obj.getElement("noOfWorkers")).isDisplayed();
		element_Actions.click();
		log.info("Verify No Of Workers Field Visible ");
		return display;
	}
	public boolean verifyESignatureFieldMandatory() {
		log.info("Verify ESignature Field Should Mandatory");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		boolean display =element_Actions.findElement(obj.getElement("esignature")).isDisplayed();
		log.info("Verify ESignature Field Should Mandatory");
		return display;
	}
	public boolean verifyAgreeContractFieldshouldcheckboxAndMandatory() {
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		boolean display =element_Actions.findElement(obj.getElement("agreeToContract")).isDisplayed();
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		log.info("Verify Agree Contract Field should be checkbox And Mandatory");
		return display;
	}
	public void enterESignatureName(String eSignName) {
		log.info("Entering name");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(eSignName);
		log.info("name entered successfully");
	}
	public void closeBlankMandatoryFieldDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeEstimatedFieldDialogBox"));
		element_Actions.findElement(obj.getElement("closeEstimatedFieldDialogBox"));
		element_Actions.click();
	}
}