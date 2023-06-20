package jobOrder;

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
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.pages.SaveOrderPage;
import com.sf.pages.StartDateTimeFieldPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3864_SaveOrder extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	SaveOrderPage saveOrder;
public Logger log;

public void loader() throws IOException {
		log = LogManager.getLogger(TG_3864_SaveOrder.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		saveOrder = new SaveOrderPage(driver,log); 
	}
	@Test(dataProvider ="TG_3864_SaveOrder")
	public void Tag_VerifyConfirmJobOrderDetails(String url ,String username,String password,String estDailyHours,String startDate,String enddate,String startTime,String availability,String jobSite ,String jobTitle, String category, String noOfWorker,String eSignature ) throws InterruptedException {
		test = extent.createTest("Verify Confirm Job Order Details");
		log.info("Started==Verifying Confirm Job Order Details");  
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		saveOrder.newOrder();
		saveOrder.enterEstDailyHours(estDailyHours);
		Thread.sleep(2000);
		saveOrder.enterStartDate(startDate);
		Thread.sleep(2000);
		saveOrder.enterEndDate(enddate);
		Thread.sleep(2000);
		saveOrder.enterStartTime(startTime);
		Thread.sleep(2000);
		saveOrder.enterAvailability(availability);
		saveOrder.enterJobSite(jobSite);
		Thread.sleep(2000);
		saveOrder.enterJobTitle(jobTitle);
		Thread.sleep(2000);
		saveOrder.enterNoOfWorker(noOfWorker);
		Thread.sleep(2000);
		saveOrder.enterESignature(eSignature);
		saveOrder.clickAgreeContract();
		Thread.sleep(2000);
		Assert.assertEquals(saveOrder.verifyConfirmJobOrderDetails(),true , "Unable Verify Confirm Job Order Detail");
		test.log(Status.PASS, "Verify Confirm Job Order Details");
	
		log.info("Started==Verify Save And Cancel Button");  
		Assert.assertEquals(saveOrder.verifyConfirmationPopupShouldHaveConfirmAndButton(), true, "Verify Confirmation Popup Should Not Have Confirm  Buttons");
		Assert.assertEquals(saveOrder.verifyConfirmationPopupShouldHaveCancelButton(), true, "Verify Confirmation Popup Should Not Have Cancel Buttons");
		test.log(Status.PASS, "Verify Save And Cancel Button");
		Thread.sleep(3000);
	
		log.info("Started==Verify Clicking on Cancel Nothing Should Save");  
		saveOrder.clickingCancelButton();
		Assert.assertEquals(saveOrder.verifyClickingCancelNothingSave().contains("New Job Order"),true , "Unable Verify Clicking on Cancel Nothing Should Save");
		//Assert.assertEquals(saveOrder.verifyClickingCancelNothingSave(),true , "Unable Verify Clicking on Cancel Nothing Should Save");
		test.log(Status.PASS, "Verify Clicking on Cancel Nothing Should Save");
		Thread.sleep(3000);
		

		log.info("Started==Verifying Job Order Id And Popup that Email Sent Successfully");  
		saveOrder.enterEstDailyHours(estDailyHours);
		Thread.sleep(2000);
		saveOrder.enterStartDate(startDate);
		Thread.sleep(2000);
		saveOrder.enterEndDate(enddate);
		Thread.sleep(2000);
		saveOrder.enterStartTime(startTime);
		Thread.sleep(2000);
		saveOrder.enterAvailability(availability);
		saveOrder.enterJobSite(jobSite);
		Thread.sleep(2000);
		saveOrder.enterJobTitle(jobTitle);
		Thread.sleep(2000);
		saveOrder.enterNoOfWorker(noOfWorker);
		Thread.sleep(2000);
		saveOrder.enterESignature(eSignature);
		saveOrder.clickAgreeContract();
		Thread.sleep(6000);
		Assert.assertEquals(saveOrder.verifyJobOrderIdAndPopupEmailSentSuccessfully(),true , "Unable Verify Popup that Email Sent Successfully");
		test.log(Status.PASS, "Verify Job Order Id And Popup that Email Sent Successfully");
   }
	
   @DataProvider(name = "TG_3864_SaveOrder")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3864_SaveOrder");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}