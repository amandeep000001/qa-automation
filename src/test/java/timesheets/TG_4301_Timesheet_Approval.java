package timesheets;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.sf.base.TestBase;
import com.sf.pages.AddNewEmployeePage;
import com.sf.pages.DeleteJobOrderPage;
import com.sf.pages.EndToEndCheckPage;
import com.sf.pages.EndToEndTimesheetApprovalPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.TimesheetApprovalPage;
import com.sf.pages.TimesheetCreationPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_4301_Timesheet_Approval extends TestBase {
	LoginPage login;
	JobOrderPage order;
	Functions functions;
	TimesheetCreationPage timesheet;
	HomePage homepage;
	Functions fun;
	EndToEndCheckPage flow;
	StaffingHomePage home;
	TimesheetApprovalPage approve;
	String jobOrderId;
	AddNewEmployeePage addEmp;
	String createdEmployeeId;
	JobOrderPage job;
	DeleteJobOrderPage delete;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4301_Timesheet_Approval.class.getName());
		functions = new Functions();
		login = new LoginPage(driver, log);
		timesheet = new TimesheetCreationPage(driver, log);
		homepage = new HomePage(driver, log);
		fun = new Functions();
		flow = new EndToEndCheckPage(driver, log);
		home = new StaffingHomePage(driver, log);
		approve = new TimesheetApprovalPage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		job = new JobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_TimesheetApproval")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue, String dateTimeSheet, String startTimeTimeSheet,
			String endTimeTimeSheet, String miles, String companyName, String empFirstName, String empLastName,
			String empDOB, String empEmail, String empAddress, String employeeId, String approveCount)
			throws IOException, InterruptedException { // should not be constructor
		test = extent.createTest("Starting End To End Flow NewOrderHiring + Employee Creation + Claim Order + Approve Claim + Assign Employee + Timesheet Creation");
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
		Thread.sleep(5000);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		flow.ApproveClaimFromHiring(approveCount, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow ApproveHiring");
		Thread.sleep(5000);
		homepage.logout();
	
		log.info("Started==Starting End To End Flow AssignEmployee");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(5000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		flow.AssignEmployee(miles, jobOrderId,createdEmployeeId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow AssignEmployee");
		Thread.sleep(30000);
		homepage.logout();
	
		log.info("Started==Starting End To End Flow TimesheetCreation");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		Thread.sleep(3000);
		flow.createTimesheetHiring(dateTimeSheet, startTimeTimeSheet, endTimeTimeSheet, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow TimesheetCreation");
		homepage.logout();
	
		log.info("Started==Verifying Timesheet Available For Approval Popup");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		Thread.sleep(3000);
		approve.clickOrder();
		Thread.sleep(3000);
		approve.selectAllOption();
		Thread.sleep(3000);
		flow.selectParticularJobOrderFromListingStaffing(jobOrderId);
		Thread.sleep(3000);
		test.log(Status.PASS, "Login successful");
//		Assert.assertEquals(approve.verifyTimesheetAvailableForApprovalPopup(), true,
//				"unable to Verify Timesheet Available For Approval Popup ");
        approve.ClickingOnTimesheet();
		test.log(Status.PASS, "Verify Timesheet Available For Approval Popup Successfully");
	
		log.info("Started==Verifying User Should Navigated To Timesheet Approval Form");
		//approve.clickTimesheetGrid();
		Assert.assertEquals(approve.timesheetTitleDisplay(), true,
				" unable to Verify User Should Navigated To Timesheet Approval Form ");
		test.log(Status.PASS, "Verify User Should Navigated To Timesheet Approval Form Successfully");
	
		log.info("Started==Verifying User Should Get Popup If Try To approve From Actions Button");
		approve.clickApprovalRequestGrid();
		approve.clickCheckBox();
		Assert.assertEquals(approve.verifyEmployeeDetails(), true,
				" unable to Verify User Should Get Popup If Try To approve From Actions Button ");
		test.log(Status.PASS, "Verify User Should Get Popup If Try To approve From Actions Button Successfully");
	
		log.info("Started==Verifying User Should Get Popup If Try To approve From Actions Button");
		approve.clickActionsButton();
		approve.clickApproveButton();
//		Assert.assertEquals(approve.verifyPopUpAfterClickApproveButton(), true,
//				" unable to Verify User Should Get Popup If Try To approve From Actions Button ");
		test.log(Status.PASS, "Verify User Should Get Popup If Try To approve From Actions Button Successfully");
		Assert.assertEquals(approve.verifyTimesheetUpdatedMessage().contains("Timesheet(s) has been updated."),
				true, "Message is not displayed");
		approve.closePopupApproveButton();
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



	@DataProvider(name = "TG_TimesheetApproval")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_TimesheetApproval");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}