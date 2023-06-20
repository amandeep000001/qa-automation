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
import com.sf.pages.StartDateTimeFieldPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;
public class TG_3854_StartDateTimeField extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	StartDateTimeFieldPage startField;
	public Logger log;
	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3854_StartDateTimeField.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		startField = new StartDateTimeFieldPage(driver,log); 
	}
	@Test(dataProvider ="TG_3854_Start_Date_Time_Field")
	public void Tag_VerifyStartDateFieldVisibleAndNotAcceptPastDate(String url ,String username,String password,String startDate,String endDate,String startTime) throws InterruptedException {
		test = extent.createTest("Verify Start Date Field should be Visible And Should Not Accept Past Date");
		log.info("Started==Verifying Start Date Field should be Visible And Should Not Accept Past Date");  
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successfully");
		test.log(Status.INFO, "Clicking New order button ");
		startField.newOrder();
		test.log(Status.PASS, "New order button clicked successfully");
		test.log(Status.INFO, "Entering Start Date");
		startField.enterStartDate(startDate);
		Thread.sleep(3000);
		test.log(Status.PASS, "Entered Start Date successfully");
		Assert.assertEquals(startField.verifyStartDateFieldVisibleAndNotAcceptPastDate(),true , "Unable to Verify stsrt Date Field Visible And Not Accept Past Date");
		Thread.sleep(3000);
		test.log(Status.INFO, "Closing Start Date Field DialogBox");
		startField.closeStartDateFieldDialogBox();
		test.log(Status.PASS, "Closed Start Date Field DialogBox successfully");
	
		log.info("Started==Verifying End Date Field should be Visible And Should Not Accept Past Date");  
		//startField.newOrder();
		test.log(Status.INFO, "Entering End Date");
		startField.enterEndDate(endDate);
		Thread.sleep(3000);
		test.log(Status.PASS, "Entered End Date successfully");
		Assert.assertEquals(startField.verifyEndDateFieldVisibleAndNotAcceptPastDate(),true , "Unable to Verify End Date Field Visible And Not Accept Past Date");
		Thread.sleep(3000);
		test.log(Status.INFO, "Closing End Date Field DialogBox");
		startField.closeEndDateFieldDialogBox();
		test.log(Status.PASS, "Closed End Date Field DialogBox successfully");
	
		log.info("Started==Verify Start Time eField Should be Visible And Mandatory");  
		startField.newOrder();
		Assert.assertEquals(startField.verifyStartTimeFieldShouldVisible(),true , "Verify Start Time Field Should be Visible And Mandatory");
		test.log(Status.PASS, "Start Time Field Visible");
		Thread.sleep(3000);
	
		log.info("Started==Verify Job Site Field Should be Visible And Mandatory");  
		startField.newOrder();
		Assert.assertEquals(startField.verifyJobSiteFieldShouldVisible(),true , "Verify Job Site FieldShould be Visible And Mandatory");
		test.log(Status.PASS, "Job Site Field Visible");
	
		log.info("Started==Verifying Start Time Field should Not Accept Past Time");  
		startField.newOrder();
		test.log(Status.INFO, "Entering Start Time");
		Thread.sleep(1000);
		startField.enterStartTime(startTime);
		test.log(Status.PASS, "Entered Start Time successfully");
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "TG_3854_Start_Date_Time_Field")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_3854_Start_Date_Time_Field");
	}
	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}