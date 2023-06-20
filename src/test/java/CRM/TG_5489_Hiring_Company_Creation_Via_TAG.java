package CRM;

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
import com.sf.pages.CompanyListingPage;
import com.sf.pages.ContactCreation;
import com.sf.pages.HomePage;
import com.sf.pages.LeadCreation;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_5489_Hiring_Company_Creation_Via_TAG extends TestBase {

	LoginPage jo;
	Functions functions;
	HomePage homePage;
	Functions fun;
	String JobOrderId;
	ContactCreation contact;
	AddNewEmployeePage addEmp;
	LeadCreation lead;
	String newUserEmail = null;
	String newLastName = null;
	String newCompany = null;
	CompanyListingPage companyListing;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_5489_Hiring_Company_Creation_Via_TAG.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
		contact = new ContactCreation(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		lead = new LeadCreation(driver, log);
		companyListing = new CompanyListingPage(driver, log);
	}

	@Test(dataProvider = "TG_5489_Hiring_Company_Creation_Via_TAG")
	public void TG_5461_VerifyUserIsAbleToRouteToLeadFormSuccessfully(String url, String username, String password, String firstName,
			String lastName, String companyType, String companyName, String email, String phoneNumber, String address,
			String notes, String startDate, String endDate, String title, String sign)
			throws IOException, InterruptedException {
		test = extent.createTest("TG_5461- Verify CRM Icon on Homepage and is able to route to Lead Form Successfully");
		log.info("Logging in");
		driver.get(url);
		log.info("Entering Username");
		jo.enterUsername(username);
		log.info("Username Entered Successfully");
		log.info("Entering Password");
		jo.enterPassword(password);
		log.info("Password Entered Successfully");
		log.info("Clicking on Login Button");
		jo.clickLoginButton();
		test.log(Status.PASS, "Login successful");
		log.info("Verifying CRM Icon");
		Assert.assertEquals(contact.verifyCRMTextOnStaffingHomepage().contains("CRM"), true, "CRM is not displayed");
		log.info("CRM Icon Verified successfully");
		log.info("Clicking on CRM Icon");
		contact.clickCRMIcoOnHomepage();
		log.info("CRM Icon Clicked Successfully");
		Thread.sleep(2000);
		log.info("Clicking on Lead Icon");
		lead.clickLeadIcon();
		log.info("Lead Icon Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verify Listing Form");
		Assert.assertEquals(lead.verifyLeadListingForm().contains("Leads"), true,
				"Leads Listing form is not displayed");
		log.info("Listing Form verified successfully");
		Thread.sleep(2000);
		log.info("Clicking on Add Lead Button");
		lead.clickAddLeadButton();
		log.info("Add Lead Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verifying the Lead Form Title");
		Assert.assertEquals(lead.verifyLeadForm().contains("New Lead"), true, "New Contact Form is not displayed");
		log.info("Lead Form Title is Verified Successfully");

	
		log.info("Verifying Mandatory Fields");
		lead.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertEquals(contact.verifyMandatoryFieldIsBlank(), true, "Fields are not mandatory");
		test.log(Status.PASS, "Mandatory fields has been verified");
		Thread.sleep(2000);
		log.info("Closing the Pop-up");
		contact.closeBlankMandatoryFieldDialogBox();
		log.info("Pop-up closed Successfully");
		Thread.sleep(2000);
		log.info("Entering First Name");
		lead.enterFirstName(firstName);
		log.info("First Name Entered Successfully");
		log.info("Entering Last Name");
		newLastName = lastName + " " + functions.randomNumberGenerator(3);
		lead.enterLastName(newLastName);
		log.info("Last Name Entered Successfully");
		log.info("Entering Company Type");
		contact.enterCompanyType(companyType);
		log.info("Company Type Entered Successfully");
		newCompany = companyName + " " + functions.randomNumberGenerator(3);
		log.info("Entering Company Name");
		lead.enterCompanyName(newCompany);
		log.info("Company Name Entered Successfully");
		log.info("Entering Email");
		newUserEmail = email + functions.randomNumberGenerator(5) + "@yopmail.com";
		lead.enterEmail(newUserEmail);
		log.info("Email Entered Successfully");
		Thread.sleep(2000);
		log.info("Entering Phone Number");
		lead.enterPhoneNumber(phoneNumber);
		log.info("Phone Number Entered Successfully");

		Thread.sleep(2000);
		log.info("Entering Employee Address");
		addEmp.enterEmployeeAddressOnMaps(address);
		log.info("Employee Address Entered Successfull");
		Thread.sleep(2000);
		log.info("Clicking on Save Button");
		lead.clickSaveButton();
		log.info("Save Button Clicked Successfully");
		Thread.sleep(3000);
		log.info("Verify the LEAD Status");
		Assert.assertEquals(lead.verifyLeadStatus().contains("Lead"), true, "Lead Status not displayed");
		log.info("LEAD Status verified Successfully");
		Thread.sleep(2000);
		log.info("Clicking Lead Link for Listing form");
		lead.clickLeadLinkforListingForm();
		log.info("Lead Link for Listing form clicked Successfully");
		Thread.sleep(2000);
		companyListing.clickFiveHundredFilter();
		Thread.sleep(5000);
		log.info("Verify Lead created Successfully or not");
		Assert.assertEquals(lead.verifyLeadCreatedOnListingPage(newCompany), true,
				"New Lead Form is not displayed");
		Thread.sleep(2000);
		log.info("Selecting the Open Lead Status");
		lead.clickLeadStatusOpen();
		log.info("Open Lead Status Selected Successfully");
		Thread.sleep(2000);
		log.info("Clicking Notes Tab");
		lead.clickNotesTab();
		log.info("Notes Tab Clicked Successfully");
		Thread.sleep(2000);
		log.info("Entering Notes");
		lead.enterNotes(notes);
		log.info("Notes Entered Successfully");
		Thread.sleep(2000);
		log.info("Clicking Overview Tab");
		lead.clickOverviewTab();
		log.info("Overview Tab Clicked Successfully");
		Thread.sleep(2000);
		log.info("Selecting the Contract Negotiation Lead Status");
		lead.clickLeadStatusContractNegotiation();
		log.info("Contract Negotiation Lead Status Selected Successfully");
		Thread.sleep(2000);
		log.info("Clicking Save Button");
		lead.clickSaveButton();
		log.info("Save Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verify Prepare Contract Button");
		Assert.assertEquals(lead.verifyPrepareContractButton(), true, "Verify Prepare Contract Button");
		log.info("Prepare Contract Button Verified Successfully");
		log.info("Click Prepare Contract Button");
		lead.clickPrepareContractButton();
		log.info("Prepare Contract Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verify Contract Form");
		Assert.assertEquals(lead.verifyContractForm().contains("New Contract"), true,
				"New Contact Form is not displayed");
		log.info("New Contract Form verified Successfully");
		log.info("Entering Start Date");
		lead.enterStartDate(startDate);
		log.info("Start Date Entered Successfully");
		Thread.sleep(2000);
		log.info("Entering End Date");
		lead.enterEndDate(endDate);
		log.info("End Date Entered Successfully");
		Thread.sleep(2000);
		log.info("Clicking Add Row Button");
		lead.clickAddRowButton();
		log.info("Add Row Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Clicking Job Title");
		lead.clickJobTitleInTable();
		log.info("Job Title Clicked Successfully");
		Thread.sleep(2000);
		log.info("Entering Job Title");
		lead.enterTitle(title);
		log.info("Job Title Entered Successfully");
		Thread.sleep(2000);
		log.info("Entering Signature");
		lead.enterSign(sign);
		log.info("Signature Entered Successfully");
		Thread.sleep(2000);
		log.info("Clicking Save Button in Contract");
		lead.clickSaveButtonInContract();
		log.info("Save Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verify Finalize Contract Button");
		Assert.assertEquals(lead.verifyFinalizeButton(), true, "Verify Finalize Button");
		log.info("Finalize Contract Button verified Successfully");
		Thread.sleep(2000);
		log.info("Clicking Finalize Contrac Button");
		lead.clickFinalizeButton();
		log.info("Finalize Contrac Button Clicked Successfully");
		Thread.sleep(30000);

		Thread.sleep(33000);
		log.info("Clicking Contract Link");
		lead.clickContractLinkforListingForm();
		log.info("Contract Link Clicked Successfully");
		Thread.sleep(2000);
		companyListing.clickFiveHundredFilter();
		Thread.sleep(5000);
		log.info("Verify Created Contract");
		Assert.assertEquals(lead.verifyContractCreatedOnListingPage(newCompany), true,
				"New Lead Form is not displayed");
		log.info("Created Contract Verified Successfully");
		Thread.sleep(2000);
		log.info("Verifying CRM Icon");
		lead.clickCRMIcon();
		log.info("CRM Icon Clicked Successfully");
		Thread.sleep(2000);
		log.info("Clicking Contact Link");
		lead.clickContactIcon();
		log.info("Contact Link Clicked Successfully");
		companyListing.clickFiveHundredFilter();
		Thread.sleep(5000);
		log.info("Verify Created Contact");
		Assert.assertEquals(lead.verifyLeadCreatedOnListingPage(newCompany), true,
				"New Lead Form is not displayed");
		log.info("Created Contact Verified Successfully");

	}

	@DataProvider(name = "TG_5489_Hiring_Company_Creation_Via_TAG")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_5489_Hiring_Company_Creation_Via_TAG"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}

}
