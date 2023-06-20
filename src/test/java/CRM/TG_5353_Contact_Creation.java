package CRM;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
import com.sf.pages.BlockCompany;
import com.sf.pages.CompanyListingPage;
import com.sf.pages.ContactCreation;
import com.sf.pages.EmployeeListingPage;
import com.sf.pages.HomePage;
import com.sf.pages.LoginPage;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

public class TG_5353_Contact_Creation extends TestBase {
	LoginPage jo;
	Functions functions;
	HomePage homePage;
	Functions fun;
	String JobOrderId;
	ContactCreation contact;
	String newUserEmail = null;
	String newContact = null;
	AddNewEmployeePage addEmp;
	CompanyListingPage companyListing;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(TG_5353_Contact_Creation.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		homePage = new HomePage(driver, log);
		fun = new Functions();
		contact = new ContactCreation(driver, log);
		addEmp = new AddNewEmployeePage(driver, log);
		companyListing = new CompanyListingPage(driver, log);
	}

	@Test(dataProvider = "TG_5353_Contact_Creation")
	public void TG_5322_VerifyContactCreationForm(String url, String username, String password, String contactName, String email,
			String phoneNumber, String lead, String address) throws IOException, InterruptedException {
		test = extent.createTest("Verify CRM Icon and route to Contact Form");
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
		Assert.assertEquals(contact.verifyCRMTextOnHomepage().contains("CRM"), true, "CRM is not displayed");
		log.info("CRM Icon Clicked Successfully");
		log.info("Clicking on CRM Icon");
		contact.clickCRMIcon();
		log.info("CRM Icon Clicked Successfully");
		Thread.sleep(2000);
		log.info("Clicking on Contact Icon");
		contact.clickContactIcon();
		log.info("Contact Icon Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verify Listing Form");
		Assert.assertEquals(contact.verifyContactListingForm().contains("Contacts"), true,
				"Contacts Listing form is not displayed");
		log.info("Listing Form verified successfully");
		Thread.sleep(2000);
		log.info("Clicking on Add Contact Button");
		contact.clickAddContactButton();
		log.info("Add Contact Button Clicked Successfully");
		Thread.sleep(2000);
		log.info("Verifying the Contact Form Title");
		Assert.assertEquals(contact.verifyContactForm().contains("New Contact"), true,
				"New Contact Form is not displayed");
		log.info("Contact Form Title is Verified Successfully");
	
		log.info("Verify Mandatory Fields and Creation of Contact");
		contact.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertEquals(contact.verifyMandatoryFieldIsBlank(), true, "Fields are not mandatory");
		test.log(Status.PASS, "Mandatory fields has been verified");
		Thread.sleep(2000);
		log.info("Closing the Pop-up");
		contact.closeBlankMandatoryFieldDialogBox();
		log.info("Pop-up closed Successfully");
		Thread.sleep(2000);
		log.info("Closing the Pop-up");
		newContact = contactName + " " + functions.randomNumberGenerator(3);
		log.info("Entering Contact Name");
		contact.enterContactName(newContact);
		log.info("Contact Name Entered Succesfully");
		Thread.sleep(2000);
		newUserEmail = email + functions.randomNumberGenerator(5) + "@yopmail.com";
		log.info("Entering Email");
		contact.enterEmail(newUserEmail);
		log.info("Email Entered Successfully");
		Thread.sleep(2000);
		log.info("Entering Phone Number");
		contact.enterPhoneNumber(phoneNumber);
		log.info("Phone Number Entered Successfully");
		Thread.sleep(2000);
		log.info("Entering Lead");
		contact.enterLead(lead);
		log.info("Lead Entered Successfully");

		Thread.sleep(2000);
		log.info("Entering Address");
		addEmp.enterEmployeeAddressOnMaps(address);
		log.info("Address Entered Successfully");
		Thread.sleep(2000);
		log.info("Clicking on Save Button");
		contact.clickSaveButton();
		log.info("Save Button Clicked Successfully");
		Thread.sleep(3000);
		log.info("Clicking Contact Link");
		contact.clickContactLinkforListingForm();
		log.info("Contact Link Clicked Successfully");
		companyListing.clickFiveHundredFilter();
		Thread.sleep(5000);
		log.info("Verify Created Contact");
		Assert.assertEquals(contact.verifyContactCreatedOnListingPage(newContact), true,
				"New Contact Form is not displayed");
		log.info("Created Contact Verified Successfully");
	}

	@DataProvider(name = "TG_5353_Contact_Creation")
	public Object[][] data1() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_5353_Contact_Creation"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		 driver.quit();
	}
}