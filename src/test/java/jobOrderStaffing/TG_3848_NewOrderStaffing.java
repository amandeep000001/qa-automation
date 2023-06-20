package jobOrderStaffing;

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
import com.sf.pages.NewOrderStaffingPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_3848_NewOrderStaffing extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	Functions fun;
	NewOrderStaffingPage newOrder;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_3848_NewOrderStaffing.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		newOrder = new NewOrderStaffingPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
	}

	@Test(dataProvider = "TG_NewOrderStaffing")
	public void Tag_VerifyJobOrdersFieldShouldVisibleOnHomepageOfStaffingUnderShortcuts(String url, String username,
			String password, String startDate, String endDate, String startTime, String estimatedHours, String estHours,
			String time) throws IOException, InterruptedException {
		test = extent.createTest("Verify Job Orders Field Should Visible On Home page Of Staffing Under Shortcuts");
		log.info("Started==Verify Job Orders Field Should Visible On Home page Of Staffing Under Shortcuts");
		driver.get(url);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		test.log(Status.PASS, "Login Successfully");
		Thread.sleep(3000);

		test.log(Status.INFO, "Verifying Job Orders Field Should Visible On Home page Of Staffing Under Shortcuts");
		Assert.assertEquals(newOrder.verifyJobOrdersFieldShouldVisibleUnderShortcuts(), true,
				"Verify Job order Field not visible");
		test.log(Status.PASS,
				"Verify Job Orders Field Should Visible On Home page Of Staffing Under Shortcuts Successfully");
	
		log.info("Started==Verify Add Order Button Should Visible On Home page ");
		Assert.assertEquals(newOrder.verifyAddOrderButtonShouldVisibleOnHomepage(), true,
				"VerifyAdd Order Button not visible");
		test.log(Status.PASS, "Verify Add Order Button Should Visible On Home page ");
	
		log.info("Started==Verifying Pop-up If click On Save Without Entering Mandatory Fields");
//		test.log(Status.INFO,"Clicking on Order button");
//		Thread.sleep(2000);
//		newOrder.clickOrder();
//		test.log(Status.PASS, "Click on Order button Successfully");
//		test.log(Status.INFO,"Clicking on All Option button");
//		Thread.sleep(3000);
//		newOrder.selectAllOption();
//		test.log(Status.PASS, "Click on All Option button Successfully");
		test.log(Status.INFO, "Clicking on Add Job Order button");
		Thread.sleep(10000);
		newOrder.clickAddJobOrder();
		test.log(Status.PASS, "Click on  Add Job Order button Successfully");
		test.log(Status.INFO, "Clicking on Save button");
		Thread.sleep(3000);
		newOrder.clickSaveButton();
		test.log(Status.PASS, "Click on Save button Successfully");
		test.log(Status.INFO, "Verifying Popup Mandatory Fields");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Select Job"), true,
				"Select Job field is not a mandatory field");
		test.log(Status.PASS, "Select Job field is verified as a mandatory field");
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
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Company"), true,
				"Company Full Name field is not a mandatory field");
		test.log(Status.PASS, "Company Full Name field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Availability"), true,
				"Availability field is not a mandatory field");
		test.log(Status.PASS, "Availability field is verified as a mandatory field");
		Assert.assertEquals(newOrder.verifyPopupMandatoryFieldsBlank().contains("Agree To Contract"), true,
				"Agree To Contract field is not a mandatory field");
		test.log(Status.PASS, "Agree To Contract field is verified as a mandatory field");
		test.log(Status.PASS, "Verify Popup Mandatory Fields Successfully");
		test.log(Status.INFO, "closing Blank Mandatory Field DialogBox");
		Thread.sleep(2000);
		newOrder.closeBlankMandatoryFieldDialogBox();
		test.log(Status.PASS, " Blank Mandatory Field DialogBox close Successfully");
	
		log.info("Started==Verifying Company Field Should Visible on Job order creation form");
		Thread.sleep(2000);
		Assert.assertEquals(newOrder.verifyCompanyFieldShouldVisible(), true, "Company Field is not a visible");
		test.log(Status.PASS, "Verify Company Field Should Visible on Job order creation form");
	
		log.info("Started==Verifying Category Field Should Visible on Job order creation form");
		Thread.sleep(5000);
		Assert.assertEquals(newOrder.verifycategoryFieldStaffingShouldVisible(), true,
				"Category Field is not a visible");
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
		Assert.assertEquals(
				newOrder.verifyEstimatedDailyHoursFieldNotAcceptHoursMoreThan24()
						.contains("Estimated Hours Per Day Cannot be Less Than Zero or Greater Than 24"),
				true, "unable to verify Estimated Hours Per Day Cannot be Less Than Zero or Greater Than 24");
		test.log(Status.PASS, "Verify Estimated Daily Hours Field Should  Not Accept Hours More Than 24 ");
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		test.log(Status.INFO, "clicking on Save Button");
		newOrder.clickSaveButton();
		test.log(Status.PASS, " click on Save Button Successfully");
		Assert.assertEquals(newOrder.verifyPopupForConfirmJobOrderDetails(), true,
				"Verify not showing Popup For Confirm Job Order Details");
		test.log(Status.PASS, "Verify Popup For Confirm Job Order Details");
	
		log.info("Started==Verify Confirmation Popup Should Have Confirm And Cancel Buttons ");
		Assert.assertEquals(newOrder.verifyConfirmationPopupShouldHaveConfirmAndButton(), true,
				"Verify Confirmation Popup Should Not Have Confirm  Buttons");
		Assert.assertEquals(newOrder.verifyConfirmationPopupShouldHaveCancelButton(), true,
				"Verify Confirmation Popup Should Not Have Cancel Buttons");
		test.log(Status.PASS, "Verify Confirmation Popup Should Have Confirm And Cancel Buttons");
	
		log.info("Started==Verify Clicking On Cancel Nothing Should Save");
		Assert.assertEquals(newOrder.verifyClickingCancelNothingShouldSave(), true,
				" Verify Clicking On Cancel Should Save order");
		test.log(Status.PASS, "Verify Clicking On Cancel Nothing Should Saves");
	
		log.info(
				"Started==Verify Clicking On Save Button Pop-up Should Create Job Order Successfully And Job Order id Should Created");
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
		Assert.assertEquals(newOrder.verifyJobOrderCreateSuccessfullyAndJobOrderIdShouldCreated(), true,
				"Verify Job order not created");
		test.log(Status.PASS,
				"Verify Clicking On Save Button Pop-up Should Create Job Order Successfully And Job Order id Should Created");
	
		log.info("Started==Verify Popup Email Sent Sucessfully");
		Assert.assertEquals(newOrder.verifyPopupEmailSentSucessfully(), true,
				"Verify Popup Email not Sent Sucessfully");
		test.log(Status.PASS, "Verify Popup Email Sent Sucessfully");

		log.info("Started==Verify Claim Has Been Approved Please Assign Employees");
		Assert.assertEquals(newOrder.verifyClaimHasBeenApprovedPleaseAssignEmployees(), true,
				"Verify Claim Has not Been Approved Please Assign Employees");
		test.log(Status.PASS, "Verify Claim Has Been Approved Please Assign Employees");
	}

	@DataProvider(name = "TG_NewOrderStaffing")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_NewOrderStaffing"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}
}