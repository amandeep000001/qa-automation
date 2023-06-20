package exclusiveJobOrder;

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
import com.sf.pages.ExclusiveNewOrderPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_3847_ExclusiveNewOrder extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	Functions fun;
	ExclusiveNewOrderPage newOrder;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3847_ExclusiveNewOrder.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		newOrder = new ExclusiveNewOrderPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
	}

	@Test(dataProvider = "TG_ExclusiveNewOrder")
	public void Tag_VerifyNewOrderbuttonOnHomepage(String url, String username, String password, String startDate,
			String endDate, String startTime, String estimatedHours, String estHours, String time, String eSignature)
			throws IOException, InterruptedException {
		test = extent.createTest("Verify New Order button On Homepage");
		log.info("Started==Verifying New Order button On Homepage");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login Successfully");
		test.log(Status.INFO, "Clicking New order button ");
		Thread.sleep(2000);
		newOrder.newOrder();
		test.log(Status.PASS, "New order button click successfully");
		Thread.sleep(2000);
		
		Assert.assertEquals(newOrder.verifyNewOrderbutton(), true, "  New Order button On Homepage not verify");
		test.log(Status.PASS, "Verifyied New Order button On Homepage Successfully");
	
		
		log.info("Started==Verifying Pop-up If click On Save Without Entering Mandatory Fields");
		test.log(Status.INFO, "Clicking New order button ");
		newOrder.newOrder();
		Thread.sleep(4000);
		test.log(Status.PASS, "New order button click successfully");
		test.log(Status.INFO, "Clicking on Save button");
		Thread.sleep(4000);
		newOrder.clickSaveButton();
		test.log(Status.PASS, "Click on Save button Successfully");
		test.log(Status.INFO, "Verifying Popup Mandatory Fields");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Select Job"), true,
				"Select Job field is not a mandatory field");
		test.log(Status.PASS, "Select Job field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Industry"), true,
				"Category field is not a mandatory field");
		test.log(Status.PASS, "Category field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Job Order Start Date"), true,
				"Job Order Start Date field is not a mandatory field");
		test.log(Status.PASS, "Job Order Start Date field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Job Site"), true,
				"Job Site field is not a mandatory field");
		test.log(Status.PASS, "Job Site field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Rate"), true,
				"Rate field is not a mandatory field");
		test.log(Status.PASS, "Rate field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Job Order End Date"), true,
				"Job Order End Date field is not a mandatory field");
		test.log(Status.PASS, "Job Order End Date field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Job Duration"), true,
				"Job Duration field is not a mandatory field");
		test.log(Status.PASS, "Job Duration field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Estimated Hours Per Day"), true,
				"Estimated Hours Per Day field is not a mandatory field");
		test.log(Status.PASS, "Estimated Hours Per Day field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("E-Signature Full Name"), true,
				"E-Signature Full Name field is not a mandatory field");
		test.log(Status.PASS, "E-Signature Full Name field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Availability"), true,
				"Availability field is not a mandatory field");
		test.log(Status.PASS, "Availability field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Agree To Contract"), true,
				"Agree To Contract field is not a mandatory field");
		test.log(Status.PASS, "Agree To Contract field is verified as a mandatory field");
		test.log(Status.PASS, "Verify Popup Mandatory Fields Successfully");
		test.log(Status.INFO, "closing Blank Mandatory Field DialogBox");
		Thread.sleep(3000);
		newOrder.closeBlankMandatoryFieldDialogBox();
		test.log(Status.PASS, " Blank Mandatory Field DialogBox close Successfully");
	
		log.info("Started==Verifying Company Field Should Visible on Job order creation form");
		Assert.assertEquals(newOrder.verifyCompanyFieldShouldVisible(), true, "Company Field is not a visible");
		test.log(Status.PASS, "Verify Company Field Should Visible on Job order creation form");
	
		log.info("Started==Verifying Category Field Should Visible on Job order creation form");
		Thread.sleep(3000);
		Assert.assertEquals(newOrder.verifyCategoryFieldShouldVisible(), true, "Category Field is not a visible");
		test.log(Status.PASS, "Verify Category Field Should Visible on Job order creation form");
	
		log.info("Started==Verifying Availability Field Should be Dropdown Field");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyAvailabilityFieldShouldDropdownField(), true,
				" Availability Field is not a visible");
		test.log(Status.PASS, "Verify Availability Field Should be Dropdown Field");
	
		log.info("Started==Verifying Start Date Field Should Visible ");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyStartDateField(), true, "date Field is not a visible");
		test.log(Status.PASS, "Verify Start Date Field Should Visible ");
	
		log.info("Started==Verifying End Date Field Should Visible ");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyEndDateField(), true, "date Field is not a visible");
		test.log(Status.PASS, "Verify End Date Field Should Visible ");
	
		log.info("Started==Verifying Start Time Field Should Visible ");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyStartTimeField(), true, "Time Field is not a visible");
		test.log(Status.PASS, "Verify Start Time Field Should Visible ");
	
		log.info("Started==Verifying Job Site Field Should Visible ");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyJobSiteField(), true, "job site Field is not a visible");
		test.log(Status.PASS, "Verify Job Site Field Should Visible ");
	
		log.info("Started==Verifying Estimated Daily Hours Field Should Visible ");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyEstimatedDailyHoursField(), true,
				"Estimated Daily Hours Field is not a visible");
		test.log(Status.PASS, "Verify Estimated Daily Hours Field Should Visible ");
	
		log.info("Started==Verifying Estimated Daily Hours Field Should  Not Accept Hours More Than 24 ");
		newOrder.enterEstHours(estimatedHours);
		Thread.sleep(2000);
		Assert.assertEquals(
				newOrder.verifyEstimatedDailyHoursFieldNotAcceptHoursMoreThan24()
						.contains("Estimated Hours Per Day Cannot be Less Than Zero or Greater Than 24"),
				true, "unable to verify Estimated Hours Per Day Cannot be Less Than Zero or Greater Than 24");
		test.log(Status.PASS, "Verify Estimated Daily Hours Field Should  Not Accept Hours More Than 24 ");
		newOrder.closeEstimatedDailyhoursDialogBox();

		log.info("Started==Verifying No Of Workers Field Should  visible ");
		Assert.assertEquals(newOrder.verifyNoOfWorkersFieldShouldVisible(), true,
				"Verify No Of Workers Field not visible");
		test.log(Status.PASS, "Verify No Of Workers Field Should visible");
	
		log.info("Started==Verify Agree To Contract Field Should Be Checkbox ");
		Assert.assertEquals(newOrder.verifyAgreeToContractFieldShouldBeCheckbox(), true,
				"Verify Agree To Contract Field Should Be Checkbox");
		test.log(Status.PASS, "Verify Agree To Contract Field Should Be Checkbox");
	
		log.info("Started==Verify Popup For Confirm Job Order Details");
		test.log(Status.INFO, "Entering estimated hours");
		newOrder.enterHours(estHours);
		test.log(Status.PASS, " Enter estimated hours Successfully");
		test.log(Status.INFO, "Entering Start Date");
		Thread.sleep(3000);
		newOrder.enterStartDate(startDate);
		test.log(Status.PASS, " EnterStart Date Successfully");
		test.log(Status.INFO, "Entering End Date");
		Thread.sleep(3000);
		newOrder.enterEndDate(endDate);
		test.log(Status.PASS, " Enter End Date Successfully");
		test.log(Status.INFO, "Entering Start Time");
		Thread.sleep(3000);
		newOrder.enterTime(time);
		test.log(Status.PASS, " Enter Start Time Successfully");
		test.log(Status.INFO, "Entering eSignature");
		newOrder.enterESignature(eSignature);
		test.log(Status.PASS, " Enter eSignature Successfully");
		Thread.sleep(3000);
		Assert.assertEquals(newOrder.verifyPopupForConfirmJobOrderDetails(), true,
				"Verify not showing Popup For Confirm Job Order Details");
		Thread.sleep(2000);
		test.log(Status.PASS, "Verify Popup For Confirm Job Order Details");
	
		log.info("Started==Verify Confirmation Popup Should Have Save And Cancel Buttons ");
		Assert.assertEquals(newOrder.verifyConfirmationPopupShouldHaveConfirmAndButton(), true,
				"Verify Confirmation Popup Should Not Have Confirm  Buttons");
		Assert.assertEquals(newOrder.verifyConfirmationPopupShouldHaveCancelButton(), true,
				"Verify Confirmation Popup Should Not Have Cancel Buttons");
		test.log(Status.PASS, "Verify Confirmation Popup Should Have Save And Cancel Buttons");
	
		log.info("Started==Verify Clicking On Cancel Nothing Should Save");
		Assert.assertEquals(newOrder.verifyClickingCancelNothingShouldSave(), true,
				" Verify Clicking On Cancel Should Save order");
		test.log(Status.PASS, "Verify Clicking On Cancel Nothing Should Saves");
	
		log.info(
				"Started==Verify Clicking On Save Button Pop-up Should Create Job Order Successfully And Job Order id Should Created");
		test.log(Status.INFO, "Entering eSignature");
		newOrder.enterESignature(eSignature);
		test.log(Status.PASS, " Enter eSignature Successfully");
		Thread.sleep(2000);
		test.log(Status.INFO, "Entering estimated hours");
		Thread.sleep(1000);
		newOrder.enterHours(estHours);
		test.log(Status.PASS, " Enter estimated hours Successfully");
		test.log(Status.INFO, "Entering Start Date");
		Thread.sleep(2000);
		newOrder.enterStartDate(startDate);
		test.log(Status.PASS, " EnterStart Date Successfully");
		test.log(Status.INFO, "Entering End Date");
		Thread.sleep(3000);
		newOrder.enterEndDate(endDate);
		test.log(Status.PASS, " Enter End Date Successfully");
		test.log(Status.INFO, "Entering Start Time");
		Thread.sleep(3000);
		newOrder.enterTime(time);
		test.log(Status.PASS, " Enter Start Time Successfully");
		Thread.sleep(2000);
		newOrder.enterHours(estHours);
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyJobOrderCreateSuccessfullyAndJobOrderIdShouldCreated(), true,
				"Verify Job order not created");
		test.log(Status.PASS,
				"Verify Clicking On Save Button Pop-up Should Create Job Order Successfully And Job Order id Should Created");
	
		log.info("Started==Verify Popup Email Sent Sucessfully");
		Assert.assertEquals(newOrder.verifyPopupEmailSentSucessfully(), true,
				"Verify Popup Email not Sent Sucessfully");
		test.log(Status.PASS, "Verify Popup Email Sent Sucessfully");
	}

	@DataProvider(name = "TG_ExclusiveNewOrder")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_ExclusiveNewOrder"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}