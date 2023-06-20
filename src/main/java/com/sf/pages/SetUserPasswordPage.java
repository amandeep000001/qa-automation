package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class SetUserPasswordPage extends ObjectRepository {

	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public SetUserPasswordPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("SetUserPassword.properties");
		obj = new ObjectRepository("SetUserPassword.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void openYopMail() {

		element_Actions.enterURL("https://yopmail.com/");
	}

	public void enterNewPassword(String password) {
		element_Actions.switchToDesiredWindow(1);
		element_Actions.waitAndFindElement(obj.getElement("newPasswordField"));
		element_Actions.clearField();
		element_Actions.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		element_Actions.waitAndFindElement(obj.getElement("confirmPassowrdField"));
		element_Actions.clearField();
		element_Actions.sendKeys(password);
	}

	public void clickSubmitButton() {
		element_Actions.waitAndFindElement(obj.getElement("submitButton"));
		element_Actions.click();
	}

	public boolean verfiyPasswordSetup() {
		return element_Actions.getCurrentURL().contains("/hiring-home");
	}
	public boolean verfiyPasswordSetupTagAdmin() {
		return element_Actions.getCurrentURL().contains("/tagadmin-page");
	}
	

}
