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
import com.sf.pages.SaveOrderPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.XmlReader;

public class TG_4419_AssignEmployeeFromStaffing extends TestBase {

	LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	Functions functions;
	EndToEndCheckPage flow;
	HomePage homepage;
	SaveOrderPage save;
	String jobOrderId;
	AddNewEmployeePage addEmp;
	String createdEmployeeId;
	String createdEmployeeName;
	JobOrderPage job;
	DeleteJobOrderPage delete;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4419_AssignEmployeeFromStaffing.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		homepage = new HomePage(driver, log);
		save = new SaveOrderPage(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		job = new JobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_AssignEmployeeStaffing")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue, String approveCount, String miles, String companyName,
			String empFirstName, String empLastName, String empDOB, String empEmail, String empAddress)
			throws IOException, InterruptedException {
		test = extent.createTest("Starting End To End Flow NewOrderHiring");
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
		Thread.sleep(2000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		createdEmployeeName = addEmp.addEmployeeFlow(companyName, empFirstName, empLastName, empDOB, empEmail,
				empAddress);
		System.out.println("createdEmployeeName  " + createdEmployeeName);
		homepage.clickHomePageLink();

		
	
		log.info("Started==Starting End To End Flow ClaimFromStaffing");

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
		test.log(Status.PASS, "Completed End To End Flow ApproveHiring");
		Thread.sleep(5000);
		homepage.logout();
	
		Thread.sleep(5000);
		driver.get(url);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "Clicking on the Orders Menu present on Staffing home page");
		home.clickOrdersMenuOnStaffingHomePage();
		Thread.sleep(3000);
		test.log(Status.PASS, "Orders menu clicked successfully");

		test.log(Status.INFO, "Clicking on the All Orders Menu present on Staffing home page");
		home.clickAllOrdersOnStaffingHomePage();
		Thread.sleep(2000);
		test.log(Status.PASS, "All Orders menu clicked successfully");
		Thread.sleep(3000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		jo.selectParticularJobOrderFromListingStaffing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		Thread.sleep(2000);
		Assert.assertEquals(
				home.verifyPleaseAssignEmployeeMessage()
						.contains("Your company’s claim has been approved. Please assign employees."),
				true, "Message is not displayed");
	
	
		test.log(Status.INFO, "Clicking Assign Employees button present on  staffing job order page");
		jo.clickAssignEmployeesButton();
		test.log(Status.PASS, "Clicked cAssign Employees button present on staffing job order page successfully");
		Thread.sleep(2000);
		Assert.assertEquals(jo.verifyNewAssignEmployeeFormVisible(), true, "New Assign Employee form is not visible");
	
		
		test.log(Status.INFO, "Entering save button in new Assign Employee ");
		jo.clickSaveButton();
		test.log(Status.PASS, "Save button entered successfully");

		Assert.assertEquals(jo.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");

		jo.clickErrorClose();

		test.log(Status.INFO, "verifiying Company Feild auto populated in new Assign Employee");
		Assert.assertEquals(jo.verifyCompanyFeildAutoPopulated(), true, "Verify company feild is auto populated");
		test.log(Status.PASS, "Verified Company Feild auto populated in new Assign Employeesuccessfully");
	
		
		test.log(Status.INFO, "verifiying Employee pay rate is visible new Assign Employee");
		Assert.assertEquals(jo.verifyEmployeePayRate(), true, "Verify company feild is auto populated");
		test.log(Status.PASS, "Verified Employee pay rate is displayed new Assign Employeesuccessfully");

		test.log(Status.INFO, "verifiying Employee pay rate value auto populated in new Assign Employee");
		Assert.assertEquals(jo.verifyEmpPayRatePopulated(), true, "Verify EmpPayRate not auto populated");
		test.log(Status.PASS, "Verified Employee pay rate value auto populated  new Assign Employeesuccessfully");
	
	
		test.log(Status.INFO, "verifiying Distance Radius visible is visible new Assign Employee");
		Assert.assertEquals(jo.verifyDistanceRadiusFeild(), true, "DistanceRadius is not displayed");
		test.log(Status.PASS, "Verified Distance Radius is displayed new Assign Employee successfully");

		test.log(Status.INFO, "Entering Distance Radius");
		jo.enterMiles(miles);
		test.log(Status.PASS, "Entered Distance Radius successfully");
	
	
		Assert.assertEquals(jo.verifyShowAllEmployeesVisible(), true, "ShowAllEmployees is not displayed");

		test.log(Status.INFO, "Clicking checkox ShowAllEmployess");
		jo.clickCheckBoxShowAllEmployess();
		test.log(Status.PASS, "Clicked ShowAllEmployess successfully");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking add row button in new Assign Employee");
		jo.clickAddRowButton();
		test.log(Status.PASS, "Clicked add row button in new Assign Employeesuccessfully");

		Assert.assertEquals(jo.verifyEmployeeIDVisible(), true, "Employee Id  is not displayed");
	
		Thread.sleep(6000);
		
		test.log(Status.INFO, "Clicking edit button on the form under the EmployeeDetails");
		jo.clickEditButton();
		test.log(Status.PASS, "Clicked edit button on the form under the EmployeeDetails successfully");
		
		test.log(Status.INFO, "Entering employeeId in new Assign Employee");
		jo.enterEmployeeName(createdEmployeeName);
		test.log(Status.PASS, "Entered employeeId in new Assign Employee successfully");
		test.log(Status.PASS, "Clicking Searched Employee");
		Thread.sleep(4000);
		jo.clickSearchedEmployee();
		test.log(Status.PASS, " Searched Employee Clicked Successfully");
		test.log(Status.INFO, "Clicking Dropdown arrow in the modal");
		jo.clickDropModalClose();
		test.log(Status.PASS, "Clicked Dropdown arrow in the modal successfully");

	
		Assert.assertEquals(jo.verifySaveButtonVisible(), true, "SaveButton is not displayed");
	
		test.log(Status.INFO, "Entering save button in new Assign Employee  ");
		jo.clickSaveButton();
		test.log(Status.PASS, "Save button entered successfully");
		

		Thread.sleep(30000);
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

	@DataProvider(name = "TG_AssignEmployeeStaffing")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_AssignEmployeeStaffing");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}