package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;
public class VerifyFieldNewOrderPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public VerifyFieldNewOrderPage(SelfHealingDriver driver, Logger log) throws IOException {

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
	public void enterEstDailyHours(String estimatedHours) {
		log.info("Entering the Estimated Daily Hours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHoursField"));
		element_Actions.findElement(obj.getElement("estDailyHoursField"));
		element_Actions.sendKeys(estimatedHours);
		log.info("Estimated Daily Hours entered successfully");
	}
	public boolean verifyEstimatedDailyHoursFieldNotAcceptHoursMoreThan24() {
		log.info("Entering the Estimated Daily Hours More Than 24 ");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton")).click();
		element_Actions.waitAndFindElement(obj.getElement("estimatedFieldError"));
		element_Actions.findElement(obj.getElement("estimatedFieldError")).getText().equalsIgnoreCase("Estimated Hours Per Day Cannot be Less Than Zero or Greater Than 24");
		log.info("verifyed Estimated Daily Hours Field Not Accept Hours More Than 24");
		return true;
	}
	public void closeEstimatedDailyHoursDialogBox() {
		element_Actions.waitAndFindElement(obj.getElement("closeEstimatedFieldDialogBox"));
		element_Actions.click();
	}
	public boolean verifyCategoryFieldVisibleAndJobTitleFieldVisible() {
		log.info("Verifying Category Field and Job Title Field");
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
			String name = jobTitle.getText();
			if(name.equalsIgnoreCase("Administrative Service")){
				jobTitle.click();
				break;
			}
		}
		log.info("Verifying Category Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("categoryField"));
		boolean display = element_Actions.findElement(obj.getElement("categoryField")).isDisplayed();
		log.info("Verifyied Category Field and Job Title");
		return  display;
	}
	public boolean verifyCompanyFieldVisible() {
		log.info("Verify Company Field");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("company"));
		boolean display =element_Actions.findElement(obj.getElement("company")).isDisplayed();
		log.info("Verifyied Company Field");
		return display;			
	}
	public boolean verifynewOrderbutton() {
		log.info("Verify New Order button On Homepage");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("newOrder"));
		boolean display = element_Actions.findElement(obj.getElement("newOrder")).isDisplayed();
		System.out.println("New Order button is display on home page"+display);
		log.info("Verify New Order button On Homepage successfully");
		return display;
	}
	public boolean verifyEstimatedDailyHoursFieldVisible() {
		log.info("verify Estimated Daily Hours Field Visible");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHoursField"));
		boolean display = element_Actions.findElement(obj.getElement("estDailyHoursField")).isDisplayed();
		System.out.println("Estimated Daily Hours Field Visible"+display);
		log.info("verify Estimated Daily Hours Field Visible");
		return display;
	}
}