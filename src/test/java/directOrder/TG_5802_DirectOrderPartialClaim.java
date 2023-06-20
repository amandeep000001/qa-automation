package directOrder;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import com.aventstack.extentreports.Status;
import com.sf.base.TestBase;
import com.sf.pages.BlockCompany;
import com.sf.pages.ClaimOrderPage;
import com.sf.pages.EndToEndCheckPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.pages.SaveOrderPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.pages.StartDateTimeFieldPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_5802_DirectOrderPartialClaim extends TestBase {

	Functions functions;
	HomePage homePage;
	SaveOrderPage saveOrder;
	BlockCompany block;
	HomePage homepage;
	LoginPage login;
	EndToEndCheckPage flow;
	StaffingHomePage home;
	String jobOrderId;
	StaffingJobOrderPage jo;
	ClaimOrderPage claim;
	
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_5802_DirectOrderPartialClaim.class.getName());
		functions = new Functions();
		login = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		saveOrder = new SaveOrderPage(driver, log);
		block = new BlockCompany(driver, log);
		homepage = new HomePage(driver, log);
		login = new LoginPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		home = new StaffingHomePage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		claim = new ClaimOrderPage(driver, log);
	}

	@Test(dataProvider = "TG_5802_automate_direct_order_partial_claim")
	public void VerifyUserRedirectToNewOrderFormViaDirectOrder(String url, String usernameHiring, String passwordHiring,
			String usernameStaffing, String passwordStaffing, String estDailyHours, String startDate, String enddate,
			String startTime, String availability, String jobSite, String jobTitle, String category, String noOfWorker,
			String eSignature, String usernameStaffing2, String passwordStaffing2, String noOfEmployeesClaim, String eSignature1) throws InterruptedException {
		test = extent.createTest("Verify Confirm Job Order Details");
		test.log(Status.PASS, "Started==Verifying Confirm Job Order Details");
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
		
		test.log(Status.INFO, "Clicking on Staffing Companies");
		block.clickStaffingCompanies();
		test.log(Status.PASS, "Staffing Companies Clickied Successfully");
		
		test.log(Status.INFO, "Verifying Staffing Companies List");
		block.verifyStaffingCompanyList();
		test.log(Status.PASS, "Staffing Companies List verified successfully");
		
		
//		test.log(Status.INFO,"Clicking on Distance Filter");
//		block.clickDistanceFilter();
//		test.log(Status.PASS,"Clicked on Distance Filter");
//		Thread.sleep(3000);
//		
//		test.log(Status.INFO,"Clicking on Clear Filter");
//		block.clickClearFilter();
//		test.log(Status.PASS,"Clicked on Clear Filter");
		Thread.sleep(8000);
		
		test.log(Status.INFO, "Clicking on Hundred filter");
		block.clickHundredFilter();
		test.log(Status.PASS, "Clicked on Hundred filter");
		Thread.sleep(5000);
		
		test.log(Status.INFO, "Clicking Staffing Company");
		block.clickStaffingCompanyDirectOrder();
		test.log(Status.PASS, "Staffing Company Clickied Successfully");
		
		Thread.sleep(3000);
		
		test.log(Status.INFO, "Clicking on Place Order Button");
		block.clickPlaceOrderButton();
		test.log(Status.PASS, "Place Order Button Clickied Successfully");
	

	
		test.log(Status.INFO, "Started==Starting End To End Flow NewOrderHiring");
		
		test.log(Status.INFO, "Entering Estimated Hours");
		saveOrder.enterEstDailyHours(estDailyHours);
		test.log(Status.PASS, "Estimated Hours entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Start Date");
		saveOrder.enterStartDate(startDate);
		test.log(Status.PASS, "Start Date entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering End Date");
		saveOrder.enterEndDate(enddate);
		test.log(Status.PASS, "End Date entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Start Time");
		saveOrder.enterStartTime(startTime);
		test.log(Status.PASS, "Start Time entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Availability");
		saveOrder.enterAvailability(availability);
		test.log(Status.PASS, "Availability entered Successfully");
		
		test.log(Status.INFO, "Entering Job Site");
		saveOrder.enterJobSite(jobSite);
		test.log(Status.PASS, "Job Site entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Job Title");
		saveOrder.enterJobTitle(jobTitle);
		test.log(Status.PASS, "Job Title entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Number of workers");
		saveOrder.enterNoOfWorker(noOfWorker);
		test.log(Status.PASS, "Number of workers entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering ESignature");
		saveOrder.enterESignature(eSignature);
		test.log(Status.PASS, "ESignature entered Successfully");
		
		test.log(Status.INFO, "Clicking Agree to Contract");
		saveOrder.clickAgreeContract();
		test.log(Status.PASS, "Agree to Contract clicked Successfully");
		Thread.sleep(3000);
		
	
		
		log.info("Started==Verifying Job Order Id And Popup that Email Sent Successfully");
		Thread.sleep(6000);
		
		test.log(Status.INFO, "Verifying pop-up");
		block.verifyJobOrderIdAndPopupEmailSentSuccessfully();
		test.log(Status.PASS, "Pop-up verified successfully");
		
		test.log(Status.INFO, "Fetching Hiring order id");
		jobOrderId=block.getTextHiringId();
		test.log(Status.PASS, "Job order id fetched successfully");
		
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on logout button");
		homepage.logout();	
		test.log(Status.PASS, "Clicked logout button");
		
	
	
		Thread.sleep(3000);
		driver.get(url);
		test.log(Status.INFO, "Entering Username");
		login.enterUsername(usernameStaffing);
		test.log(Status.PASS, "Username Entered Successfully");
		
		test.log(Status.INFO, "Entering Password");
		login.enterPassword(passwordStaffing);
		test.log(Status.PASS, "Password Entered Successfully");
		
		test.log(Status.INFO, "Clicking on Login Button");
		login.clickLoginButton();
		test.log(Status.PASS, "Login Button Clicked Successfully");
		
		Thread.sleep(3000);
		test.log(Status.INFO, "Clicking on Notifications Icon");
		block.clickNotificationIcon();
		test.log(Status.PASS, "Notifications Icon Clicked Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Verifying Notification Text");
		Assert.assertEquals(block.verifyNotificationText().contains(
				"Genpact Hiring is requesting a fulfilment of a work order for Administrative Service specifically with maruti suzuki. Please respond."),
				true, "Company not blicked successfully");
		test.log(Status.PASS, "Notification Text Clicked Successfully");
		
		test.log(Status.INFO, "clicking job order home page");
		home.clickJobOrderHomePage();
		test.log(Status.INFO, "clicked job order home page successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Verify Job Order form");
		Assert.assertEquals(jo.verifyJobOrderPage(), true, "Job order page title not displayed");
		test.log(Status.INFO, "Job Order form verified successfully");
		Thread.sleep(10000);

		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		block.selectParticularJobOrderFromListing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		
		Thread.sleep(5000);
		test.log(Status.PASS, "Clicking Orders menu on the homepage");
		homepage.clickOrdersMenuOnStaffingHomePage();
		test.log(Status.PASS, "Orders menu on the homepage clicked successfully");
		
		Thread.sleep(2000);
		test.log(Status.PASS, "Clicking on Direct Order");
		block.clickDirectOrderNav();
		test.log(Status.PASS, "Direct Order clicked successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		block.selectParticularJobOrderFromListing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");

	
		Thread.sleep(5000);
		test.log(Status.PASS, "Clicking on Claim order button");
		jo.clickClaimOrderButton();
		test.log(Status.PASS, "Claim order button clicked successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering no of employees to claim");
		claim.enterNoOfEmployeesClaim(noOfEmployeesClaim);
		test.log(Status.PASS, "Entered no of employees to claim successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering ESignature");
		claim.enterESignature(eSignature1);
		test.log(Status.PASS, "Entered ESignature successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "clicking Agree to Contract");
		claim.clickAgreeContract();
		test.log(Status.PASS, "clicked Agree to Contract successfully");
		
		Thread.sleep(10000);
		test.log(Status.INFO, "clicking submit claim button ");
		claim.clickSubmitClaim();
		test.log(Status.PASS, "clicked submit claim successfully");
		
		Thread.sleep(60000);
		test.log(Status.INFO, "Verify Auto Approve Text");
		Thread.sleep(10000);
		Assert.assertEquals(jo.autoApproveText().contains("Please assign employees."), true,
				"'Your company's claim has been approved. Please assign employees. not displayed");
		test.log(Status.PASS, "Auto Approve Text displayed successfully");
	}

	@DataProvider(name = "TG_5802_automate_direct_order_partial_claim")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_5802_automate_direct_order_partial_claim");
	}

	public void closeSession() throws InterruptedException {
		 driver.quit();
	}
}