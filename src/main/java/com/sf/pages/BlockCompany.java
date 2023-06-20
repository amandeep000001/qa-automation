package com.sf.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.sf.objectRepository.ObjectRepository;
import com.sf.utility.Functions;
import com.sf.webActions.ElementActions;

public class BlockCompany extends ObjectRepository {
	private static final String Admin = null;
	Logger log;
	SelfHealingDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;


	public BlockCompany(SelfHealingDriver driver, Logger log) throws IOException {
			super("BlockCompany.properties");
			obj = new ObjectRepository("BlockCompany.properties");
			this.log = log;
			this.driver = driver;
			functions = new Functions();
			element_Actions = new ElementActions(driver);
		}


	public void clickOrder() {
		log.info("Clicking on  Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("Orders"));
		element_Actions.findElement(obj.getElement("Orders"));
		element_Actions.click();
		log.info(" Order Button clicked successfully");
	}

	public void selectDirectOption() {
		log.info("Clicking on Direct Order Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("directOrders"));
		element_Actions.findElement(obj.getElement("directOrders"));
		element_Actions.click();
		log.info("Direct Order Button clicked successfully");
	}

	public void clickStaffingCompanies() {
		log.info("Clicking on Staffing Companies Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("clickStaffingCompanies"));
		element_Actions.findElement(obj.getElement("clickStaffingCompanies"));
		element_Actions.click();
		log.info("Staffing Companies Button clicked successfully");
	}

	public boolean verifyStaffingCompanyList() {
		log.info("Verify Staffing Company List is displayed");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("staffCompanyListTitle"));
		Boolean display = element_Actions.findElement(obj.getElement("staffCompanyListTitle")).isDisplayed();
		log.info("Staffing Company List displayed successfully");
		return display;
	}

	public void clickStaffingCompany() {
		log.info("Clicking on Staffing Company");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("staffingCompany"));
		element_Actions.findElement(obj.getElement("staffingCompany"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		element_Actions.click();
		log.info("Staffing Company clicked successfully");
	}

	public void clickBlockButton() {
		log.info("Clicking on Block Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("blockButton"));
		element_Actions.findElement(obj.getElement("blockButton"));
		element_Actions.click();
		log.info("Block Button clicked successfully");
	}

	public void clickUnblockButton() {
		log.info("Clicking on Block Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("unblockButton"));
		element_Actions.findElement(obj.getElement("unblockButton"));
		element_Actions.click();
		log.info("Block Button clicked successfully");
	}

	public String verifyBlockCompanyPopUp() {
		log.info("Verify Company Blocked Pop Up displayed");
		element_Actions.waitAndFindElement(obj.getElement("popUpMsgVerify"));
		String blockCompanyPopUp = element_Actions.findElement(obj.getElement("popUpMsgVerify")).getText();
		log.info("Company Blocked Pop Up displayed successfully");
		return blockCompanyPopUp;
	}

	public String verifyUnblockCompanyPopUp() throws InterruptedException {
		log.info("Verify Company Unblocked Pop Up displayed");
		// Thread.sleep(20000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("popUpMsgVerify"));
		String unblockCompanyPopUp = element_Actions.findElement(obj.getElement("popUpMsgVerify")).getText();
		log.info("Company Unblocked Pop Up displayed successfully");
		return unblockCompanyPopUp;
	}

	public void closePopUpButton() {
		log.info("Clicking on Close Pop Up");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("closePopUp"));
		element_Actions.findElement(obj.getElement("closePopUp"));
		element_Actions.click();
		log.info("Close Pop Up clicked Successfully");
	}

	public void clickHundredFilter() {
		log.info("Clicking on 100 records button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("increaseRecordsOnForm"));
		element_Actions.findElement(obj.getElement("increaseRecordsOnForm"));
		element_Actions.click();
		log.info("100 records button clicked Successfully");
	}

	public void clickPlaceOrderButton() {
		log.info("Clicking on Staffing Company");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("placeOrderButton"));
		element_Actions.findElement(obj.getElement("placeOrderButton"));
		element_Actions.click();
		log.info("Staffing Company clicked successfully");
	}

	public String getTextHiringId() throws InterruptedException {
		log.info("Job order link present on the home page clicked");
		Thread.sleep(3000);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("jobOrderConfirmID"));
		String hiringJobId = element_Actions.findElement(obj.getElement("jobOrderConfirmID")).getText();
		System.out.println("Hiring Job order Id Is : " + hiringJobId);
		Thread.sleep(5000);
		driver.navigate().refresh();
		log.info("Verify Job Order Id and Email Successfully");
		return hiringJobId;
	}

	public void selectParticularJobOrderFromListing(String hiringJobId) throws InterruptedException {
		log.info("Selecting Particular Joborder on the listing");
		Thread.sleep(10000);
		System.out.println("JobOrderId= ****** " + hiringJobId);
		List<WebElement> listOrder = element_Actions
				.findElements(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
		listOrder.get(1).click();
		log.info("Particular Joborder on the listing selected successfully");
	}

	public void clickNotificationIcon() {
		log.info("Clicking on Notifications");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("notificationIcon"));
		element_Actions.findElement(obj.getElement("notificationIcon"));
		element_Actions.click();
		log.info("Notifications clicked successfully");
	}

	public String verifyNotificationText() {
		log.info("Verify Direct Order Text in Notification");
		element_Actions.waitAndFindElement(obj.getElement("notificationText"));
		String blockCompanyPopUp = element_Actions.findElement(obj.getElement("notificationText")).getText();
		log.info("Direct Order Text in Notification displayed successfully");
		return blockCompanyPopUp;
	}

	public void clickDirectOrderNav() {
		log.info("Clicking on Direct Orders");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("directOrder"));
		element_Actions.findElement(obj.getElement("directOrder"));
		element_Actions.click();
		log.info("Direct orders clicked successfully");
	}

	public void clickDenyButton() throws InterruptedException {
		log.info("Clicking on Deny Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("denyOrderButton"));
		element_Actions.findElement(obj.getElement("denyOrderButton"));
		element_Actions.click();
		Thread.sleep(60000);
		log.info("Deny Button clicked successfully");
	}

	public void selectParticularJobOrderFromListingStaff(String hiringJobId) throws InterruptedException {
		log.info("Selecting Particular Joborder on the listing");
		Thread.sleep(10000);
		System.out.println("JobOrderId= ****** " + hiringJobId);
		List<WebElement> listOrder = element_Actions
				.findElements(obj.getElement("selectJobOrderFromListingPage", hiringJobId));
		listOrder.get(0).click();
		log.info("Particular Joborder on the listing selected successfully");
	}

	public void verifyJobOrderIdAndPopupEmailSentSuccessfully() throws InterruptedException {
		element_Actions.waitUntilVisibilityLocated(obj.getElement("saveButton"));
		element_Actions.findElement(obj.getElement("saveButton"));
		element_Actions.click();
		List<WebElement> confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 1st confirm " + confirmButton.size());
		confirmButton.get(0).click();
		Thread.sleep(2000);
		confirmButton = element_Actions.findElements(obj.getElement("confirmButtonConfirmJoborder"));
		System.out.println("size of the list before clicking on 2nd confirm " + confirmButton.size());
		confirmButton.get(1).click();
		Thread.sleep(13000);
		element_Actions.refreshWebpage();
	}

	public void clickStaffingCompanyDirectOrder() {
		log.info("Clicking on Staffing Companies Button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("staffingCompanyDirectOrder"));
		element_Actions.findElement(obj.getElement("staffingCompanyDirectOrder"));
		element_Actions.scrollElementIntoView();
		element_Actions.scrollToTheTop();
		element_Actions.click();
		log.info("Staffing Companies Button clicked successfully");
	}
	
	public void clickDistanceFilter() throws InterruptedException {
		log.info("Clicking on Distance Filter");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("distanceFilter"));
		element_Actions.findElement(obj.getElement("distanceFilter"));
		element_Actions.click();
		log.info("Distance Filter clicked successfully");
	}
	
	public void clickClearFilter() throws InterruptedException {
		log.info("Clicking on Clear Filter");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("clearFilter"));
		element_Actions.findElement(obj.getElement("clearFilter"));
		element_Actions.click();
		log.info("Clear Filter clicked successfully");
	}

}
