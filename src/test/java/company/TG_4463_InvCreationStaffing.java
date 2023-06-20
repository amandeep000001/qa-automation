package company;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.google.common.base.Functions;
import com.sf.base.TestBase;
import com.sf.pages.AddNewEmployeePage;
import com.sf.pages.ClaimOrderPage;
import com.sf.pages.DeleteJobOrderPage;
import com.sf.pages.EndToEndCheckPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.XmlReader;

public class TG_4463_InvCreationStaffing extends TestBase {

	LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	ClaimOrderPage order;
	Functions functions;
	EndToEndCheckPage flow;
	HomePage homepage;
	String jobOrderId;
	AddNewEmployeePage addEmp;
	String createdEmployeeId;
	JobOrderPage job;
	DeleteJobOrderPage delete;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4463_InvCreationStaffing.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		homepage = new HomePage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		job = new JobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);
	}

	@Test(dataProvider = "InvoiceCreationStaffing")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue, String approveCount, String miles, String companyName,
			String empFirstName, String empLastName, String empDOB, String empEmail, String empAddress,
			String dateTimeSheet, String startTimeTimeSheet, String endTimeTimeSheet)
			throws IOException, InterruptedException {
		test = extent.createTest(
				"Starting End To End Flow NewOrderHiring + Employee Creation + Claim Order + Approve Claim");
		log.info("Started==Starting End To End Flow NewOrderHiring");
		driver.get(url);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		jobOrderId = flow.newOrderHiring(estDailyHours, startDate, enddate, startTime, availability, jobSite, jobTitle,
				category, noOfWorker, eSignature);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow NewOrderHiring");
		Thread.sleep(5000);
		homepage.logout();

		log.info("Started==Starting End To End Flow CreateEmployeeFromStaffing");
		Thread.sleep(6000);
		driver.get(url);
		Thread.sleep(6000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		createdEmployeeId = addEmp.addEmployeeFlow(companyName, empFirstName, empLastName, empDOB, empEmail,
				empAddress);
		System.out.println("createdEmployeeId  " + createdEmployeeId);
		homepage.clickHomePageLink();

		log.info("Started==Starting End To End Flow ClaimFromStaffing");
//		driver.get(url);
//		Thread.sleep(2000);
//		login.enterUsername(usernameStaffing);
//		login.enterPassword(passwordStaffing);
//		login.clickLoginButton();
		flow.ClaimOrderForStaffing(noOfEmployeesClaim, employeePayRate, eSignatureClaim, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow ClaimFromStaffing");
		Thread.sleep(5000);
		homepage.logout();

		log.info("Started==Starting End To End Flow ApproveHiring");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		flow.ApproveClaimFromHiring(approveCount, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End FlowApproveHiring");
		Thread.sleep(5000);
		homepage.logout();
	
		log.info("Started==Starting End To End Flow AssignEmployee");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(5000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		flow.AssignEmployee(miles, jobOrderId, createdEmployeeId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow AssignEmployee");
		Thread.sleep(30000);
		homepage.logout();

		log.info("Started==Starting End To End Flow TimesheetCreation");
		Thread.sleep(6000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		Thread.sleep(3000);
		flow.createTimesheetHiring(dateTimeSheet, startTimeTimeSheet, endTimeTimeSheet, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow TimesheetCreation");
		Thread.sleep(5000);
		homepage.logout();

		log.info("Started==Starting End To End Flow approveTimesheet");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		Thread.sleep(3000);
		flow.approveTimesheetFromStaffing(jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow approveTimesheet");
		Thread.sleep(5000);
		homepage.logout();
	
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "Clicking on the Orders Menu present on Staffing home page");
		home.clickOrdersMenuOnStaffingHomePage();
		test.log(Status.PASS, "Orders menu clicked successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking on the All Orders Menu present on Staffing home page");
		home.clickAllOrdersOnStaffingHomePage();
		test.log(Status.PASS, "All Orders menu clicked successfully");
		Thread.sleep(3000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		jo.selectParticularJobOrderFromListingStaffing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		Thread.sleep(5000);
	
		
		test.log(Status.INFO, "Clicking on the create invoice button");
		jo.clickCreateInvoice();
		test.log(Status.PASS, "Invoice Button clicked successfully");

		test.log(Status.INFO, "verifiying New Invoice title is visible in the form");
		Assert.assertEquals(jo.VerifyNewInvoice(), true, "New Invoice title is not visible");
		test.log(Status.PASS, "Verified New Invoice title is visible in the form successfully");

		test.log(Status.INFO, "verifiying cancel button is visible in the form");
		Assert.assertEquals(jo.VerifyCancelButton(), true, "cancel button title is visible");
		test.log(Status.PASS, "Verified cancel button is visible in the form successfully");

		test.log(Status.INFO, "verifiying save button title is visible in the form");
		Assert.assertEquals(jo.VerifySaveButton(), true, "save button is visible");
		test.log(Status.PASS, "Verified save button title is visible in the form successfully");

		test.log(Status.INFO, "Clicking save button route form to Draft status");
		jo.clickSaveButton();
		test.log(Status.PASS, "Clicked Save button routed draft status form successfully");

		Assert.assertEquals(jo.VerifyDraftText(), true, "Draft status is not visible");

		Assert.assertEquals(jo.verifySubmitThisDocumentMessage().contains("Submit this document to confirm"), true,
				"Submit this document to confirm is not visible");

		test.log(Status.INFO, "Clicking on the submit button");
		jo.clickSubmitButton();
		test.log(Status.PASS, "Submit Button clicked successfully");

		Assert.assertEquals(jo.VerifyYesButtonConfirmModal(), true, "Yes button is not visible");
		Assert.assertEquals(jo.VerifyNoButtonConfirmModal(), true, "No button is not visible");

		test.log(Status.INFO, "Clicking yes button  in confirm modal");
		jo.clickYesButtonConfirmModal();
		test.log(Status.PASS, "Yes button  in confirm modal clicked successfully");

		Assert.assertEquals(jo.verifyEmailSuccessMessage().contains("Email Sent Successfully"), true,
				"'Email Sent Successfully' message not displayed");
		driver.navigate().refresh();
		Thread.sleep(10000);
		homepage.logout();
		Thread.sleep(7000);
		driver.get(url);

		test.log(Status.INFO,"Entering Username");
		login.enterUsername(usernameHiring);
		test.log(Status.PASS,"Username Entered Successfully");
		
		test.log(Status.INFO,"Entering Password");
		login.enterPassword(passwordHiring);
		test.log(Status.PASS,"Password Entered Successfully");
		
		test.log(Status.INFO,"Clicking on Login Button");
		login.clickLoginButton();
		test.log(Status.PASS,"Login Button Clicked Successfully");
		
		Thread.sleep(7000);
		
		test.log(Status.INFO, "Clicking on the Orders Menu present on hiring home page");
		homepage.clickOrdersMenuOnHiringHomePage();
		test.log(Status.PASS, "Orders menu clicked on hiring home page successfully");
		Thread.sleep(3000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		job.selectParticularJobOrderFromListingHiring(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		Thread.sleep(3000);
		
		test.log(Status.INFO, "Clicking on delete job order");
		delete.clickDeleteJobOrderButton();
		test.log(Status.PASS, "delete job order clicked successfully");
		Thread.sleep(3000);
		
		test.log(Status.INFO, "Accepting delete job order");
		delete.clickAcceptDeleteJobOrderRequestButton();
		test.log(Status.PASS, "Deleting job order accepted successfully");
		
		test.log(Status.INFO, "Verifying that job order deleted via pop-up");
		Assert.assertEquals(delete.verifyJobOrderDeleted().contains("Order Deleted Successfully"), true,
				"Failed to delete the order");
		test.log(Status.PASS, "Verified that order deleted successfully");
	}

	@DataProvider(name = "InvoiceCreationStaffing")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_InvoiceCreationStaffing");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}
