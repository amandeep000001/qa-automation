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

public class TG_4325_ApproveClaimFromHiring extends TestBase {

	LoginPage login;
	HomePage home;
	Functions functions;
	JobOrderPage job;
	ClaimOrderPage order;
	EndToEndCheckPage flow;
	HomePage homepage;
	DeleteJobOrderPage delete;
	String jobOrderId;

	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_4325_ApproveClaimFromHiring.class.getName());
		login = new LoginPage(driver, log);
		home = new HomePage(driver, log);
		job = new JobOrderPage(driver, log);
		order = new ClaimOrderPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		homepage = new HomePage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);

	}
	@Test(dataProvider = "TG_MandatoryDataApproveClaimFromHiringPage")
	public void Tag_EndToEndFlowNewOrderHiring(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String noOfEmployeesClaim, String employeePayRate, String eSignatureClaim,
			String alphabetValue, String specialCharacterValue, String approveCount, String approveCount1)
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
		homepage.logout();
		
		log.info("Started==Starting End To End Flow ClaimFromStaffing");
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(2000);
		login.enterUsername(usernameStaffing);
		login.enterPassword(passwordStaffing);
		login.clickLoginButton();
		flow.ClaimOrderForStaffing(noOfEmployeesClaim, employeePayRate, eSignatureClaim,jobOrderId);
		test.log(Status.PASS, "Login successful");
		test.log(Status.PASS, "Completed End To End Flow ClaimFromStaffing");
		homepage.logout();
	
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(5000);
		login.enterUsername(usernameHiring);
		login.enterPassword(passwordHiring);
		login.clickLoginButton();
		Thread.sleep(7000);
		test.log(Status.INFO, "Clicking on the Orders Menu present on hiring home page");
		home.clickOrdersMenuOnHiringHomePage();
		test.log(Status.PASS, "Orders menu clicked on hiring home page successfully");

//		test.log(Status.INFO, "Clicking on the All Orders Menu present on hiring home page");
//		home.clickAllOrdersOnStaffingHomePage();
//		test.log(Status.PASS, "All menu clicked on hiring home page successfully");
		Thread.sleep(3000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		job.selectParticularJobOrderFromListingHiring(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		Thread.sleep(2000);

		Assert.assertEquals(home.verifyPleaseReviewSubmittedClaimsMessage().contains("Please review submitted claims."),
				true, "PleaseReviewSubmittedClaimsmessage is not displayed");
	
	
		test.log(Status.INFO, "Clicking on the claims button present on hiring job order page");
		job.clickClaimsButton();
		test.log(Status.PASS, "Clicked claims button present on hiring job order page successfully");

		test.log(Status.INFO, "Clicking on the HeadCountButton present on hiring claim order page");
		Thread.sleep(3000);
		job.clickSelectHeadCountButton();
		test.log(Status.PASS, "Clicked HeadCountButton present on hiring claim order page successfully");
	
		
		test.log(Status.INFO,
				"Clicking on the HeadCountButton present on hiring job order page opens model title as 'Select Head Count' ");
		job.titleSelectHeadCountModal();
		test.log(Status.PASS,
				"Clicked on the HeadCountButton present on hiring job order page opens model title as 'Select Head Count' ");
	
		Assert.assertEquals(order.verifyApproveFieldIsVisible(), true, "Approvefield is not visible");
		
		test.log(Status.INFO,
				"Entering ApproveCount Greater than WorkersCount on hiring claim order page opens model title as 'Select Head Count' ");
		order.enterApproveCountGreater(approveCount1);
		test.log(Status.PASS,
				"Entered ApproveCount Greater than WorkersCount on hiring claim order page opens model title as 'Select Head Count' successfully ");
		Thread.sleep(2000);

		test.log(Status.INFO,
				"Clicking submit button on hiring claim order page opens model title as 'Select Head Count' ");
		order.clickModalSubmitButton();
		test.log(Status.INFO,
				"clicked submit button on hiring claim order page opens model title as 'Select Head Count' ");
		Assert.assertEquals(
				order.verifyErrorMessage().contains(
						"Claims approved cannot be greater than the no. of workers claimed by Staffing Company"),
				true,
				"Claims approved cannot be greater than the no. of workers claimed by Staffing Company is not displayed");
	
		Thread.sleep(10000);
		test.log(Status.INFO,
				"Clicking on the HeadCountButton present on hiring job order page opens model title as 'Select Head Count' ");
		job.clickSelectHeadCountButton();
		test.log(Status.PASS,
				"Clicked on the HeadCountButton present on hiring job order page opens model title as 'Select Head Count' ");

		test.log(Status.INFO,
				"Entering ApproveCount equal to WorkersCount on hiring claim order page opens model title as 'Select Head Count' ");
		order.enterApproveCount(approveCount);
		test.log(Status.PASS,
				"Entered ApproveCount equal to WorkersCount on hiring claim order page opens model title as 'Select Head Count' successfully ");
		Thread.sleep(2000);

		test.log(Status.INFO,
				"Clicking submit button on hiring claim order page opens model title as 'Select Head Count' ");
		order.clickModalSubmitButton();
		test.log(Status.INFO,
				"clicked submit button on hiring claim order page opens model title as 'Select Head Count' ");
		Assert.assertEquals(order.verifyEmailSuccessMessage().contains("Email Sent Successfully"), true,
				"'Email Sent Successfully' message not displayed");
		

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

	@DataProvider(name = "TG_MandatoryDataApproveClaimFromHiringPage")
	public Object[][] getData() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_MandatoryDataApproveClaimFromHiringPage");
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}
