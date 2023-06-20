package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class LoginPage extends ObjectRepository {

	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public LoginPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("Login_Page.properties");
		obj = new ObjectRepository("Login_Page.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
   public void enterUsername(String username) {
		log.info("Entering new user's first name");
		element_Actions.waitAndFindElement(obj.getElement("username"));
		element_Actions.findElement(obj.getElement("username"));
		element_Actions.sendKeys(username);
		log.info("User's first name entered successfully");
		//element_Actions.waitAndFindElement(obj.getElement(username), 20000);
	}
    public void enterPassword(String password) {
		log.info("Entering new user's last name");
		element_Actions.waitAndFindElement(obj.getElement("password"));
		element_Actions.findElement(obj.getElement("password"));
		element_Actions.sendKeys(password);
		log.info("User's last name entered successfully");
	}
	public void clickLoginButton() {
		log.info("Clicking on Login Button");
		element_Actions.waitAndFindElement(obj.getElement("login_button"));
		element_Actions.findElement(obj.getElement("login_button"));
		element_Actions.click();
		log.info("Close Pop Up clicked successfully");
	}
	public boolean checkLoginSuccessfully() {
		log.info("Verifying login");
		element_Actions.waitAndFindElement(obj.getElement("home"));
		element_Actions.findElement(obj.getElement("home"));
		boolean loginsuccessfully= element_Actions.checkElementPresence(obj.getElement("home"));
		log.info("Login Successfully");
		return loginsuccessfully;
	}
}
