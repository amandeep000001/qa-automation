package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class VerifyExclusiveNewOrderPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	Functions fun ;
	public VerifyExclusiveNewOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderPage.properties");
		obj = new ObjectRepository("JobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
		fun = new Functions();
	}
	public boolean verifySameJobOrderCreatedForParentStaffingCompany() throws InterruptedException {
		log.info("Clicking on Available order Button");
		element_Actions.waitAndFindElement(obj.getElement("availableOrderButton"));
		boolean display =element_Actions.findElement(obj.getElement("availableOrderButton")).isDisplayed();
		element_Actions.click();
		log.info("Available Order Button clicked successfully");
		log.info("Verifying first job order Button");
		Thread.sleep(5000);
		List<WebElement> jobOrders = element_Actions.findElements(obj.getElement("jobOrdersList"));
		System.out.println("size of job : " + jobOrders.size());
		String jobId =jobOrders.get(0).getText();
		System.out.println(" job id : " +jobId );
		log.info("First job order button Verify successfully");
		return display;
	}
	public void clickOrder() {
		log.info("Clicking on  Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("clickOrder"));
		element_Actions.findElement(obj.getElement("clickOrder"));
		element_Actions.click();
		log.info(" Order Button clicked successfully");
	}
	public void selectAllOption() {
		log.info("Clicking on All Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("selectAllFromOrder"));
		element_Actions.findElement(obj.getElement("selectAllFromOrder"));
		element_Actions.click();
		log.info("All Button clicked successfully");
	}
}