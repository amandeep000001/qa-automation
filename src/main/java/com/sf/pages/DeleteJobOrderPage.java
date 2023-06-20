package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class DeleteJobOrderPage extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;

	public DeleteJobOrderPage(SelfHealingDriver driver, Logger log) throws IOException {
		super("JobOrderDeletion.properties");
		obj = new ObjectRepository("JobOrderDeletion.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}

	public void clickJobOrderLinkOnHomePage() {
		log.info("clicking on job order link present on the home page");
		List<WebElement> homePagelinks = element_Actions.findElements(obj.getElement("jobOrderLinkOnHomePage"));
		homePagelinks.get(0).click();
		log.info("Job order link present on the home page clicked");
		element_Actions.waitAndFindElement(obj.getElement("filterIconOnJobOrderListingPage"), 20000);
	}

	public String selectJobOrderOnlistingPage() {
		log.info("Selecting Job order on Job Order Listing Page");
		String jobOrderId = null;
		element_Actions.waitUntilVisibilityOfAllElementsLocated(obj.getElement("selectJobOrderFromListingPage"));
		List<WebElement> jobOrder = element_Actions.findElements(obj.getElement("selectJobOrderFromListingPage"));
		jobOrderId=jobOrder.get(0).getText();
		jobOrder.get(0).click();
		log.info("Job order selected");
		element_Actions.waitAndFindElement(obj.getElement("deleteJobOrderButtonOnDetailsPage"), 20000);
		return jobOrderId;
	}

	public void clickDeleteJobOrderButton() {
		log.info("Clicking on delete button present on Job Order detials page");
		element_Actions.waitAndFindElement(obj.getElement("deleteJobOrderButtonOnDetailsPage"));
		element_Actions.click();
		log.info("Delete button present on Job Order detials page clicked");
		element_Actions.waitAndFindElement(obj.getElement("confirmDeleteButton"), 20000);
	}

	public void clickAcceptDeleteJobOrderRequestButton() {
		log.info("Clicking on confirm deletion button");
		element_Actions.waitAndFindElement(obj.getElement("confirmDeleteButton"));
		element_Actions.click();
		log.info("Confirm deletion button clicked");
	}
	
	public void clickRejectDeleteJobOrderRequestButton()
	{
		log.info("Clicking on Discard deletion button");
		element_Actions.waitAndFindElement(obj.getElement("discardDeletionButton"));
		element_Actions.click();
		log.info("Discard deletion button clicked");
		element_Actions.refreshWebpage();
		element_Actions.waitAndFindElement(obj.getElement("deleteJobOrderButtonOnDetailsPage"), 20000);
	}

	public boolean verifyJobOrderDeletion(String deletedJobOrderId) {
		return element_Actions.checkElementPresence(obj.getElement("deletedJobOrderId", deletedJobOrderId));
	}
	
	public String verifyJobOrderDeleted() throws InterruptedException {
		log.info("Verifying that job order deleted via pop-up");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("popUpMsgVerify"));
		String deletedOrder = element_Actions.findElement(obj.getElement("popUpMsgVerify")).getText();
		log.info("Verified that order deleted successfully");
		return deletedOrder;
	}
}
