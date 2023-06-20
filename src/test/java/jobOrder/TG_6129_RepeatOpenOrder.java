package jobOrder;
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
import com.sf.pages.DeleteJobOrderPage;
import com.sf.pages.EndToEndCheckPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.SaveOrderPage;
import com.sf.pages.StaffingHomePage;
import com.sf.pages.StaffingJobOrderPage;
import com.sf.pages.StartDateTimeFieldPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_6129_RepeatOpenOrder extends TestBase {
	Functions functions;
	HomePage homePage;
	SaveOrderPage saveOrder;
	BlockCompany block;
	HomePage homepage;
	LoginPage login;
	EndToEndCheckPage flow;
	StaffingHomePage home;
	String jobOrderId;
	JobOrderPage job;
	ClaimOrderPage claim;
	StaffingJobOrderPage jo;
	DeleteJobOrderPage delete;
	String jobSiteValue;
	String jobTitleValue;
	String jobIndustryValue;
	String estHoursValue;
	String noOfWorkers;
	String ESignature;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_6129_RepeatOpenOrder.class.getName());
		functions = new Functions();
		login = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		saveOrder = new SaveOrderPage(driver, log);
		block = new BlockCompany(driver, log);
		homepage = new HomePage(driver, log);
		login = new LoginPage(driver, log);
		flow = new EndToEndCheckPage(driver, log);
		home = new StaffingHomePage(driver, log);
		job = new JobOrderPage(driver, log);
		claim = new ClaimOrderPage(driver, log);
		jo = new StaffingJobOrderPage(driver, log);
		delete = new DeleteJobOrderPage(driver, log);
	}
	@Test(dataProvider = "TG_6129_repeat_open_order")
	public void TG_6129_VerifyRepeatOpenOrderCreatedSuccessfully(String url, String usernameHiring,
			String passwordHiring, String startDate, String enddate, String availability,
			String usernameStaffing, String passwordStaffing) throws InterruptedException {
		test = extent.createTest("TG-6129 Repeat Job Order Flow");
		
		
		driver.get(url);
		
		test.log(Status.INFO, "Entering Username");
		login.enterUsername(usernameHiring);
		test.log(Status.PASS, "Username Entered Successfully");
		
		test.log(Status.INFO, "Entering Password");
		login.enterPassword(passwordHiring);
		test.log(Status.PASS, "Password Entered Successfully");
		
		test.log(Status.INFO, "Clicking on Login Button");
		login.clickLoginButton();
		test.log(Status.PASS, "Login Button Clicked Successfully");
		
		test.log(Status.INFO, "Clicking on Job Orders Button");
		Thread.sleep(3000);
		homePage.clickOrdersMenuOnHiringHomePage();
		test.log(Status.PASS, "Clicked Orders Successfully");
		
		Thread.sleep(10000);
		test.log(Status.INFO, "Clicking on the Completed Orders Tab");
		job.clickCompletedOrdersTab();
		test.log(Status.PASS, "Completed Tab Clicked Successfully");
		
		Thread.sleep(15000);
		test.log(Status.INFO, "Clicking on the Completed Order");
		job.clickCompletedOrder();
		test.log(Status.PASS, "Completed Order Clicked Successfully");
		
		test.log(Status.INFO, "Getting Job Site Text");
		jobSiteValue=job.getJobSiteText();
		test.log(Status.PASS, "Got the Job Site text successfully");
		
		test.log(Status.INFO, "Getting Job Title Text");
		jobTitleValue=job.getJobTitleText();
		test.log(Status.PASS, "Got the Job Title text successfully");
		
		test.log(Status.INFO, "Getting Job Industry Text");
		jobIndustryValue=job.getJobIndustryText();
		test.log(Status.PASS, "Got the Job Industry text successfully");
		
//		test.log(Status.INFO, "Getting Estimated Hours Text");
//		estHoursValue=job.getEstHoursText();
//		test.log(Status.PASS, "Got the Estimated Hours text successfully");
//		
//		test.log(Status.INFO, "Getting Number of Workers Text");
//		noOfWorkers=job.getNoOfWorkers();
//		test.log(Status.PASS, "Got the Number of Workers text successfully");
		
		test.log(Status.INFO, "Getting ESignature Text");
		ESignature=job.getESignature();
		test.log(Status.PASS, "Got the ESignature Text successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on the Repeat Order Button");
		job.clickRepeatOrderButton();
		test.log(Status.PASS, "Repeat Order Button Clicked Successfully");
		
		test.log(Status.INFO, "Clicking on the Open Order Checkbox");
		job.clickOpenOrderCheckbox();
		test.log(Status.PASS, "Open Order Checkbox Clicked Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on the Proceed Button");
		job.clickProceedButton();
		test.log(Status.PASS, "Proceed Butto Clicked Successfully");
		
		Assert.assertEquals(job.verifyJobSiteTextIsPresent(jobSiteValue), true,
				"Job Site doesn't exist");
		
		Assert.assertEquals(job.verifyJobTitleTextIsPresent(jobTitleValue), true,
				"Job Title doesn't exist");
		
		Assert.assertEquals(job.verifyJobIndustryTextIsPresent(jobIndustryValue), true,
				"Job Industry doesn't exist");
		
//		Assert.assertEquals(job.verifyEstHoursTextIsPresent(estHoursValue), true,
//				"Estimated Hours doesn't exist");
//		
//		Assert.assertEquals(job.verifynoOfWorkersTextIsPresent(noOfWorkers), true,
//				"Number of Workers doesn't exist");
		
		Assert.assertEquals(job.verifyESignatureTextIsPresent(ESignature), true,
				"ESignature doesn't exist");
		
		Thread.sleep(4000);
		test.log(Status.INFO, "Entering Start Date");
		saveOrder.enterStartDate(startDate);
		test.log(Status.PASS, "Start Date entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering End Date");
		saveOrder.enterEndDate(enddate);
		test.log(Status.PASS, "End Date entered Successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering Availability");
		saveOrder.enterAvailability(availability);
		test.log(Status.PASS, "Availability entered Successfully");
		
		test.log(Status.INFO, "Clicking Save and Verifying Pop-up");
		job.clickSaveAndVerifyPopUp();
		test.log(Status.PASS, "Save button Clicked Successfully and Pop-Up verified");
		
		test.log(Status.INFO, "Fetching Hiring order id");
		jobOrderId = block.getTextHiringId();
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
		
		test.log(Status.INFO, "clicking job order home page");
		home.clickJobOrderHomePage();
		test.log(Status.PASS, "clicked job order home page successfully");
		
		Thread.sleep(2000);
		test.log(Status.INFO, "Verify Job Order form");
		Assert.assertEquals(jo.verifyJobOrderPage(), true, "Job order page title not displayed");
		test.log(Status.PASS, "Job Order form verified successfully");
		
		Thread.sleep(10000);
		test.log(Status.INFO, "Selecting Particular Joborder on the listing");
		block.selectParticularJobOrderFromListing(jobOrderId);
		test.log(Status.PASS, "Particular Joborder on the listing selected successfully");
		
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
	@DataProvider(name = "TG_6129_repeat_open_order")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_6129_repeat_open_order");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}