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
public class ETENewOrderHiringPage  extends ObjectRepository {
	private static final String Admin = null;
	private static final String category = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public ETENewOrderHiringPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderPage.properties");
		obj = new ObjectRepository("JobOrderPage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public String newOrderHiring(String estDailyHours,String startDate,String enddate,String startTime,String availability,String jobSite ,String jobTitle, String category, String noOfWorker,String eSignature ) throws InterruptedException {
		log.info("Entering EstDailyHours");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("estDailyHoursField"));
		element_Actions.findElement(obj.getElement("estDailyHoursField"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		Thread.sleep(5000);
		element_Actions.click();
		Thread.sleep(2000);
		element_Actions.sendKeys(estDailyHours);
		log.info("EstDailyHours entered successfully");
		log.info("Entering StartDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("startDate"));
		element_Actions.findElement(obj.getElement("startDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(startDate);
		Thread.sleep(2000);
		log.info("StartDate entered successfully");
		log.info("Entering EndDate");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("endDate"));
		element_Actions.findElement(obj.getElement("endDate"));
		element_Actions.click();
		Thread.sleep(3000);
		element_Actions.sendKeys(enddate);
		Thread.sleep(2000);
		log.info("EndDate entered successfully");
		log.info("Entering StartTime");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobStartTime"));
		element_Actions.findElement(obj.getElement("jobStartTime"));
		element_Actions.sendKeys(startTime);
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("hourStartTime"));
		element_Actions.findElement(obj.getElement("hourStartTime"));
		element_Actions.click();
		element_Actions.waitUntilVisibilityLocated(obj.getElement("minStartTime"));
		element_Actions.findElement(obj.getElement("minStartTime"));
		element_Actions.click();
		log.info("StartTime entered successfully");
		log.info("Entering Availability");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("availability"));
		element_Actions.findElement(obj.getElement("availability"));
		element_Actions.sendKeys(availability);
		Select select= new Select(element_Actions.findElement(obj.getElement("availability")));
		select.selectByVisibleText("Mon-Fri");
		log.info("Availabilit entered successfully");
		log.info("Entering JobSite");
		Thread.sleep(3000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobSiteField"));
		element_Actions.findElement(obj.getElement("jobSiteField"));
		element_Actions.sendKeys(jobSite);
		List<WebElement> jobSiteOptions= element_Actions.findElements(obj.getElement("selectHiringJobSiteField"));
		for(WebElement jobSites:jobSiteOptions) {
			String value = jobSites.getText();
			if(value.equalsIgnoreCase("New York, NY 10020, USA")){
				jobSites.click();
				break;
			}
		}
		log.info("JobSite entered successfully");
		log.info("Entering JobTitle");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobTitleField"));
		element_Actions.findElement(obj.getElement("jobTitleField"));
		element_Actions.sendKeys(jobTitle);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("selectJobTitle"));
		element_Actions.findElement(obj.getElement("selectJobTitle"));
		element_Actions.click();
		List<WebElement> jobTitleOption= element_Actions.findElements(obj.getElement("selectJobTitle"));
		for(WebElement jobTitles:jobTitleOption) {
			String jobName = jobTitles.getText();
			if(jobName.equalsIgnoreCase("Administrative Service")){
				jobTitles.click();
				break;
			}
		}
		log.info("JobTitle entered successfully");
		log.info("Entering No Of Workers");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("noOfWorkers"));
		element_Actions.findElement(obj.getElement("noOfWorkers"));
		element_Actions.sendKeys(noOfWorker);
		log.info("NoOfWorkers entered successfully");
		log.info("Entering ESignature");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("esignature"));
		element_Actions.findElement(obj.getElement("esignature"));
		element_Actions.sendKeys(eSignature);
		log.info("ESignature entered successfully");
		log.info("clickAgreeContract");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("agreeToContract"));
		element_Actions.findElement(obj.getElement("agreeToContract"));
		element_Actions.click();
		log.info("clickAgreeContract successfully");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		List<WebElement> confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 1st confirm " +confirmButton.size());
		confirmButton.get(0).click();
		Thread.sleep(2000);
		confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 2nd confirm " +confirmButton.size());
		confirmButton.get(1).click();
		Thread.sleep(3000);
		log.info("Job order link present on the home page clicked");
		Thread.sleep(2000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderConfirmID"));
		String hiringJobId=element_Actions.findElement(obj.getElement("jobOrderConfirmID")).getText();
		System.out.println("Hiring Job order Id Is : " +hiringJobId);
		log.info("Verify Job Order Id and Email Successfully");
		return hiringJobId;
	}
}