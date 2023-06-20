package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class VerifyFieldNewHiringOrderPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public VerifyFieldNewHiringOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
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
	public boolean verifyAvailabilityFieldShouldDropdownField() {
		log.info("Verify Availability Field Should have Dropdown");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		boolean display = element_Actions.findElement(obj.getElement("availability")).isDisplayed();
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Verifyied Availability Field Should have Dropdown");
		return  display;
	}
	public boolean verifyRateFieldAutomaticallyFetchedAndEditable() throws InterruptedException {
		log.info("Verifying Rate Field Should be Automatically Fetched And Editable");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField")).click();
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectHiringJobSiteField"));
		for(WebElement jobSite:jobSiteOptions) {
			String value = jobSite.getText();
			if(value.equalsIgnoreCase("New York, NY 10020, USA")){
				jobSite.click();
				break;
			}
		}
		log.info("Verifying Job Title Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField")).click();
		List<WebElement> jobTitleOption= element_Actions.findElements(obj.getElement("selectJobTitle"));
		for(WebElement jobTitle:jobTitleOption) {
			String jobTitleName = jobTitle.getText();
			if(jobTitleName.equalsIgnoreCase("Administrative Service")){
				jobTitle.click();
				break;
			}
		}
		log.info("Verifying Category Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryField"));
		element_Actions.scrollElementIntoView();
		Thread.sleep(2000);
        element_Actions.findElement(obj.getElement("categoryField"));
		log.info("Verifyied Category Field and Job Title");
		log.info("Verifying rate Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("rateField"));
		boolean display=element_Actions.findElement(obj.getElement("rateField")).isDisplayed();
		String rate = element_Actions.findElement(obj.getElement("rateField")).getAttribute("value");
		System.out.println("The rate is : " +rate);
		log.info("Verifyied Rate Field Should be Automatically Fetched And Editable");
		return  display;
	}	
}