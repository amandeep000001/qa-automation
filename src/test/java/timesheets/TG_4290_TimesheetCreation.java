package timesheets;

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
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.TimesheetCreationPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_4290_TimesheetCreation extends TestBase {
	LoginPage jo;
	JobOrderPage order;
	Functions functions;
	TimesheetCreationPage timesheet;
	HomePage homePage;
	Functions fun;
	EndToEndCheckPage flow;
	StaffingHomePage home;
	String jobOrderId;
	AddNewEmployeePage addEmp;
	JobOrderPage job;
	String createdEmployeeId;
	DeleteJobOrderPage delete;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4290_TimesheetCreation.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		timesheet = new TimesheetCreationPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
		flow = new EndToEndCheckPage(driver, log);
		home = new StaffingHomePage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		job = new JobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_TimesheetCreation")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue, String dateTimeSheet, String startTimeTimeSheet,
			String endTimeTimeSheet, String miles, String companyName, String empFirstName, String empLastName,
			String empDOB, String empEmail, String empAddress, String employeeId, String approveCount)
			throws IOException, InterruptedException {
		test = extent.createTest(
				"Starting End To End Flow NewOrderHiring + Employee Creation + Claim Order + Approve Claim + Assign Employee");
		log.info("Started==Starting End To End Flow NewOrderHiring");
		driver.get(url);
		jo.enterUsername(usernameHiring);
		jo.enterPassword(passwordHiring);
		jo.clickLoginButton();
		jobOrderId = flow.newOrderHiring(estDailyHours, startDate, enddate, startTime, availability, jobSite, jobTitle,
				category, noOfWorker, eSignature);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow NewOrderHiring");
		Thread.sleep(5000);
		homePage.logout();

		log.info("Started==Starting End To End Flow CreateEmployeeFromStaffing");
		Thread.sleep(6000);
		driver.get(url);
		Thread.sleep(2000);
		jo.enterUsername(usernameStaffing);
		jo.enterPassword(passwordStaffing);
		jo.clickLoginButton();
		createdEmployeeId = addEmp.addEmployeeFlow(companyName, empFirstName, empLastName, empDOB, empEmail,
				empAddress);
		System.out.println("createdEmployeeId  " + createdEmployeeId);
		homePage.clickHomePageLink();

		log.info("Started==Starting End To End Flow ClaimFromStaffing");
//		driver.get(url);
//		Thread.sleep(2000);
//		login.enterUsername(usernameStaffing);
//		login.enterPassword(passwordStaffing);
//		login.clickLoginButton();
		flow.ClaimOrderForStaffing(noOfEmployeesClaim, employeePayRate, eSignatureClaim, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow ClaimFromStaffing");
		Thread.sleep(15000);
		homePage.logout();

		log.info("Started==Starting End To End Flow ApproveHiring");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		jo.enterUsername(usernameHiring);
		jo.enterPassword(passwordHiring);
		jo.clickLoginButton();
		flow.ApproveClaimFromHiring(approveCount, jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow ApproveHiring");
		Thread.sleep(5000);
		homePage.logout();

		log.info("Started==Starting End To End Flow AssignEmployee");
		Thread.sleep(5000);
		driver.get(url);
		jo.enterUsername(usernameStaffing);
		jo.enterPassword(passwordStaffing);
		jo.clickLoginButton();
		flow.AssignEmployee(miles, jobOrderId, createdEmployeeId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow AssignEmployee");
		Thread.sleep(30000);
		homePage.logout();
	
		log.info(
				"Started==Verifying Hiring Admin Able To View Employees Have Been Assigned Please Submit Their Timesheets");
		Thread.sleep(5000);
		driver.get(url);
		jo.enterUsername(usernameHiring);
		jo.enterPassword(passwordHiring);
		jo.clickLoginButton();
		Thread.sleep(3000);
		timesheet.clickOrderOption();
		Thread.sleep(3000);
//		timesheet.clickAllOrder();
//		Thread.sleep(3000);
		flow.selectParticularJobOrderFromListingHiring(jobOrderId);
		Thread.sleep(3000);
		test.log(Status.PASS, "Login successful");
//		Assert.assertEquals(timesheet.verifyHiringAdminAbleToViewEmployeesHaveBeenAssignedPleaseSubmitTheirTimesheets(),
//				true, " Employees Not Have Been Assigned ");
		Assert.assertEquals(
				timesheet.verifyPleaseReviewTimesheetMessage()
						.contains("Employees have been assigned. Please submit their timesheets."),
				true, "Message is not displayed");
		test.log(Status.PASS,
				"Verify Hiring Admin Able To View Employees Have Been Assigned Please Submit Their Timesheets Successfully");

		log.info("Started==Verifying Add Edit Timesheet Button Visible On Clicking On Timesheet");
		timesheet.ClickingOnTimesheet();
		Thread.sleep(2000);
		timesheet.clickaddEditButton();
		test.log(Status.PASS, "Verifying Add Edit Timesheet Button Visible On Clicking On Timesheet Successfully");

		log.info(
				"Started==Verifying Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet");
		Assert.assertEquals(
				timesheet.verifyNavigatedToAddTimesheetFormByClickingOnAddEditTimesheetButtonOnClickingOnTimesheet(),
				true,
				" Unable to Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet");
		test.log(Status.PASS,
				"Verifying Navigated To Add Timesheet Form By Clicking On Add Edit Timesheet Button On Clicking On Timesheet Successfully");

		log.info("Started==Verifying Timesheet Detail Should Get Auto-Fetched");
		Assert.assertEquals(timesheet.verifyTimesheetDetailShouldGetAutoFetched(), true,
				"Unable to Verify Timesheet Detail Should Get Auto-Fetched");
		test.log(Status.PASS, "Verify Timesheet Detail Should Get Auto-Fetched Successfully");
	
		log.info("Started==Verifying Hiring Role Should Not Able To Select Future Date And Gets Popup");
		test.log(Status.INFO, "Entering Date");
		Thread.sleep(3000);
		timesheet.enterDate(dateTimeSheet);
		test.log(Status.PASS, " Enter Date Successfully");
		Thread.sleep(3000);
		Assert.assertEquals(
				timesheet.verifyHiringRoleShouldNotAbleToSelectFutureDateAndGetsPopup()
						.contains("Date can't be future date."),
				true, "Unable toVerifying Hiring Role Should Not Able To Select Future Date And Gets Popup");
		Thread.sleep(3000);
		test.log(Status.PASS, "Verify Hiring Role Should Not Able To Select Future Date And Gets Popup");
		test.log(Status.INFO, "closing Future Date DialogBox");
		Thread.sleep(2000);
		timesheet.closeBlankMandatoryFieldDialogBox();
		test.log(Status.PASS, " Future Date DialogBox close Successfully");

		log.info("Started==Verifying Hiring Role Should Able To Select Date As Current Day");
		Assert.assertEquals(timesheet.verifyHiringRoleShouldAbleToSelectDateAsCurrentDay(), true,
				"Unable to Verify Hiring Role Should Able To Select Date As Current Day");
		test.log(Status.PASS, "Verify Hiring Role Should Able To Select Date As Current Day Successfully");
		
		test.log(Status.INFO,"Selecting Checkbox");
		timesheet.clickEmployeeSelectChechbox();
		test.log(Status.PASS,"Checkbox Selected Successfully");

		test.log(Status.INFO, "Entering Start Time");
		Thread.sleep(3000);
		timesheet.enterStartTime(startTimeTimeSheet);
		test.log(Status.PASS, " Enter Start Time Successfully");
		test.log(Status.INFO, "Entering End Time");
		Thread.sleep(3000);
		timesheet.enterEndTime(endTimeTimeSheet);
		test.log(Status.PASS, " Enter End Time Successfully");
		log.info(
				"Started==Verifying User Should Able To Select From Time And To Time Successfully And Total Hours Should Get Calculate");
		Thread.sleep(2000);
		Assert.assertEquals(
				timesheet.verifyUserShouldAbleToSelectFromTimeAndToTimeSuccessfullyAndTotalHoursShouldGetCalculate(),
				true,
				"Unable to Verify User Should Able To Select From Time And To Time Successfully And Total Hours Should Get Calculate");
		test.log(Status.PASS,
				"Verify User Should Able To Select From Time And To Time Successfully And Total Hours Should Get Calculate Successfully");

		log.info("Started==Verifying Selecting Valid Date Employees Details Should Get Fetched Automatically");
		Thread.sleep(3000);
		Assert.assertEquals(timesheet.verifyEmployeesDetailsShouldGetFetchedAutomatically(), true,
				"Unable to Verifying Selecting Valid Date Employees Details Should Get Fetched Automatically");
		test.log(Status.PASS,
				"Verifying Selecting Valid Date Employees Details Should Get Fetched Automatically Successfully");
		
		log.info("Started==Verifying Selecting Valid Date Employees Details Should Get Fetched Automatically");
		Thread.sleep(2000);
		Assert.assertEquals(timesheet.verifyUserShouldAableViewPopupTimesheetAddedSuccessfully(), true,
				"Unable to Verifying User Should Able To View 3 Values In the Dropdown Of Status Column");
		test.log(Status.PASS, "Verified User Should Aable View Popup Timesheet Added Successfully Successfully");
		
		Thread.sleep(20000);
		homePage.logout();
		Thread.sleep(7000);
		driver.get(url);

		test.log(Status.INFO,"Entering Username");
		jo.enterUsername(usernameHiring);
		test.log(Status.PASS,"Username Entered Successfully");
		
		test.log(Status.INFO,"Entering Password");
		jo.enterPassword(passwordHiring);
		test.log(Status.PASS,"Password Entered Successfully");
		
		test.log(Status.INFO,"Clicking on Login Button");
		jo.clickLoginButton();
		test.log(Status.PASS,"Login Button Clicked Successfully");
		
		Thread.sleep(7000);
		
		test.log(Status.INFO, "Clicking on the Orders Menu present on hiring home page");
		homePage.clickOrdersMenuOnHiringHomePage();
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

	@DataProvider(name = "TG_TimesheetCreation")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_TimesheetCreation");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}