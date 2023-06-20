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
import com.sf.pages.ClaimOrderPage;
import com.sf.pages.DeleteJobOrderPage;
import com.sf.pages.EndToEndCheckPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.utility.XmlReader;

public class TG_4145_ClaimOrderForStaffing extends TestBase {

	LoginPage login;
	StaffingHomePage home;
	StaffingJobOrderPage jo;
	ClaimOrderPage order;
	Functions functions;
	String jobOrderId;
	EndToEndCheckPage flow;
	HomePage homepage;
	JobOrderPage job;
	DeleteJobOrderPage delete;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4145_ClaimOrderForStaffing.class.getName());
		login = new LoginPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		homepage = new HomePage(driver, log);
		job = new JobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);

	}

	@Test(dataProvider = "TG_MandatoryDataNewOrderStaffingPage")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue) throws IOException, InterruptedException {
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
		Thread.sleep(3000);
		homepage.logout();
	
		Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(1000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		Thread.sleep(3000);

		test.log(Status.INFO, "clicking job order home page");
		home.clickJobOrderHomePage();
		test.log(Status.INFO, "clicked job order home page successfully");
		Thread.sleep(2000);
		Assert.assertEquals(jo.verifyJobOrderPage(), true, "Job order page title not displayed");
	
		
		Assert.assertEquals(jo.verifyHeadCountAvaialblecolumnIsAvailableInJobOrderForm(), true,
				"HeadCountAvaialble not displayed");
	
		test.log(Status.INFO, "Clicking on the Available order");
		Thread.sleep(10000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		jo.selectParticularJobOrderFromListingStaffing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		Thread.sleep(2000);
		Assert.assertEquals(jo.VerifyResumeRequiredBoxIsUnchecked(), false, "Resume required Box is not Unchecked");
		Assert.assertEquals(jo.VerifyClaimOrderVisible(), true, "Claim order Button is not displayed");
	
		test.log(Status.INFO, "Clicking on the Claim Order");
		jo.clickClaimOrderButton();
		test.log(Status.PASS, " Claim Order clicked successfully");
		Thread.sleep(2000);
		Assert.assertEquals(order.verifyNewClaimOrderPage(), true, "Claim order is not displayed");
	
		Thread.sleep(2000);
		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");
		test.log(Status.INFO, "clicking close Icon button ");
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");
	
		Thread.sleep(5000);
		test.log(Status.INFO, "verifying EmployeesClaim accepting Alphabet ");
		order.verifyNoOfEmployeesClaimNotAcceptAlphabet(alphabetValue);
		test.log(Status.PASS, "verified EmployeesClaim accepting Alphabet successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");
		Thread.sleep(3000);
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");
		Thread.sleep(3000);
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("No. of Employees to Claim"), true,
				"No of Employees to Claim Error message is not displayed");

		test.log(Status.INFO, "clicking close Icon button ");
		Thread.sleep(3000);
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");

		test.log(Status.INFO, "verifying EmployeesClaim accepting special character ");
		Thread.sleep(3000);
		order.verifyNoOfEmployeesClaimNotAcceptSpecialCharacters(specialCharacterValue);
		test.log(Status.PASS, "verifyied EmployeesClaim accepting special character ");

		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");
		Thread.sleep(3000);
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");
		Thread.sleep(3000);
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("No. of Employees to Claim"), true,
				"No of Employees to Claim Error message is not displayed");
		Thread.sleep(3000);
		test.log(Status.INFO, "clicking close Icon button ");
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");

		Thread.sleep(2000);
		String remainingEmployees = order.getRemainingEmployeeValue();
		Integer addedEmployee = Integer.valueOf(remainingEmployees) + Integer.valueOf(noOfEmployeesClaim);
		test.log(Status.INFO, "Entering employee value greater");
		order.enterNoOfEmployeesClaim(addedEmployee.toString());
		test.log(Status.PASS, "Entered employee value greater successfully");
		Thread.sleep(3000);
		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");
		Thread.sleep(3000);
		Assert.assertEquals(
				order.verifyMandatoryFieldErrorMessage()
						.contains("Claims should not be greater than number of workers required"),
				true, "Error message is not displayed");
		test.log(Status.INFO, "clicking close Icon button ");
		Thread.sleep(2000);
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");
		Thread.sleep(2000);

		order.clearField();
		test.log(Status.INFO, "Entering no of employees to claim");
		order.enterNoOfEmployeesClaim(noOfEmployeesClaim);
		test.log(Status.PASS, "Entered no of employees to claim successfully");
	
		
		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");

		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("E Signature"), true,
				"E signature error message is not displayed");

		test.log(Status.INFO, "clicking close Icon button ");
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");

		test.log(Status.INFO, "Entering ESignature");
		order.enterESignature(eSignature);
		test.log(Status.PASS, "Entered ESignature successfully");
	
		

		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");

		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Please Fill Mandatory Fields"), true,
				"Error message is not displayed");
		Assert.assertEquals(order.verifyMandatoryFieldErrorMessage().contains("Agree To Contract"), true,
				"Agree To Contract error message is not displayed");

		test.log(Status.INFO, "clicking close Icon button ");
		order.clickCloseIcon();
		test.log(Status.PASS, "clicked close Icon button successfully ");

		test.log(Status.INFO, "clicking Agree to Contract");
		order.clickAgreeContract();
		test.log(Status.PASS, "clicked Agree to Contract successfully");
	
		

		Assert.assertEquals(order.verifySubmitButtonIsVisible(), true, "Submit Button is not displayed");
		Assert.assertEquals(order.verifyCancelButtonIsVisible(), true, "Cancel Button is not displayed");
	
	
		test.log(Status.INFO, "clicking submit claim button ");
		order.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");

		Assert.assertEquals(order.verifyEmailSuccessMessage().contains("Email Sent Successfully"), true,
				"'Email Sent Successfully' message not displayed");
		
			Thread.sleep(3000);
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


	@DataProvider(name = "TG_MandatoryDataNewOrderStaffingPage")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_MandatoryDataNewOrderStaffingPage");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}