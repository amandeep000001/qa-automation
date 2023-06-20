package users;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.sf.base.TestBase;
import com.sf.pages.AddNewCompanyPage;
import com.sf.pages.AddNewUserPage;
import com.sf.pages.CompanyListingPage;
import com.sf.pages.HomePage;
import com.sf.pages.JobOrderPage;
import com.sf.pages.LoginPage;
import com.sf.pages.SetUserPasswordPage;
import com.sf.pages.UserListingPage;
import com.sf.pages.YopMail;
import com.sf.utility.Functions;
import com.sf.utility.XmlReader;

import company.TG_594_Job_order;

public class AddNewUserHiring extends TestBase {
	LoginPage jo;
	JobOrderPage order;
	Functions functions;
	AddNewCompanyPage newCompany;
	CompanyListingPage companyListing;
	HomePage homePage;
	UserListingPage userList;
	SetUserPasswordPage setPassword;
	YopMail yopmail;
	AddNewUserPage addUser;
	String newUserEmail = null;
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(AddNewUserHiring.class.getName());
		functions = new Functions();
		jo = new LoginPage(driver, log);
		order = new JobOrderPage(driver, log);
		newCompany = new AddNewCompanyPage(driver, log);
		companyListing = new CompanyListingPage(driver, log);
		homePage = new HomePage(driver, log);
		userList = new UserListingPage(driver, log);
		setPassword = new SetUserPasswordPage(driver, log);
		yopmail = new YopMail(driver, log);
		addUser = new AddNewUserPage(driver, log);
	}

	@Test(dataProvider = "TG_AddNewUser")
	public void VerifyMandatoryFields(String url, String username, String password, String companyType,
			String userlLastName, String userFirstName, String userEmail, String companyName, String role)
			throws InterruptedException, IOException {
		test = extent.createTest("Verify mandatory fields");
		log.info("Started==Verifying mandatory fields in Add New User form");
		driver.get(url);
		log.info("Logging into the application using username: " + username);
		jo.enterUsername(username);
		jo.enterPassword(password);
		jo.clickLoginButton();
		log.info("User: " + username + " logged in successfully");
		Thread.sleep(3000);
		homePage.clickUsersLinkOnHomePage();
		userList.clickAddNewUserButton();
		Thread.sleep(6000);
		addUser.clearCompanyTypeField();
		addUser.clickLastNameField();
		addUser.clickSavebutton();
		Assert.assertEquals(addUser.verifyMessageBoxContent(), true, "Mandatory fields validation failed");
		test.log(Status.PASS, "Mandatory fields verified successfully");
		Thread.sleep(3000);
		addUser.closeMandatoryFieldsDialogBox();
	
		
		log.info("Started==Verify user creation");
		addUser.enterCompanyType(companyType);
		addUser.clickLastNameField();
		Thread.sleep(3000);
		newUserEmail = "automation." + functions.randomNumberGenerator(5) + "@yopmail.com";
		addUser.enterUserEmail(newUserEmail);
		addUser.enterFirstNameField(userFirstName);
		addUser.enterLastNameField(userlLastName);
		addUser.cickOnMoreInformationheader();
		Thread.sleep(1000);
		addUser.enterCompanyName(companyName);
		//addUser.clickLastNameField();
		addUser.clickSavebutton();
		Thread.sleep(40000);
		Assert.assertEquals(addUser.verifyUserCreatedOrNot(), true, "User was not created successfully");
		test.log(Status.PASS, "User created successfully with email as " +newUserEmail);
	
		
		Thread.sleep(3000);
		addUser.clickCloseEmailSentDialogBox();
		Thread.sleep(3000);
		addUser.navigateToUserlisting();
		Thread.sleep(5000);
		//userList.clickFilterIcon();
	//	userList.clickClearFilterIcon();
		addUser.clearField();
		Thread.sleep(3000);
		companyListing.clickFiveHundredFilter();
		Thread.sleep(5000);
		Assert.assertEquals(userList.verifyUserCreatedOnListingPage(newUserEmail), true,
				"User creation is not a success");
		test.log(Status.PASS, "User: " + newUserEmail + " created  successfully");
  
		log.info("Started==new user password setup");
		homePage.logout();
		Thread.sleep(3000);
		setPassword.openYopMail();
		Thread.sleep(3000);
		yopmail.enterEmailAddrress(newUserEmail);
		yopmail.submitEmailButton();
		yopmail.clickGoToTAGLInkOnFirstEmail();
		Thread.sleep(3000);
		setPassword.enterNewPassword(password);
		setPassword.enterConfirmPassword(password);
		setPassword.clickSubmitButton();
		Thread.sleep(10000);
		Assert.assertEquals(setPassword.verfiyPasswordSetup(), true, "User password is not a success");
		test.log(Status.PASS, "User password setup for : " + newUserEmail + " done successfully");
	}

	@DataProvider(name = "TG_AddNewUser")
	public Object[][] data() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("TG_AddNewUserHiring"); // data tag from XML
	}

	public void closeSession() throws InterruptedException {
		driver.quit();
	}

}
