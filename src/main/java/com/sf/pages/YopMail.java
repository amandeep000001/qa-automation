package com.sf.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class YopMail extends ObjectRepository{

	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public YopMail(SelfHealingDriver driver, Logger log) throws IOException {
		super("YopMail.properties");
		obj = new ObjectRepository("YopMail.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	
	
	
	public void enterEmailAddrress(String email)
	{
		element_Actions.waitAndFindElement(obj.getElement("emailField"));
		element_Actions.clearField();
		element_Actions.sendKeys(email);
		
		
	}
	
	public void submitEmailButton()
	{
		element_Actions.waitAndFindElement(obj.getElement("forwardButton"));
		element_Actions.click();
	}
	
	public void clickGoToTAGLInkOnFirstEmail() throws IOException
	{
		element_Actions.switchToFrame("ifmail");
		element_Actions.waitAndFindElement(obj.getElement("buttonTAGOnFirstEmail"));
		element_Actions.click();
		element_Actions.switchToDefault();
	}
	

}
